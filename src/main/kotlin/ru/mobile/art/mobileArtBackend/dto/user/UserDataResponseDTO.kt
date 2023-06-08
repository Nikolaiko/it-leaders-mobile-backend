package ru.mobile.art.mobileArtBackend.dto.user

import ru.mobile.art.mobileArtBackend.model.news.NewsCategory

data class UserDataResponseDTO(
    val id: Long,
    val email: String,
    val birthDate: String?,
    val name: String,
    val avatarUrl: String? = null,
    val interests: List<NewsCategory>
)
