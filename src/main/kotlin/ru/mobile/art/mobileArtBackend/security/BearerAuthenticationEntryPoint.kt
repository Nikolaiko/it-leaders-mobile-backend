package ru.mobile.art.mobileArtBackend.security

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint

class BearerAuthenticationEntryPoint: AuthenticationEntryPoint {
    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        response?.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.reasonPhrase)
    }
}