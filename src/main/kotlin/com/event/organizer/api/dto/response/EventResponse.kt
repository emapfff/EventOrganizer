package com.event.organizer.api.dto.response

data class EventResponse(
    val id: Long,
    val title: String,
    val imgUrl: String,
    val time: String,
    val location: String,
    val description: String
)