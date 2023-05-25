package ru.mobile.art.mobileArtBackend.dto.news

import ru.mobile.art.mobileArtBackend.model.news.NewsCategory
import ru.mobile.art.mobileArtBackend.model.news.NewsHeading

data class NewsShortDataDTO(
    val id: Long,
    val category: NewsCategory,
    val heading: NewsHeading,
    val title: String,
    val info: String,
    val imageUrl: String?
)
