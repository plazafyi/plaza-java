// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MultiPolygonGeometryTest {

    @Test
    fun create() {
        val multiPolygonGeometry =
            MultiPolygonGeometry.builder()
                .addCoordinate(
                    listOf(
                        listOf(
                            listOf(0.0, 0.0),
                            listOf(0.0, 0.0),
                            listOf(0.0, 0.0),
                            listOf(0.0, 0.0),
                        )
                    )
                )
                .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                .build()

        assertThat(multiPolygonGeometry.coordinates())
            .containsExactly(
                listOf(
                    listOf(listOf(0.0, 0.0), listOf(0.0, 0.0), listOf(0.0, 0.0), listOf(0.0, 0.0))
                )
            )
        assertThat(multiPolygonGeometry.type()).isEqualTo(MultiPolygonGeometry.Type.MULTI_POLYGON)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val multiPolygonGeometry =
            MultiPolygonGeometry.builder()
                .addCoordinate(
                    listOf(
                        listOf(
                            listOf(0.0, 0.0),
                            listOf(0.0, 0.0),
                            listOf(0.0, 0.0),
                            listOf(0.0, 0.0),
                        )
                    )
                )
                .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                .build()

        val roundtrippedMultiPolygonGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(multiPolygonGeometry),
                jacksonTypeRef<MultiPolygonGeometry>(),
            )

        assertThat(roundtrippedMultiPolygonGeometry).isEqualTo(multiPolygonGeometry)
    }
}
