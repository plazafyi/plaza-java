// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.optimize.OptimizeCreateParams
import com.plazafyi.models.optimize.OptimizeJobStatus
import com.plazafyi.models.optimize.OptimizeRequest
import com.plazafyi.models.optimize.OptimizeResult
import com.plazafyi.models.optimize.OptimizeRetrieveParams
import java.util.function.Consumer

interface OptimizeService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OptimizeService

    /** Optimize route through waypoints */
    fun create(params: OptimizeCreateParams): OptimizeResult = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: OptimizeCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OptimizeResult

    /** @see create */
    fun create(
        optimizeRequest: OptimizeRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OptimizeResult =
        create(
            OptimizeCreateParams.builder().optimizeRequest(optimizeRequest).build(),
            requestOptions,
        )

    /** @see create */
    fun create(optimizeRequest: OptimizeRequest): OptimizeResult =
        create(optimizeRequest, RequestOptions.none())

    /** Get async optimization result */
    fun retrieve(jobId: String): OptimizeJobStatus = retrieve(jobId, OptimizeRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        jobId: String,
        params: OptimizeRetrieveParams = OptimizeRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OptimizeJobStatus = retrieve(params.toBuilder().jobId(jobId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        jobId: String,
        params: OptimizeRetrieveParams = OptimizeRetrieveParams.none(),
    ): OptimizeJobStatus = retrieve(jobId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: OptimizeRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OptimizeJobStatus

    /** @see retrieve */
    fun retrieve(params: OptimizeRetrieveParams): OptimizeJobStatus =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(jobId: String, requestOptions: RequestOptions): OptimizeJobStatus =
        retrieve(jobId, OptimizeRetrieveParams.none(), requestOptions)

    /** A view of [OptimizeService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): OptimizeService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/optimize`, but is otherwise the same as
         * [OptimizeService.create].
         */
        @MustBeClosed
        fun create(params: OptimizeCreateParams): HttpResponseFor<OptimizeResult> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: OptimizeCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OptimizeResult>

        /** @see create */
        @MustBeClosed
        fun create(
            optimizeRequest: OptimizeRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OptimizeResult> =
            create(
                OptimizeCreateParams.builder().optimizeRequest(optimizeRequest).build(),
                requestOptions,
            )

        /** @see create */
        @MustBeClosed
        fun create(optimizeRequest: OptimizeRequest): HttpResponseFor<OptimizeResult> =
            create(optimizeRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `get /api/v1/optimize/{job_id}`, but is otherwise the
         * same as [OptimizeService.retrieve].
         */
        @MustBeClosed
        fun retrieve(jobId: String): HttpResponseFor<OptimizeJobStatus> =
            retrieve(jobId, OptimizeRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            jobId: String,
            params: OptimizeRetrieveParams = OptimizeRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OptimizeJobStatus> =
            retrieve(params.toBuilder().jobId(jobId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            jobId: String,
            params: OptimizeRetrieveParams = OptimizeRetrieveParams.none(),
        ): HttpResponseFor<OptimizeJobStatus> = retrieve(jobId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: OptimizeRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OptimizeJobStatus>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: OptimizeRetrieveParams): HttpResponseFor<OptimizeJobStatus> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            jobId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OptimizeJobStatus> =
            retrieve(jobId, OptimizeRetrieveParams.none(), requestOptions)
    }
}
