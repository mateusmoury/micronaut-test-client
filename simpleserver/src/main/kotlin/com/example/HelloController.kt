package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/hello")
class HelloController {

    @Post(processes = [MediaType.APPLICATION_JSON])
    fun index(request: HttpRequest<ByteArray>): HttpResponse<String> {
        return HttpResponse.ok<String?>().body("LOCALHOST BEING CALLED. URI: ${request.uri}")
    }
}
