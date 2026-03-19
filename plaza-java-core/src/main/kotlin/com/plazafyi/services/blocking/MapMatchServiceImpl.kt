// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.handlers.errorBodyHandler
import com.plazafyi.core.handlers.errorHandler
import com.plazafyi.core.handlers.jsonHandler
import com.plazafyi.core.http.HttpMethod
import com.plazafyi.core.http.HttpRequest
import com.plazafyi.core.http.HttpResponse
import com.plazafyi.core.http.HttpResponse.Handler
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.core.http.json
import com.plazafyi.core.http.parseable
import com.plazafyi.core.prepare
import com.plazafyi.models.mapmatch.MapMatchMatchParams
import com.plazafyi.models.mapmatch.MapMatchResult
import java.util.function.Consumer

class MapMatchServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MapMatchService {

    private val withRawResponse: MapMatchService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MapMatchService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MapMatchService =
        MapMatchServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun match(
        params: MapMatchMatchParams,
        requestOptions: RequestOptions,
    ): MapMatchResult =
        // post /api/v1/map-match
        withRawResponse().match(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MapMatchService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MapMatchService.WithRawResponse =
            MapMatchServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val matchHandler: Handler<MapMatchResult> =
            jsonHandler<MapMatchResult>(clientOptions.jsonMapper)

        override fun match(
            params: MapMatchMatchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MapMatchResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "map-match")
                    .putHeader("Accept", "application/geo+json")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { matchHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
