// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponse
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.datasets.Dataset
import com.plazafyi.models.datasets.DatasetCreateParams
import com.plazafyi.models.datasets.DatasetDeleteParams
import com.plazafyi.models.datasets.DatasetFeaturesParams
import com.plazafyi.models.datasets.DatasetList
import com.plazafyi.models.datasets.DatasetListParams
import com.plazafyi.models.datasets.DatasetRetrieveParams
import java.util.function.Consumer

interface DatasetService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DatasetService

    /** Create a new dataset (admin only) */
    fun create(params: DatasetCreateParams): Dataset = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: DatasetCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset

    /** Get dataset by ID */
    fun retrieve(id: String): Dataset = retrieve(id, DatasetRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DatasetRetrieveParams = DatasetRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DatasetRetrieveParams = DatasetRetrieveParams.none(),
    ): Dataset = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: DatasetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset

    /** @see retrieve */
    fun retrieve(params: DatasetRetrieveParams): Dataset = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): Dataset =
        retrieve(id, DatasetRetrieveParams.none(), requestOptions)

    /** List all datasets */
    fun list(): DatasetList = list(DatasetListParams.none())

    /** @see list */
    fun list(
        params: DatasetListParams = DatasetListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DatasetList

    /** @see list */
    fun list(params: DatasetListParams = DatasetListParams.none()): DatasetList =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): DatasetList =
        list(DatasetListParams.none(), requestOptions)

    /** Delete a dataset */
    fun delete(id: String) = delete(id, DatasetDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: DatasetDeleteParams = DatasetDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(id: String, params: DatasetDeleteParams = DatasetDeleteParams.none()) =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(params: DatasetDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(params: DatasetDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions) =
        delete(id, DatasetDeleteParams.none(), requestOptions)

    /** Query features in a dataset */
    fun features(id: String): FeatureCollection = features(id, DatasetFeaturesParams.none())

    /** @see features */
    fun features(
        id: String,
        params: DatasetFeaturesParams = DatasetFeaturesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection = features(params.toBuilder().id(id).build(), requestOptions)

    /** @see features */
    fun features(
        id: String,
        params: DatasetFeaturesParams = DatasetFeaturesParams.none(),
    ): FeatureCollection = features(id, params, RequestOptions.none())

    /** @see features */
    fun features(
        params: DatasetFeaturesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see features */
    fun features(params: DatasetFeaturesParams): FeatureCollection =
        features(params, RequestOptions.none())

    /** @see features */
    fun features(id: String, requestOptions: RequestOptions): FeatureCollection =
        features(id, DatasetFeaturesParams.none(), requestOptions)

    /** A view of [DatasetService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): DatasetService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/datasets`, but is otherwise the same as
         * [DatasetService.create].
         */
        @MustBeClosed
        fun create(params: DatasetCreateParams): HttpResponseFor<Dataset> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: DatasetCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset>

        /**
         * Returns a raw HTTP response for `get /api/v1/datasets/{id}`, but is otherwise the same as
         * [DatasetService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<Dataset> =
            retrieve(id, DatasetRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: DatasetRetrieveParams = DatasetRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset> = retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: DatasetRetrieveParams = DatasetRetrieveParams.none(),
        ): HttpResponseFor<Dataset> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: DatasetRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: DatasetRetrieveParams): HttpResponseFor<Dataset> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(id: String, requestOptions: RequestOptions): HttpResponseFor<Dataset> =
            retrieve(id, DatasetRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/datasets`, but is otherwise the same as
         * [DatasetService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<DatasetList> = list(DatasetListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: DatasetListParams = DatasetListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DatasetList>

        /** @see list */
        @MustBeClosed
        fun list(
            params: DatasetListParams = DatasetListParams.none()
        ): HttpResponseFor<DatasetList> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<DatasetList> =
            list(DatasetListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /api/v1/datasets/{id}`, but is otherwise the same
         * as [DatasetService.delete].
         */
        @MustBeClosed fun delete(id: String): HttpResponse = delete(id, DatasetDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: DatasetDeleteParams = DatasetDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: DatasetDeleteParams = DatasetDeleteParams.none(),
        ): HttpResponse = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: DatasetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: DatasetDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(id: String, requestOptions: RequestOptions): HttpResponse =
            delete(id, DatasetDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/datasets/{id}/features`, but is otherwise
         * the same as [DatasetService.features].
         */
        @MustBeClosed
        fun features(id: String): HttpResponseFor<FeatureCollection> =
            features(id, DatasetFeaturesParams.none())

        /** @see features */
        @MustBeClosed
        fun features(
            id: String,
            params: DatasetFeaturesParams = DatasetFeaturesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection> =
            features(params.toBuilder().id(id).build(), requestOptions)

        /** @see features */
        @MustBeClosed
        fun features(
            id: String,
            params: DatasetFeaturesParams = DatasetFeaturesParams.none(),
        ): HttpResponseFor<FeatureCollection> = features(id, params, RequestOptions.none())

        /** @see features */
        @MustBeClosed
        fun features(
            params: DatasetFeaturesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see features */
        @MustBeClosed
        fun features(params: DatasetFeaturesParams): HttpResponseFor<FeatureCollection> =
            features(params, RequestOptions.none())

        /** @see features */
        @MustBeClosed
        fun features(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeatureCollection> =
            features(id, DatasetFeaturesParams.none(), requestOptions)
    }
}
