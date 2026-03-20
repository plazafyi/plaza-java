// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NearestResultTest {

    @Test
    fun create() {
        val nearestResult =
            NearestResult.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfPoint(listOf(2.3522, 48.8566))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    NearestResult.Properties.builder()
                        .distanceM(12.4)
                        .edgeId(0L)
                        .edgeLengthM(0.0)
                        .highway("highway")
                        .osmWayId(0L)
                        .surface("surface")
                        .build()
                )
                .type(NearestResult.Type.FEATURE)
                .build()

        assertThat(nearestResult.geometry())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfPoint(listOf(2.3522, 48.8566))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(nearestResult.properties())
            .isEqualTo(
                NearestResult.Properties.builder()
                    .distanceM(12.4)
                    .edgeId(0L)
                    .edgeLengthM(0.0)
                    .highway("highway")
                    .osmWayId(0L)
                    .surface("surface")
                    .build()
            )
        assertThat(nearestResult.type()).isEqualTo(NearestResult.Type.FEATURE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val nearestResult =
            NearestResult.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfPoint(listOf(2.3522, 48.8566))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    NearestResult.Properties.builder()
                        .distanceM(12.4)
                        .edgeId(0L)
                        .edgeLengthM(0.0)
                        .highway("highway")
                        .osmWayId(0L)
                        .surface("surface")
                        .build()
                )
                .type(NearestResult.Type.FEATURE)
                .build()

        val roundtrippedNearestResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(nearestResult),
                jacksonTypeRef<NearestResult>(),
            )

        assertThat(roundtrippedNearestResult).isEqualTo(nearestResult)
    }
}
