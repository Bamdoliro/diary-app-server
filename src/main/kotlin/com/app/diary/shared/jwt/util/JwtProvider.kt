package com.app.diary.shared.jwt.util

import com.app.diary.shared.config.properties.JwtProperties
import com.app.diary.shared.response.TokenResponse
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.security.Key
import java.time.ZonedDateTime
import java.util.*

@Component
class JwtProvider (
    private val jwtProperties: JwtProperties
) {

    fun generateAccessToken(authId: Long, role: String): String {
        return generateToken(
            authId,
            role,
            "access_token",
            jwtProperties.accessExp
        )
    }

    fun generateToken(authId: Long, role: String): TokenResponse {
        val accessToken = generateToken(
            authId,
            role,
            "access_token",
            jwtProperties.accessExp
        )
        val refreshToken = generateToken(
            authId,
            role,
            "refresh_token",
            jwtProperties.refreshExp
        )
        return TokenResponse(accessToken, refreshToken, expiredTime)
    }

    private fun generateToken(authId: Long, role: String, type: String, time: Long): String {
        return Jwts.builder()
            .setHeaderParam("type", type)
            .claim("role", role)
            .claim("id", authId)
            .signWith(getSigningKey(jwtProperties.secret), SignatureAlgorithm.HS256)
            .setExpiration(Date(System.currentTimeMillis() + time * 1000))
            .compact()
    }

    val expiredTime: ZonedDateTime
        get() = ZonedDateTime.now().plusSeconds(jwtProperties.refreshExp)

    private fun getSigningKey(key: String): Key {
        val keyBytes = key.toByteArray(StandardCharsets.UTF_8)
        return Keys.hmacShaKeyFor(keyBytes)
    }
}