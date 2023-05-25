package ru.mobile.art.mobileArtBackend.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.mobile.art.mobileArtBackend.model.entities.NewsInfo
import ru.mobile.art.mobileArtBackend.model.news.NewsCategory

interface NewsRepository: JpaRepository<NewsInfo, Long> {
    fun findAllByCategory(category: NewsCategory): List<NewsInfo>
}