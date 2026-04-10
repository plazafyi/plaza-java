// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PolygonGeometryTest {

    @Test
    fun create() {
        val polygonGeometry =
            PolygonGeometry.builder()
                .addCoordinate(
                    listOf(listOf(0.0, 0.0), listOf(0.0, 0.0), listOf(0.0, 0.0), listOf(0.0, 0.0))
                )
                .type(PolygonGeometry.Type.POLYGON)
                .build()

        assertThat(polygonGeometry.coordinates())
            .containsExactly(
                listOf(listOf(0.0, 0.0), listOf(0.0, 0.0), listOf(0.0, 0.0), listOf(0.0, 0.0))
            )
        assertThat(polygonGeometry.type()).isEqualTo(PolygonGeometry.Type.POLYGON)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val polygonGeometry =
            PolygonGeometry.builder()
                .addCoordinate(
                    listOf(listOf(0.0, 0.0), listOf(0.0, 0.0), listOf(0.0, 0.0), listOf(0.0, 0.0))
                )
                .type(PolygonGeometry.Type.POLYGON)
                .build()

        val roundtrippedPolygonGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(polygonGeometry),
                jacksonTypeRef<PolygonGeometry>(),
            )

        assertThat(roundtrippedPolygonGeometry).isEqualTo(polygonGeometry)
    }
}
