// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.search.SearchQueryParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface SearchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SearchServiceAsync

    /** Search OSM features by name */
    fun query(params: SearchQueryParams): CompletableFuture<FeatureCollection> =
        query(params, RequestOptions.none())

    /** @see query */
    fun query(
        params: SearchQueryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeatureCollection>

    /**
     * A view of [SearchServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SearchServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/search`, but is otherwise the same as
         * [SearchServiceAsync.query].
         */
        fun query(
            params: SearchQueryParams
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            query(params, RequestOptions.none())

        /** @see query */
        fun query(
            params: SearchQueryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeatureCollection>>
    }
}
