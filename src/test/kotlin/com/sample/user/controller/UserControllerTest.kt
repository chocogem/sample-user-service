package com.sample.user.controller

import com.sample.user.service.ClientApiService
import com.sample.user.service.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(UserController::class)
class UserControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @SpyBean
    private lateinit var userService : UserService

    @SpyBean
    private lateinit var clientApiService : ClientApiService


    @Test
    fun callGetUsers() {
        var givenSeed = "foobar"
        mockMvc.get("/v1/users/$givenSeed").andExpect {
            status { isOk() }
            content {
                contentTypeCompatibleWith("application/json")
            }
            MockMvcResultMatchers.jsonPath("$.firstName").hasJsonPath()
            MockMvcResultMatchers.jsonPath("$.lastName").hasJsonPath()
            MockMvcResultMatchers.jsonPath("$.gender").hasJsonPath()
            MockMvcResultMatchers.jsonPath("$.email").hasJsonPath()
        }
    }


}
