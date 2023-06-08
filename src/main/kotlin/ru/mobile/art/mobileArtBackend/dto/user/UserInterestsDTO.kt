package ru.mobile.art.mobileArtBackend.dto.user

import ru.mobile.art.mobileArtBackend.model.news.NewsCategory


data class UserInterestsDTO(
    val interests: List<NewsCategory>
)
