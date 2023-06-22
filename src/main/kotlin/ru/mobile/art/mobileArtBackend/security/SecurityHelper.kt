package ru.mobile.art.mobileArtBackend.security

import io.jsonwebtoken.security.Keys
import org.apache.commons.lang3.StringUtils
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import ru.mobile.art.mobileArtBackend.model.exceptions.ValidationException
import ru.mobile.art.mobileArtBackend.model.signingKey
import ru.mobile.art.mobileArtBackend.model.wrongTokenMessage
import java.security.Key
import java.security.Principal

object SecurityHelper {

    fun getUserId(principal: Principal): Long {
        try {
            val name = principal.name
            return name.toLong()
        } catch (numberFormatError: NumberFormatException) {
            throw ValidationException(wrongTokenMessage)
        }
    }

    fun getSigningKey(): Key {
        val keyBytes: ByteArray = signingKey.toByteArray()
        return Keys.hmacShaKeyFor(keyBytes)
    }

    fun configureSecurity(httpSecurity: HttpSecurity): HttpSecurity {
        return httpSecurity
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)  }
            .csrf().disable()
            .anonymous().disable()
            .logout().disable()
    }
}