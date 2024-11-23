package com.event.organizer.service

import com.event.organizer.api.dto.request.EventRequest
import com.event.organizer.api.dto.response.EventResponse
import com.event.organizer.domain.entity.EventEntity
import com.event.organizer.domain.entity.UserEntity
import com.event.organizer.domain.repository.EventRepository
import com.event.organizer.domain.repository.UserRepository
import jakarta.transaction.Transactional
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class EventService(
    private val eventRepository: EventRepository,
    private val userRepository: UserRepository
) {
    @Transactional
    fun save(email: String, eventRequest: EventRequest) {
        val user: UserEntity = userRepository.findUserEntityByEmail(email)
        eventRepository.save(
            EventEntity(
                title = eventRequest.title,
                location = eventRequest.location,
                description = eventRequest.description,
                time = eventRequest.time,
                imgUrl = eventRequest.imgUrl,
                user = user
            )
        )
    }

    @Transactional
    fun delete(id: Long) = eventRepository.deleteEventEntityById(id)

    @Transactional
    fun update(id: Long, request: EventRequest): EventRequest {
        val event: EventEntity = eventRepository.findEventEntityById(id)
        event.time = request.time
        event.title = request.title
        event.imgUrl = request.imgUrl
        event.description = request.description
        event.location = request.location
        eventRepository.save(event)
        return request
    }


    @Transactional
    fun getAll(email: String): List<EventResponse> {
        val user: UserEntity = userRepository.findUserEntityByEmail(email)
        val events: List<EventResponse> = eventRepository.findAllByUser(user)
            .stream()
            .map { eventEntity ->
                EventResponse(
                    id = eventEntity.id,
                    title = eventEntity.title,
                    imgUrl = eventEntity.imgUrl,
                    time = eventEntity.time,
                    location = eventEntity.location,
                    description = eventEntity.description
                )
            }
            .toList()
        return events
    }
}