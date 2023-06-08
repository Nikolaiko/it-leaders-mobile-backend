package ru.mobile.art.mobileArtBackend.model.entities

import jakarta.persistence.*
import ru.mobile.art.mobileArtBackend.model.news.NewsCategory

@Entity
@Table(name = "user_tests")
class DataBaseUserTests constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var userId: Long,
    var score: Int,
    var futureTests: String,
    var passedTests: String
)