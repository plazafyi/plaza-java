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
import com.plazafyi.models.routing.MatrixResult
import com.plazafyi.models.routing.NearestResult
import com.plazafyi.models.routing.RouteResult
import com.plazafyi.models.routing.RoutingIsochroneParams
import com.plazafyi.models.routing.RoutingIsochronePostParams
import com.plazafyi.models.routing.RoutingIsochronePostResponse
import com.plazafyi.models.routing.RoutingIsochroneResponse
import com.plazafyi.models.routing.RoutingMatrixParams
import com.plazafyi.models.routing.RoutingNearestParams
import com.plazafyi.models.routing.RoutingNearestPostParams
import com.plazafyi.models.routing.RoutingRouteParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class RoutingServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RoutingServiceAsync {

    private val withRawResponse: RoutingServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RoutingServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoutingServiceAsync =
        RoutingServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun isochrone(
        params: RoutingIsochroneParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<RoutingIsochroneResponse> =
        // get /api/v1/isochrone
        withRawResponse().isochrone(params, requestOptions).thenApply { it.parse() }

    override fun isochronePost(
        params: RoutingIsochronePostParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<RoutingIsochronePostResponse> =
        // post /api/v1/isochrone
        withRawResponse().isochronePost(params, requestOptions).thenApply { it.parse() }

    override fun matrix(
        params: RoutingMatrixParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MatrixResult> =
        // post /api/v1/matrix
        withRawResponse().matrix(params, requestOptions).thenApply { it.parse() }

    override fun nearest(
        params: RoutingNearestParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NearestResult> =
        // get /api/v1/nearest
        withRawResponse().nearest(params, requestOptions).thenApply { it.parse() }

    override fun nearestPost(
        params: RoutingNearestPostParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NearestResult> =
        // post /api/v1/nearest
        withRawResponse().nearestPost(params, requestOptions).thenApply { it.parse() }

    override fun route(
        params: RoutingRouteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<RouteResult> =
        // post /api/v1/route
        withRawResponse().route(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RoutingServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RoutingServiceAsync.WithRawResponse =
            RoutingServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val isochroneHandler: Handler<RoutingIsochroneResponse> =
            jsonHandler<RoutingIsochroneResponse>(clientOptions.jsonMapper)

        override fun isochrone(
            params: RoutingIsochroneParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RoutingIsochroneResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "isochrone")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { isochroneHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val isochronePostHandler: Handler<RoutingIsochronePostResponse> =
            jsonHandler<RoutingIsochronePostResponse>(clientOptions.jsonMapper)

        override fun isochronePost(
            params: RoutingIsochronePostParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RoutingIsochronePostResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "isochrone")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { isochronePostHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val matrixHandler: Handler<MatrixResult> =
            jsonHandler<MatrixResult>(clientOptions.jsonMapper)

        override fun matrix(
            params: RoutingMatrixParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MatrixResult>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "matrix")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { matrixHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val nearestHandler: Handler<NearestResult> =
            jsonHandler<NearestResult>(clientOptions.jsonMapper)

        override fun nearest(
            params: RoutingNearestParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NearestResult>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "nearest")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { nearestHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val nearestPostHandler: Handler<NearestResult> =
            jsonHandler<NearestResult>(clientOptions.jsonMapper)

        override fun nearestPost(
            params: RoutingNearestPostParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NearestResult>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "nearest")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { nearestPostHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val routeHandler: Handler<RouteResult> =
            jsonHandler<RouteResult>(clientOptions.jsonMapper)

        override fun route(
            params: RoutingRouteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RouteResult>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "route")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { routeHandler.handle(it) }
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
