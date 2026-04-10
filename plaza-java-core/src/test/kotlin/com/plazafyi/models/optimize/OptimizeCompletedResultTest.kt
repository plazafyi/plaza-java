// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.optimize

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OptimizeCompletedResultTest {

    @Test
    fun create() {
        val optimizeCompletedResult =
            OptimizeCompletedResult.builder()
                .addFeature(
                    OptimizeCompletedResult.Feature.builder()
                        .pointGeometry(listOf(2.3522, 48.8566))
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

        assertThat(optimizeCompletedResult.features())
            .containsExactly(
                OptimizeCompletedResult.Feature.builder()
                    .pointGeometry(listOf(2.3522, 48.8566))
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
        assertThat(optimizeCompletedResult.optimization()).isEqualTo("optimization")
        assertThat(optimizeCompletedResult.roundtrip()).isEqualTo(true)
        assertThat(optimizeCompletedResult.totalCostS()).isEqualTo(0.0)
        assertThat(optimizeCompletedResult.type())
            .isEqualTo(OptimizeCompletedResult.Type.FEATURE_COLLECTION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val optimizeCompletedResult =
            OptimizeCompletedResult.builder()
                .addFeature(
                    OptimizeCompletedResult.Feature.builder()
                        .pointGeometry(listOf(2.3522, 48.8566))
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

        val roundtrippedOptimizeCompletedResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(optimizeCompletedResult),
                jacksonTypeRef<OptimizeCompletedResult>(),
            )

        assertThat(roundtrippedOptimizeCompletedResult).isEqualTo(optimizeCompletedResult)
    }
}
