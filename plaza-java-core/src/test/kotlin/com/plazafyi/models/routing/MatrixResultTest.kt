// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MatrixResultTest {

    @Test
    fun create() {
        val matrixResult =
            MatrixResult.builder().addDistance(listOf(0.0)).addDuration(listOf(0.0)).build()

        assertThat(matrixResult.distances()).containsExactly(listOf(0.0))
        assertThat(matrixResult.durations()).containsExactly(listOf(0.0))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val matrixResult =
            MatrixResult.builder().addDistance(listOf(0.0)).addDuration(listOf(0.0)).build()

        val roundtrippedMatrixResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(matrixResult),
                jacksonTypeRef<MatrixResult>(),
            )

        assertThat(roundtrippedMatrixResult).isEqualTo(matrixResult)
    }
}
