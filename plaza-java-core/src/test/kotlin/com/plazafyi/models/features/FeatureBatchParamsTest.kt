// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.features

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FeatureBatchParamsTest {

    @Test
    fun create() {
        FeatureBatchParams.builder()
            .batchRequest(
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
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            FeatureBatchParams.builder()
                .batchRequest(
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
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
            )
    }
}
