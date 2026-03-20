// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoutingMatrixParamsTest {

    @Test
    fun create() {
        RoutingMatrixParams.builder()
            .matrixRequest(
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
                            MatrixRequest.Destination.builder().lat(48.8584).lng(2.2945).build()
                        )
                        .addOrigin(MatrixRequest.Origin.builder().lat(48.8566).lng(2.3522).build())
                        .addOrigin(MatrixRequest.Origin.builder().lat(48.8606).lng(2.3376).build())
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
                        MatrixRequest.Destination.builder().lat(48.8584).lng(2.2945).build()
                    )
                    .addOrigin(MatrixRequest.Origin.builder().lat(48.8566).lng(2.3522).build())
                    .addOrigin(MatrixRequest.Origin.builder().lat(48.8606).lng(2.3376).build())
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
                            MatrixRequest.Destination.builder().lat(48.8584).lng(2.2945).build()
                        )
                        .addOrigin(MatrixRequest.Origin.builder().lat(48.8566).lng(2.3522).build())
                        .addOrigin(MatrixRequest.Origin.builder().lat(48.8606).lng(2.3376).build())
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                MatrixRequest.builder()
                    .addDestination(
                        MatrixRequest.Destination.builder().lat(48.8584).lng(2.2945).build()
                    )
                    .addOrigin(MatrixRequest.Origin.builder().lat(48.8566).lng(2.3522).build())
                    .addOrigin(MatrixRequest.Origin.builder().lat(48.8606).lng(2.3376).build())
                    .build()
            )
    }
}
