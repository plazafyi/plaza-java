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
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.query.QueryExecuteParams
import com.plazafyi.models.query.QueryExecuteResponse
import com.plazafyi.models.query.QueryOverpassParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class QueryServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    QueryServiceAsync {

    private val withRawResponse: QueryServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): QueryServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): QueryServiceAsync =
        QueryServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun execute(
        params: QueryExecuteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<QueryExecuteResponse> =
        // post /api/v1/query
        withRawResponse().execute(params, requestOptions).thenApply { it.parse() }

    override fun overpass(
        params: QueryOverpassParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FeatureCollection> =
        // post /api/v1/overpass
        withRawResponse().overpass(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        QueryServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): QueryServiceAsync.WithRawResponse =
            QueryServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val executeHandler: Handler<QueryExecuteResponse> =
            jsonHandler<QueryExecuteResponse>(clientOptions.jsonMapper)

        override fun execute(
            params: QueryExecuteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<QueryExecuteResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "query")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { executeHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val overpassHandler: Handler<FeatureCollection> =
            jsonHandler<FeatureCollection>(clientOptions.jsonMapper)

        override fun overpass(
            params: QueryOverpassParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("api", "v1", "overpass")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { overpassHandler.handle(it) }
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
