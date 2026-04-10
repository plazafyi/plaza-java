// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.Geometry
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RouteResultTest {

    @Test
    fun create() {
        val routeResult =
            RouteResult.builder()
                .pointGeometry(listOf(2.3522, 48.8566))
                .properties(
                    RouteResult.Properties.builder()
                        .distanceM(4523.7)
                        .durationS(847.2)
                        .annotations(
                            RouteResult.Properties.Annotations.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .addChargeProfile(listOf(0.0))
                        .addChargingStop(
                            RouteResult.Properties.ChargingStop.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .addEdge(
                            RouteResult.Properties.Edge.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .energyUsedWh(0.0)
                        .build()
                )
                .type(RouteResult.Type.FEATURE)
                .build()

        assertThat(routeResult.geometry())
            .isEqualTo(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(routeResult.properties())
            .isEqualTo(
                RouteResult.Properties.builder()
                    .distanceM(4523.7)
                    .durationS(847.2)
                    .annotations(
                        RouteResult.Properties.Annotations.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .addChargeProfile(listOf(0.0))
                    .addChargingStop(
                        RouteResult.Properties.ChargingStop.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .addEdge(
                        RouteResult.Properties.Edge.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .energyUsedWh(0.0)
                    .build()
            )
        assertThat(routeResult.type()).isEqualTo(RouteResult.Type.FEATURE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val routeResult =
            RouteResult.builder()
                .pointGeometry(listOf(2.3522, 48.8566))
                .properties(
                    RouteResult.Properties.builder()
                        .distanceM(4523.7)
                        .durationS(847.2)
                        .annotations(
                            RouteResult.Properties.Annotations.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .addChargeProfile(listOf(0.0))
                        .addChargingStop(
                            RouteResult.Properties.ChargingStop.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .addEdge(
                            RouteResult.Properties.Edge.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .energyUsedWh(0.0)
                        .build()
                )
                .type(RouteResult.Type.FEATURE)
                .build()

        val roundtrippedRouteResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(routeResult),
                jacksonTypeRef<RouteResult>(),
            )

        assertThat(roundtrippedRouteResult).isEqualTo(routeResult)
    }
}
