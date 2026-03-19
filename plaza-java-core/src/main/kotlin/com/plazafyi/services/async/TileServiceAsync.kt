// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponse
import com.plazafyi.models.tiles.TileGetParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TileServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TileServiceAsync

    /** Get a Mapbox Vector Tile */
    fun get(y: Long, params: TileGetParams): CompletableFuture<HttpResponse> =
        get(y, params, RequestOptions.none())

    /** @see get */
    fun get(
        y: Long,
        params: TileGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse> = get(params.toBuilder().y(y).build(), requestOptions)

    /** @see get */
    fun get(params: TileGetParams): CompletableFuture<HttpResponse> =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(
        params: TileGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /** A view of [TileServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TileServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/tiles/{z}/{x}/{y}`, but is otherwise the
         * same as [TileServiceAsync.get].
         */
        fun get(y: Long, params: TileGetParams): CompletableFuture<HttpResponse> =
            get(y, params, RequestOptions.none())

        /** @see get */
        fun get(
            y: Long,
            params: TileGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> = get(params.toBuilder().y(y).build(), requestOptions)

        /** @see get */
        fun get(params: TileGetParams): CompletableFuture<HttpResponse> =
            get(params, RequestOptions.none())

        /** @see get */
        fun get(
            params: TileGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
