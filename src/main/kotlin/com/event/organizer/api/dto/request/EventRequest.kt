package com.event.organizer.api.dto.request

data class EventRequest(
    val title: String,
    val imgUrl: String,
    val time: String,
    val location: String,
    val description: String
)