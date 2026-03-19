// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.mapmatch

import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MapMatchMatchParamsTest {

    @Test
    fun create() {
        MapMatchMatchParams.builder()
            .mapMatchRequest(
                MapMatchRequest.builder()
                    .trace(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .addRadius(0.0)
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            MapMatchMatchParams.builder()
                .mapMatchRequest(
                    MapMatchRequest.builder()
                        .trace(
                            GeoJsonGeometry.builder()
                                .coordinatesOfNumber(listOf(0.0))
                                .type(GeoJsonGeometry.Type.POINT)
                                .build()
                        )
                        .addRadius(0.0)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                MapMatchRequest.builder()
                    .trace(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .addRadius(0.0)
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MapMatchMatchParams.builder()
                .mapMatchRequest(
                    MapMatchRequest.builder()
                        .trace(
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
                MapMatchRequest.builder()
                    .trace(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .build()
            )
    }
}
