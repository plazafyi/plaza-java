// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GeoJsonGeometryTest {

    @Test
    fun create() {
        val geoJsonGeometry =
            GeoJsonGeometry.builder()
                .coordinatesOfNumber(listOf(0.0))
                .type(GeoJsonGeometry.Type.POINT)
                .build()

        assertThat(geoJsonGeometry.coordinates())
            .isEqualTo(GeoJsonGeometry.Coordinates.ofNumber(listOf(0.0)))
        assertThat(geoJsonGeometry.type()).isEqualTo(GeoJsonGeometry.Type.POINT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val geoJsonGeometry =
            GeoJsonGeometry.builder()
                .coordinatesOfNumber(listOf(0.0))
                .type(GeoJsonGeometry.Type.POINT)
                .build()

        val roundtrippedGeoJsonGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geoJsonGeometry),
                jacksonTypeRef<GeoJsonGeometry>(),
            )

        assertThat(roundtrippedGeoJsonGeometry).isEqualTo(geoJsonGeometry)
    }
}
