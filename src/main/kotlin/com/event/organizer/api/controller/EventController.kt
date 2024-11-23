package com.event.organizer.api.controller

import com.event.organizer.api.dto.request.EventRequest
import com.event.organizer.service.EventService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
class EventController(
    private val eventService: EventService
) {
    @PostMapping("/save/{email}")
    fun saveEvent(@PathVariable email: String, @RequestBody event: EventRequest) {
        eventService.save(email, event)
    }

    @GetMapping("/all/{email}")
    fun getEvents(@PathVariable email: String) = eventService.getAll(email)

    @PatchMapping("/{id}")
    fun updateEvent(@PathVariable id: Long, @RequestBody event: EventRequest) = eventService.update(id, event)

    @DeleteMapping("/{id}")
    fun deleteEvent(@PathVariable id: Long) = eventService.delete(id)
}