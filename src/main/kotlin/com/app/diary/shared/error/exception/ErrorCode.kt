package com.app.diary.shared.error.exception

enum class ErrorCode (
    val states: Int,
    val code: String,
    val message: String
) {

    // JWT
    INVALID_TOKEN(403, "TOKEN-403-1", "Invalid Token"),

    // USER
    USER_NOT_FOUND(404, "USER-404-1", "User Not Found")
}