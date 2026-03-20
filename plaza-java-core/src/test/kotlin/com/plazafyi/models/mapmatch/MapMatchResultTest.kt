// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.mapmatch

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MapMatchResultTest {

    @Test
    fun create() {
        val mapMatchResult =
            MapMatchResult.builder()
                .addFeature(
                    MapMatchResult.Feature.builder()
                        .geometry(
                            GeoJsonGeometry.builder()
                                .coordinatesOfPoint(listOf(2.3522, 48.8566))
                                .type(GeoJsonGeometry.Type.POINT)
                                .build()
                        )
                        .properties(
                            MapMatchResult.Feature.Properties.builder()
                                .distanceM(0.0)
                                .edgeId(0L)
                                .matchingsIndex(0L)
                                .name("name")
                                .addOriginal(0.0)
                                .addOriginal(0.0)
                                .waypointIndex(0L)
                                .build()
                        )
                        .type(MapMatchResult.Feature.Type.FEATURE)
                        .build()
                )
                .addMatching(
                    MapMatchResult.Matching.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .type(MapMatchResult.Type.FEATURE_COLLECTION)
                .build()

        assertThat(mapMatchResult.features())
            .containsExactly(
                MapMatchResult.Feature.builder()
                    .geometry(
                        GeoJsonGeometry.builder()
                            .coordinatesOfPoint(listOf(2.3522, 48.8566))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .properties(
                        MapMatchResult.Feature.Properties.builder()
                            .distanceM(0.0)
                            .edgeId(0L)
                            .matchingsIndex(0L)
                            .name("name")
                            .addOriginal(0.0)
                            .addOriginal(0.0)
                            .waypointIndex(0L)
                            .build()
                    )
                    .type(MapMatchResult.Feature.Type.FEATURE)
                    .build()
            )
        assertThat(mapMatchResult.matchings())
            .containsExactly(
                MapMatchResult.Matching.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(mapMatchResult.type()).isEqualTo(MapMatchResult.Type.FEATURE_COLLECTION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mapMatchResult =
            MapMatchResult.builder()
                .addFeature(
                    MapMatchResult.Feature.builder()
                        .geometry(
                            GeoJsonGeometry.builder()
                                .coordinatesOfPoint(listOf(2.3522, 48.8566))
                                .type(GeoJsonGeometry.Type.POINT)
                                .build()
                        )
                        .properties(
                            MapMatchResult.Feature.Properties.builder()
                                .distanceM(0.0)
                                .edgeId(0L)
                                .matchingsIndex(0L)
                                .name("name")
                                .addOriginal(0.0)
                                .addOriginal(0.0)
                                .waypointIndex(0L)
                                .build()
                        )
                        .type(MapMatchResult.Feature.Type.FEATURE)
                        .build()
                )
                .addMatching(
                    MapMatchResult.Matching.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .type(MapMatchResult.Type.FEATURE_COLLECTION)
                .build()

        val roundtrippedMapMatchResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mapMatchResult),
                jacksonTypeRef<MapMatchResult>(),
            )

        assertThat(roundtrippedMapMatchResult).isEqualTo(mapMatchResult)
    }
}
