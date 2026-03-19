// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationProfileResultTest {

    @Test
    fun create() {
        val elevationProfileResult =
            ElevationProfileResult.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    ElevationProfileResult.Properties.builder()
                        .avgElevationM(0.0)
                        .maxElevationM(0.0)
                        .minElevationM(0.0)
                        .totalAscentM(0.0)
                        .totalDescentM(0.0)
                        .build()
                )
                .type(ElevationProfileResult.Type.FEATURE)
                .build()

        assertThat(elevationProfileResult.geometry())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(elevationProfileResult.properties())
            .isEqualTo(
                ElevationProfileResult.Properties.builder()
                    .avgElevationM(0.0)
                    .maxElevationM(0.0)
                    .minElevationM(0.0)
                    .totalAscentM(0.0)
                    .totalDescentM(0.0)
                    .build()
            )
        assertThat(elevationProfileResult.type()).isEqualTo(ElevationProfileResult.Type.FEATURE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val elevationProfileResult =
            ElevationProfileResult.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    ElevationProfileResult.Properties.builder()
                        .avgElevationM(0.0)
                        .maxElevationM(0.0)
                        .minElevationM(0.0)
                        .totalAscentM(0.0)
                        .totalDescentM(0.0)
                        .build()
                )
                .type(ElevationProfileResult.Type.FEATURE)
                .build()

        val roundtrippedElevationProfileResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(elevationProfileResult),
                jacksonTypeRef<ElevationProfileResult>(),
            )

        assertThat(roundtrippedElevationProfileResult).isEqualTo(elevationProfileResult)
    }
}
