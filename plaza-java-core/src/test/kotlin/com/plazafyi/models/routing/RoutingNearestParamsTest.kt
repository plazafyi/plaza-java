// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoutingNearestParamsTest {

    @Test
    fun create() {
        RoutingNearestParams.builder()
            .nearestRequest(
                NearestRequest.builder()
                    .geometry(
                        PointGeometry.builder()
                            .addCoordinate(2.3522)
                            .addCoordinate(48.8566)
                            .type(PointGeometry.Type.POINT)
                            .build()
                    )
                    .radius(1.0)
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            RoutingNearestParams.builder()
                .nearestRequest(
                    NearestRequest.builder()
                        .geometry(
                            PointGeometry.builder()
                                .addCoordinate(2.3522)
                                .addCoordinate(48.8566)
                                .type(PointGeometry.Type.POINT)
                                .build()
                        )
                        .radius(1.0)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                NearestRequest.builder()
                    .geometry(
                        PointGeometry.builder()
                            .addCoordinate(2.3522)
                            .addCoordinate(48.8566)
                            .type(PointGeometry.Type.POINT)
                            .build()
                    )
                    .radius(1.0)
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            RoutingNearestParams.builder()
                .nearestRequest(
                    NearestRequest.builder()
                        .geometry(
                            PointGeometry.builder()
                                .addCoordinate(2.3522)
                                .addCoordinate(48.8566)
                                .type(PointGeometry.Type.POINT)
                                .build()
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                NearestRequest.builder()
                    .geometry(
                        PointGeometry.builder()
                            .addCoordinate(2.3522)
                            .addCoordinate(48.8566)
                            .type(PointGeometry.Type.POINT)
                            .build()
                    )
                    .build()
            )
    }
}
