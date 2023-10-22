package com.app.diary.shared.jwt.util

import com.app.diary.shared.config.properties.JwtProperties
import com.app.diary.shared.error.exception.DiaryException
import com.app.diary.shared.error.exception.ErrorCode
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.security.Key

@Component
class JwtUtil(
    val jwtProperties: JwtProperties,
) {

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer:String? = request.getHeader(jwtProperties.header)
        return parseToken(bearer)
    }

    fun parseToken(bearer:String?):String? {
        if(!bearer.isNullOrBlank()){
            return bearer.replace("Bearer","").trim()
        }
        return null
    }

    fun getJwt(token: String?): Jws<Claims> {
        if(token == null) {
            throw DiaryException(ErrorCode.INVALID_TOKEN)
        }

        return Jwts.parserBuilder().setSigningKey(getSigningKey(jwtProperties.secret)).build().parseClaimsJws(token)
    }

    fun getJwtBody(bearer: String): Claims? {
        return getJwt(parseToken(bearer)).body
    }

    private fun getSigningKey(key: String): Key {
        val keyBytes = key.toByteArray(StandardCharsets.UTF_8)
        return Keys.hmacShaKeyFor(keyBytes)
    }
}