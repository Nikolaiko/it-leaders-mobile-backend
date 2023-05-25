package ru.mobile.art.mobileArtBackend.services

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Service
import ru.mobile.art.mobileArtBackend.model.issuerValue
import java.time.Instant
import java.util.*

@Service
class AccessTokenService {

    fun createToken(subjectId: Long): String {
        val instant = Instant.now()
        return Jwts.builder()
            .setIssuer(issuerValue)
            .setSubject(subjectId.toString())
            .setIssuedAt(Date.from(instant))
            .compact()
    }
}