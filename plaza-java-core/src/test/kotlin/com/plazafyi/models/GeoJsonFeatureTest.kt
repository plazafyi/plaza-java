// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GeoJsonFeatureTest {

    @Test
    fun create() {
        val geoJsonFeature =
            GeoJsonFeature.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfPoint(listOf(2.3522, 48.8566))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    GeoJsonFeature.Properties.builder()
                        .putAdditionalProperty("@id", JsonValue.from("bar"))
                        .putAdditionalProperty("@type", JsonValue.from("bar"))
                        .putAdditionalProperty("amenity", JsonValue.from("bar"))
                        .putAdditionalProperty("cuisine", JsonValue.from("bar"))
                        .putAdditionalProperty("name", JsonValue.from("bar"))
                        .build()
                )
                .type(GeoJsonFeature.Type.FEATURE)
                .id("node/21154906")
                .build()

        assertThat(geoJsonFeature.geometry())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfPoint(listOf(2.3522, 48.8566))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(geoJsonFeature.properties())
            .isEqualTo(
                GeoJsonFeature.Properties.builder()
                    .putAdditionalProperty("@id", JsonValue.from("bar"))
                    .putAdditionalProperty("@type", JsonValue.from("bar"))
                    .putAdditionalProperty("amenity", JsonValue.from("bar"))
                    .putAdditionalProperty("cuisine", JsonValue.from("bar"))
                    .putAdditionalProperty("name", JsonValue.from("bar"))
                    .build()
            )
        assertThat(geoJsonFeature.type()).isEqualTo(GeoJsonFeature.Type.FEATURE)
        assertThat(geoJsonFeature.id()).contains("node/21154906")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val geoJsonFeature =
            GeoJsonFeature.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfPoint(listOf(2.3522, 48.8566))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    GeoJsonFeature.Properties.builder()
                        .putAdditionalProperty("@id", JsonValue.from("bar"))
                        .putAdditionalProperty("@type", JsonValue.from("bar"))
                        .putAdditionalProperty("amenity", JsonValue.from("bar"))
                        .putAdditionalProperty("cuisine", JsonValue.from("bar"))
                        .putAdditionalProperty("name", JsonValue.from("bar"))
                        .build()
                )
                .type(GeoJsonFeature.Type.FEATURE)
                .id("node/21154906")
                .build()

        val roundtrippedGeoJsonFeature =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geoJsonFeature),
                jacksonTypeRef<GeoJsonFeature>(),
            )

        assertThat(roundtrippedGeoJsonFeature).isEqualTo(geoJsonFeature)
    }
}
