// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LineStringGeometryTest {

    @Test
    fun create() {
        val lineStringGeometry =
            LineStringGeometry.builder()
                .addCoordinate(listOf(0.0, 0.0))
                .addCoordinate(listOf(0.0, 0.0))
                .type(LineStringGeometry.Type.LINE_STRING)
                .build()

        assertThat(lineStringGeometry.coordinates())
            .containsExactly(listOf(0.0, 0.0), listOf(0.0, 0.0))
        assertThat(lineStringGeometry.type()).isEqualTo(LineStringGeometry.Type.LINE_STRING)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val lineStringGeometry =
            LineStringGeometry.builder()
                .addCoordinate(listOf(0.0, 0.0))
                .addCoordinate(listOf(0.0, 0.0))
                .type(LineStringGeometry.Type.LINE_STRING)
                .build()

        val roundtrippedLineStringGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(lineStringGeometry),
                jacksonTypeRef<LineStringGeometry>(),
            )

        assertThat(roundtrippedLineStringGeometry).isEqualTo(lineStringGeometry)
    }
}
