// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MatrixRequestTest {

    @Test
    fun create() {
        val matrixRequest =
            MatrixRequest.builder()
                .addDestination(
                    MatrixRequest.Destination.builder().lat(48.8584).lng(2.2945).build()
                )
                .addOrigin(MatrixRequest.Origin.builder().lat(48.8566).lng(2.3522).build())
                .addOrigin(MatrixRequest.Origin.builder().lat(48.8606).lng(2.3376).build())
                .annotations("annotations")
                .fallbackSpeed(1.0)
                .mode(MatrixRequest.Mode.AUTO)
                .build()

        assertThat(matrixRequest.destinations())
            .containsExactly(MatrixRequest.Destination.builder().lat(48.8584).lng(2.2945).build())
        assertThat(matrixRequest.origins())
            .containsExactly(
                MatrixRequest.Origin.builder().lat(48.8566).lng(2.3522).build(),
                MatrixRequest.Origin.builder().lat(48.8606).lng(2.3376).build(),
            )
        assertThat(matrixRequest.annotations()).contains("annotations")
        assertThat(matrixRequest.fallbackSpeed()).contains(1.0)
        assertThat(matrixRequest.mode()).contains(MatrixRequest.Mode.AUTO)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val matrixRequest =
            MatrixRequest.builder()
                .addDestination(
                    MatrixRequest.Destination.builder().lat(48.8584).lng(2.2945).build()
                )
                .addOrigin(MatrixRequest.Origin.builder().lat(48.8566).lng(2.3522).build())
                .addOrigin(MatrixRequest.Origin.builder().lat(48.8606).lng(2.3376).build())
                .annotations("annotations")
                .fallbackSpeed(1.0)
                .mode(MatrixRequest.Mode.AUTO)
                .build()

        val roundtrippedMatrixRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(matrixRequest),
                jacksonTypeRef<MatrixRequest>(),
            )

        assertThat(roundtrippedMatrixRequest).isEqualTo(matrixRequest)
    }
}
