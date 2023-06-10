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
    dataType = TestDataType.Text,
    score = 1
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
    dataType = TestDataType.Text,
    score = 1
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
    dataType = TestDataType.Text,
    score = 1
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
    dataType = TestDataType.Text,
    score = 1
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
    dataType = TestDataType.Text,
    score = 1
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
    dataType = TestDataType.Text,
    score = 1
)

val musicHardTest1 = EducationTest(
    id = null,
    category = NewsCategory.music,
    difficulty = TestDifficulty.Hard,
    text = "Как называется музыкальный спектакль, содержание которого воплощается через музыку и танец?",
    correctAnswerText = "Балет",
    wrongAnswerText = "Балет",
    fact = "Балет – вид сценического искусства, содержание которого выражается в музыкально-хореографических образах.",
    dataUrl = null,
    dataType = TestDataType.Text,
    score = 1
)

val musicHardTest2 = EducationTest(
    id = null,
    category = NewsCategory.music,
    difficulty = TestDifficulty.Hard,
    text = "Выберите вариант ответа, где перечислены струнные музыкальные инструменты.",
    correctAnswerText = "Скрипка, контрабас, домра, арфа",
    wrongAnswerText = "Скрипка, контрабас, домра, арфа",
    fact = "Скрипка, контрабас, домра, арфа, балалайка, гитара, виолончель, укулеле – струнные музыкальные инструменты. Гобой, тромбон, кларнет – духовые музыкальные инструменты.",
    dataUrl = null,
    dataType = TestDataType.Text,
    score = 1
)

val musicHardTest3 = EducationTest(
    id = null,
    category = NewsCategory.music,
    difficulty = TestDifficulty.Hard,
    text = "Какого музыкального интервала не существует?",
    correctAnswerText = "Минута",
    wrongAnswerText = "Минута",
    fact = "Музыкальный интервал – расстояние между двумя различными по высоте звуками. Прима, секунда, октава – музыкальные интервалы. Минута не является музыкальным интервалом, минута – единица измерения времени.",
    dataUrl = null,
    dataType = TestDataType.Text,
    score = 1
)

