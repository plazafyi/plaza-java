// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.GeoJsonFeature
import com.plazafyi.models.features.BatchRequest
import com.plazafyi.models.features.FeatureBatchParams
import com.plazafyi.models.features.FeatureQueryParams
import com.plazafyi.models.features.FeatureRetrieveParams
import com.plazafyi.models.features.SpatialPredicate
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface FeatureServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FeatureServiceAsync

    /** Get feature by type and ID */
    fun retrieve(id: Long, params: FeatureRetrieveParams): CompletableFuture<GeoJsonFeature> =
        retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: Long,
        params: FeatureRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GeoJsonFeature> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: FeatureRetrieveParams): CompletableFuture<GeoJsonFeature> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: FeatureRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GeoJsonFeature>

    /** Fetch multiple features by type and ID */
    fun batch(params: FeatureBatchParams): CompletableFuture<FeatureCollection> =
        batch(params, RequestOptions.none())

    /** @see batch */
    fun batch(
        params: FeatureBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeatureCollection>

    /** @see batch */
    fun batch(
        batchRequest: BatchRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeatureCollection> =
        batch(FeatureBatchParams.builder().batchRequest(batchRequest).build(), requestOptions)

    /** @see batch */
    fun batch(batchRequest: BatchRequest): CompletableFuture<FeatureCollection> =
        batch(batchRequest, RequestOptions.none())

    /** Query features by spatial predicate, bounding box, or H3 cell */
    fun query(): CompletableFuture<FeatureCollection> = query(FeatureQueryParams.none())

    /** @see query */
    fun query(
        params: FeatureQueryParams = FeatureQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeatureCollection>

    /** @see query */
    fun query(
        params: FeatureQueryParams = FeatureQueryParams.none()
    ): CompletableFuture<FeatureCollection> = query(params, RequestOptions.none())

    /** @see query */
    fun query(
        spatialPredicate: SpatialPredicate,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeatureCollection> =
        query(
            FeatureQueryParams.builder().spatialPredicate(spatialPredicate).build(),
            requestOptions,
        )

    /** @see query */
    fun query(spatialPredicate: SpatialPredicate): CompletableFuture<FeatureCollection> =
        query(spatialPredicate, RequestOptions.none())

    /** @see query */
    fun query(requestOptions: RequestOptions): CompletableFuture<FeatureCollection> =
        query(FeatureQueryParams.none(), requestOptions)

    /**
     * A view of [FeatureServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FeatureServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/features/{type}/{id}`, but is otherwise the
         * same as [FeatureServiceAsync.retrieve].
         */
        fun retrieve(
            id: Long,
            params: FeatureRetrieveParams,
        ): CompletableFuture<HttpResponseFor<GeoJsonFeature>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: Long,
            params: FeatureRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GeoJsonFeature>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: FeatureRetrieveParams
        ): CompletableFuture<HttpResponseFor<GeoJsonFeature>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: FeatureRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GeoJsonFeature>>

        /**
         * Returns a raw HTTP response for `post /api/v1/features/batch`, but is otherwise the same
         * as [FeatureServiceAsync.batch].
         */
        fun batch(
            params: FeatureBatchParams
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            batch(params, RequestOptions.none())

        /** @see batch */
        fun batch(
            params: FeatureBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeatureCollection>>

        /** @see batch */
        fun batch(
            batchRequest: BatchRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            batch(FeatureBatchParams.builder().batchRequest(batchRequest).build(), requestOptions)

        /** @see batch */
        fun batch(
            batchRequest: BatchRequest
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            batch(batchRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `post /api/v1/features`, but is otherwise the same as
         * [FeatureServiceAsync.query].
         */
        fun query(): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            query(FeatureQueryParams.none())

        /** @see query */
        fun query(
            params: FeatureQueryParams = FeatureQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeatureCollection>>

        /** @see query */
        fun query(
            params: FeatureQueryParams = FeatureQueryParams.none()
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            query(params, RequestOptions.none())

        /** @see query */
        fun query(
            spatialPredicate: SpatialPredicate,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            query(
                FeatureQueryParams.builder().spatialPredicate(spatialPredicate).build(),
                requestOptions,
            )

        /** @see query */
        fun query(
            spatialPredicate: SpatialPredicate
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            query(spatialPredicate, RequestOptions.none())

        /** @see query */
        fun query(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            query(FeatureQueryParams.none(), requestOptions)
    }
}
