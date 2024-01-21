package com.example

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.ClientFilterChain
import io.micronaut.http.filter.HttpClientFilter
import io.micronaut.http.uri.UriBuilder
import org.reactivestreams.Publisher

@Filter(Filter.MATCH_ALL_PATTERN)
class MyClientFilter : HttpClientFilter {
    override fun doFilter(request: MutableHttpRequest<*>, chain: ClientFilterChain): Publisher<out HttpResponse<*>> {
        val requestUri = UriBuilder.of("https://www.google.com")
            .path(request.path)
            .queryParam("custom-param", "custom-value")
            .build()

        return chain.proceed(request.uri(requestUri).header("custom-header", "custom-header-value"))
    }
}
