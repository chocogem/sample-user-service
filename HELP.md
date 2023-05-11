Sample User Service
====================
This project using SpringBoot to get random user from Random User API.

Getting Started
====================

Build and Run Test:

`mvn clean install`

Run Service:

`mvn spring-boot:run`

Testing the API
====================

GET — Get Users

Example Request:
```
curl --location 'localhost:8080/v1/users/{seed}'
```

Example Response:
```
[
    {
        "firstName": "xxxxxx",
        "lastName": "xxxxxx",
        "gender": "xxxxx",
        "email": "xxxxxx"
    }
]
```
Building with
====================
* InteliJ
* Maven
* Kotlin

System required
====================
JDK 11 
