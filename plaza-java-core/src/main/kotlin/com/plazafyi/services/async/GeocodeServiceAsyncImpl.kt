// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

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
import com.plazafyi.core.prepareAsync
import com.plazafyi.models.geocode.AutocompleteResult
import com.plazafyi.models.geocode.GeocodeAutocompleteParams
import com.plazafyi.models.geocode.GeocodeBatchParams
import com.plazafyi.models.geocode.GeocodeBatchResponse
import com.plazafyi.models.geocode.GeocodeForwardParams
import com.plazafyi.models.geocode.GeocodeResult
import com.plazafyi.models.geocode.GeocodeReverseParams
import com.plazafyi.models.geocode.ReverseGeocodeResult
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class GeocodeServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    GeocodeServiceAsync {

    private val withRawResponse: GeocodeServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GeocodeServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): GeocodeServiceAsync =
        GeocodeServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun autocomplete(
        params: GeocodeAutocompleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AutocompleteResult> =
        // get /api/v1/geocode/autocomplete
        withRawResponse().autocomplete(params, requestOptions).thenApply { it.parse() }

    override fun batch(
        params: GeocodeBatchParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GeocodeBatchResponse> =
        // post /api/v1/geocode/batch
        withRawResponse().batch(params, requestOptions).thenApply { it.parse() }

    override fun forward(
        params: GeocodeForwardParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GeocodeResult> =
        // get /api/v1/geocode
        withRawResponse().forward(params, requestOptions).thenApply { it.parse() }

    override fun reverse(
        params: GeocodeReverseParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ReverseGeocodeResult> =
        // get /api/v1/geocode/reverse
        withRawResponse().reverse(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GeocodeServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GeocodeServiceAsync.WithRawResponse =
            GeocodeServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val autocompleteHandler: Handler<AutocompleteResult> =
            jsonHandler<AutocompleteResult>(clientOptions.jsonMapper)

        override fun autocomplete(
            params: GeocodeAutocompleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AutocompleteResult>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode", "autocomplete")
                    .putHeader("Accept", "application/geo+json")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { autocompleteHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val batchHandler: Handler<GeocodeBatchResponse> =
            jsonHandler<GeocodeBatchResponse>(clientOptions.jsonMapper)

        override fun batch(
            params: GeocodeBatchParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GeocodeBatchResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode", "batch")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { batchHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val forwardHandler: Handler<GeocodeResult> =
            jsonHandler<GeocodeResult>(clientOptions.jsonMapper)

        override fun forward(
            params: GeocodeForwardParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GeocodeResult>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode")
                    .putHeader("Accept", "application/geo+json")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { forwardHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val reverseHandler: Handler<ReverseGeocodeResult> =
            jsonHandler<ReverseGeocodeResult>(clientOptions.jsonMapper)

        override fun reverse(
            params: GeocodeReverseParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ReverseGeocodeResult>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "geocode", "reverse")
                    .putHeader("Accept", "application/geo+json")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
}
