package ru.mobile.art.mobileArtBackend.model.entities

import jakarta.persistence.*
import ru.mobile.art.mobileArtBackend.dto.user.UserDataResponseDTO
import ru.mobile.art.mobileArtBackend.model.exceptions.ValidationException
import ru.mobile.art.mobileArtBackend.model.news.NewsCategory
import ru.mobile.art.mobileArtBackend.model.wrongEnumValueMessage

@Entity
@Table(name = "users")
class DataBaseUser constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var email: String = "",
    var password: String? = null,
    var vkToken: String? = null,
    var birthDate: String? = null,
    var name: String = "",
    var avatarUrl: String? = null,
    var interests: String? = null
) {
    fun toUserDataResponseDTO(): UserDataResponseDTO = UserDataResponseDTO(
        id = id!!,
        email = email,
        birthDate = birthDate,
        avatarUrl = avatarUrl,
        name = name,
        interests = getInterestsFromString(interests)
    )

    private fun getInterestsFromString(interestsString: String?): List<NewsCategory> {
        val elements = interestsString?.split(",") ?: emptyList()
        val interests: MutableList<NewsCategory> = mutableListOf()

        elements.forEach {
            try {
                interests.add(NewsCategory.valueOf(it))
            } catch (wrongName: java.lang.IllegalArgumentException) {
                throw ValidationException(wrongEnumValueMessage)
            }
        }
        return interests.toList()
    }
}
