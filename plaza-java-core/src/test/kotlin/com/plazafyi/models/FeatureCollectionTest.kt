// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FeatureCollectionTest {

    @Test
    fun create() {
        val featureCollection =
            FeatureCollection.builder()
                .addFeature(
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
                )
                .type(FeatureCollection.Type.FEATURE_COLLECTION)
                .build()

        assertThat(featureCollection.features())
            .containsExactly(
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
            )
        assertThat(featureCollection.type()).isEqualTo(FeatureCollection.Type.FEATURE_COLLECTION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val featureCollection =
            FeatureCollection.builder()
                .addFeature(
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
                )
                .type(FeatureCollection.Type.FEATURE_COLLECTION)
                .build()

        val roundtrippedFeatureCollection =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(featureCollection),
                jacksonTypeRef<FeatureCollection>(),
            )

        assertThat(roundtrippedFeatureCollection).isEqualTo(featureCollection)
    }
}
