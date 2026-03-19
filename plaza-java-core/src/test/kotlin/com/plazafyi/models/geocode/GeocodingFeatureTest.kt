// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GeocodingFeatureTest {

    @Test
    fun create() {
        val geocodingFeature =
            GeocodingFeature.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    GeocodingFeature.Properties.builder()
                        .countryCode("country_code")
                        .displayName("display_name")
                        .distanceM(0.0)
                        .osmId(0L)
                        .osmType("osm_type")
                        .score(0.0)
                        .source("source")
                        .build()
                )
                .type(GeocodingFeature.Type.FEATURE)
                .build()

        assertThat(geocodingFeature.geometry())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(geocodingFeature.properties())
            .isEqualTo(
                GeocodingFeature.Properties.builder()
                    .countryCode("country_code")
                    .displayName("display_name")
                    .distanceM(0.0)
                    .osmId(0L)
                    .osmType("osm_type")
                    .score(0.0)
                    .source("source")
                    .build()
            )
        assertThat(geocodingFeature.type()).isEqualTo(GeocodingFeature.Type.FEATURE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val geocodingFeature =
            GeocodingFeature.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    GeocodingFeature.Properties.builder()
                        .countryCode("country_code")
                        .displayName("display_name")
                        .distanceM(0.0)
                        .osmId(0L)
                        .osmType("osm_type")
                        .score(0.0)
                        .source("source")
                        .build()
                )
                .type(GeocodingFeature.Type.FEATURE)
                .build()

        val roundtrippedGeocodingFeature =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geocodingFeature),
                jacksonTypeRef<GeocodingFeature>(),
            )

        assertThat(roundtrippedGeocodingFeature).isEqualTo(geocodingFeature)
    }
}
