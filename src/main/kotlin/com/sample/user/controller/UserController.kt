package com.sample.user.controller

import com.sample.user.model.UserResponse
import com.sample.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserController(var userService: UserService) {

    @GetMapping("/{seed}")
    fun getUsers(@PathVariable("seed") seed : String) : ResponseEntity<List<UserResponse>> {
        var users : List<UserResponse>? = userService.findUsers(seed);
        return if (users != null) {
            ResponseEntity(users, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }
}