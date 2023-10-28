package com.app.diary.shared.auth

import com.app.diary.domain.user.domain.User
import com.app.diary.domain.user.domain.repository.UserRepository
import com.app.diary.shared.error.exception.DiaryException
import com.app.diary.shared.error.exception.ErrorCode
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
class AuthDetailService (
    val userRepository: UserRepository
){
    fun loadByUsername(id: Long): UserDetails {
        val user: User = userRepository.findById(id)
            .orElseThrow { DiaryException(ErrorCode.USER_NOT_FOUND) }
        return AuthDetails(user)
    }
}