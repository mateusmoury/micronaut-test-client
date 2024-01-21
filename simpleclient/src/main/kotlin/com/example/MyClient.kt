package com.example

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

@Client(id = "my-client")
interface MyClient {
    @Post("/hello")
    fun hello(@Body requestBody: String): String
}