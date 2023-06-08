package ru.mobile.art.mobileArtBackend.model.entities

import jakarta.persistence.*
import ru.mobile.art.mobileArtBackend.model.tests.TestDataType

@Entity
@Table(name = "tests_answers")
class EducationTestAnswer constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var testId: Long,

    @Column(length = 5048)
    var answerText: String,
    var isCorrect: Boolean,

    @Column(length = 5048)
    var dataUrl: String?,
    var dataType: TestDataType,
)