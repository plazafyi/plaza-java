// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NearestRequestTest {

    @Test
    fun create() {
        val nearestRequest =
            NearestRequest.builder()
                .geometry(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .radius(1.0)
                .build()

        assertThat(nearestRequest.geometry())
            .isEqualTo(
                PointGeometry.builder()
                    .addCoordinate(2.3522)
                    .addCoordinate(48.8566)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )
        assertThat(nearestRequest.radius()).contains(1.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val nearestRequest =
            NearestRequest.builder()
                .geometry(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .radius(1.0)
                .build()

        val roundtrippedNearestRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(nearestRequest),
                jacksonTypeRef<NearestRequest>(),
            )

        assertThat(roundtrippedNearestRequest).isEqualTo(nearestRequest)
    }
}
