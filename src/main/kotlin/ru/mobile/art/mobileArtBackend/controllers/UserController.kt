package ru.mobile.art.mobileArtBackend.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.mobile.art.mobileArtBackend.dto.auth.AuthUserResponseDTO
import ru.mobile.art.mobileArtBackend.dto.auth.EmailRegisterRequestDTO
import ru.mobile.art.mobileArtBackend.dto.user.UserDataResponseDTO
import ru.mobile.art.mobileArtBackend.dto.user.UserInterestsDTO
import ru.mobile.art.mobileArtBackend.dto.user.UserTestsResponseDTO
import ru.mobile.art.mobileArtBackend.services.AccessTokenService
import ru.mobile.art.mobileArtBackend.services.UserService
import ru.mobile.art.mobileArtBackend.services.UserTestsService
import java.security.Principal

@RestController
class UserController @Autowired constructor(
    private val userService: UserService,
    private val userTestsService: UserTestsService
) {
    @GetMapping("/user/profile")
    fun getUserData(
        @RequestHeader("Authorization") bearerToken: String
    ): UserDataResponseDTO {
        return userService.getUserData(bearerToken)
    }

    @PostMapping("/user/interests")
    fun setUserInterests(
        @RequestHeader("Authorization") bearerToken: String,
        @RequestBody interestsDTO: UserInterestsDTO
    ): UserDataResponseDTO {
        return userService.setUserInterests(bearerToken, interestsDTO)
    }

    @GetMapping("/user/tests")
    fun getUserTestsData(
        @RequestHeader("Authorization") bearerToken: String
    ): UserTestsResponseDTO {
        return userTestsService.getUserTestsByToken(bearerToken)
    }
}