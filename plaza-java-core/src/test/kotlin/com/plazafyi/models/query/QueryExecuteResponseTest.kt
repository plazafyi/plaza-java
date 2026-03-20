// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.query

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class QueryExecuteResponseTest {

    @Test
    fun create() {
        val queryExecuteResponse =
            QueryExecuteResponse.builder()
                .addStep(
                    QueryExecuteResponse.Step.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        assertThat(queryExecuteResponse.steps())
            .containsExactly(
                QueryExecuteResponse.Step.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val queryExecuteResponse =
            QueryExecuteResponse.builder()
                .addStep(
                    QueryExecuteResponse.Step.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val roundtrippedQueryExecuteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(queryExecuteResponse),
                jacksonTypeRef<QueryExecuteResponse>(),
            )

        assertThat(roundtrippedQueryExecuteResponse).isEqualTo(queryExecuteResponse)
    }
}
