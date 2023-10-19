package com.app.diary.domain.user.domain

import com.app.diary.domain.user.domain.authority.Authority
import com.app.diary.domain.user.domain.value.RoomCode
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var name: String,

    val email: String,

    var description: String,

    var authority: Authority,

    @Embedded
    var roomCode: RoomCode
) {
}