package com.app.diary.shared.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("auth.jwt")
class JwtProperties (
    val header: String,
    val secret: String,
    val accessExp: Long,
    val refreshExp: Long,
    val prefix: String
)