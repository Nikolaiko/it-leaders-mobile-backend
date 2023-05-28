package ru.mobile.art.mobileArtBackend.model.entities

import jakarta.persistence.*
import ru.mobile.art.mobileArtBackend.model.news.NewsCategory
import ru.mobile.art.mobileArtBackend.model.news.NewsHeading

@Entity
@Table(name = "news")
data class NewsInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val heading: NewsHeading = NewsHeading.interestingFacts,
    val category: NewsCategory = NewsCategory.art,
    val newsThumbnail: String? = null,
    val title: String = "",

    @Column(length = 5048)
    val shortText: String = "",

    @Column(length = 5048)
    val content: String = ""
)