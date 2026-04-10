// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationLookupRequestTest {

    @Test
    fun create() {
        val elevationLookupRequest =
            ElevationLookupRequest.builder()
                .geometry(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .build()

        assertThat(elevationLookupRequest.geometry())
            .isEqualTo(
                ElevationLookupRequest.Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val elevationLookupRequest =
            ElevationLookupRequest.builder()
                .geometry(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .build()

        val roundtrippedElevationLookupRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(elevationLookupRequest),
                jacksonTypeRef<ElevationLookupRequest>(),
            )

        assertThat(roundtrippedElevationLookupRequest).isEqualTo(elevationLookupRequest)
    }
}
