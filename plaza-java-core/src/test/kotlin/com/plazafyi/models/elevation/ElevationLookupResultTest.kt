// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationLookupResultTest {

    @Test
    fun create() {
        val elevationLookupResult =
            ElevationLookupResult.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfPoint(listOf(2.3522, 48.8566))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(ElevationLookupResult.Properties.builder().elevationM(35.2).build())
                .type(ElevationLookupResult.Type.FEATURE)
                .build()

        assertThat(elevationLookupResult.geometry())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfPoint(listOf(2.3522, 48.8566))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(elevationLookupResult.properties())
            .isEqualTo(ElevationLookupResult.Properties.builder().elevationM(35.2).build())
        assertThat(elevationLookupResult.type()).isEqualTo(ElevationLookupResult.Type.FEATURE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val elevationLookupResult =
            ElevationLookupResult.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfPoint(listOf(2.3522, 48.8566))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(ElevationLookupResult.Properties.builder().elevationM(35.2).build())
                .type(ElevationLookupResult.Type.FEATURE)
                .build()

        val roundtrippedElevationLookupResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(elevationLookupResult),
                jacksonTypeRef<ElevationLookupResult>(),
            )

        assertThat(roundtrippedElevationLookupResult).isEqualTo(elevationLookupResult)
    }
}
