package ru.mobile.art.mobileArtBackend.security

import io.jsonwebtoken.JwtParser
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import ru.mobile.art.mobileArtBackend.model.authorityClaimName

class AuthTokenFilter(
    private val jwtParser: JwtParser
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            val authToken = parseJwt(request)
            if (authToken != null) {
                val body = jwtParser.parseClaimsJws(authToken).body
                val subject = body.subject
                val authority = body.get(authorityClaimName, String::class.java)
                SecurityContextHolder.getContext().authentication = UsernamePasswordAuthenticationToken(
                    subject, null, mutableListOf(SimpleGrantedAuthority(authority))
                )
            }
        } catch (exception: Exception) {
            println("Error in ${AuthTokenFilter::class.java} : $exception")
        }
        filterChain.doFilter(request, response)
    }

    private fun parseJwt(request: HttpServletRequest): String? {
        val authHeader = request.getHeader(HttpHeaders.AUTHORIZATION)
        val correctHeader = StringUtils.startsWith(authHeader, headerStaticName)
        println("authHeader : $authHeader")
        println("correct Header : $correctHeader")
        return when (correctHeader) {
            true -> parseAuthHeader(authHeader)
            false -> null
        }
    }

    private fun parseAuthHeader(header: String): String? {
        val value = header.substring(headerStaticName.length).trim()
        return when (value.isEmpty()) {
            true -> null
            false -> value
        }
    }

    companion object {
        const val headerStaticName = "Bearer"
    }
}