package ru.mobile.art.mobileArtBackend.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.mobile.art.mobileArtBackend.model.entities.DataBaseUser
import ru.mobile.art.mobileArtBackend.model.entities.DataBaseUserTests
import ru.mobile.art.mobileArtBackend.model.entities.EducationTest

interface UserTestsRepository: JpaRepository<DataBaseUserTests, Long> {
    fun findByUserId(id: Long): DataBaseUserTests?
}