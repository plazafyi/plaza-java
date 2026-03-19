// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.optimize

import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OptimizeCreateParamsTest {

    @Test
    fun create() {
        OptimizeCreateParams.builder()
            .optimizeRequest(
                OptimizeRequest.builder()
                    .waypoints(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .mode(OptimizeRequest.Mode.AUTO)
                    .roundtrip(true)
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            OptimizeCreateParams.builder()
                .optimizeRequest(
                    OptimizeRequest.builder()
                        .waypoints(
                            GeoJsonGeometry.builder()
                                .coordinatesOfNumber(listOf(0.0))
                                .type(GeoJsonGeometry.Type.POINT)
                                .build()
                        )
                        .mode(OptimizeRequest.Mode.AUTO)
                        .roundtrip(true)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                OptimizeRequest.builder()
                    .waypoints(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .mode(OptimizeRequest.Mode.AUTO)
                    .roundtrip(true)
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            OptimizeCreateParams.builder()
                .optimizeRequest(
                    OptimizeRequest.builder()
                        .waypoints(
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
                OptimizeRequest.builder()
                    .waypoints(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .build()
            )
    }
}
