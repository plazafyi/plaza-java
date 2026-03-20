// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.optimize.OptimizeCreateParams
import com.plazafyi.models.optimize.OptimizeJobStatus
import com.plazafyi.models.optimize.OptimizeRequest
import com.plazafyi.models.optimize.OptimizeResult
import com.plazafyi.models.optimize.OptimizeRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface OptimizeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OptimizeServiceAsync

    /** Optimize route through waypoints */
    fun create(params: OptimizeCreateParams): CompletableFuture<OptimizeResult> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: OptimizeCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OptimizeResult>

    /** @see create */
    fun create(
        optimizeRequest: OptimizeRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OptimizeResult> =
        create(
            OptimizeCreateParams.builder().optimizeRequest(optimizeRequest).build(),
            requestOptions,
        )

    /** @see create */
    fun create(optimizeRequest: OptimizeRequest): CompletableFuture<OptimizeResult> =
        create(optimizeRequest, RequestOptions.none())

    /** Get async optimization result */
    fun retrieve(jobId: String): CompletableFuture<OptimizeJobStatus> =
        retrieve(jobId, OptimizeRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        jobId: String,
        params: OptimizeRetrieveParams = OptimizeRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OptimizeJobStatus> =
        retrieve(params.toBuilder().jobId(jobId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        jobId: String,
        params: OptimizeRetrieveParams = OptimizeRetrieveParams.none(),
    ): CompletableFuture<OptimizeJobStatus> = retrieve(jobId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: OptimizeRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OptimizeJobStatus>

    /** @see retrieve */
    fun retrieve(params: OptimizeRetrieveParams): CompletableFuture<OptimizeJobStatus> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        jobId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<OptimizeJobStatus> =
        retrieve(jobId, OptimizeRetrieveParams.none(), requestOptions)

    /**
     * A view of [OptimizeServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OptimizeServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/optimize`, but is otherwise the same as
         * [OptimizeServiceAsync.create].
         */
        fun create(
            params: OptimizeCreateParams
        ): CompletableFuture<HttpResponseFor<OptimizeResult>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: OptimizeCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OptimizeResult>>

        /** @see create */
        fun create(
            optimizeRequest: OptimizeRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OptimizeResult>> =
            create(
                OptimizeCreateParams.builder().optimizeRequest(optimizeRequest).build(),
                requestOptions,
            )

        /** @see create */
        fun create(
            optimizeRequest: OptimizeRequest
        ): CompletableFuture<HttpResponseFor<OptimizeResult>> =
            create(optimizeRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `get /api/v1/optimize/{job_id}`, but is otherwise the
         * same as [OptimizeServiceAsync.retrieve].
         */
        fun retrieve(jobId: String): CompletableFuture<HttpResponseFor<OptimizeJobStatus>> =
            retrieve(jobId, OptimizeRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            jobId: String,
            params: OptimizeRetrieveParams = OptimizeRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OptimizeJobStatus>> =
            retrieve(params.toBuilder().jobId(jobId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            jobId: String,
            params: OptimizeRetrieveParams = OptimizeRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<OptimizeJobStatus>> =
            retrieve(jobId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: OptimizeRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OptimizeJobStatus>>

        /** @see retrieve */
        fun retrieve(
            params: OptimizeRetrieveParams
        ): CompletableFuture<HttpResponseFor<OptimizeJobStatus>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            jobId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OptimizeJobStatus>> =
            retrieve(jobId, OptimizeRetrieveParams.none(), requestOptions)
    }
}
