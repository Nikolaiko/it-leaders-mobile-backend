package ru.mobile.art.mobileArtBackend.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.mobile.art.mobileArtBackend.dto.auth.*
import ru.mobile.art.mobileArtBackend.model.emailPattern
import ru.mobile.art.mobileArtBackend.model.exceptions.ValidationException
import ru.mobile.art.mobileArtBackend.model.invalidEmailMessage
import ru.mobile.art.mobileArtBackend.services.UserService

@RestController
class AuthController @Autowired constructor(
    private val userService: UserService
) {
    @PostMapping("/api/auth/register")
    fun registerUser(
        @RequestBody registerUserRequestDTO: EmailRegisterRequestDTO
    ): AuthUserResponseDTO {
        validateEmail(registerUserRequestDTO.email)
        return userService.registerUserByEmail(registerUserRequestDTO)
    }

    @PostMapping("/api/auth/register/vk")
    fun registerUserVK(
        @RequestBody registerUserRequestDTO: VKRegisterRequestDTO
    ): AuthUserResponseDTO {
        validateEmail(registerUserRequestDTO.email)
        return userService.registerUserByVK(registerUserRequestDTO)
    }

    @PostMapping("/api/auth/login/email")
    fun loginUserByEmail(
        @RequestBody loginUserRequestDTO: EmailLoginUserRequestDTO
    ): AuthUserResponseDTO {
        validateEmail(loginUserRequestDTO.email)
        return userService.loginUserByEmail(loginUserRequestDTO)
    }

    @PostMapping("/api/auth/login/vk")
    fun loginUserByVK(
        @RequestBody loginUserRequestDTO: VKLoginRequestDTO
    ): AuthUserResponseDTO {
        return userService.loginUserByVK(loginUserRequestDTO)
    }

    private fun validateEmail(email: String) {
        if (email.isBlank() || !emailPattern.matcher(email).find()) {
            throw ValidationException(invalidEmailMessage)
        }
    }
}