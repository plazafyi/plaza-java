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
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    GeoJsonFeature.Properties.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .type(GeoJsonFeature.Type.FEATURE)
                .id("id")
                .osmId(0L)
                .build()

        assertThat(geoJsonFeature.geometry())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(geoJsonFeature.properties())
            .isEqualTo(
                GeoJsonFeature.Properties.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(geoJsonFeature.type()).isEqualTo(GeoJsonFeature.Type.FEATURE)
        assertThat(geoJsonFeature.id()).contains("id")
        assertThat(geoJsonFeature.osmId()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val geoJsonFeature =
            GeoJsonFeature.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    GeoJsonFeature.Properties.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .type(GeoJsonFeature.Type.FEATURE)
                .id("id")
                .osmId(0L)
                .build()

        val roundtrippedGeoJsonFeature =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geoJsonFeature),
                jacksonTypeRef<GeoJsonFeature>(),
            )

        assertThat(roundtrippedGeoJsonFeature).isEqualTo(geoJsonFeature)
    }
}
