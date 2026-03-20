// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.GeoJsonFeature
import com.plazafyi.models.elements.BatchRequest
import com.plazafyi.models.elements.ElementBatchParams
import com.plazafyi.models.elements.ElementLookupParams
import com.plazafyi.models.elements.ElementNearbyParams
import com.plazafyi.models.elements.ElementNearbyPostParams
import com.plazafyi.models.elements.ElementQueryParams
import com.plazafyi.models.elements.ElementQueryPostParams
import com.plazafyi.models.elements.ElementRetrieveParams
import java.util.function.Consumer

interface ElementService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ElementService

    /** Get feature by type and ID */
    fun retrieve(id: Long, params: ElementRetrieveParams): GeoJsonFeature =
        retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: Long,
        params: ElementRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeoJsonFeature = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: ElementRetrieveParams): GeoJsonFeature =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ElementRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeoJsonFeature

    /** Fetch multiple features by type and ID */
    fun batch(params: ElementBatchParams): FeatureCollection = batch(params, RequestOptions.none())

    /** @see batch */
    fun batch(
        params: ElementBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see batch */
    fun batch(
        batchRequest: BatchRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection =
        batch(ElementBatchParams.builder().batchRequest(batchRequest).build(), requestOptions)

    /** @see batch */
    fun batch(batchRequest: BatchRequest): FeatureCollection =
        batch(batchRequest, RequestOptions.none())

    /** Get feature by type and ID */
    fun lookup(): GeoJsonFeature = lookup(ElementLookupParams.none())

    /** @see lookup */
    fun lookup(
        params: ElementLookupParams = ElementLookupParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeoJsonFeature

    /** @see lookup */
    fun lookup(params: ElementLookupParams = ElementLookupParams.none()): GeoJsonFeature =
        lookup(params, RequestOptions.none())

    /** @see lookup */
    fun lookup(requestOptions: RequestOptions): GeoJsonFeature =
        lookup(ElementLookupParams.none(), requestOptions)

    /** Find features near a geographic point */
    fun nearby(): FeatureCollection = nearby(ElementNearbyParams.none())

    /** @see nearby */
    fun nearby(
        params: ElementNearbyParams = ElementNearbyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see nearby */
    fun nearby(params: ElementNearbyParams = ElementNearbyParams.none()): FeatureCollection =
        nearby(params, RequestOptions.none())

    /** @see nearby */
    fun nearby(requestOptions: RequestOptions): FeatureCollection =
        nearby(ElementNearbyParams.none(), requestOptions)

    /** Find features near a geographic point */
    fun nearbyPost(): FeatureCollection = nearbyPost(ElementNearbyPostParams.none())

    /** @see nearbyPost */
    fun nearbyPost(
        params: ElementNearbyPostParams = ElementNearbyPostParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see nearbyPost */
    fun nearbyPost(
        params: ElementNearbyPostParams = ElementNearbyPostParams.none()
    ): FeatureCollection = nearbyPost(params, RequestOptions.none())

    /** @see nearbyPost */
    fun nearbyPost(requestOptions: RequestOptions): FeatureCollection =
        nearbyPost(ElementNearbyPostParams.none(), requestOptions)

    /** Query features by spatial predicate, bounding box, or H3 cell */
    fun query(): FeatureCollection = query(ElementQueryParams.none())

    /** @see query */
    fun query(
        params: ElementQueryParams = ElementQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see query */
    fun query(params: ElementQueryParams = ElementQueryParams.none()): FeatureCollection =
        query(params, RequestOptions.none())

    /** @see query */
    fun query(requestOptions: RequestOptions): FeatureCollection =
        query(ElementQueryParams.none(), requestOptions)

    /** Query features by spatial predicate, bounding box, or H3 cell */
    fun queryPost(): FeatureCollection = queryPost(ElementQueryPostParams.none())

    /** @see queryPost */
    fun queryPost(
        params: ElementQueryPostParams = ElementQueryPostParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see queryPost */
    fun queryPost(
        params: ElementQueryPostParams = ElementQueryPostParams.none()
    ): FeatureCollection = queryPost(params, RequestOptions.none())

    /** @see queryPost */
    fun queryPost(requestOptions: RequestOptions): FeatureCollection =
        queryPost(ElementQueryPostParams.none(), requestOptions)

    /** A view of [ElementService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ElementService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/features/{type}/{id}`, but is otherwise the
         * same as [ElementService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: Long, params: ElementRetrieveParams): HttpResponseFor<GeoJsonFeature> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: Long,
            params: ElementRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeoJsonFeature> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ElementRetrieveParams): HttpResponseFor<GeoJsonFeature> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ElementRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeoJsonFeature>

        /**
         * Returns a raw HTTP response for `post /api/v1/features/batch`, but is otherwise the same
         * as [ElementService.batch].
         */
        @MustBeClosed
        fun batch(params: ElementBatchParams): HttpResponseFor<FeatureCollection> =
            batch(params, RequestOptions.none())

        /** @see batch */
        @MustBeClosed
        fun batch(
            params: ElementBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see batch */
        @MustBeClosed
        fun batch(
            batchRequest: BatchRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection> =
            batch(ElementBatchParams.builder().batchRequest(batchRequest).build(), requestOptions)

        /** @see batch */
        @MustBeClosed
        fun batch(batchRequest: BatchRequest): HttpResponseFor<FeatureCollection> =
            batch(batchRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `post /api/v1/features/lookup`, but is otherwise the same
         * as [ElementService.lookup].
         */
        @MustBeClosed
        fun lookup(): HttpResponseFor<GeoJsonFeature> = lookup(ElementLookupParams.none())

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            params: ElementLookupParams = ElementLookupParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeoJsonFeature>

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            params: ElementLookupParams = ElementLookupParams.none()
        ): HttpResponseFor<GeoJsonFeature> = lookup(params, RequestOptions.none())

        /** @see lookup */
        @MustBeClosed
        fun lookup(requestOptions: RequestOptions): HttpResponseFor<GeoJsonFeature> =
            lookup(ElementLookupParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/features/nearby`, but is otherwise the same
         * as [ElementService.nearby].
         */
        @MustBeClosed
        fun nearby(): HttpResponseFor<FeatureCollection> = nearby(ElementNearbyParams.none())

        /** @see nearby */
        @MustBeClosed
        fun nearby(
            params: ElementNearbyParams = ElementNearbyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see nearby */
        @MustBeClosed
        fun nearby(
            params: ElementNearbyParams = ElementNearbyParams.none()
        ): HttpResponseFor<FeatureCollection> = nearby(params, RequestOptions.none())

        /** @see nearby */
        @MustBeClosed
        fun nearby(requestOptions: RequestOptions): HttpResponseFor<FeatureCollection> =
            nearby(ElementNearbyParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/features/nearby`, but is otherwise the same
         * as [ElementService.nearbyPost].
         */
        @MustBeClosed
        fun nearbyPost(): HttpResponseFor<FeatureCollection> =
            nearbyPost(ElementNearbyPostParams.none())

        /** @see nearbyPost */
        @MustBeClosed
        fun nearbyPost(
            params: ElementNearbyPostParams = ElementNearbyPostParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see nearbyPost */
        @MustBeClosed
        fun nearbyPost(
            params: ElementNearbyPostParams = ElementNearbyPostParams.none()
        ): HttpResponseFor<FeatureCollection> = nearbyPost(params, RequestOptions.none())

        /** @see nearbyPost */
        @MustBeClosed
        fun nearbyPost(requestOptions: RequestOptions): HttpResponseFor<FeatureCollection> =
            nearbyPost(ElementNearbyPostParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/features`, but is otherwise the same as
         * [ElementService.query].
         */
        @MustBeClosed
        fun query(): HttpResponseFor<FeatureCollection> = query(ElementQueryParams.none())

        /** @see query */
        @MustBeClosed
        fun query(
            params: ElementQueryParams = ElementQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see query */
        @MustBeClosed
        fun query(
            params: ElementQueryParams = ElementQueryParams.none()
        ): HttpResponseFor<FeatureCollection> = query(params, RequestOptions.none())

        /** @see query */
        @MustBeClosed
        fun query(requestOptions: RequestOptions): HttpResponseFor<FeatureCollection> =
            query(ElementQueryParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/features`, but is otherwise the same as
         * [ElementService.queryPost].
         */
        @MustBeClosed
        fun queryPost(): HttpResponseFor<FeatureCollection> =
            queryPost(ElementQueryPostParams.none())

        /** @see queryPost */
        @MustBeClosed
        fun queryPost(
            params: ElementQueryPostParams = ElementQueryPostParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see queryPost */
        @MustBeClosed
        fun queryPost(
            params: ElementQueryPostParams = ElementQueryPostParams.none()
        ): HttpResponseFor<FeatureCollection> = queryPost(params, RequestOptions.none())

        /** @see queryPost */
        @MustBeClosed
        fun queryPost(requestOptions: RequestOptions): HttpResponseFor<FeatureCollection> =
            queryPost(ElementQueryPostParams.none(), requestOptions)
    }
}
