// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GeocodeReverseRequestTest {

    @Test
    fun create() {
        val geocodeReverseRequest =
            GeocodeReverseRequest.builder()
                .geometry(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .lang("lang")
                .limit(1L)
                .radius(1.0)
                .build()

        assertThat(geocodeReverseRequest.geometry())
            .isEqualTo(
                PointGeometry.builder()
                    .addCoordinate(2.3522)
                    .addCoordinate(48.8566)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )
        assertThat(geocodeReverseRequest.lang()).contains("lang")
        assertThat(geocodeReverseRequest.limit()).contains(1L)
        assertThat(geocodeReverseRequest.radius()).contains(1.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val geocodeReverseRequest =
            GeocodeReverseRequest.builder()
                .geometry(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .lang("lang")
                .limit(1L)
                .radius(1.0)
                .build()

        val roundtrippedGeocodeReverseRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geocodeReverseRequest),
                jacksonTypeRef<GeocodeReverseRequest>(),
            )

        assertThat(roundtrippedGeocodeReverseRequest).isEqualTo(geocodeReverseRequest)
    }
}
