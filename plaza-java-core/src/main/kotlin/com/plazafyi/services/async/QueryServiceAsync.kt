// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.query.PlazaqlQuery
import com.plazafyi.models.query.QueryExecuteParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface QueryServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): QueryServiceAsync

    /** Execute a PlazaQL query */
    fun execute(params: QueryExecuteParams): CompletableFuture<FeatureCollection> =
        execute(params, RequestOptions.none())

    /** @see execute */
    fun execute(
        params: QueryExecuteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeatureCollection>

    /** @see execute */
    fun execute(
        plazaqlQuery: PlazaqlQuery,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeatureCollection> =
        execute(QueryExecuteParams.builder().plazaqlQuery(plazaqlQuery).build(), requestOptions)

    /** @see execute */
    fun execute(plazaqlQuery: PlazaqlQuery): CompletableFuture<FeatureCollection> =
        execute(plazaqlQuery, RequestOptions.none())

    /** A view of [QueryServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): QueryServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/query`, but is otherwise the same as
         * [QueryServiceAsync.execute].
         */
        fun execute(
            params: QueryExecuteParams
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            execute(params, RequestOptions.none())

        /** @see execute */
        fun execute(
            params: QueryExecuteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeatureCollection>>

        /** @see execute */
        fun execute(
            plazaqlQuery: PlazaqlQuery,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            execute(QueryExecuteParams.builder().plazaqlQuery(plazaqlQuery).build(), requestOptions)

        /** @see execute */
        fun execute(
            plazaqlQuery: PlazaqlQuery
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            execute(plazaqlQuery, RequestOptions.none())
    }
}
