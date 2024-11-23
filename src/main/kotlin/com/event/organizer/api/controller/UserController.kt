package com.event.organizer.api.controller

import com.event.organizer.api.dto.request.LoginRequest
import com.event.organizer.service.UserService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
class UserController(
    private val userService: UserService
) {
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest) = userService.login(
        loginRequest.email,
        loginRequest.password
    )

    @PostMapping("/save")
    fun registration(@RequestBody loginRequest: LoginRequest) = userService.saveUser(
        loginRequest.email,
        loginRequest.password
    )

}