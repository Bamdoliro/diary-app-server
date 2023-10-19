package com.app.diary.domain.user.domain.value

import jakarta.persistence.Embeddable

@Embeddable
class RoomCode (
    val value: String
) {
}