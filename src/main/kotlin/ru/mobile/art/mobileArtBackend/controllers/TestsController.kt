package ru.mobile.art.mobileArtBackend.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.mobile.art.mobileArtBackend.dto.auth.EmailRegisterRequestDTO
import ru.mobile.art.mobileArtBackend.dto.tests.TestResultsDTO
import ru.mobile.art.mobileArtBackend.dto.user.UserDataResponseDTO
import ru.mobile.art.mobileArtBackend.dto.user.UserTestsResponseDTO
import ru.mobile.art.mobileArtBackend.services.UserTestsService

@RestController
class TestsController @Autowired constructor(
    private val userTestsService: UserTestsService
) {
    @PostMapping("/api/tests/results")
    fun testResults(
        @RequestHeader("Authorization") bearerToken: String,
        @RequestBody testData: TestResultsDTO
    ): UserTestsResponseDTO {
        return userTestsService.applyTestData(bearerToken, testData)
    }
}