package com.app.diary.shared.response

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

class TokenResponse (
    val accessToken: String,
    val refreshToken: String,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    val expiredAt: ZonedDateTime,
)