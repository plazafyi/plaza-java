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
import com.plazafyi.models.elevation.ElevationLookupParams
import com.plazafyi.models.elevation.ElevationLookupResult
import com.plazafyi.models.elevation.ElevationProfileParams
import com.plazafyi.models.elevation.ElevationProfileResult
import java.util.function.Consumer

class ElevationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ElevationService {

    private val withRawResponse: ElevationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ElevationService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ElevationService =
        ElevationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun lookup(
        params: ElevationLookupParams,
        requestOptions: RequestOptions,
    ): ElevationLookupResult =
        // post /api/v1/elevation
        withRawResponse().lookup(params, requestOptions).parse()

    override fun profile(
        params: ElevationProfileParams,
        requestOptions: RequestOptions,
    ): ElevationProfileResult =
        // post /api/v1/elevation/profile
        withRawResponse().profile(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ElevationService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ElevationService.WithRawResponse =
            ElevationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val lookupHandler: Handler<ElevationLookupResult> =
            jsonHandler<ElevationLookupResult>(clientOptions.jsonMapper)

        override fun lookup(
            params: ElevationLookupParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ElevationLookupResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "elevation")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { lookupHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val profileHandler: Handler<ElevationProfileResult> =
            jsonHandler<ElevationProfileResult>(clientOptions.jsonMapper)

        override fun profile(
            params: ElevationProfileParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ElevationProfileResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "elevation", "profile")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { profileHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
