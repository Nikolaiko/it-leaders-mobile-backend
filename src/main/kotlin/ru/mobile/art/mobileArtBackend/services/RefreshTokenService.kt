package ru.mobile.art.mobileArtBackend.services

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Service
import ru.mobile.art.mobileArtBackend.model.accessTokenLiveTime
import ru.mobile.art.mobileArtBackend.model.authorityClaimName
import ru.mobile.art.mobileArtBackend.model.exceptions.UnauthorizedException
import ru.mobile.art.mobileArtBackend.model.issuerValue
import ru.mobile.art.mobileArtBackend.model.refreshTokenLiveTime
import ru.mobile.art.mobileArtBackend.security.SecurityHelper
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

@Service
class RefreshTokenService {
    private val parser = Jwts
        .parserBuilder()
        .setSigningKey(SecurityHelper.getSigningKey())
        .build()

    fun createToken(subjectId: Long): String {
        val instant = Instant.now()
        return Jwts.builder()
            .setSubject(subjectId.toString())
            .setId(UUID.randomUUID().toString())
            .setIssuedAt(Date.from(instant))
            .setExpiration(Date.from(instant.plus(refreshTokenLiveTime, ChronoUnit.HOURS)))
            .signWith(SecurityHelper.getSigningKey())
            .compact()
    }

    fun checkToken(token: String): Long {
        try {
            val body = parser.parseClaimsJws(token).body
            return body.subject.toLong()
        } catch (exception: Exception) {
            throw UnauthorizedException()
        }

    }
}