package com.event.organizer.service

import com.event.organizer.domain.entity.UserEntity
import com.event.organizer.domain.repository.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserService(
    private val userRepository: UserRepository
) {
    fun login(email: String, password: String) =
        userRepository.existsUserEntityByEmailAndPassword(email, password)

    fun saveUser(email: String, password: String) = userRepository.save(
        UserEntity(
            email = email,
            password = password
        )
    )
}