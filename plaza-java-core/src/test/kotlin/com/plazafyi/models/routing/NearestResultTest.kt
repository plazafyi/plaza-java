// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.Geometry
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NearestResultTest {

    @Test
    fun create() {
        val nearestResult =
            NearestResult.builder()
                .pointGeometry(listOf(2.3522, 48.8566))
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
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
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
                .pointGeometry(listOf(2.3522, 48.8566))
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
