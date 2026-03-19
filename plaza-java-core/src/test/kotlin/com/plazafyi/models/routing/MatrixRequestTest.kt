// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MatrixRequestTest {

    @Test
    fun create() {
        val matrixRequest =
            MatrixRequest.builder()
                .destinations(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .origins(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .mode(MatrixRequest.Mode.AUTO)
                .build()

        assertThat(matrixRequest.destinations())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(matrixRequest.origins())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(matrixRequest.mode()).contains(MatrixRequest.Mode.AUTO)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val matrixRequest =
            MatrixRequest.builder()
                .destinations(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .origins(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
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
