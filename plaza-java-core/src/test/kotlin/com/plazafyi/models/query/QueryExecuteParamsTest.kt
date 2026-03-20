// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.query

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class QueryExecuteParamsTest {

    @Test
    fun create() {
        QueryExecuteParams.builder()
            .addStep(
                QueryExecuteParams.Step.builder()
                    .type(QueryExecuteParams.Step.Type.OVERPASS)
                    .query("query")
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            QueryExecuteParams.builder()
                .addStep(
                    QueryExecuteParams.Step.builder()
                        .type(QueryExecuteParams.Step.Type.OVERPASS)
                        .query("query")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.steps())
            .containsExactly(
                QueryExecuteParams.Step.builder()
                    .type(QueryExecuteParams.Step.Type.OVERPASS)
                    .query("query")
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            QueryExecuteParams.builder()
                .addStep(
                    QueryExecuteParams.Step.builder()
                        .type(QueryExecuteParams.Step.Type.OVERPASS)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.steps())
            .containsExactly(
                QueryExecuteParams.Step.builder()
                    .type(QueryExecuteParams.Step.Type.OVERPASS)
                    .build()
            )
    }
}
