package ru.mobile.art.mobileArtBackend.services

import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mobile.art.mobileArtBackend.dto.tests.TestResultsDTO
import ru.mobile.art.mobileArtBackend.dto.user.UserTestsResponseDTO
import ru.mobile.art.mobileArtBackend.model.entities.DataBaseUserTests
import ru.mobile.art.mobileArtBackend.model.exceptions.TestsNotFoundException
import ru.mobile.art.mobileArtBackend.model.exceptions.ValidationException
import ru.mobile.art.mobileArtBackend.model.testNotFoundMessage
import ru.mobile.art.mobileArtBackend.model.testsNotFoundMessage
import ru.mobile.art.mobileArtBackend.model.wrongTokenMessage
import ru.mobile.art.mobileArtBackend.repositories.TestsRepository
import ru.mobile.art.mobileArtBackend.repositories.UserTestsRepository
import kotlin.jvm.optionals.getOrNull

@Service
class UserTestsService @Autowired constructor(
    private val accessTokenService: AccessTokenService,
    private val userTestsRepository: UserTestsRepository,
    private val testsRepository: TestsRepository
) {
    @Transactional
    fun getUserTests(id: Long): DataBaseUserTests? {
        return userTestsRepository.findByUserId(id)
    }

    @Transactional
    fun getUserTestsByToken(id: Long): UserTestsResponseDTO {
        return when(val tests = getUserTests(id)) {
            null -> createTestsForUser(id).toResponseTestsDTO()
            else -> tests.toResponseTestsDTO()
        }
    }

    @Transactional
    fun createTestsForUser(id: Long): DataBaseUserTests {
        val allTests = testsRepository.findAll()
        allTests.sortBy { it.difficulty.ordinal }

        val ids = allTests.map { it.id }
        val userTests = DataBaseUserTests(
            id = null,
            userId = id,
            score = 0,
            futureTests = ids.joinToString(","),
            passedTests = ""
        )
        return userTestsRepository.save(userTests)
    }

    @Transactional
    fun applyTestData(token: String, testData: TestResultsDTO): UserTestsResponseDTO {
        val tokenParts = token.split(" ")
        val idValue = try {
            val tokenValue = tokenParts[1]
            val idString = accessTokenService.claimIdFromToken(tokenValue)
            idString.toLong()
        } catch (outOfBound: java.lang.IndexOutOfBoundsException) {
            throw ValidationException(wrongTokenMessage)
        } catch (wrongFormat: NumberFormatException) {
            throw ValidationException(wrongTokenMessage)
        }

        val test = testsRepository.findById(testData.testId).getOrNull()
            ?: throw TestsNotFoundException(message = testNotFoundMessage)

        val userTestsData = userTestsRepository.findByUserId(idValue)
            ?: throw TestsNotFoundException(message = testsNotFoundMessage)
        val futureTests = when(userTestsData.futureTests.isEmpty()) {
            true -> mutableListOf()
            false -> userTestsData.futureTests.split(",").map { it.toLong() }.toMutableList()
        }
        val passedTests = when(userTestsData.passedTests.isEmpty()) {
            true -> mutableListOf()
            false -> userTestsData.passedTests.split(",").map { it.toLong() }.toMutableList()
        }

        if (futureTests.contains(testData.testId)) {
            futureTests.remove(testData.testId)
        }

        if (!passedTests.contains(testData.testId)) {
            passedTests.add(testData.testId)
        }

        val newTestData = DataBaseUserTests(
            id = userTestsData.id,
            userId = userTestsData.userId,
            score = when(testData.passed) {
                true -> userTestsData.score + test.score
                false -> userTestsData.score
            },
            futureTests = futureTests.joinToString(","),
            passedTests = passedTests.joinToString(",")
        )
        userTestsRepository.save(newTestData)
        return  newTestData.toResponseTestsDTO()
    }
}