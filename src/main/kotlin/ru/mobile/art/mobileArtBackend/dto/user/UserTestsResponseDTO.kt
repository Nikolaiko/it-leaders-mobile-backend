package ru.mobile.art.mobileArtBackend.dto.user

data class UserTestsResponseDTO(
    val id: Long,
    val userId: Long,
    val score: Int,
    val futureTests: List<Long>,
    val passedTests: List<Long>
)
