package ru.mobile.art.mobileArtBackend.services

import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.mobile.art.mobileArtBackend.dto.auth.*
import ru.mobile.art.mobileArtBackend.dto.user.UserDataResponseDTO
import ru.mobile.art.mobileArtBackend.dto.user.UserInterestsDTO
import ru.mobile.art.mobileArtBackend.model.authorityUser
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
    private val authService: AuthService
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
                authService.createTokens(newId, authorityUser)
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
        return authService.createTokens(userId, authorityUser)
    }

    @Transactional
    fun loginUserByEmail(request: EmailLoginUserRequestDTO): AuthUserResponseDTO {
        val foundUser = usersRepository.findByEmail(request.email)
        return when {
            foundUser != null && foundUser.password == request.password -> {
                authService.createTokens(foundUser.id!!, authorityUser)
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
                authService.createTokens(newId, authorityUser)
            }
        }
    }

    @Transactional
    fun setUserInterests(id: Long, interests: UserInterestsDTO): UserDataResponseDTO {
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
    fun getUserData(id: Long): UserDataResponseDTO {
        val response = getUserById(id)
        return response.toUserDataResponseDTO()
    }

    private fun getUserById(id: Long): DataBaseUser = try {
        usersRepository.getReferenceById(id)
    } catch (notFound: EntityNotFoundException) {
        throw UserNotFoundException()
    }
}