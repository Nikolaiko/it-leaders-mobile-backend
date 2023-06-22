package ru.mobile.art.mobileArtBackend.security

import io.jsonwebtoken.JwtParser
import io.jsonwebtoken.Jwts
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import ru.mobile.art.mobileArtBackend.model.*
import ru.mobile.art.mobileArtBackend.security.SecurityHelper.getSigningKey
import java.security.Key

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    @Bean
    fun accessJwtParser(key: Key?) = Jwts
        .parserBuilder()
        .setSigningKey(getSigningKey())
        .requireIssuer(issuerValue)
        .build()

    @Bean(memoryUserDetailsService)
    fun customUserService(): InMemoryUserDetailsManager {
        val initialUsers: MutableList<UserDetails> = mutableListOf()
        initialUsers.add(
            buildUser(
                encoder = passwordEncoder(),
                login = apiLogin,
                password = apiPassword,
                authorities = authorityService
            )
        )
        return InMemoryUserDetailsManager(initialUsers)
    }

    private fun buildUser(
        encoder: PasswordEncoder,
        login: String,
        password: String,
        authorities: String
    ): UserDetails {
        return User.builder()
            .passwordEncoder(encoder::encode)
            .username(login)
            .password(password)
            .authorities(authorities)
            .build()
    }
}