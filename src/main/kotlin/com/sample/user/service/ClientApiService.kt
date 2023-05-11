package com.sample.user.service

import com.sample.user.config.ClientApiConfig
import com.sample.user.model.RandomUser
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ClientApiService(clientApiConfig: ClientApiConfig) {
    var webClient : WebClient = WebClient.builder().baseUrl(clientApiConfig.apiUrl).build()

    fun callRandomUser(seed: String): List<RandomUser> {
        val userStream: Flux<RandomUser> = webClient.get()
            .uri("/?seed=$seed")
            .retrieve()
            .onStatus({ responseStatus -> responseStatus == HttpStatus.NOT_FOUND
            }) { throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR) }
            .onStatus({ responseStatus: HttpStatus -> responseStatus.is5xxServerError
            }) { throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR) }
            .bodyToFlux(RandomUser::class.java)
        val collectedUsersStream: Mono<List<RandomUser>> = userStream.collectList()
        return collectedUsersStream.block().orEmpty()
    }


}