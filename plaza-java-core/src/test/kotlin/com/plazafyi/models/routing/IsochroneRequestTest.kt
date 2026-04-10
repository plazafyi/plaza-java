// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IsochroneRequestTest {

    @Test
    fun create() {
        val isochroneRequest =
            IsochroneRequest.builder()
                .geometry(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .addTime(1L)
                .mode(IsochroneRequest.Mode.AUTO)
                .build()

        assertThat(isochroneRequest.geometry())
            .isEqualTo(
                PointGeometry.builder()
                    .addCoordinate(2.3522)
                    .addCoordinate(48.8566)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )
        assertThat(isochroneRequest.time()).containsExactly(1L)
        assertThat(isochroneRequest.mode()).contains(IsochroneRequest.Mode.AUTO)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val isochroneRequest =
            IsochroneRequest.builder()
                .geometry(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .addTime(1L)
                .mode(IsochroneRequest.Mode.AUTO)
                .build()

        val roundtrippedIsochroneRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(isochroneRequest),
                jacksonTypeRef<IsochroneRequest>(),
            )

        assertThat(roundtrippedIsochroneRequest).isEqualTo(isochroneRequest)
    }
}
