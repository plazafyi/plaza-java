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
import com.plazafyi.models.elevation.ElevationBatchParams
import com.plazafyi.models.elevation.ElevationBatchResult
import com.plazafyi.models.elevation.ElevationLookupParams
import com.plazafyi.models.elevation.ElevationLookupPostParams
import com.plazafyi.models.elevation.ElevationLookupResult
import com.plazafyi.models.elevation.ElevationProfileParams
import com.plazafyi.models.elevation.ElevationProfileResult
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ElevationServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ElevationServiceAsync {

    private val withRawResponse: ElevationServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ElevationServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ElevationServiceAsync =
        ElevationServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun batch(
        params: ElevationBatchParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ElevationBatchResult> =
        // post /api/v1/elevation/batch
        withRawResponse().batch(params, requestOptions).thenApply { it.parse() }

    override fun lookup(
        params: ElevationLookupParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ElevationLookupResult> =
        // get /api/v1/elevation
        withRawResponse().lookup(params, requestOptions).thenApply { it.parse() }

    override fun lookupPost(
        params: ElevationLookupPostParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ElevationLookupResult> =
        // post /api/v1/elevation
        withRawResponse().lookupPost(params, requestOptions).thenApply { it.parse() }

    override fun profile(
        params: ElevationProfileParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ElevationProfileResult> =
        // post /api/v1/elevation/profile
        withRawResponse().profile(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ElevationServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ElevationServiceAsync.WithRawResponse =
            ElevationServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val batchHandler: Handler<ElevationBatchResult> =
            jsonHandler<ElevationBatchResult>(clientOptions.jsonMapper)

        override fun batch(
            params: ElevationBatchParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ElevationBatchResult>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "elevation", "batch")
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

        private val lookupHandler: Handler<ElevationLookupResult> =
            jsonHandler<ElevationLookupResult>(clientOptions.jsonMapper)

        override fun lookup(
            params: ElevationLookupParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ElevationLookupResult>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "elevation")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { lookupHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val lookupPostHandler: Handler<ElevationLookupResult> =
            jsonHandler<ElevationLookupResult>(clientOptions.jsonMapper)

        override fun lookupPost(
            params: ElevationLookupPostParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ElevationLookupResult>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "elevation")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { lookupPostHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val profileHandler: Handler<ElevationProfileResult> =
            jsonHandler<ElevationProfileResult>(clientOptions.jsonMapper)

        override fun profile(
            params: ElevationProfileParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ElevationProfileResult>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "elevation", "profile")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
}
