package com.sample.user.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "app.client")
data class ClientApiConfig (
    var apiUrl: String = "",

    )
