package com.event.organizer.domain.repository

import com.event.organizer.domain.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun existsUserEntityByEmailAndPassword(email: String, password: String): Boolean
    fun findUserEntityByEmail(email: String): UserEntity
}