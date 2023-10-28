package com.app.diary.shared.response


data class ExceptionResponse(
    val status:Int,
    val message:String
) {
    override fun toString(): String {
        return "ExceptionResponse(status=$status, message='$message')"
    }
}