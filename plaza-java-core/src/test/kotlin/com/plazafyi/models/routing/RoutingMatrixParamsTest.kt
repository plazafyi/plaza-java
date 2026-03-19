// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoutingMatrixParamsTest {

    @Test
    fun create() {
        RoutingMatrixParams.builder()
            .matrixRequest(
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
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            RoutingMatrixParams.builder()
                .matrixRequest(
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
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            RoutingMatrixParams.builder()
                .matrixRequest(
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
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
                    .build()
            )
    }
}
