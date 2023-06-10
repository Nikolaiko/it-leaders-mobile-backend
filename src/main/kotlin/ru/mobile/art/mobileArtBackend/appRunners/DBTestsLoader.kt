package ru.mobile.art.mobileArtBackend.appRunners

import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import ru.mobile.art.mobileArtBackend.model.entities.EducationTestAnswer
import ru.mobile.art.mobileArtBackend.model.testData.*
import ru.mobile.art.mobileArtBackend.model.tests.TestDataType
import ru.mobile.art.mobileArtBackend.repositories.AnswersRepository
import ru.mobile.art.mobileArtBackend.repositories.TestsRepository

@Component
class DBTestsLoader @Autowired constructor(
    private val testsRepository: TestsRepository,
    private val answersRepository: AnswersRepository
): ApplicationRunner {

    @Transactional
    override fun run(args: ApplicationArguments?) {
        if (testsRepository.findAll().isEmpty()) {
            addMusicTest1()
            addMusicTest2()
            addMusicTest3()
            addMusicTest4()
            addMusicTest5()
            addMusicTest6()
            addMusicTest7()
            addMusicTest8()
            addMusicTest9()
        }
    }

    @Transactional
    private fun addMusicTest1() {
        val addedTest = testsRepository.save(musicLiteTest1)
        val answer1 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = liteMusicText1Answer1,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer2 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = liteMusicText1Answer2,
            isCorrect = true,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer3 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = liteMusicText1Answer3,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer4 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = liteMusicText1Answer4,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        answersRepository.saveAll(
            mutableListOf(answer1, answer2, answer3, answer4)
        )
    }

    @Transactional
    private fun addMusicTest2() {
        val addedTest = testsRepository.save(musicLiteTest2)
        val answer1 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = liteMusicText2Answer1,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer2 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = liteMusicText2Answer2,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer3 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = liteMusicText2Answer3,
            isCorrect = true,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer4 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = liteMusicText2Answer4,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        answersRepository.saveAll(
            mutableListOf(answer1, answer2, answer3, answer4)
        )
    }

    @Transactional
    private fun addMusicTest3() {
        val addedTest = testsRepository.save(musicLiteTest3)
        val answer1 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = liteMusicText3Answer1,
            isCorrect = true,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer2 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = liteMusicText3Answer2,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer3 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = liteMusicText3Answer3,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer4 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = liteMusicText3Answer4,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        answersRepository.saveAll(
            mutableListOf(answer1, answer2, answer3, answer4)
        )
    }

    @Transactional
    private fun addMusicTest4() {
        val addedTest = testsRepository.save(musicInterTest1)
        val answer1 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = interMusicText1Answer1,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer2 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = interMusicText1Answer2,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer3 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = interMusicText1Answer3,
            isCorrect = true,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer4 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = interMusicText1Answer4,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        answersRepository.saveAll(
            mutableListOf(answer1, answer2, answer3, answer4)
        )
    }

    @Transactional
    private fun addMusicTest5() {
        val addedTest = testsRepository.save(musicInterTest2)
        val answer1 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = interMusicText2Answer1,
            isCorrect = true,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer2 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = interMusicText2Answer2,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer3 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = interMusicText2Answer3,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer4 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = interMusicText2Answer4,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        answersRepository.saveAll(
            mutableListOf(answer1, answer2, answer3, answer4)
        )
    }

    @Transactional
    private fun addMusicTest6() {
        val addedTest = testsRepository.save(musicInterTest3)
        val answer1 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = interMusicText3Answer1,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer2 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = interMusicText3Answer2,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer3 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = interMusicText3Answer3,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer4 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = interMusicText3Answer4,
            isCorrect = true,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        answersRepository.saveAll(
            mutableListOf(answer1, answer2, answer3, answer4)
        )
    }

    @Transactional
    private fun addMusicTest7() {
        val addedTest = testsRepository.save(musicHardTest1)
        val answer1 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = hardMusicText1Answer1,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer2 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = hardMusicText1Answer2,
            isCorrect = true,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer3 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = hardMusicText1Answer3,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer4 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = hardMusicText1Answer4,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        answersRepository.saveAll(
            mutableListOf(answer1, answer2, answer3, answer4)
        )
    }

    @Transactional
    private fun addMusicTest8() {
        val addedTest = testsRepository.save(musicHardTest2)
        val answer1 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = hardMusicText2Answer1,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer2 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = hardMusicText2Answer2,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer3 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = hardMusicText2Answer3,
            isCorrect = true,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer4 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = hardMusicText2Answer4,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        answersRepository.saveAll(
            mutableListOf(answer1, answer2, answer3, answer4)
        )
    }

    @Transactional
    private fun addMusicTest9() {
        val addedTest = testsRepository.save(musicHardTest3)
        val answer1 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = hardMusicText3Answer1,
            isCorrect = true,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer2 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = hardMusicText3Answer2,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer3 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = hardMusicText3Answer3,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        val answer4 = EducationTestAnswer(
            id = null,
            addedTest.id!!,
            answerText = hardMusicText3Answer4,
            isCorrect = false,
            dataUrl = null,
            dataType = TestDataType.Text
        )
        answersRepository.saveAll(
            mutableListOf(answer1, answer2, answer3, answer4)
        )
    }
}