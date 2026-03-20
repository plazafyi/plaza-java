// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GeocodeResultTest {

    @Test
    fun create() {
        val geocodeResult =
            GeocodeResult.builder()
                .addFeature(
                    GeocodingFeature.builder()
                        .geometry(
                            GeoJsonGeometry.builder()
                                .coordinatesOfPoint(listOf(2.3522, 48.8566))
                                .type(GeoJsonGeometry.Type.POINT)
                                .build()
                        )
                        .properties(
                            GeocodingFeature.Properties.builder()
                                .displayName("221B Baker Street, London, NW1 6XE, United Kingdom")
                                .category("restaurant")
                                .city("London")
                                .confidence(0.0)
                                .country("United Kingdom")
                                .countryCode("GB")
                                .distanceM(0.0)
                                .fullAddress("221B Baker Street, London, NW1 6XE, United Kingdom")
                                .houseNumber("221B")
                                .interpolated(true)
                                .name("Eiffel Tower")
                                .osmId(21154906L)
                                .osmType(GeocodingFeature.Properties.OsmType.NODE)
                                .postcode("NW1 6XE")
                                .score(0.0)
                                .source(GeocodingFeature.Properties.Source.STRUCTURED)
                                .state("England")
                                .street("Baker Street")
                                .subcategory("italian")
                                .tags(
                                    GeocodingFeature.Properties.Tags.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .wikipedia("en:Eiffel Tower")
                                .build()
                        )
                        .type(GeocodingFeature.Type.FEATURE)
                        .build()
                )
                .type(GeocodeResult.Type.FEATURE_COLLECTION)
                .build()

        assertThat(geocodeResult.features())
            .containsExactly(
                GeocodingFeature.builder()
                    .geometry(
                        GeoJsonGeometry.builder()
                            .coordinatesOfPoint(listOf(2.3522, 48.8566))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .properties(
                        GeocodingFeature.Properties.builder()
                            .displayName("221B Baker Street, London, NW1 6XE, United Kingdom")
                            .category("restaurant")
                            .city("London")
                            .confidence(0.0)
                            .country("United Kingdom")
                            .countryCode("GB")
                            .distanceM(0.0)
                            .fullAddress("221B Baker Street, London, NW1 6XE, United Kingdom")
                            .houseNumber("221B")
                            .interpolated(true)
                            .name("Eiffel Tower")
                            .osmId(21154906L)
                            .osmType(GeocodingFeature.Properties.OsmType.NODE)
                            .postcode("NW1 6XE")
                            .score(0.0)
                            .source(GeocodingFeature.Properties.Source.STRUCTURED)
                            .state("England")
                            .street("Baker Street")
                            .subcategory("italian")
                            .tags(
                                GeocodingFeature.Properties.Tags.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .wikipedia("en:Eiffel Tower")
                            .build()
                    )
                    .type(GeocodingFeature.Type.FEATURE)
                    .build()
            )
        assertThat(geocodeResult.type()).isEqualTo(GeocodeResult.Type.FEATURE_COLLECTION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val geocodeResult =
            GeocodeResult.builder()
                .addFeature(
                    GeocodingFeature.builder()
                        .geometry(
                            GeoJsonGeometry.builder()
                                .coordinatesOfPoint(listOf(2.3522, 48.8566))
                                .type(GeoJsonGeometry.Type.POINT)
                                .build()
                        )
                        .properties(
                            GeocodingFeature.Properties.builder()
                                .displayName("221B Baker Street, London, NW1 6XE, United Kingdom")
                                .category("restaurant")
                                .city("London")
                                .confidence(0.0)
                                .country("United Kingdom")
                                .countryCode("GB")
                                .distanceM(0.0)
                                .fullAddress("221B Baker Street, London, NW1 6XE, United Kingdom")
                                .houseNumber("221B")
                                .interpolated(true)
                                .name("Eiffel Tower")
                                .osmId(21154906L)
                                .osmType(GeocodingFeature.Properties.OsmType.NODE)
                                .postcode("NW1 6XE")
                                .score(0.0)
                                .source(GeocodingFeature.Properties.Source.STRUCTURED)
                                .state("England")
                                .street("Baker Street")
                                .subcategory("italian")
                                .tags(
                                    GeocodingFeature.Properties.Tags.builder()
                                        .putAdditionalProperty("foo", JsonValue.from("string"))
                                        .build()
                                )
                                .wikipedia("en:Eiffel Tower")
                                .build()
                        )
                        .type(GeocodingFeature.Type.FEATURE)
                        .build()
                )
                .type(GeocodeResult.Type.FEATURE_COLLECTION)
                .build()

        val roundtrippedGeocodeResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geocodeResult),
                jacksonTypeRef<GeocodeResult>(),
            )

        assertThat(roundtrippedGeocodeResult).isEqualTo(geocodeResult)
    }
}
