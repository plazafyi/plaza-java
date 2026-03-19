// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.elevation.ElevationBatchParams
import com.plazafyi.models.elevation.ElevationBatchResult
import com.plazafyi.models.elevation.ElevationLookupParams
import com.plazafyi.models.elevation.ElevationLookupResult
import com.plazafyi.models.elevation.ElevationProfileParams
import com.plazafyi.models.elevation.ElevationProfileRequest
import com.plazafyi.models.elevation.ElevationProfileResult
import java.util.function.Consumer

interface ElevationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ElevationService

    /** Look up elevation for multiple coordinates */
    fun batch(params: ElevationBatchParams): ElevationBatchResult =
        batch(params, RequestOptions.none())

    /** @see batch */
    fun batch(
        params: ElevationBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ElevationBatchResult

    /** @see batch */
    fun batch(
        elevationProfileRequest: ElevationProfileRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ElevationBatchResult =
        batch(
            ElevationBatchParams.builder().elevationProfileRequest(elevationProfileRequest).build(),
            requestOptions,
        )

    /** @see batch */
    fun batch(elevationProfileRequest: ElevationProfileRequest): ElevationBatchResult =
        batch(elevationProfileRequest, RequestOptions.none())

    /** Look up elevation at one or more points */
    fun lookup(): ElevationLookupResult = lookup(ElevationLookupParams.none())

    /** @see lookup */
    fun lookup(
        params: ElevationLookupParams = ElevationLookupParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ElevationLookupResult

    /** @see lookup */
    fun lookup(
        params: ElevationLookupParams = ElevationLookupParams.none()
    ): ElevationLookupResult = lookup(params, RequestOptions.none())

    /** @see lookup */
    fun lookup(requestOptions: RequestOptions): ElevationLookupResult =
        lookup(ElevationLookupParams.none(), requestOptions)

    /** Elevation profile along coordinates */
    fun profile(params: ElevationProfileParams): ElevationProfileResult =
        profile(params, RequestOptions.none())

    /** @see profile */
    fun profile(
        params: ElevationProfileParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ElevationProfileResult

    /** @see profile */
    fun profile(
        elevationProfileRequest: ElevationProfileRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ElevationProfileResult =
        profile(
            ElevationProfileParams.builder()
                .elevationProfileRequest(elevationProfileRequest)
                .build(),
            requestOptions,
        )

    /** @see profile */
    fun profile(elevationProfileRequest: ElevationProfileRequest): ElevationProfileResult =
        profile(elevationProfileRequest, RequestOptions.none())

    /** A view of [ElevationService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ElevationService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/elevation/batch`, but is otherwise the same
         * as [ElevationService.batch].
         */
        @MustBeClosed
        fun batch(params: ElevationBatchParams): HttpResponseFor<ElevationBatchResult> =
            batch(params, RequestOptions.none())

        /** @see batch */
        @MustBeClosed
        fun batch(
            params: ElevationBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ElevationBatchResult>

        /** @see batch */
        @MustBeClosed
        fun batch(
            elevationProfileRequest: ElevationProfileRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ElevationBatchResult> =
            batch(
                ElevationBatchParams.builder()
                    .elevationProfileRequest(elevationProfileRequest)
                    .build(),
                requestOptions,
            )

        /** @see batch */
        @MustBeClosed
        fun batch(
            elevationProfileRequest: ElevationProfileRequest
        ): HttpResponseFor<ElevationBatchResult> =
            batch(elevationProfileRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `get /api/v1/elevation`, but is otherwise the same as
         * [ElevationService.lookup].
         */
        @MustBeClosed
        fun lookup(): HttpResponseFor<ElevationLookupResult> = lookup(ElevationLookupParams.none())

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            params: ElevationLookupParams = ElevationLookupParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ElevationLookupResult>

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            params: ElevationLookupParams = ElevationLookupParams.none()
        ): HttpResponseFor<ElevationLookupResult> = lookup(params, RequestOptions.none())

        /** @see lookup */
        @MustBeClosed
        fun lookup(requestOptions: RequestOptions): HttpResponseFor<ElevationLookupResult> =
            lookup(ElevationLookupParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/elevation/profile`, but is otherwise the
         * same as [ElevationService.profile].
         */
        @MustBeClosed
        fun profile(params: ElevationProfileParams): HttpResponseFor<ElevationProfileResult> =
            profile(params, RequestOptions.none())

        /** @see profile */
        @MustBeClosed
        fun profile(
            params: ElevationProfileParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ElevationProfileResult>

        /** @see profile */
        @MustBeClosed
        fun profile(
            elevationProfileRequest: ElevationProfileRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ElevationProfileResult> =
            profile(
                ElevationProfileParams.builder()
                    .elevationProfileRequest(elevationProfileRequest)
                    .build(),
                requestOptions,
            )

        /** @see profile */
        @MustBeClosed
        fun profile(
            elevationProfileRequest: ElevationProfileRequest
        ): HttpResponseFor<ElevationProfileResult> =
            profile(elevationProfileRequest, RequestOptions.none())
    }
}
