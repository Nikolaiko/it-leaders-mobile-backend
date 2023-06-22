package ru.mobile.art.mobileArtBackend.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.mobile.art.mobileArtBackend.dto.auth.AuthUserResponseDTO
import ru.mobile.art.mobileArtBackend.dto.auth.EmailRegisterRequestDTO
import ru.mobile.art.mobileArtBackend.dto.user.UserDataResponseDTO
import ru.mobile.art.mobileArtBackend.dto.user.UserInterestsDTO
import ru.mobile.art.mobileArtBackend.dto.user.UserTestsResponseDTO
import ru.mobile.art.mobileArtBackend.security.SecurityHelper
import ru.mobile.art.mobileArtBackend.security.SecurityHelper.getUserId
import ru.mobile.art.mobileArtBackend.services.AccessTokenService
import ru.mobile.art.mobileArtBackend.services.UserService
import ru.mobile.art.mobileArtBackend.services.UserTestsService
import java.security.Principal

@RestController
class UserController @Autowired constructor(
    private val userService: UserService,
    private val userTestsService: UserTestsService
) {
    @GetMapping("/api/user/profile")
    fun getUserData(principal: Principal): UserDataResponseDTO {
        return userService.getUserData(getUserId(principal))
    }

    @PostMapping("/api/user/interests")
    fun setUserInterests(
        principal: Principal,
        @RequestBody interestsDTO: UserInterestsDTO
    ): UserDataResponseDTO {
        return userService.setUserInterests(getUserId(principal), interestsDTO)
    }

    @GetMapping("/api/user/tests")
    fun getUserTestsData(
        principal: Principal
    ): UserTestsResponseDTO {
        return userTestsService.getUserTestsByToken(getUserId(principal))
    }
}