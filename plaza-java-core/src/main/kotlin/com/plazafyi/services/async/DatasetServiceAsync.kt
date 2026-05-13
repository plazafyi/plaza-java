// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponse
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.datasets.Dataset
import com.plazafyi.models.datasets.DatasetCreateParams
import com.plazafyi.models.datasets.DatasetDeleteParams
import com.plazafyi.models.datasets.DatasetList
import com.plazafyi.models.datasets.DatasetListParams
import com.plazafyi.models.datasets.DatasetRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface DatasetServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DatasetServiceAsync

    /** Create a new dataset */
    fun create(params: DatasetCreateParams): CompletableFuture<Dataset> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: DatasetCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Dataset>

    /** Get dataset by ID */
    fun retrieve(id: String): CompletableFuture<Dataset> =
        retrieve(id, DatasetRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DatasetRetrieveParams = DatasetRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Dataset> = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: DatasetRetrieveParams = DatasetRetrieveParams.none(),
    ): CompletableFuture<Dataset> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: DatasetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Dataset>

    /** @see retrieve */
    fun retrieve(params: DatasetRetrieveParams): CompletableFuture<Dataset> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): CompletableFuture<Dataset> =
        retrieve(id, DatasetRetrieveParams.none(), requestOptions)

    /** List datasets */
    fun list(): CompletableFuture<DatasetList> = list(DatasetListParams.none())

    /** @see list */
    fun list(
        params: DatasetListParams = DatasetListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DatasetList>

    /** @see list */
    fun list(params: DatasetListParams = DatasetListParams.none()): CompletableFuture<DatasetList> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<DatasetList> =
        list(DatasetListParams.none(), requestOptions)

    /** Delete a dataset */
    fun delete(id: String): CompletableFuture<Void?> = delete(id, DatasetDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: DatasetDeleteParams = DatasetDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: DatasetDeleteParams = DatasetDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: DatasetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: DatasetDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(id, DatasetDeleteParams.none(), requestOptions)

    /**
     * A view of [DatasetServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): DatasetServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/datasets`, but is otherwise the same as
         * [DatasetServiceAsync.create].
         */
        fun create(params: DatasetCreateParams): CompletableFuture<HttpResponseFor<Dataset>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: DatasetCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Dataset>>

        /**
         * Returns a raw HTTP response for `get /api/v1/datasets/{id}`, but is otherwise the same as
         * [DatasetServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<Dataset>> =
            retrieve(id, DatasetRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: DatasetRetrieveParams = DatasetRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Dataset>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: DatasetRetrieveParams = DatasetRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Dataset>> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: DatasetRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Dataset>>

        /** @see retrieve */
        fun retrieve(params: DatasetRetrieveParams): CompletableFuture<HttpResponseFor<Dataset>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Dataset>> =
            retrieve(id, DatasetRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/datasets`, but is otherwise the same as
         * [DatasetServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<DatasetList>> = list(DatasetListParams.none())

        /** @see list */
        fun list(
            params: DatasetListParams = DatasetListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DatasetList>>

        /** @see list */
        fun list(
            params: DatasetListParams = DatasetListParams.none()
        ): CompletableFuture<HttpResponseFor<DatasetList>> = list(params, RequestOptions.none())

        /** @see list */
        fun list(requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<DatasetList>> =
            list(DatasetListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /api/v1/datasets/{id}`, but is otherwise the same
         * as [DatasetServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponse> =
            delete(id, DatasetDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: DatasetDeleteParams = DatasetDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: DatasetDeleteParams = DatasetDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: DatasetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: DatasetDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            delete(id, DatasetDeleteParams.none(), requestOptions)
    }
}
