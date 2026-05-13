// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

interface RoutingService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoutingService

    /** Calculate an isochrone from a point */
    fun isochrone(params: RoutingIsochroneParams): RoutingIsochroneResponse =
        isochrone(params, RequestOptions.none())

    /** @see isochrone */
    fun isochrone(
        params: RoutingIsochroneParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoutingIsochroneResponse

    /** @see isochrone */
    fun isochrone(
        isochroneRequest: IsochroneRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoutingIsochroneResponse =
        isochrone(
            RoutingIsochroneParams.builder().isochroneRequest(isochroneRequest).build(),
            requestOptions,
        )

    /** @see isochrone */
    fun isochrone(isochroneRequest: IsochroneRequest): RoutingIsochroneResponse =
        isochrone(isochroneRequest, RequestOptions.none())

    /** Calculate a distance matrix between points */
    fun matrix(params: RoutingMatrixParams): MatrixResult = matrix(params, RequestOptions.none())

    /** @see matrix */
    fun matrix(
        params: RoutingMatrixParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MatrixResult

    /** @see matrix */
    fun matrix(
        matrixRequest: MatrixRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MatrixResult =
        matrix(RoutingMatrixParams.builder().matrixRequest(matrixRequest).build(), requestOptions)

    /** @see matrix */
    fun matrix(matrixRequest: MatrixRequest): MatrixResult =
        matrix(matrixRequest, RequestOptions.none())

    /** Snap a coordinate to the nearest road */
    fun nearest(params: RoutingNearestParams): NearestResult =
        nearest(params, RequestOptions.none())

    /** @see nearest */
    fun nearest(
        params: RoutingNearestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NearestResult

    /** @see nearest */
    fun nearest(
        nearestRequest: NearestRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NearestResult =
        nearest(
            RoutingNearestParams.builder().nearestRequest(nearestRequest).build(),
            requestOptions,
        )

    /** @see nearest */
    fun nearest(nearestRequest: NearestRequest): NearestResult =
        nearest(nearestRequest, RequestOptions.none())

    /** Calculate a route between two points */
    fun route(params: RoutingRouteParams): RouteResult = route(params, RequestOptions.none())

    /** @see route */
    fun route(
        params: RoutingRouteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RouteResult

    /** @see route */
    fun route(
        routeRequest: RouteRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RouteResult =
        route(RoutingRouteParams.builder().routeRequest(routeRequest).build(), requestOptions)

    /** @see route */
    fun route(routeRequest: RouteRequest): RouteResult = route(routeRequest, RequestOptions.none())

    /** A view of [RoutingService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RoutingService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/isochrone`, but is otherwise the same as
         * [RoutingService.isochrone].
         */
        @MustBeClosed
        fun isochrone(params: RoutingIsochroneParams): HttpResponseFor<RoutingIsochroneResponse> =
            isochrone(params, RequestOptions.none())

        /** @see isochrone */
        @MustBeClosed
        fun isochrone(
            params: RoutingIsochroneParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoutingIsochroneResponse>

        /** @see isochrone */
        @MustBeClosed
        fun isochrone(
            isochroneRequest: IsochroneRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoutingIsochroneResponse> =
            isochrone(
                RoutingIsochroneParams.builder().isochroneRequest(isochroneRequest).build(),
                requestOptions,
            )

        /** @see isochrone */
        @MustBeClosed
        fun isochrone(
            isochroneRequest: IsochroneRequest
        ): HttpResponseFor<RoutingIsochroneResponse> =
            isochrone(isochroneRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `post /api/v1/matrix`, but is otherwise the same as
         * [RoutingService.matrix].
         */
        @MustBeClosed
        fun matrix(params: RoutingMatrixParams): HttpResponseFor<MatrixResult> =
            matrix(params, RequestOptions.none())

        /** @see matrix */
        @MustBeClosed
        fun matrix(
            params: RoutingMatrixParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MatrixResult>

        /** @see matrix */
        @MustBeClosed
        fun matrix(
            matrixRequest: MatrixRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MatrixResult> =
            matrix(
                RoutingMatrixParams.builder().matrixRequest(matrixRequest).build(),
                requestOptions,
            )

        /** @see matrix */
        @MustBeClosed
        fun matrix(matrixRequest: MatrixRequest): HttpResponseFor<MatrixResult> =
            matrix(matrixRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `post /api/v1/nearest`, but is otherwise the same as
         * [RoutingService.nearest].
         */
        @MustBeClosed
        fun nearest(params: RoutingNearestParams): HttpResponseFor<NearestResult> =
            nearest(params, RequestOptions.none())

        /** @see nearest */
        @MustBeClosed
        fun nearest(
            params: RoutingNearestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NearestResult>

        /** @see nearest */
        @MustBeClosed
        fun nearest(
            nearestRequest: NearestRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NearestResult> =
            nearest(
                RoutingNearestParams.builder().nearestRequest(nearestRequest).build(),
                requestOptions,
            )

        /** @see nearest */
        @MustBeClosed
        fun nearest(nearestRequest: NearestRequest): HttpResponseFor<NearestResult> =
            nearest(nearestRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `post /api/v1/route`, but is otherwise the same as
         * [RoutingService.route].
         */
        @MustBeClosed
        fun route(params: RoutingRouteParams): HttpResponseFor<RouteResult> =
            route(params, RequestOptions.none())

        /** @see route */
        @MustBeClosed
        fun route(
            params: RoutingRouteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RouteResult>

        /** @see route */
        @MustBeClosed
        fun route(
            routeRequest: RouteRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RouteResult> =
            route(RoutingRouteParams.builder().routeRequest(routeRequest).build(), requestOptions)

        /** @see route */
        @MustBeClosed
        fun route(routeRequest: RouteRequest): HttpResponseFor<RouteResult> =
            route(routeRequest, RequestOptions.none())
    }
}
