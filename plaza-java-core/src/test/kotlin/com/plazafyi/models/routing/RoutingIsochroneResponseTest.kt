// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonFeature
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoutingIsochroneResponseTest {

    @Test
    fun create() {
        val routingIsochroneResponse =
            RoutingIsochroneResponse.builder()
                .addFeature(
                    GeoJsonFeature.builder()
                        .pointGeometry(listOf(2.3522, 48.8566))
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
                .type(RoutingIsochroneResponse.Type.FEATURE_COLLECTION)
                .build()

        assertThat(routingIsochroneResponse.features())
            .containsExactly(
                GeoJsonFeature.builder()
                    .pointGeometry(listOf(2.3522, 48.8566))
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
        assertThat(routingIsochroneResponse.type())
            .isEqualTo(RoutingIsochroneResponse.Type.FEATURE_COLLECTION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val routingIsochroneResponse =
            RoutingIsochroneResponse.builder()
                .addFeature(
                    GeoJsonFeature.builder()
                        .pointGeometry(listOf(2.3522, 48.8566))
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
                .type(RoutingIsochroneResponse.Type.FEATURE_COLLECTION)
                .build()

        val roundtrippedRoutingIsochroneResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(routingIsochroneResponse),
                jacksonTypeRef<RoutingIsochroneResponse>(),
            )

        assertThat(roundtrippedRoutingIsochroneResponse).isEqualTo(routingIsochroneResponse)
    }
}
