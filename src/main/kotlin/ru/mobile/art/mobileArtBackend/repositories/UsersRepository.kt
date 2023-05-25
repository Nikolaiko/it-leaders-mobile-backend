package ru.mobile.art.mobileArtBackend.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.mobile.art.mobileArtBackend.model.entities.DataBaseUser


interface UsersRepository: JpaRepository<DataBaseUser, Long> {
    fun findByEmail(email: String): DataBaseUser?
    fun findByvkToken(vkToken: String): DataBaseUser?
}