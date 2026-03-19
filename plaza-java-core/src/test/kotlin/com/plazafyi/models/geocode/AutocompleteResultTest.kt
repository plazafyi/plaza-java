// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutocompleteResultTest {

    @Test
    fun create() {
        val autocompleteResult =
            AutocompleteResult.builder()
                .addFeature(
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
                )
                .type(AutocompleteResult.Type.FEATURE_COLLECTION)
                .build()

        assertThat(autocompleteResult.features())
            .containsExactly(
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
            )
        assertThat(autocompleteResult.type()).isEqualTo(AutocompleteResult.Type.FEATURE_COLLECTION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val autocompleteResult =
            AutocompleteResult.builder()
                .addFeature(
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
                )
                .type(AutocompleteResult.Type.FEATURE_COLLECTION)
                .build()

        val roundtrippedAutocompleteResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(autocompleteResult),
                jacksonTypeRef<AutocompleteResult>(),
            )

        assertThat(roundtrippedAutocompleteResult).isEqualTo(autocompleteResult)
    }
}
