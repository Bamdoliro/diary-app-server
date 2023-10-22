package com.app.diary.shared.response

class ExceptionResponse(
    val status:Int,
    val message:String
) {
    override fun toString(): String {
        return "ExceptionResponse(status=$status, message='$message')"
    }
}