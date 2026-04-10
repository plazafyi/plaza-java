// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.Geometry
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationProfileResultTest {

    @Test
    fun create() {
        val elevationProfileResult =
            ElevationProfileResult.builder()
                .pointGeometry(listOf(2.3522, 48.8566))
                .properties(
                    ElevationProfileResult.Properties.builder()
                        .avgElevationM(67.8)
                        .maxElevationM(155.3)
                        .minElevationM(28.1)
                        .totalAscentM(127.4)
                        .totalDescentM(89.2)
                        .build()
                )
                .type(ElevationProfileResult.Type.FEATURE)
                .build()

        assertThat(elevationProfileResult.geometry())
            .isEqualTo(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(elevationProfileResult.properties())
            .isEqualTo(
                ElevationProfileResult.Properties.builder()
                    .avgElevationM(67.8)
                    .maxElevationM(155.3)
                    .minElevationM(28.1)
                    .totalAscentM(127.4)
                    .totalDescentM(89.2)
                    .build()
            )
        assertThat(elevationProfileResult.type()).isEqualTo(ElevationProfileResult.Type.FEATURE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val elevationProfileResult =
            ElevationProfileResult.builder()
                .pointGeometry(listOf(2.3522, 48.8566))
                .properties(
                    ElevationProfileResult.Properties.builder()
                        .avgElevationM(67.8)
                        .maxElevationM(155.3)
                        .minElevationM(28.1)
                        .totalAscentM(127.4)
                        .totalDescentM(89.2)
                        .build()
                )
                .type(ElevationProfileResult.Type.FEATURE)
                .build()

        val roundtrippedElevationProfileResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(elevationProfileResult),
                jacksonTypeRef<ElevationProfileResult>(),
            )

        assertThat(roundtrippedElevationProfileResult).isEqualTo(elevationProfileResult)
    }
}
