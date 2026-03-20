// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.FeatureCollection
import com.plazafyi.models.query.OverpassQuery
import com.plazafyi.models.query.QueryExecuteParams
import com.plazafyi.models.query.QueryExecuteResponse
import com.plazafyi.models.query.QueryOverpassParams
import com.plazafyi.models.query.QuerySparqlParams
import com.plazafyi.models.query.SparqlQuery
import com.plazafyi.models.query.SparqlResult
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

    /** Execute a multi-step query pipeline */
    fun execute(params: QueryExecuteParams): CompletableFuture<QueryExecuteResponse> =
        execute(params, RequestOptions.none())

    /** @see execute */
    fun execute(
        params: QueryExecuteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<QueryExecuteResponse>

    /** Execute an Overpass QL query */
    fun overpass(params: QueryOverpassParams): CompletableFuture<FeatureCollection> =
        overpass(params, RequestOptions.none())

    /** @see overpass */
    fun overpass(
        params: QueryOverpassParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeatureCollection>

    /** @see overpass */
    fun overpass(
        overpassQuery: OverpassQuery,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FeatureCollection> =
        overpass(QueryOverpassParams.builder().overpassQuery(overpassQuery).build(), requestOptions)

    /** @see overpass */
    fun overpass(overpassQuery: OverpassQuery): CompletableFuture<FeatureCollection> =
        overpass(overpassQuery, RequestOptions.none())

    /** Execute a SPARQL query */
    fun sparql(params: QuerySparqlParams): CompletableFuture<SparqlResult> =
        sparql(params, RequestOptions.none())

    /** @see sparql */
    fun sparql(
        params: QuerySparqlParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SparqlResult>

    /** @see sparql */
    fun sparql(
        sparqlQuery: SparqlQuery,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SparqlResult> =
        sparql(QuerySparqlParams.builder().sparqlQuery(sparqlQuery).build(), requestOptions)

    /** @see sparql */
    fun sparql(sparqlQuery: SparqlQuery): CompletableFuture<SparqlResult> =
        sparql(sparqlQuery, RequestOptions.none())

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
        ): CompletableFuture<HttpResponseFor<QueryExecuteResponse>> =
            execute(params, RequestOptions.none())

        /** @see execute */
        fun execute(
            params: QueryExecuteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<QueryExecuteResponse>>

        /**
         * Returns a raw HTTP response for `post /api/v1/overpass`, but is otherwise the same as
         * [QueryServiceAsync.overpass].
         */
        fun overpass(
            params: QueryOverpassParams
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            overpass(params, RequestOptions.none())

        /** @see overpass */
        fun overpass(
            params: QueryOverpassParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeatureCollection>>

        /** @see overpass */
        fun overpass(
            overpassQuery: OverpassQuery,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            overpass(
                QueryOverpassParams.builder().overpassQuery(overpassQuery).build(),
                requestOptions,
            )

        /** @see overpass */
        fun overpass(
            overpassQuery: OverpassQuery
        ): CompletableFuture<HttpResponseFor<FeatureCollection>> =
            overpass(overpassQuery, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `post /api/v1/sparql`, but is otherwise the same as
         * [QueryServiceAsync.sparql].
         */
        fun sparql(params: QuerySparqlParams): CompletableFuture<HttpResponseFor<SparqlResult>> =
            sparql(params, RequestOptions.none())

        /** @see sparql */
        fun sparql(
            params: QuerySparqlParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SparqlResult>>

        /** @see sparql */
        fun sparql(
            sparqlQuery: SparqlQuery,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SparqlResult>> =
            sparql(QuerySparqlParams.builder().sparqlQuery(sparqlQuery).build(), requestOptions)

        /** @see sparql */
        fun sparql(sparqlQuery: SparqlQuery): CompletableFuture<HttpResponseFor<SparqlResult>> =
            sparql(sparqlQuery, RequestOptions.none())
    }
}
