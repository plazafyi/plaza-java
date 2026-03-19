// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationProfileRequestTest {

    @Test
    fun create() {
        val elevationProfileRequest =
            ElevationProfileRequest.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .build()

        assertThat(elevationProfileRequest.geometry())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val elevationProfileRequest =
            ElevationProfileRequest.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .build()

        val roundtrippedElevationProfileRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(elevationProfileRequest),
                jacksonTypeRef<ElevationProfileRequest>(),
            )

        assertThat(roundtrippedElevationProfileRequest).isEqualTo(elevationProfileRequest)
    }
}
