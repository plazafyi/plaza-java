// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.query.PlazaqlQuery
import com.plazafyi.models.query.QueryExecuteParams
import java.util.function.Consumer

interface QueryService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): QueryService

    /** Execute a PlazaQL query */
    fun execute(params: QueryExecuteParams): FeatureCollection =
        execute(params, RequestOptions.none())

    /** @see execute */
    fun execute(
        params: QueryExecuteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see execute */
    fun execute(
        plazaqlQuery: PlazaqlQuery,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection =
        execute(QueryExecuteParams.builder().plazaqlQuery(plazaqlQuery).build(), requestOptions)

    /** @see execute */
    fun execute(plazaqlQuery: PlazaqlQuery): FeatureCollection =
        execute(plazaqlQuery, RequestOptions.none())

    /** A view of [QueryService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): QueryService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /api/v1/query`, but is otherwise the same as
         * [QueryService.execute].
         */
        @MustBeClosed
        fun execute(params: QueryExecuteParams): HttpResponseFor<FeatureCollection> =
            execute(params, RequestOptions.none())

        /** @see execute */
        @MustBeClosed
        fun execute(
            params: QueryExecuteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see execute */
        @MustBeClosed
        fun execute(
            plazaqlQuery: PlazaqlQuery,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection> =
            execute(QueryExecuteParams.builder().plazaqlQuery(plazaqlQuery).build(), requestOptions)

        /** @see execute */
        @MustBeClosed
        fun execute(plazaqlQuery: PlazaqlQuery): HttpResponseFor<FeatureCollection> =
            execute(plazaqlQuery, RequestOptions.none())
    }
}
