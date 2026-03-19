// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.optimize

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OptimizeCompletedResultTest {

    @Test
    fun create() {
        val optimizeCompletedResult =
            OptimizeCompletedResult.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    OptimizeCompletedResult.Properties.builder()
                        .distance(0.0)
                        .duration(0.0)
                        .addWaypointOrder(0L)
                        .build()
                )
                .status(OptimizeCompletedResult.Status.COMPLETED)
                .type(OptimizeCompletedResult.Type.FEATURE)
                .build()

        assertThat(optimizeCompletedResult.geometry())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(optimizeCompletedResult.properties())
            .isEqualTo(
                OptimizeCompletedResult.Properties.builder()
                    .distance(0.0)
                    .duration(0.0)
                    .addWaypointOrder(0L)
                    .build()
            )
        assertThat(optimizeCompletedResult.status())
            .isEqualTo(OptimizeCompletedResult.Status.COMPLETED)
        assertThat(optimizeCompletedResult.type()).isEqualTo(OptimizeCompletedResult.Type.FEATURE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val optimizeCompletedResult =
            OptimizeCompletedResult.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    OptimizeCompletedResult.Properties.builder()
                        .distance(0.0)
                        .duration(0.0)
                        .addWaypointOrder(0L)
                        .build()
                )
                .status(OptimizeCompletedResult.Status.COMPLETED)
                .type(OptimizeCompletedResult.Type.FEATURE)
                .build()

        val roundtrippedOptimizeCompletedResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(optimizeCompletedResult),
                jacksonTypeRef<OptimizeCompletedResult>(),
            )

        assertThat(roundtrippedOptimizeCompletedResult).isEqualTo(optimizeCompletedResult)
    }
}
