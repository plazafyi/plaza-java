// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

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
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ElementServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ElementServiceAsync

    /** Get feature by type and ID */
    fun retrieve(id: Long, params: ElementRetrieveParams): CompletableFuture<GeoJsonFeature> =
        retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: Long,
        params: ElementRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GeoJsonFeature> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: ElementRetrieveParams): CompletableFuture<GeoJsonFeature> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ElementRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GeoJsonFeature>

    /** Fetch multiple features by type and ID */
    fun batch(params: ElementBatchParams): CompletableFuture<FeatureCollection> =
        batch(params, RequestOptions.none())

    /** @see batch */
    fun batch(
        params: ElementBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeatureCollection>

    /** @see batch */
    fun batch(
        batchRequest: BatchRequest,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeatureCollection> =
        batch(ElementBatchParams.builder().batchRequest(batchRequest).build(), requestOptions)

    /** @see batch */
    fun batch(batchRequest: BatchRequest): CompletableFuture<FeatureCollection> =
        batch(batchRequest, RequestOptions.none())

    /** Find features near a geographic point */
    fun nearby(params: ElementNearbyParams): CompletableFuture<FeatureCollection> =
        nearby(params, RequestOptions.none())

    /** @see nearby */
    fun nearby(
        params: ElementNearbyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeatureCollection>

    /** Query features by bounding box or H3 cell */
    fun query(): CompletableFuture<FeatureCollection> = query(ElementQueryParams.none())

    /** @see query */
    fun query(
        params: ElementQueryParams = ElementQueryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeatureCollection>

    /** @see query */
    fun query(
        params: ElementQueryParams = ElementQueryParams.none()
    ): CompletableFuture<FeatureCollection> = query(params, RequestOptions.none())

    /** @see query */
    fun query(requestOptions: RequestOptions): CompletableFuture<FeatureCollection> =
        query(ElementQueryParams.none(), requestOptions)

    /**
     * A view of [ElementServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ElementServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/features/{type}/{id}`, but is otherwise the
         * same as [ElementServiceAsync.retrieve].
         */
        fun retrieve(
            id: Long,
            params: ElementRetrieveParams,
        ): CompletableFuture<HttpResponseFor<GeoJsonFeature>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: Long,
            params: ElementRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GeoJsonFeature>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: ElementRetrieveParams
        ): CompletableFuture<HttpResponseFor<GeoJsonFeature>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ElementRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GeoJsonFeature>>

        /**
         * Returns a raw HTTP response for `post /api/v1/features/batch`, but is otherwise the same
         * as [ElementServiceAsync.batch].
         */
        fun batch(
            params: ElementBatchParams
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            batch(params, RequestOptions.none())

        /** @see batch */
        fun batch(
            params: ElementBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeatureCollection>>

        /** @see batch */
        fun batch(
            batchRequest: BatchRequest,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            batch(ElementBatchParams.builder().batchRequest(batchRequest).build(), requestOptions)

        /** @see batch */
        fun batch(
            batchRequest: BatchRequest
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            batch(batchRequest, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `get /api/v1/features/nearby`, but is otherwise the same
         * as [ElementServiceAsync.nearby].
         */
        fun nearby(
            params: ElementNearbyParams
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            nearby(params, RequestOptions.none())

        /** @see nearby */
        fun nearby(
            params: ElementNearbyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeatureCollection>>

        /**
         * Returns a raw HTTP response for `get /api/v1/features`, but is otherwise the same as
         * [ElementServiceAsync.query].
         */
        fun query(): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            query(ElementQueryParams.none())

        /** @see query */
        fun query(
            params: ElementQueryParams = ElementQueryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeatureCollection>>

        /** @see query */
        fun query(
            params: ElementQueryParams = ElementQueryParams.none()
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            query(params, RequestOptions.none())

        /** @see query */
        fun query(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            query(ElementQueryParams.none(), requestOptions)
    }
}
