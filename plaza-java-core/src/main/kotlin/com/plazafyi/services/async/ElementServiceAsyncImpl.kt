// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.checkRequired
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
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.GeoJsonFeature
import com.plazafyi.models.elements.ElementBatchParams
import com.plazafyi.models.elements.ElementNearbyParams
import com.plazafyi.models.elements.ElementQueryParams
import com.plazafyi.models.elements.ElementRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ElementServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ElementServiceAsync {

    private val withRawResponse: ElementServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ElementServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ElementServiceAsync =
        ElementServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: ElementRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GeoJsonFeature> =
        // get /api/v1/features/{type}/{id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun batch(
        params: ElementBatchParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FeatureCollection> =
        // post /api/v1/features/batch
        withRawResponse().batch(params, requestOptions).thenApply { it.parse() }

    override fun nearby(
        params: ElementNearbyParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FeatureCollection> =
        // get /api/v1/features/nearby
        withRawResponse().nearby(params, requestOptions).thenApply { it.parse() }

    override fun query(
        params: ElementQueryParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FeatureCollection> =
        // get /api/v1/features
        withRawResponse().query(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ElementServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ElementServiceAsync.WithRawResponse =
            ElementServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<GeoJsonFeature> =
            jsonHandler<GeoJsonFeature>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ElementRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GeoJsonFeature>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "api",
                        "v1",
                        "features",
                        params._pathParam(0),
                        params._pathParam(1),
                    )
                    .putHeader("Accept", "application/geo+json")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val batchHandler: Handler<FeatureCollection> =
            jsonHandler<FeatureCollection>(clientOptions.jsonMapper)

        override fun batch(
            params: ElementBatchParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "features", "batch")
                    .putHeader("Accept", "application/geo+json")
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

        private val nearbyHandler: Handler<FeatureCollection> =
            jsonHandler<FeatureCollection>(clientOptions.jsonMapper)

        override fun nearby(
            params: ElementNearbyParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "features", "nearby")
                    .putHeader("Accept", "application/geo+json")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { nearbyHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val queryHandler: Handler<FeatureCollection> =
            jsonHandler<FeatureCollection>(clientOptions.jsonMapper)

        override fun query(
            params: ElementQueryParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "features")
                    .putHeader("Accept", "application/geo+json")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { queryHandler.handle(it) }
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
