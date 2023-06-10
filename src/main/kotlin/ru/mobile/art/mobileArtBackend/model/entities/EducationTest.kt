package ru.mobile.art.mobileArtBackend.model.entities

import jakarta.persistence.*
import ru.mobile.art.mobileArtBackend.model.news.NewsCategory
import ru.mobile.art.mobileArtBackend.model.tests.TestDataType
import ru.mobile.art.mobileArtBackend.model.tests.TestDifficulty

@Entity
@Table(name = "tests")
class EducationTest constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var difficulty: TestDifficulty = TestDifficulty.Lite,
    var category: NewsCategory = NewsCategory.music,
    var score: Int = 0,

    @Column(length = 5048)
    var text: String = "",

    @Column(length = 5048)
    var correctAnswerText: String = "",

    @Column(length = 5048)
    var wrongAnswerText: String = "",

    @Column(length = 5048)
    var fact: String = "",

    var dataUrl: String? = null,
    var dataType: TestDataType = TestDataType.Text
)