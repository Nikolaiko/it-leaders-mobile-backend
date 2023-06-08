package ru.mobile.art.mobileArtBackend.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.mobile.art.mobileArtBackend.model.entities.EducationTestAnswer
import ru.mobile.art.mobileArtBackend.model.entities.NewsInfo

interface AnswersRepository: JpaRepository<EducationTestAnswer, Long> {
}