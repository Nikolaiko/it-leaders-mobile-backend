package ru.mobile.art.mobileArtBackend.appRunners

import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import ru.mobile.art.mobileArtBackend.model.testData.allTestNews
import ru.mobile.art.mobileArtBackend.repositories.NewsRepository

@Component
class DBNewsLoader @Autowired constructor(
    private val newsRepository: NewsRepository
): ApplicationRunner {

    @Transactional
    override fun run(args: ApplicationArguments?) {
        val allNews = newsRepository.findAll()
        if (allNews.isEmpty()) {
            newsRepository.saveAll(allTestNews)
        }
    }
}