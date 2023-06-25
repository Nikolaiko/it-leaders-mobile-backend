package ru.mobile.art.mobileArtBackend.security

import io.jsonwebtoken.JwtParser
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import ru.mobile.art.mobileArtBackend.model.authorityService
import ru.mobile.art.mobileArtBackend.model.authorityUser
import ru.mobile.art.mobileArtBackend.model.memoryUserDetailsService

@Configuration
class SecurityFilterMobile {

    @Bean
    @Order(10)
    fun securityFilterChain(
        http: HttpSecurity,
        @Qualifier(memoryUserDetailsService) userDetailsService: UserDetailsService,
        jwtParser: JwtParser
    ): SecurityFilterChain {
        return SecurityHelper.configureSecurity(http)
            .securityMatcher("/api/tests/**", "/api/user/**")
            .userDetailsService(userDetailsService)
            .authorizeHttpRequests {
                it
                    .anyRequest()
                    .hasAuthority(authorityUser)
            }
            .addFilterAfter(AuthTokenFilter(jwtParser), BasicAuthenticationFilter::class.java)
            .exceptionHandling {
                println("Exception is custom chain")
                it.authenticationEntryPoint(BearerAuthenticationEntryPoint())
            }
            .build()
    }

    @Bean
    @Order(1)
    fun basicFilterChain(
        http: HttpSecurity,
        @Qualifier(memoryUserDetailsService) userDetailsService: UserDetailsService
    ): SecurityFilterChain {
        return SecurityHelper.configureSecurity(http)
            .securityMatcher("/api/auth/**", "/api/news/**")
            .userDetailsService(userDetailsService)
            .authorizeHttpRequests {
                it
                    .anyRequest()
                    .hasAuthority(authorityService)
            }
            .httpBasic(withDefaults())
            .build()
    }
}