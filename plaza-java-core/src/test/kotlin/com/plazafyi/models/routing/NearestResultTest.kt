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
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(NearestResult.Properties.builder().distanceM(0.0).edgeId(0L).build())
                .type(NearestResult.Type.FEATURE)
                .build()

        assertThat(nearestResult.geometry())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(nearestResult.properties())
            .isEqualTo(NearestResult.Properties.builder().distanceM(0.0).edgeId(0L).build())
        assertThat(nearestResult.type()).isEqualTo(NearestResult.Type.FEATURE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val nearestResult =
            NearestResult.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(NearestResult.Properties.builder().distanceM(0.0).edgeId(0L).build())
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
