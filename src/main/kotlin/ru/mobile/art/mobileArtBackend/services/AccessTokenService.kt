package ru.mobile.art.mobileArtBackend.services

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import ru.mobile.art.mobileArtBackend.model.issuerValue
import ru.mobile.art.mobileArtBackend.model.signingKey
import java.nio.charset.StandardCharsets
import java.security.Key
import java.time.Instant
import java.util.*

@Service
class AccessTokenService {

    private fun getSigningKey(): Key {
        val keyBytes: ByteArray = signingKey.toByteArray()
        return Keys.hmacShaKeyFor(keyBytes)
    }

    fun createToken(subjectId: Long): String {
        val instant = Instant.now()
        return Jwts.builder()
            .setIssuer(issuerValue)
            .setSubject(subjectId.toString())
            .setIssuedAt(Date.from(instant))
            .signWith(getSigningKey())
            .compact()
    }

    fun claimIdFromToken(token: String): String = Jwts.parser()
            .setSigningKey(getSigningKey())
            .parseClaimsJws(token)
            .body
            .subject
}