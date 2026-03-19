// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.optimize

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import com.plazafyi.errors.PlazaInvalidDataException
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class OptimizeResultTest {

    @Test
    fun ofCompleted() {
        val completed =
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

        val optimizeResult = OptimizeResult.ofCompleted(completed)

        assertThat(optimizeResult.completed()).contains(completed)
        assertThat(optimizeResult.processing()).isEmpty
    }

    @Test
    fun ofCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val optimizeResult =
            OptimizeResult.ofCompleted(
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
            )

        val roundtrippedOptimizeResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(optimizeResult),
                jacksonTypeRef<OptimizeResult>(),
            )

        assertThat(roundtrippedOptimizeResult).isEqualTo(optimizeResult)
    }

    @Test
    fun ofProcessing() {
        val processing =
            OptimizeProcessingResult.builder()
                .jobId("job_id")
                .status(OptimizeProcessingResult.Status.PROCESSING)
                .build()

        val optimizeResult = OptimizeResult.ofProcessing(processing)

        assertThat(optimizeResult.completed()).isEmpty
        assertThat(optimizeResult.processing()).contains(processing)
    }

    @Test
    fun ofProcessingRoundtrip() {
        val jsonMapper = jsonMapper()
        val optimizeResult =
            OptimizeResult.ofProcessing(
                OptimizeProcessingResult.builder()
                    .jobId("job_id")
                    .status(OptimizeProcessingResult.Status.PROCESSING)
                    .build()
            )

        val roundtrippedOptimizeResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(optimizeResult),
                jacksonTypeRef<OptimizeResult>(),
            )

        assertThat(roundtrippedOptimizeResult).isEqualTo(optimizeResult)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val optimizeResult =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<OptimizeResult>())

        val e = assertThrows<PlazaInvalidDataException> { optimizeResult.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
