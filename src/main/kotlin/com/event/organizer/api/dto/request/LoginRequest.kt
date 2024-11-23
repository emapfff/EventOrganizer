package com.event.organizer.api.dto.request

data class LoginRequest(
    val email: String,
    val password: String
)