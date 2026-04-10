// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GeocodeForwardRequestTest {

    @Test
    fun create() {
        val geocodeForwardRequest =
            GeocodeForwardRequest.builder()
                .q("221B Baker Street, London")
                .countryCode("xx")
                .focus(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .lang("lang")
                .layer("layer")
                .limit(1L)
                .build()

        assertThat(geocodeForwardRequest.q()).isEqualTo("221B Baker Street, London")
        assertThat(geocodeForwardRequest.countryCode()).contains("xx")
        assertThat(geocodeForwardRequest.focus())
            .contains(
                PointGeometry.builder()
                    .addCoordinate(2.3522)
                    .addCoordinate(48.8566)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )
        assertThat(geocodeForwardRequest.lang()).contains("lang")
        assertThat(geocodeForwardRequest.layer()).contains("layer")
        assertThat(geocodeForwardRequest.limit()).contains(1L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val geocodeForwardRequest =
            GeocodeForwardRequest.builder()
                .q("221B Baker Street, London")
                .countryCode("xx")
                .focus(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .lang("lang")
                .layer("layer")
                .limit(1L)
                .build()

        val roundtrippedGeocodeForwardRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geocodeForwardRequest),
                jacksonTypeRef<GeocodeForwardRequest>(),
            )

        assertThat(roundtrippedGeocodeForwardRequest).isEqualTo(geocodeForwardRequest)
    }
}
