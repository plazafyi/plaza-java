// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.optimize

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OptimizeProcessingResultTest {

    @Test
    fun create() {
        val optimizeProcessingResult =
            OptimizeProcessingResult.builder()
                .jobId("job_id")
                .status(OptimizeProcessingResult.Status.PROCESSING)
                .build()

        assertThat(optimizeProcessingResult.jobId()).isEqualTo("job_id")
        assertThat(optimizeProcessingResult.status())
            .isEqualTo(OptimizeProcessingResult.Status.PROCESSING)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val optimizeProcessingResult =
            OptimizeProcessingResult.builder()
                .jobId("job_id")
                .status(OptimizeProcessingResult.Status.PROCESSING)
                .build()

        val roundtrippedOptimizeProcessingResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(optimizeProcessingResult),
                jacksonTypeRef<OptimizeProcessingResult>(),
            )

        assertThat(roundtrippedOptimizeProcessingResult).isEqualTo(optimizeProcessingResult)
    }
}
