package com.sample.user.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class RandomUser (
    var results: List<Result>? = null,
    var info: Info? = null,
)

data class Result(
    var gender: String?= null,
    var name: Name?= null,
    var location: Location?= null,
    var email: String?= null,
    var login: Login?= null,
    var dob: Dob?= null,
    var registered: Registered?= null,
    var phone: String?= null,
    var cell: String?= null,
    var id: Id?= null,
    var picture: Picture?= null,
    var nat: String?= null,
)

data class Name(
    var title: String?= null,
    var first: String?= null,
    var last: String?= null,
)

data class Location(
    var street: Street?= null,
    var city: String?= null,
    var state: String?= null,
    var country: String?= null,
    var postcode: String?= null,
    var coordinates: Coordinates?= null,
    var timezone: Timezone?= null,
)

data class Street(
    var number: Long?= null,
    var name: String?= null,
)

data class Coordinates(
    var latitude: String?= null,
    var longitude: String?= null,
)

data class Timezone(
    var offset: String?= null,
    var description: String?= null,
)

data class Login(
    var uuid: String?= null,
    var username: String?= null,
    var password: String?= null,
    var salt: String?= null,
    var md5: String?= null,
    var sha1: String?= null,
    var sha256: String?= null,
)

data class Dob(
    var date: String?= null,
    var age: Long?= null,
)

data class Registered(
    var date: String?= null,
    var age: Long?= null,
)

data class Id(
    var name: String?= null,
    var value: String?= null,
)

data class Picture(
    var large: String?= null,
    var medium: String?= null,
    var thumbnail: String?= null,
)

data class Info(
    var seed: String?= null,
    var results: Long?= null,
    var page: Long?= null,
    var version: String?= null,
)
