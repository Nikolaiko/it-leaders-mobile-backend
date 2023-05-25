package ru.mobile.art.mobileArtBackend.dto.auth

import com.fasterxml.jackson.annotation.JsonProperty

data class VKLoginRequestDTO(
    @JsonProperty("vk_id")
    val vkId: String
)
