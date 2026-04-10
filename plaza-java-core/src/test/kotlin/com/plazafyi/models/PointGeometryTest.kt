// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PointGeometryTest {

    @Test
    fun create() {
        val pointGeometry =
            PointGeometry.builder()
                .addCoordinate(2.3522)
                .addCoordinate(48.8566)
                .type(PointGeometry.Type.POINT)
                .build()

        assertThat(pointGeometry.coordinates()).containsExactly(2.3522, 48.8566)
        assertThat(pointGeometry.type()).isEqualTo(PointGeometry.Type.POINT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val pointGeometry =
            PointGeometry.builder()
                .addCoordinate(2.3522)
                .addCoordinate(48.8566)
                .type(PointGeometry.Type.POINT)
                .build()

        val roundtrippedPointGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(pointGeometry),
                jacksonTypeRef<PointGeometry>(),
            )

        assertThat(roundtrippedPointGeometry).isEqualTo(pointGeometry)
    }
}
