package ru.mobile.art.mobileArtBackend.dto.auth

data class EmailLoginUserRequestDTO(
    val email: String,
    val password: String
)
