package ru.mobile.art.mobileArtBackend.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.mobile.art.mobileArtBackend.dto.news.NewsFullDataResponseDTO
import ru.mobile.art.mobileArtBackend.dto.news.NewsShortDataDTO
import ru.mobile.art.mobileArtBackend.model.entities.NewsInfo
import ru.mobile.art.mobileArtBackend.model.exceptions.NewsNotFoundException
import ru.mobile.art.mobileArtBackend.model.news.NewsCategory
import ru.mobile.art.mobileArtBackend.repositories.NewsRepository

@Service
class NewsService @Autowired constructor(
    private val newsRepository: NewsRepository
) {
    @Transactional
    fun getNewsByCategory(category: NewsCategory): List<NewsShortDataDTO> {
        return newsRepository.findAllByCategory(category)
            .map {
                NewsShortDataDTO(
                    id = it.id!!,
                    category = it.category,
                    heading = it.heading,
                    title = it.title,
                    info = it.shortText,
                    imageUrl = it.newsThumbnail
                )
            }
    }

    @Transactional
    fun getNewsById(id: Long): NewsFullDataResponseDTO {
        val news = newsRepository.findById(id)
        return when(news.isPresent) {
            false -> throw NewsNotFoundException()
            else -> NewsFullDataResponseDTO(
                id = news.get().id!!,
                content = news.get().content
            )
        }
    }
}