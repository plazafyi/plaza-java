// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.features

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchRequestTest {

    @Test
    fun create() {
        val batchRequest =
            BatchRequest.builder()
                .addElement(
                    BatchRequest.Element.builder()
                        .id(21154906L)
                        .type(BatchRequest.Element.Type.NODE)
                        .build()
                )
                .addElement(
                    BatchRequest.Element.builder()
                        .id(4589123L)
                        .type(BatchRequest.Element.Type.WAY)
                        .build()
                )
                .build()

        assertThat(batchRequest.elements())
            .containsExactly(
                BatchRequest.Element.builder()
                    .id(21154906L)
                    .type(BatchRequest.Element.Type.NODE)
                    .build(),
                BatchRequest.Element.builder()
                    .id(4589123L)
                    .type(BatchRequest.Element.Type.WAY)
                    .build(),
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchRequest =
            BatchRequest.builder()
                .addElement(
                    BatchRequest.Element.builder()
                        .id(21154906L)
                        .type(BatchRequest.Element.Type.NODE)
                        .build()
                )
                .addElement(
                    BatchRequest.Element.builder()
                        .id(4589123L)
                        .type(BatchRequest.Element.Type.WAY)
                        .build()
                )
                .build()

        val roundtrippedBatchRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchRequest),
                jacksonTypeRef<BatchRequest>(),
            )

        assertThat(roundtrippedBatchRequest).isEqualTo(batchRequest)
    }
}
