// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoutingMatrixParamsTest {

    @Test
    fun create() {
        RoutingMatrixParams.builder()
            .matrixRequest(
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
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            RoutingMatrixParams.builder()
                .matrixRequest(
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
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            RoutingMatrixParams.builder()
                .matrixRequest(
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
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
                    .build()
            )
    }
}
