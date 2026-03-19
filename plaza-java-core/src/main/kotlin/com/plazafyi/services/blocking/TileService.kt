// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponse
import com.plazafyi.models.tiles.TileGetParams
import java.util.function.Consumer

interface TileService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TileService

    /** Get a Mapbox Vector Tile */
    @MustBeClosed
    fun get(y: Long, params: TileGetParams): HttpResponse = get(y, params, RequestOptions.none())

    /** @see get */
    @MustBeClosed
    fun get(
        y: Long,
        params: TileGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse = get(params.toBuilder().y(y).build(), requestOptions)

    /** @see get */
    @MustBeClosed fun get(params: TileGetParams): HttpResponse = get(params, RequestOptions.none())

    /** @see get */
    @MustBeClosed
    fun get(
        params: TileGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    /** A view of [TileService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TileService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/tiles/{z}/{x}/{y}`, but is otherwise the
         * same as [TileService.get].
         */
        @MustBeClosed
        fun get(y: Long, params: TileGetParams): HttpResponse =
            get(y, params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            y: Long,
            params: TileGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = get(params.toBuilder().y(y).build(), requestOptions)

        /** @see get */
        @MustBeClosed
        fun get(params: TileGetParams): HttpResponse = get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: TileGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
