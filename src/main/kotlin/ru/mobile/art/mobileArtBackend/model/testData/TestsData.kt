package ru.mobile.art.mobileArtBackend.model.testData

import ru.mobile.art.mobileArtBackend.model.entities.EducationTest
import ru.mobile.art.mobileArtBackend.model.news.NewsCategory
import ru.mobile.art.mobileArtBackend.model.tests.TestDataType
import ru.mobile.art.mobileArtBackend.model.tests.TestDifficulty

val musicLiteTest1 = EducationTest(
    id = null,
    category = NewsCategory.music,
    difficulty = TestDifficulty.Lite,
    text = "Кто сочиняет музыку?",
    correctAnswerText = "Композитор",
    wrongAnswerText = "Композитор",
    fact = "Композитор – автор, создатель музыкальных произведений",
    dataUrl = null,
    dataType = TestDataType.Text
)

val musicLiteTest2 = EducationTest(
    id = null,
    category = NewsCategory.music,
    difficulty = TestDifficulty.Lite,
    text = "В каком городе находится Государственный академический Большой театр России?",
    correctAnswerText = "Москва",
    wrongAnswerText = "Москва",
    fact = "Государственный академический Большой театр России расположен в Москве по адресу: Театральная площадь, д. 1",
    dataUrl = null,
    dataType = TestDataType.Text
)

val musicLiteTest3 = EducationTest(
    id = null,
    category = NewsCategory.music,
    difficulty = TestDifficulty.Lite,
    text = "Чем занимаются участники хора?",
    correctAnswerText = "Поют",
    wrongAnswerText = "Поют",
    fact = "Хор – певческий коллектив, исполняющий вокальную музыку",
    dataUrl = null,
    dataType = TestDataType.Text
)

val musicInterTest1 = EducationTest(
    id = null,
    category = NewsCategory.music,
    difficulty = TestDifficulty.Intermediate,
    text = "Как называется инструмент, в котором одна из клавиатур напоминает клавиатуру фортепиано?",
    correctAnswerText = "Аккордеон",
    wrongAnswerText = "Аккордеон",
    fact = "Аккордеон – музыкальный инструмент, в котором  правая клавиатура фортепианного типа, то есть, напоминает клавиатуру фортепиано.",
    dataUrl = null,
    dataType = TestDataType.Text
)

val musicInterTest2 = EducationTest(
    id = null,
    category = NewsCategory.music,
    difficulty = TestDifficulty.Intermediate,
    text = "Сколько струн на виолончели?",
    correctAnswerText = "4",
    wrongAnswerText = "4",
    fact = "Виолончель – струнный смычковый музыкальный инструмент, который имеет 4 струны.",
    dataUrl = null,
    dataType = TestDataType.Text
)

val musicInterTest3 = EducationTest(
    id = null,
    category = NewsCategory.music,
    difficulty = TestDifficulty.Intermediate,
    text = "Денис Мацуев –...",
    correctAnswerText = "Пианист",
    wrongAnswerText = "Пианист",
    fact = "Денис Мацуев – российский пианист, Народный артист РФ, победитель XI Международного конкурса имени П.И. Чайковского.",
    dataUrl = null,
    dataType = TestDataType.Text
)

