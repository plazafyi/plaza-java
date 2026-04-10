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
import com.plazafyi.models.routing.MatrixResult
import com.plazafyi.models.routing.NearestResult
import com.plazafyi.models.routing.RouteResult
import com.plazafyi.models.routing.RoutingIsochroneParams
import com.plazafyi.models.routing.RoutingIsochroneResponse
import com.plazafyi.models.routing.RoutingMatrixParams
import com.plazafyi.models.routing.RoutingNearestParams
import com.plazafyi.models.routing.RoutingRouteParams
import java.util.function.Consumer

class RoutingServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    RoutingService {

    private val withRawResponse: RoutingService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RoutingService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoutingService =
        RoutingServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun isochrone(
        params: RoutingIsochroneParams,
        requestOptions: RequestOptions,
    ): RoutingIsochroneResponse =
        // post /api/v1/isochrone
        withRawResponse().isochrone(params, requestOptions).parse()

    override fun matrix(params: RoutingMatrixParams, requestOptions: RequestOptions): MatrixResult =
        // post /api/v1/matrix
        withRawResponse().matrix(params, requestOptions).parse()

    override fun nearest(
        params: RoutingNearestParams,
        requestOptions: RequestOptions,
    ): NearestResult =
        // post /api/v1/nearest
        withRawResponse().nearest(params, requestOptions).parse()

    override fun route(params: RoutingRouteParams, requestOptions: RequestOptions): RouteResult =
        // post /api/v1/route
        withRawResponse().route(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RoutingService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RoutingService.WithRawResponse =
            RoutingServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val isochroneHandler: Handler<RoutingIsochroneResponse> =
            jsonHandler<RoutingIsochroneResponse>(clientOptions.jsonMapper)

        override fun isochrone(
            params: RoutingIsochroneParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RoutingIsochroneResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "isochrone")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { isochroneHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val matrixHandler: Handler<MatrixResult> =
            jsonHandler<MatrixResult>(clientOptions.jsonMapper)

        override fun matrix(
            params: RoutingMatrixParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MatrixResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "matrix")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { matrixHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val nearestHandler: Handler<NearestResult> =
            jsonHandler<NearestResult>(clientOptions.jsonMapper)

        override fun nearest(
            params: RoutingNearestParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NearestResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "nearest")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { nearestHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val routeHandler: Handler<RouteResult> =
            jsonHandler<RouteResult>(clientOptions.jsonMapper)

        override fun route(
            params: RoutingRouteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RouteResult> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "route")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
