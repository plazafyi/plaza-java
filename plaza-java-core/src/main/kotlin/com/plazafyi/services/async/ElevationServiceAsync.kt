// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

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
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ElevationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ElevationServiceAsync

    /** Look up elevation for multiple coordinates */
    fun batch(params: ElevationBatchParams): CompletableFuture<ElevationBatchResult> =
        batch(params, RequestOptions.none())

    /** @see batch */
    fun batch(
        params: ElevationBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ElevationBatchResult>

    /** @see batch */
    fun batch(
        elevationProfileRequest: ElevationProfileRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ElevationBatchResult> =
        batch(
            ElevationBatchParams.builder().elevationProfileRequest(elevationProfileRequest).build(),
            requestOptions,
        )

    /** @see batch */
    fun batch(
        elevationProfileRequest: ElevationProfileRequest
    ): CompletableFuture<ElevationBatchResult> =
        batch(elevationProfileRequest, RequestOptions.none())

    /** Look up elevation at one or more points */
    fun lookup(): CompletableFuture<ElevationLookupResult> = lookup(ElevationLookupParams.none())

    /** @see lookup */
    fun lookup(
        params: ElevationLookupParams = ElevationLookupParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ElevationLookupResult>

    /** @see lookup */
    fun lookup(
        params: ElevationLookupParams = ElevationLookupParams.none()
    ): CompletableFuture<ElevationLookupResult> = lookup(params, RequestOptions.none())

    /** @see lookup */
    fun lookup(requestOptions: RequestOptions): CompletableFuture<ElevationLookupResult> =
        lookup(ElevationLookupParams.none(), requestOptions)

    /** Elevation profile along coordinates */
    fun profile(params: ElevationProfileParams): CompletableFuture<ElevationProfileResult> =
        profile(params, RequestOptions.none())

    /** @see profile */
    fun profile(
        params: ElevationProfileParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ElevationProfileResult>

    /** @see profile */
    fun profile(
        elevationProfileRequest: ElevationProfileRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ElevationProfileResult> =
        profile(
            ElevationProfileParams.builder()
                .elevationProfileRequest(elevationProfileRequest)
                .build(),
            requestOptions,
        )

    /** @see profile */
    fun profile(
        elevationProfileRequest: ElevationProfileRequest
    ): CompletableFuture<ElevationProfileResult> =
        profile(elevationProfileRequest, RequestOptions.none())

    /**
     * A view of [ElevationServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ElevationServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/elevation/batch`, but is otherwise the same
         * as [ElevationServiceAsync.batch].
         */
        fun batch(
            params: ElevationBatchParams
        ): CompletableFuture<HttpResponseFor<ElevationBatchResult>> =
            batch(params, RequestOptions.none())

        /** @see batch */
        fun batch(
            params: ElevationBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ElevationBatchResult>>

        /** @see batch */
        fun batch(
            elevationProfileRequest: ElevationProfileRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ElevationBatchResult>> =
            batch(
                ElevationBatchParams.builder()
                    .elevationProfileRequest(elevationProfileRequest)
                    .build(),
                requestOptions,
            )

        /** @see batch */
        fun batch(
            elevationProfileRequest: ElevationProfileRequest
        ): CompletableFuture<HttpResponseFor<ElevationBatchResult>> =
            batch(elevationProfileRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `get /api/v1/elevation`, but is otherwise the same as
         * [ElevationServiceAsync.lookup].
         */
        fun lookup(): CompletableFuture<HttpResponseFor<ElevationLookupResult>> =
            lookup(ElevationLookupParams.none())

        /** @see lookup */
        fun lookup(
            params: ElevationLookupParams = ElevationLookupParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ElevationLookupResult>>

        /** @see lookup */
        fun lookup(
            params: ElevationLookupParams = ElevationLookupParams.none()
        ): CompletableFuture<HttpResponseFor<ElevationLookupResult>> =
            lookup(params, RequestOptions.none())

        /** @see lookup */
        fun lookup(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ElevationLookupResult>> =
            lookup(ElevationLookupParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/elevation/profile`, but is otherwise the
         * same as [ElevationServiceAsync.profile].
         */
        fun profile(
            params: ElevationProfileParams
        ): CompletableFuture<HttpResponseFor<ElevationProfileResult>> =
            profile(params, RequestOptions.none())

        /** @see profile */
        fun profile(
            params: ElevationProfileParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ElevationProfileResult>>

        /** @see profile */
        fun profile(
            elevationProfileRequest: ElevationProfileRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ElevationProfileResult>> =
            profile(
                ElevationProfileParams.builder()
                    .elevationProfileRequest(elevationProfileRequest)
                    .build(),
                requestOptions,
            )

        /** @see profile */
        fun profile(
            elevationProfileRequest: ElevationProfileRequest
        ): CompletableFuture<HttpResponseFor<ElevationProfileResult>> =
            profile(elevationProfileRequest, RequestOptions.none())
    }
}
