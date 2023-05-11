package com.sample.user.controller

import com.sample.user.model.Result
import com.sample.user.model.Name
import com.sample.user.model.RandomUser
import com.sample.user.service.ClientApiService
import com.sample.user.service.UserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import java.util.*

@ExtendWith(MockitoExtension::class)
class UserServiceTest {

    @InjectMocks
    private lateinit var userService : UserService

    @Mock
    private lateinit var clientApiService: ClientApiService

    @Test
    fun whenFindUsersCallRandomUserSuccessShouldReturnCorrectResponse() {
        var givenSeed = "foobar"
        var mockRandomUsers =  Arrays.asList(
            RandomUser(
                Arrays.asList(
                    Result(gender = "female" ,
                        Name(first = "TestFirstName1", last = "TestLastName1"),
                        email = "test.dev1.gmail.com"
                    ),
                    Result(gender = "male" ,
                        Name(first = "TestFirstName2", last = "TestLastName2"),
                        email = "test.dev2.gmail.com"
                    )
                )
            )

        )

        Mockito.doReturn(mockRandomUsers).`when`(clientApiService).callRandomUser(givenSeed)
        var actualResult = userService.findUsers(givenSeed )
        Assertions.assertEquals(2,actualResult.size)
        Assertions.assertEquals("TestFirstName1",actualResult[0].firstName)
        Assertions.assertEquals("TestLastName1",actualResult[0].lastName)
        Assertions.assertEquals("female",actualResult[0].gender)
        Assertions.assertEquals("test.dev1.gmail.com",actualResult[0].email)

        Assertions.assertEquals("TestFirstName2",actualResult[1].firstName)
        Assertions.assertEquals("TestLastName2",actualResult[1].lastName)
        Assertions.assertEquals("male",actualResult[1].gender)
        Assertions.assertEquals("test.dev2.gmail.com",actualResult[1].email)
    }


    @Test
    fun whenFindUsersCallRandomUserExceptionShouldThrowsException() {
        var givenSeed = "foobar"

        Mockito.doThrow(ResponseStatusException(HttpStatus.NOT_FOUND)).`when`(clientApiService).callRandomUser(givenSeed)
        Assertions.assertThrows(
            ResponseStatusException::class.java
        ) { userService.findUsers(givenSeed) }
            .status.value().compareTo(404)
    }


}