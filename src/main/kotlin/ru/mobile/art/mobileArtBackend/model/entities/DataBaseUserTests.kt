package ru.mobile.art.mobileArtBackend.model.entities

import jakarta.persistence.*
import ru.mobile.art.mobileArtBackend.dto.user.UserTestsResponseDTO
import ru.mobile.art.mobileArtBackend.model.news.NewsCategory

@Entity
@Table(name = "user_tests")
class DataBaseUserTests constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var userId: Long = 0,
    var score: Int = 0,
    var futureTests: String = "",
    var passedTests: String = ""
) {
    fun toResponseTestsDTO(): UserTestsResponseDTO {
        val futureTestsValues = when(futureTests.isEmpty()) {
            true -> emptyList<Long>()
            false -> futureTests.split(",").map { it.toLong() }
        }
        val passedTestsValues = when(passedTests.isEmpty()) {
            true -> emptyList<Long>()
            false -> passedTests.split(",").map { it.toLong() }
        }
        return UserTestsResponseDTO(
            id = id!!,
            userId = userId,
            score = score,
            futureTests = futureTestsValues,
            passedTests = passedTestsValues
        )
    }
}