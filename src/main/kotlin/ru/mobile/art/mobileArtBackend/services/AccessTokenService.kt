package ru.mobile.art.mobileArtBackend.services

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import ru.mobile.art.mobileArtBackend.model.*
import ru.mobile.art.mobileArtBackend.security.SecurityHelper.getSigningKey
import java.nio.charset.StandardCharsets
import java.security.Key
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

@Service
class AccessTokenService {

    fun createToken(subjectId: Long, authority: String): String {
        val instant = Instant.now()
        return Jwts.builder()
            .setIssuer(issuerValue)
            .setSubject(subjectId.toString())
            .claim(authorityClaimName, authority)
            .setIssuedAt(Date.from(instant))
            .setExpiration(Date.from(instant.plus(accessTokenLiveTime, ChronoUnit.SECONDS)))
            .signWith(getSigningKey())
            .compact()
    }

    fun claimIdFromToken(token: String): String = Jwts
        .parser()
        .setSigningKey(getSigningKey())
        .requireIssuer(issuerValue)
        .parseClaimsJws(token)
        .body
        .subject
}