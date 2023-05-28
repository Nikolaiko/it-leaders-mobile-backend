package ru.mobile.art.mobileArtBackend.dto.auth

import com.fasterxml.jackson.annotation.JsonProperty

data class VKRegisterRequestDTO(
    @JsonProperty("email")
    val email: String,

    @JsonProperty("password")
    val password: String,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("birthdate")
    val birthDate: String?,

    @JsonProperty("vkToken")
    val token: String
)
