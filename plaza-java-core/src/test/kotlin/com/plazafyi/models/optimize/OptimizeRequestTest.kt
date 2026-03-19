// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.optimize

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OptimizeRequestTest {

    @Test
    fun create() {
        val optimizeRequest =
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

        assertThat(optimizeRequest.waypoints())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(optimizeRequest.mode()).contains(OptimizeRequest.Mode.AUTO)
        assertThat(optimizeRequest.roundtrip()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val optimizeRequest =
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

        val roundtrippedOptimizeRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(optimizeRequest),
                jacksonTypeRef<OptimizeRequest>(),
            )

        assertThat(roundtrippedOptimizeRequest).isEqualTo(optimizeRequest)
    }
}
