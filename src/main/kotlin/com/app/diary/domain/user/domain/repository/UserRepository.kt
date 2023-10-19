package com.app.diary.domain.user.domain.repository

import com.app.diary.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
}