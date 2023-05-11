package com.sample.user.service

import com.sample.user.config.ClientApiConfig
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.web.server.ResponseStatusException

@ExtendWith(MockitoExtension::class)
class ClientApiServiceTest {


    private lateinit var clientApiService : ClientApiService

    @Mock
    private lateinit var clientApiConfig: ClientApiConfig


    @Test
    fun whenCallRandomUserWithCorrectUrlShouldReturnNotNull() {
        Mockito.doReturn("https://randomuser.me/api/").`when`(clientApiConfig).apiUrl
        clientApiService =  ClientApiService(clientApiConfig);
        var givenSeed = "foobar"
        var actualResult = clientApiService.callRandomUser(givenSeed)
        Assertions.assertNotNull(actualResult)
    }

    @Test
    fun whenCallRandomUserWithInCorrectUrlSeedShouldThrowResponseStatusException_404() {
        Mockito.doReturn("https://randomuser.me/xxx/").`when`(clientApiConfig).apiUrl
        clientApiService =  ClientApiService(clientApiConfig);
        var givenSeed = "foobar"
        Assertions.assertThrows(
            ResponseStatusException::class.java
        ) { clientApiService.callRandomUser(givenSeed) }
            .status.value().compareTo(404)
    }


}