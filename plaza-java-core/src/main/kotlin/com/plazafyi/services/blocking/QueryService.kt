// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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

    /** Execute a multi-step query pipeline */
    fun execute(params: QueryExecuteParams): QueryExecuteResponse =
        execute(params, RequestOptions.none())

    /** @see execute */
    fun execute(
        params: QueryExecuteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): QueryExecuteResponse

    /** Execute an Overpass QL query */
    fun overpass(params: QueryOverpassParams): FeatureCollection =
        overpass(params, RequestOptions.none())

    /** @see overpass */
    fun overpass(
        params: QueryOverpassParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection

    /** @see overpass */
    fun overpass(
        overpassQuery: OverpassQuery,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeatureCollection =
        overpass(QueryOverpassParams.builder().overpassQuery(overpassQuery).build(), requestOptions)

    /** @see overpass */
    fun overpass(overpassQuery: OverpassQuery): FeatureCollection =
        overpass(overpassQuery, RequestOptions.none())

    /** Execute a SPARQL query */
    fun sparql(params: QuerySparqlParams): SparqlResult = sparql(params, RequestOptions.none())

    /** @see sparql */
    fun sparql(
        params: QuerySparqlParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SparqlResult

    /** @see sparql */
    fun sparql(
        sparqlQuery: SparqlQuery,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SparqlResult =
        sparql(QuerySparqlParams.builder().sparqlQuery(sparqlQuery).build(), requestOptions)

    /** @see sparql */
    fun sparql(sparqlQuery: SparqlQuery): SparqlResult = sparql(sparqlQuery, RequestOptions.none())

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
        fun execute(params: QueryExecuteParams): HttpResponseFor<QueryExecuteResponse> =
            execute(params, RequestOptions.none())

        /** @see execute */
        @MustBeClosed
        fun execute(
            params: QueryExecuteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<QueryExecuteResponse>

        /**
         * Returns a raw HTTP response for `post /api/v1/overpass`, but is otherwise the same as
         * [QueryService.overpass].
         */
        @MustBeClosed
        fun overpass(params: QueryOverpassParams): HttpResponseFor<FeatureCollection> =
            overpass(params, RequestOptions.none())

        /** @see overpass */
        @MustBeClosed
        fun overpass(
            params: QueryOverpassParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection>

        /** @see overpass */
        @MustBeClosed
        fun overpass(
            overpassQuery: OverpassQuery,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeatureCollection> =
            overpass(
                QueryOverpassParams.builder().overpassQuery(overpassQuery).build(),
                requestOptions,
            )

        /** @see overpass */
        @MustBeClosed
        fun overpass(overpassQuery: OverpassQuery): HttpResponseFor<FeatureCollection> =
            overpass(overpassQuery, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `post /api/v1/sparql`, but is otherwise the same as
         * [QueryService.sparql].
         */
        @MustBeClosed
        fun sparql(params: QuerySparqlParams): HttpResponseFor<SparqlResult> =
            sparql(params, RequestOptions.none())

        /** @see sparql */
        @MustBeClosed
        fun sparql(
            params: QuerySparqlParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SparqlResult>

        /** @see sparql */
        @MustBeClosed
        fun sparql(
            sparqlQuery: SparqlQuery,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SparqlResult> =
            sparql(QuerySparqlParams.builder().sparqlQuery(sparqlQuery).build(), requestOptions)

        /** @see sparql */
        @MustBeClosed
        fun sparql(sparqlQuery: SparqlQuery): HttpResponseFor<SparqlResult> =
            sparql(sparqlQuery, RequestOptions.none())
    }
}
