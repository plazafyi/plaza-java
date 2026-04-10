// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.Geometry
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationLookupResultTest {

    @Test
    fun create() {
        val elevationLookupResult =
            ElevationLookupResult.builder()
                .pointGeometry(listOf(2.3522, 48.8566))
                .properties(ElevationLookupResult.Properties.builder().elevationM(35.2).build())
                .type(ElevationLookupResult.Type.FEATURE)
                .build()

        assertThat(elevationLookupResult.geometry())
            .isEqualTo(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
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
                .pointGeometry(listOf(2.3522, 48.8566))
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
