package ru.mobile.art.mobileArtBackend.controllers

import jakarta.websocket.server.PathParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.mobile.art.mobileArtBackend.dto.news.NewsCategoryResponseDTO
import ru.mobile.art.mobileArtBackend.dto.news.NewsFullDataResponseDTO
import ru.mobile.art.mobileArtBackend.model.news.NewsCategory
import ru.mobile.art.mobileArtBackend.services.NewsService

@RestController
class NewsController @Autowired constructor(
    private val newsService: NewsService
) {
    @GetMapping("/api/news")
    fun getNewsByCategory(
        @RequestParam category: NewsCategory
    ): NewsCategoryResponseDTO {
        return NewsCategoryResponseDTO(
            news = newsService.getNewsByCategory(category)
        )
    }

    @GetMapping("/api/news/{id}")
    fun getNewsById(
        @PathVariable id: Long
    ): NewsFullDataResponseDTO {
        return newsService.getNewsById(id)
    }
}