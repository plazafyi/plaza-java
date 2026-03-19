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
import com.plazafyi.models.elements.ElementNearbyParams
import com.plazafyi.models.elements.ElementQueryParams
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

    /** Find features near a geographic point */
    fun nearby(params: ElementNearbyParams): FeatureCollection =
        nearby(params, RequestOptions.none())

    /** @see nearby */
    fun nearby(
        params: ElementNearbyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** Query features by bounding box or H3 cell */
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
         * Returns a raw HTTP response for `get /api/v1/features/nearby`, but is otherwise the same
         * as [ElementService.nearby].
         */
        @MustBeClosed
        fun nearby(params: ElementNearbyParams): HttpResponseFor<FeatureCollection> =
            nearby(params, RequestOptions.none())

        /** @see nearby */
        @MustBeClosed
        fun nearby(
            params: ElementNearbyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

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
    }
}
