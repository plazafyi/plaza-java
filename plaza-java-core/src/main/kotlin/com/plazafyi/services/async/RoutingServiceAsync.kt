// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.routing.IsochroneRequest
import com.plazafyi.models.routing.MatrixRequest
import com.plazafyi.models.routing.MatrixResult
import com.plazafyi.models.routing.NearestRequest
import com.plazafyi.models.routing.NearestResult
import com.plazafyi.models.routing.RouteRequest
import com.plazafyi.models.routing.RouteResult
import com.plazafyi.models.routing.RoutingIsochroneParams
import com.plazafyi.models.routing.RoutingIsochroneResponse
import com.plazafyi.models.routing.RoutingMatrixParams
import com.plazafyi.models.routing.RoutingNearestParams
import com.plazafyi.models.routing.RoutingRouteParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface RoutingServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoutingServiceAsync

    /** Calculate an isochrone from a point */
    fun isochrone(params: RoutingIsochroneParams): CompletableFuture<RoutingIsochroneResponse> =
        isochrone(params, RequestOptions.none())

    /** @see isochrone */
    fun isochrone(
        params: RoutingIsochroneParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RoutingIsochroneResponse>

    /** @see isochrone */
    fun isochrone(
        isochroneRequest: IsochroneRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RoutingIsochroneResponse> =
        isochrone(
            RoutingIsochroneParams.builder().isochroneRequest(isochroneRequest).build(),
            requestOptions,
        )

    /** @see isochrone */
    fun isochrone(isochroneRequest: IsochroneRequest): CompletableFuture<RoutingIsochroneResponse> =
        isochrone(isochroneRequest, RequestOptions.none())

    /** Calculate a distance matrix between points */
    fun matrix(params: RoutingMatrixParams): CompletableFuture<MatrixResult> =
        matrix(params, RequestOptions.none())

    /** @see matrix */
    fun matrix(
        params: RoutingMatrixParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MatrixResult>

    /** @see matrix */
    fun matrix(
        matrixRequest: MatrixRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MatrixResult> =
        matrix(RoutingMatrixParams.builder().matrixRequest(matrixRequest).build(), requestOptions)

    /** @see matrix */
    fun matrix(matrixRequest: MatrixRequest): CompletableFuture<MatrixResult> =
        matrix(matrixRequest, RequestOptions.none())

    /** Snap a coordinate to the nearest road */
    fun nearest(params: RoutingNearestParams): CompletableFuture<NearestResult> =
        nearest(params, RequestOptions.none())

    /** @see nearest */
    fun nearest(
        params: RoutingNearestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NearestResult>

    /** @see nearest */
    fun nearest(
        nearestRequest: NearestRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NearestResult> =
        nearest(
            RoutingNearestParams.builder().nearestRequest(nearestRequest).build(),
            requestOptions,
        )

    /** @see nearest */
    fun nearest(nearestRequest: NearestRequest): CompletableFuture<NearestResult> =
        nearest(nearestRequest, RequestOptions.none())

    /** Calculate a route between two points */
    fun route(params: RoutingRouteParams): CompletableFuture<RouteResult> =
        route(params, RequestOptions.none())

    /** @see route */
    fun route(
        params: RoutingRouteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RouteResult>

    /** @see route */
    fun route(
        routeRequest: RouteRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RouteResult> =
        route(RoutingRouteParams.builder().routeRequest(routeRequest).build(), requestOptions)

    /** @see route */
    fun route(routeRequest: RouteRequest): CompletableFuture<RouteResult> =
        route(routeRequest, RequestOptions.none())

    /**
     * A view of [RoutingServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RoutingServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/isochrone`, but is otherwise the same as
         * [RoutingServiceAsync.isochrone].
         */
        fun isochrone(
            params: RoutingIsochroneParams
        ): CompletableFuture<HttpResponseFor<RoutingIsochroneResponse>> =
            isochrone(params, RequestOptions.none())

        /** @see isochrone */
        fun isochrone(
            params: RoutingIsochroneParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RoutingIsochroneResponse>>

        /** @see isochrone */
        fun isochrone(
            isochroneRequest: IsochroneRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RoutingIsochroneResponse>> =
            isochrone(
                RoutingIsochroneParams.builder().isochroneRequest(isochroneRequest).build(),
                requestOptions,
            )

        /** @see isochrone */
        fun isochrone(
            isochroneRequest: IsochroneRequest
        ): CompletableFuture<HttpResponseFor<RoutingIsochroneResponse>> =
            isochrone(isochroneRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `post /api/v1/matrix`, but is otherwise the same as
         * [RoutingServiceAsync.matrix].
         */
        fun matrix(params: RoutingMatrixParams): CompletableFuture<HttpResponseFor<MatrixResult>> =
            matrix(params, RequestOptions.none())

        /** @see matrix */
        fun matrix(
            params: RoutingMatrixParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MatrixResult>>

        /** @see matrix */
        fun matrix(
            matrixRequest: MatrixRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MatrixResult>> =
            matrix(
                RoutingMatrixParams.builder().matrixRequest(matrixRequest).build(),
                requestOptions,
            )

        /** @see matrix */
        fun matrix(matrixRequest: MatrixRequest): CompletableFuture<HttpResponseFor<MatrixResult>> =
            matrix(matrixRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `post /api/v1/nearest`, but is otherwise the same as
         * [RoutingServiceAsync.nearest].
         */
        fun nearest(
            params: RoutingNearestParams
        ): CompletableFuture<HttpResponseFor<NearestResult>> =
            nearest(params, RequestOptions.none())

        /** @see nearest */
        fun nearest(
            params: RoutingNearestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NearestResult>>

        /** @see nearest */
        fun nearest(
            nearestRequest: NearestRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NearestResult>> =
            nearest(
                RoutingNearestParams.builder().nearestRequest(nearestRequest).build(),
                requestOptions,
            )

        /** @see nearest */
        fun nearest(
            nearestRequest: NearestRequest
        ): CompletableFuture<HttpResponseFor<NearestResult>> =
            nearest(nearestRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `post /api/v1/route`, but is otherwise the same as
         * [RoutingServiceAsync.route].
         */
        fun route(params: RoutingRouteParams): CompletableFuture<HttpResponseFor<RouteResult>> =
            route(params, RequestOptions.none())

        /** @see route */
        fun route(
            params: RoutingRouteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RouteResult>>

        /** @see route */
        fun route(
            routeRequest: RouteRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RouteResult>> =
            route(RoutingRouteParams.builder().routeRequest(routeRequest).build(), requestOptions)

        /** @see route */
        fun route(routeRequest: RouteRequest): CompletableFuture<HttpResponseFor<RouteResult>> =
            route(routeRequest, RequestOptions.none())
    }
}
