// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.query

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class QuerySparqlParamsTest {

    @Test
    fun create() {
        QuerySparqlParams.builder()
            .sparqlQuery(SparqlQuery.builder().query("query").build())
            .build()
    }

    @Test
    fun body() {
        val params =
            QuerySparqlParams.builder()
                .sparqlQuery(SparqlQuery.builder().query("query").build())
                .build()

        val body = params._body()

        assertThat(body).isEqualTo(SparqlQuery.builder().query("query").build())
    }
}
