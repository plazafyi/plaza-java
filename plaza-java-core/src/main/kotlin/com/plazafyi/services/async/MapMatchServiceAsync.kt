// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.mapmatch.MapMatchMatchParams
import com.plazafyi.models.mapmatch.MapMatchRequest
import com.plazafyi.models.mapmatch.MapMatchResult
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface MapMatchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MapMatchServiceAsync

    /** Match GPS coordinates to the road network */
    fun match(params: MapMatchMatchParams): CompletableFuture<MapMatchResult> =
        match(params, RequestOptions.none())

    /** @see match */
    fun match(
        params: MapMatchMatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MapMatchResult>

    /** @see match */
    fun match(
        mapMatchRequest: MapMatchRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MapMatchResult> =
        match(
            MapMatchMatchParams.builder().mapMatchRequest(mapMatchRequest).build(),
            requestOptions,
        )

    /** @see match */
    fun match(mapMatchRequest: MapMatchRequest): CompletableFuture<MapMatchResult> =
        match(mapMatchRequest, RequestOptions.none())

    /**
     * A view of [MapMatchServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MapMatchServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/map-match`, but is otherwise the same as
         * [MapMatchServiceAsync.match].
         */
        fun match(params: MapMatchMatchParams): CompletableFuture<HttpResponseFor<MapMatchResult>> =
            match(params, RequestOptions.none())

        /** @see match */
        fun match(
            params: MapMatchMatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MapMatchResult>>

        /** @see match */
        fun match(
            mapMatchRequest: MapMatchRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MapMatchResult>> =
            match(
                MapMatchMatchParams.builder().mapMatchRequest(mapMatchRequest).build(),
                requestOptions,
            )

        /** @see match */
        fun match(
            mapMatchRequest: MapMatchRequest
        ): CompletableFuture<HttpResponseFor<MapMatchResult>> =
            match(mapMatchRequest, RequestOptions.none())
    }
}
