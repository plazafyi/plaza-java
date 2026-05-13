// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MatrixRequestTest {

    @Test
    fun create() {
        val matrixRequest =
            MatrixRequest.builder()
                .addDestination(
                    PointGeometry.builder()
                        .addCoordinate(2.2945)
                        .addCoordinate(48.8584)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .addOrigin(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .addOrigin(
                    PointGeometry.builder()
                        .addCoordinate(2.3376)
                        .addCoordinate(48.8606)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .annotations("annotations")
                .fallbackSpeed(1.0)
                .mode(MatrixRequest.Mode.AUTO)
                .build()

        assertThat(matrixRequest.destinations())
            .containsExactly(
                PointGeometry.builder()
                    .addCoordinate(2.2945)
                    .addCoordinate(48.8584)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )
        assertThat(matrixRequest.origins())
            .containsExactly(
                PointGeometry.builder()
                    .addCoordinate(2.3522)
                    .addCoordinate(48.8566)
                    .type(PointGeometry.Type.POINT)
                    .build(),
                PointGeometry.builder()
                    .addCoordinate(2.3376)
                    .addCoordinate(48.8606)
                    .type(PointGeometry.Type.POINT)
                    .build(),
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
                    PointGeometry.builder()
                        .addCoordinate(2.2945)
                        .addCoordinate(48.8584)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .addOrigin(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .addOrigin(
                    PointGeometry.builder()
                        .addCoordinate(2.3376)
                        .addCoordinate(48.8606)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
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
