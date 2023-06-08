package ru.mobile.art.mobileArtBackend.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.mobile.art.mobileArtBackend.model.entities.EducationTest
import ru.mobile.art.mobileArtBackend.model.entities.NewsInfo

interface TestsRepository: JpaRepository<EducationTest, Long> {
}