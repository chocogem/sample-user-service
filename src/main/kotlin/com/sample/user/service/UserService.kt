package com.sample.user.service

import com.sample.user.model.UserResponse
import org.springframework.stereotype.Service

@Service
class UserService (var clientApiService: ClientApiService) {

    fun findUsers(seed: String): List<UserResponse> {
        var users  = ArrayList<UserResponse>()
        clientApiService.callRandomUser(seed).forEach { it ->
            var firstName = ""
            var lastName = ""
            var gender = ""
            var email = ""

            it.results?.forEach { result ->

                var name = result.name
                name ?.let{it ->
                    firstName = it.first.orEmpty()
                    lastName = it.last.orEmpty()
                }
                gender = result.gender.orEmpty()
                email = result.email.orEmpty()
                users.add(UserResponse(firstName,lastName,gender,email))
            }

        }

        return users
    }
}