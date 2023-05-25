package ru.mobile.art.mobileArtBackend.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.mobile.art.mobileArtBackend.dto.auth.EmailRegisterRequestDTO
import ru.mobile.art.mobileArtBackend.dto.auth.AuthUserResponseDTO
import ru.mobile.art.mobileArtBackend.dto.auth.EmailLoginUserRequestDTO
import ru.mobile.art.mobileArtBackend.dto.auth.VKLoginRequestDTO
import ru.mobile.art.mobileArtBackend.model.entities.DataBaseUser
import ru.mobile.art.mobileArtBackend.model.exceptions.UserAlreadyExistException
import ru.mobile.art.mobileArtBackend.model.exceptions.UserNotFoundException
import ru.mobile.art.mobileArtBackend.repositories.UsersRepository

@Service
class UserService @Autowired constructor(
    private val usersRepository: UsersRepository,
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
    fun loginUserByEmail(request: EmailLoginUserRequestDTO): AuthUserResponseDTO {
        val foundUser = usersRepository.findByEmail(request.email)
        return when {
            foundUser != null && foundUser.password == request.password -> {
                val newId: Long = usersRepository.save(foundUser).id!!
                val token = accessTokenService.createToken(newId)
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
}