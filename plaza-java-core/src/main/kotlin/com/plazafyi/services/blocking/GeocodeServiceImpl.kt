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
import com.plazafyi.models.geocode.AutocompleteResult
import com.plazafyi.models.geocode.GeocodeAutocompleteParams
import com.plazafyi.models.geocode.GeocodeBatchParams
import com.plazafyi.models.geocode.GeocodeBatchResponse
import com.plazafyi.models.geocode.GeocodeForwardParams
import com.plazafyi.models.geocode.GeocodeResult
import com.plazafyi.models.geocode.GeocodeReverseParams
import com.plazafyi.models.geocode.ReverseGeocodeResult
import java.util.function.Consumer

class GeocodeServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    GeocodeService {

    private val withRawResponse: GeocodeService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GeocodeService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): GeocodeService =
        GeocodeServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun autocomplete(
        params: GeocodeAutocompleteParams,
        requestOptions: RequestOptions,
    ): AutocompleteResult =
        // post /api/v1/geocode/autocomplete
        withRawResponse().autocomplete(params, requestOptions).parse()

    override fun batch(
        params: GeocodeBatchParams,
        requestOptions: RequestOptions,
    ): GeocodeBatchResponse =
        // post /api/v1/geocode/batch
        withRawResponse().batch(params, requestOptions).parse()

    override fun forward(
        params: GeocodeForwardParams,
        requestOptions: RequestOptions,
    ): GeocodeResult =
        // post /api/v1/geocode
        withRawResponse().forward(params, requestOptions).parse()

    override fun reverse(
        params: GeocodeReverseParams,
        requestOptions: RequestOptions,
    ): ReverseGeocodeResult =
        // post /api/v1/geocode/reverse
        withRawResponse().reverse(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GeocodeService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GeocodeService.WithRawResponse =
            GeocodeServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val autocompleteHandler: Handler<AutocompleteResult> =
            jsonHandler<AutocompleteResult>(clientOptions.jsonMapper)

        override fun autocomplete(
            params: GeocodeAutocompleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AutocompleteResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode", "autocomplete")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { autocompleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val batchHandler: Handler<GeocodeBatchResponse> =
            jsonHandler<GeocodeBatchResponse>(clientOptions.jsonMapper)

        override fun batch(
            params: GeocodeBatchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GeocodeBatchResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode", "batch")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { batchHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val forwardHandler: Handler<GeocodeResult> =
            jsonHandler<GeocodeResult>(clientOptions.jsonMapper)

        override fun forward(
            params: GeocodeForwardParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GeocodeResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { forwardHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val reverseHandler: Handler<ReverseGeocodeResult> =
            jsonHandler<ReverseGeocodeResult>(clientOptions.jsonMapper)

        override fun reverse(
            params: GeocodeReverseParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ReverseGeocodeResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode", "reverse")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { reverseHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
