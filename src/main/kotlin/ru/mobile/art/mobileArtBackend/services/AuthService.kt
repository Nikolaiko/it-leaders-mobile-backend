package ru.mobile.art.mobileArtBackend.services

import org.springframework.stereotype.Service
import ru.mobile.art.mobileArtBackend.dto.auth.AuthUserResponseDTO
import ru.mobile.art.mobileArtBackend.model.authorityUser

@Service
class AuthService(
    private val accessTokenService: AccessTokenService,
    private val refreshTokenService: RefreshTokenService
) {
    fun createTokens(userId: Long, authority: String): AuthUserResponseDTO = AuthUserResponseDTO(
        accessToken = accessTokenService.createToken(userId, authority),
        refreshToken = refreshTokenService.createToken(userId)
    )

    fun refreshToken(token: String): AuthUserResponseDTO {
        val userId = refreshTokenService.checkToken(token)
        return createTokens(userId, authorityUser)
    }
}