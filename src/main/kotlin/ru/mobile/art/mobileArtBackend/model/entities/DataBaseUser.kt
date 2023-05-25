package ru.mobile.art.mobileArtBackend.model.entities

import jakarta.persistence.*

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
    var name: String = ""
)
