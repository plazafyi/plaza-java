// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.optimize

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OptimizeJobStatusTest {

    @Test
    fun create() {
        val optimizeJobStatus =
            OptimizeJobStatus.builder()
                .status(OptimizeJobStatus.Status.COMPLETED)
                .result(
                    OptimizeCompletedResult.builder()
                        .addFeature(
                            OptimizeCompletedResult.Feature.builder()
                                .geometry(
                                    GeoJsonGeometry.builder()
                                        .coordinatesOfPoint(listOf(2.3522, 48.8566))
                                        .type(GeoJsonGeometry.Type.POINT)
                                        .build()
                                )
                                .properties(
                                    OptimizeCompletedResult.Feature.Properties.builder()
                                        .costS(0.0)
                                        .cumulativeCostS(0.0)
                                        .waypointIndex(0L)
                                        .build()
                                )
                                .type(OptimizeCompletedResult.Feature.Type.FEATURE)
                                .build()
                        )
                        .optimization("optimization")
                        .roundtrip(true)
                        .totalCostS(0.0)
                        .type(OptimizeCompletedResult.Type.FEATURE_COLLECTION)
                        .build()
                )
                .build()

        assertThat(optimizeJobStatus.status()).isEqualTo(OptimizeJobStatus.Status.COMPLETED)
        assertThat(optimizeJobStatus.result())
            .contains(
                OptimizeCompletedResult.builder()
                    .addFeature(
                        OptimizeCompletedResult.Feature.builder()
                            .geometry(
                                GeoJsonGeometry.builder()
                                    .coordinatesOfPoint(listOf(2.3522, 48.8566))
                                    .type(GeoJsonGeometry.Type.POINT)
                                    .build()
                            )
                            .properties(
                                OptimizeCompletedResult.Feature.Properties.builder()
                                    .costS(0.0)
                                    .cumulativeCostS(0.0)
                                    .waypointIndex(0L)
                                    .build()
                            )
                            .type(OptimizeCompletedResult.Feature.Type.FEATURE)
                            .build()
                    )
                    .optimization("optimization")
                    .roundtrip(true)
                    .totalCostS(0.0)
                    .type(OptimizeCompletedResult.Type.FEATURE_COLLECTION)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val optimizeJobStatus =
            OptimizeJobStatus.builder()
                .status(OptimizeJobStatus.Status.COMPLETED)
                .result(
                    OptimizeCompletedResult.builder()
                        .addFeature(
                            OptimizeCompletedResult.Feature.builder()
                                .geometry(
                                    GeoJsonGeometry.builder()
                                        .coordinatesOfPoint(listOf(2.3522, 48.8566))
                                        .type(GeoJsonGeometry.Type.POINT)
                                        .build()
                                )
                                .properties(
                                    OptimizeCompletedResult.Feature.Properties.builder()
                                        .costS(0.0)
                                        .cumulativeCostS(0.0)
                                        .waypointIndex(0L)
                                        .build()
                                )
                                .type(OptimizeCompletedResult.Feature.Type.FEATURE)
                                .build()
                        )
                        .optimization("optimization")
                        .roundtrip(true)
                        .totalCostS(0.0)
                        .type(OptimizeCompletedResult.Type.FEATURE_COLLECTION)
                        .build()
                )
                .build()

        val roundtrippedOptimizeJobStatus =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(optimizeJobStatus),
                jacksonTypeRef<OptimizeJobStatus>(),
            )

        assertThat(roundtrippedOptimizeJobStatus).isEqualTo(optimizeJobStatus)
    }
}
