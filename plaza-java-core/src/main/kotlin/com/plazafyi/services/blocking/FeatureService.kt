// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

interface FeatureService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FeatureService

    /** Get feature by type and ID */
    fun retrieve(id: Long, params: FeatureRetrieveParams): GeoJsonFeature =
        retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: Long,
        params: FeatureRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeoJsonFeature = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: FeatureRetrieveParams): GeoJsonFeature =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: FeatureRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeoJsonFeature

    /** Fetch multiple features by type and ID */
    fun batch(params: FeatureBatchParams): FeatureCollection = batch(params, RequestOptions.none())

    /** @see batch */
    fun batch(
        params: FeatureBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see batch */
    fun batch(
        batchRequest: BatchRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection =
        batch(FeatureBatchParams.builder().batchRequest(batchRequest).build(), requestOptions)

    /** @see batch */
    fun batch(batchRequest: BatchRequest): FeatureCollection =
        batch(batchRequest, RequestOptions.none())

    /** Query features by spatial predicate, bounding box, or H3 cell */
    fun query(): FeatureCollection = query(FeatureQueryParams.none())

    /** @see query */
    fun query(
        params: FeatureQueryParams = FeatureQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see query */
    fun query(params: FeatureQueryParams = FeatureQueryParams.none()): FeatureCollection =
        query(params, RequestOptions.none())

    /** @see query */
    fun query(
        spatialPredicate: SpatialPredicate,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection =
        query(
            FeatureQueryParams.builder().spatialPredicate(spatialPredicate).build(),
            requestOptions,
        )

    /** @see query */
    fun query(spatialPredicate: SpatialPredicate): FeatureCollection =
        query(spatialPredicate, RequestOptions.none())

    /** @see query */
    fun query(requestOptions: RequestOptions): FeatureCollection =
        query(FeatureQueryParams.none(), requestOptions)

    /** A view of [FeatureService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FeatureService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/features/{type}/{id}`, but is otherwise the
         * same as [FeatureService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: Long, params: FeatureRetrieveParams): HttpResponseFor<GeoJsonFeature> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: Long,
            params: FeatureRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeoJsonFeature> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: FeatureRetrieveParams): HttpResponseFor<GeoJsonFeature> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: FeatureRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeoJsonFeature>

        /**
         * Returns a raw HTTP response for `post /api/v1/features/batch`, but is otherwise the same
         * as [FeatureService.batch].
         */
        @MustBeClosed
        fun batch(params: FeatureBatchParams): HttpResponseFor<FeatureCollection> =
            batch(params, RequestOptions.none())

        /** @see batch */
        @MustBeClosed
        fun batch(
            params: FeatureBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see batch */
        @MustBeClosed
        fun batch(
            batchRequest: BatchRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection> =
            batch(FeatureBatchParams.builder().batchRequest(batchRequest).build(), requestOptions)

        /** @see batch */
        @MustBeClosed
        fun batch(batchRequest: BatchRequest): HttpResponseFor<FeatureCollection> =
            batch(batchRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `post /api/v1/features`, but is otherwise the same as
         * [FeatureService.query].
         */
        @MustBeClosed
        fun query(): HttpResponseFor<FeatureCollection> = query(FeatureQueryParams.none())

        /** @see query */
        @MustBeClosed
        fun query(
            params: FeatureQueryParams = FeatureQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see query */
        @MustBeClosed
        fun query(
            params: FeatureQueryParams = FeatureQueryParams.none()
        ): HttpResponseFor<FeatureCollection> = query(params, RequestOptions.none())

        /** @see query */
        @MustBeClosed
        fun query(
            spatialPredicate: SpatialPredicate,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection> =
            query(
                FeatureQueryParams.builder().spatialPredicate(spatialPredicate).build(),
                requestOptions,
            )

        /** @see query */
        @MustBeClosed
        fun query(spatialPredicate: SpatialPredicate): HttpResponseFor<FeatureCollection> =
            query(spatialPredicate, RequestOptions.none())

        /** @see query */
        @MustBeClosed
        fun query(requestOptions: RequestOptions): HttpResponseFor<FeatureCollection> =
            query(FeatureQueryParams.none(), requestOptions)
    }
}
