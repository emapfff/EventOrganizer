package com.event.organizer.domain.repository

import com.event.organizer.domain.entity.EventEntity
import com.event.organizer.domain.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository : JpaRepository<EventEntity, Long> {
    fun findAllByUser(user: UserEntity): List<EventEntity>
    fun deleteEventEntityById(id: Long)
    fun findEventEntityById(id: Long): EventEntity
}