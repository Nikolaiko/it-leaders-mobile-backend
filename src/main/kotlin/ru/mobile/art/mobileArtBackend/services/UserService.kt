package ru.mobile.art.mobileArtBackend.services

import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.mobile.art.mobileArtBackend.dto.auth.*
import ru.mobile.art.mobileArtBackend.dto.user.UserDataResponseDTO
import ru.mobile.art.mobileArtBackend.dto.user.UserInterestsDTO
import ru.mobile.art.mobileArtBackend.model.entities.DataBaseUser
import ru.mobile.art.mobileArtBackend.model.entities.DataBaseUserTests
import ru.mobile.art.mobileArtBackend.model.exceptions.UserAlreadyExistException
import ru.mobile.art.mobileArtBackend.model.exceptions.UserNotFoundException
import ru.mobile.art.mobileArtBackend.model.exceptions.ValidationException
import ru.mobile.art.mobileArtBackend.model.news.NewsCategory
import ru.mobile.art.mobileArtBackend.model.wrongEnumValueMessage
import ru.mobile.art.mobileArtBackend.model.wrongTokenMessage
import ru.mobile.art.mobileArtBackend.repositories.TestsRepository
import ru.mobile.art.mobileArtBackend.repositories.UserTestsRepository
import ru.mobile.art.mobileArtBackend.repositories.UsersRepository

@Service
class UserService @Autowired constructor(
    private val usersRepository: UsersRepository,
    private val userTestsService: UserTestsService,
    private val accessTokenService: AccessTokenService
) {
    @Transactional
    fun registerUserByEmail(request: EmailRegisterRequestDTO): AuthUserResponseDTO {
        return when(usersRepository.findByEmail(request.email)) {
            null -> {
                val newUser = DataBaseUser(
                    email = request.email,
                    password = request.password,
                    name = request.name,
                    birthDate = request.birthDate
                )
                val newId: Long = usersRepository.save(newUser).id!!
                val token = accessTokenService.createToken(newId)
                AuthUserResponseDTO(accessToken = token)
            }
            else -> throw UserAlreadyExistException()
        }
    }

    @Transactional
    fun registerUserByVK(request: VKRegisterRequestDTO): AuthUserResponseDTO {
        val userId = when(val dbUser = usersRepository.findByvkToken(request.email)) {
            null -> {
                val newUser = DataBaseUser(
                    email = request.email,
                    password = request.password,
                    name = request.name,
                    birthDate = request.birthDate,
                    vkToken = request.token
                )
                usersRepository.save(newUser).id!!
            }
            else -> dbUser.id!!
        }
        val token = accessTokenService.createToken(userId)
        return AuthUserResponseDTO(accessToken = token)
    }

    @Transactional
    fun loginUserByEmail(request: EmailLoginUserRequestDTO): AuthUserResponseDTO {
        val foundUser = usersRepository.findByEmail(request.email)
        return when {
            foundUser != null && foundUser.password == request.password -> {
                val token = accessTokenService.createToken(foundUser.id!!)
                AuthUserResponseDTO(accessToken = token)
            }
            else -> throw  UserNotFoundException()
        }
    }

    @Transactional
    fun loginUserByVK(request: VKLoginRequestDTO): AuthUserResponseDTO {
        val foundUser = usersRepository.findByvkToken(request.vkId)
        return when(foundUser) {
            null -> throw  UserNotFoundException()
            else -> {
                val newId: Long = usersRepository.save(foundUser).id!!
                val token = accessTokenService.createToken(newId)
                AuthUserResponseDTO(accessToken = token)
            }
        }
    }

    @Transactional
    fun setUserInterests(token: String, interests: UserInterestsDTO): UserDataResponseDTO {
        val id: Long = getIdFromToken(token)
        val userTests = userTestsService.getUserTests(id)
        if (userTests == null) {
            userTestsService.createTestsForUser(id)
        }

        val userFromDb = getUserById(id)
        val interestsString = interests.interests.map { it.name }
        val newUser = DataBaseUser(
            id = userFromDb.id,
            avatarUrl = userFromDb.avatarUrl,
            name = userFromDb.name,
            birthDate = userFromDb.birthDate,
            email = userFromDb.email,
            password = userFromDb.password,
            vkToken = userFromDb.vkToken,
            interests = interestsString.joinToString(",")
        )
        return usersRepository.save(newUser).toUserDataResponseDTO()
    }

    @Transactional
    fun getUserData(token: String): UserDataResponseDTO {
        val id: Long = getIdFromToken(token)
        val response = getUserById(id)
        return response.toUserDataResponseDTO()
    }

    private fun getUserById(id: Long): DataBaseUser = try {
        usersRepository.getReferenceById(id)
    } catch (notFound: EntityNotFoundException) {
        throw UserNotFoundException()
    }

    private fun getIdFromToken(token: String): Long {
        val tokenParts = token.split(" ")
        return try {
            val tokenValue = tokenParts[1]
            val idString = accessTokenService.claimIdFromToken(tokenValue)
            idString.toLong()
        } catch (outOfBounds: IndexOutOfBoundsException) {
            throw ValidationException(wrongTokenMessage)
        } catch (wrongFormat: NumberFormatException) {
            throw ValidationException(wrongTokenMessage)
        }
    }
}