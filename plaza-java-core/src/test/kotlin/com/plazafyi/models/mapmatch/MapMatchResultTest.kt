// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.mapmatch

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MapMatchResultTest {

    @Test
    fun create() {
        val mapMatchResult =
            MapMatchResult.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    MapMatchResult.Properties.builder()
                        .confidence(0.0)
                        .distance(0.0)
                        .duration(0.0)
                        .build()
                )
                .type(MapMatchResult.Type.FEATURE)
                .addLeg(
                    MapMatchResult.Leg.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        assertThat(mapMatchResult.geometry())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(mapMatchResult.properties())
            .isEqualTo(
                MapMatchResult.Properties.builder()
                    .confidence(0.0)
                    .distance(0.0)
                    .duration(0.0)
                    .build()
            )
        assertThat(mapMatchResult.type()).isEqualTo(MapMatchResult.Type.FEATURE)
        assertThat(mapMatchResult.legs().getOrNull())
            .containsExactly(
                MapMatchResult.Leg.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mapMatchResult =
            MapMatchResult.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    MapMatchResult.Properties.builder()
                        .confidence(0.0)
                        .distance(0.0)
                        .duration(0.0)
                        .build()
                )
                .type(MapMatchResult.Type.FEATURE)
                .addLeg(
                    MapMatchResult.Leg.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        val roundtrippedMapMatchResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mapMatchResult),
                jacksonTypeRef<MapMatchResult>(),
            )

        assertThat(roundtrippedMapMatchResult).isEqualTo(mapMatchResult)
    }
}
