// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MultiLineStringGeometryTest {

    @Test
    fun create() {
        val multiLineStringGeometry =
            MultiLineStringGeometry.builder()
                .addCoordinate(listOf(listOf(0.0, 0.0), listOf(0.0, 0.0)))
                .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                .build()

        assertThat(multiLineStringGeometry.coordinates())
            .containsExactly(listOf(listOf(0.0, 0.0), listOf(0.0, 0.0)))
        assertThat(multiLineStringGeometry.type())
            .isEqualTo(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val multiLineStringGeometry =
            MultiLineStringGeometry.builder()
                .addCoordinate(listOf(listOf(0.0, 0.0), listOf(0.0, 0.0)))
                .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                .build()

        val roundtrippedMultiLineStringGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(multiLineStringGeometry),
                jacksonTypeRef<MultiLineStringGeometry>(),
            )

        assertThat(roundtrippedMultiLineStringGeometry).isEqualTo(multiLineStringGeometry)
    }
}
