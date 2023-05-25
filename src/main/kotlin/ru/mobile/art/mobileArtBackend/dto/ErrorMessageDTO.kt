package ru.mobile.art.mobileArtBackend.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorMessageDTO(
    @JsonProperty("message")
    val message: String
)