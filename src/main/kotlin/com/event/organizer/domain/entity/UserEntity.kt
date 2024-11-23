package com.event.organizer.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = -1,

    @Column(name = "email")
    var email: String = "",

    @Column(name = "password")
    var password: String = "",
)