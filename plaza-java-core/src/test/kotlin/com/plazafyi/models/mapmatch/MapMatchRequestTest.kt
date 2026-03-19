// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.mapmatch

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MapMatchRequestTest {

    @Test
    fun create() {
        val mapMatchRequest =
            MapMatchRequest.builder()
                .trace(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .addRadius(0.0)
                .build()

        assertThat(mapMatchRequest.trace())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(mapMatchRequest.radiuses().getOrNull()).containsExactly(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mapMatchRequest =
            MapMatchRequest.builder()
                .trace(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .addRadius(0.0)
                .build()

        val roundtrippedMapMatchRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mapMatchRequest),
                jacksonTypeRef<MapMatchRequest>(),
            )

        assertThat(roundtrippedMapMatchRequest).isEqualTo(mapMatchRequest)
    }
}
