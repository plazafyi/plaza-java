// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.optimize

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OptimizeJobStatusTest {

    @Test
    fun create() {
        val optimizeJobStatus =
            OptimizeJobStatus.builder()
                .status(OptimizeJobStatus.Status.COMPLETED)
                .error("error")
                .result(JsonValue.from(mapOf<String, Any>()))
                .build()

        assertThat(optimizeJobStatus.status()).isEqualTo(OptimizeJobStatus.Status.COMPLETED)
        assertThat(optimizeJobStatus.error()).contains("error")
        assertThat(optimizeJobStatus._result()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val optimizeJobStatus =
            OptimizeJobStatus.builder()
                .status(OptimizeJobStatus.Status.COMPLETED)
                .error("error")
                .result(JsonValue.from(mapOf<String, Any>()))
                .build()

        val roundtrippedOptimizeJobStatus =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(optimizeJobStatus),
                jacksonTypeRef<OptimizeJobStatus>(),
            )

        assertThat(roundtrippedOptimizeJobStatus).isEqualTo(optimizeJobStatus)
    }
}
