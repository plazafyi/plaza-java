// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonFeature
import com.plazafyi.models.GeoJsonGeometry
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoutingIsochronePostResponseTest {

    @Test
    fun create() {
        val routingIsochronePostResponse =
            RoutingIsochronePostResponse.builder()
                .addFeature(
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
                )
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfPoint(listOf(2.3522, 48.8566))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    RoutingIsochronePostResponse.Properties.builder()
                        .areaM2(0.0)
                        .maxCostS(0.0)
                        .mode(RoutingIsochronePostResponse.Properties.Mode.AUTO)
                        .timeSeconds(0.0)
                        .verticesReached(0L)
                        .build()
                )
                .type(RoutingIsochronePostResponse.Type.FEATURE)
                .build()

        assertThat(routingIsochronePostResponse.features().getOrNull())
            .containsExactly(
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
            )
        assertThat(routingIsochronePostResponse.geometry())
            .contains(
                GeoJsonGeometry.builder()
                    .coordinatesOfPoint(listOf(2.3522, 48.8566))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(routingIsochronePostResponse.properties())
            .contains(
                RoutingIsochronePostResponse.Properties.builder()
                    .areaM2(0.0)
                    .maxCostS(0.0)
                    .mode(RoutingIsochronePostResponse.Properties.Mode.AUTO)
                    .timeSeconds(0.0)
                    .verticesReached(0L)
                    .build()
            )
        assertThat(routingIsochronePostResponse.type())
            .contains(RoutingIsochronePostResponse.Type.FEATURE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val routingIsochronePostResponse =
            RoutingIsochronePostResponse.builder()
                .addFeature(
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
                )
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfPoint(listOf(2.3522, 48.8566))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    RoutingIsochronePostResponse.Properties.builder()
                        .areaM2(0.0)
                        .maxCostS(0.0)
                        .mode(RoutingIsochronePostResponse.Properties.Mode.AUTO)
                        .timeSeconds(0.0)
                        .verticesReached(0L)
                        .build()
                )
                .type(RoutingIsochronePostResponse.Type.FEATURE)
                .build()

        val roundtrippedRoutingIsochronePostResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(routingIsochronePostResponse),
                jacksonTypeRef<RoutingIsochronePostResponse>(),
            )

        assertThat(roundtrippedRoutingIsochronePostResponse).isEqualTo(routingIsochronePostResponse)
    }
}
