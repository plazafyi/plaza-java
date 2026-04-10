// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.PointGeometry
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RouteRequestTest {

    @Test
    fun create() {
        val routeRequest =
            RouteRequest.builder()
                .destination(
                    PointGeometry.builder()
                        .addCoordinate(2.2945)
                        .addCoordinate(48.8584)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .origin(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .alternatives(0L)
                .annotations(true)
                .departAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .ev(
                    RouteRequest.Ev.builder()
                        .batteryCapacityWh(75000.0)
                        .addConnectorType("string")
                        .initialChargePct(0.0)
                        .minChargePct(0.0)
                        .minPowerKw(0.0)
                        .build()
                )
                .exclude("exclude")
                .geometries(RouteRequest.Geometries.GEOJSON)
                .mode(RouteRequest.Mode.AUTO)
                .overview(RouteRequest.Overview.FULL)
                .steps(true)
                .trafficModel(RouteRequest.TrafficModel.BEST_GUESS)
                .addWaypoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .build()

        assertThat(routeRequest.destination())
            .isEqualTo(
                PointGeometry.builder()
                    .addCoordinate(2.2945)
                    .addCoordinate(48.8584)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )
        assertThat(routeRequest.origin())
            .isEqualTo(
                PointGeometry.builder()
                    .addCoordinate(2.3522)
                    .addCoordinate(48.8566)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )
        assertThat(routeRequest.alternatives()).contains(0L)
        assertThat(routeRequest.annotations()).contains(true)
        assertThat(routeRequest.departAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(routeRequest.ev())
            .contains(
                RouteRequest.Ev.builder()
                    .batteryCapacityWh(75000.0)
                    .addConnectorType("string")
                    .initialChargePct(0.0)
                    .minChargePct(0.0)
                    .minPowerKw(0.0)
                    .build()
            )
        assertThat(routeRequest.exclude()).contains("exclude")
        assertThat(routeRequest.geometries()).contains(RouteRequest.Geometries.GEOJSON)
        assertThat(routeRequest.mode()).contains(RouteRequest.Mode.AUTO)
        assertThat(routeRequest.overview()).contains(RouteRequest.Overview.FULL)
        assertThat(routeRequest.steps()).contains(true)
        assertThat(routeRequest.trafficModel()).contains(RouteRequest.TrafficModel.BEST_GUESS)
        assertThat(routeRequest.waypoints().getOrNull())
            .containsExactly(
                PointGeometry.builder()
                    .addCoordinate(2.3522)
                    .addCoordinate(48.8566)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val routeRequest =
            RouteRequest.builder()
                .destination(
                    PointGeometry.builder()
                        .addCoordinate(2.2945)
                        .addCoordinate(48.8584)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .origin(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .alternatives(0L)
                .annotations(true)
                .departAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .ev(
                    RouteRequest.Ev.builder()
                        .batteryCapacityWh(75000.0)
                        .addConnectorType("string")
                        .initialChargePct(0.0)
                        .minChargePct(0.0)
                        .minPowerKw(0.0)
                        .build()
                )
                .exclude("exclude")
                .geometries(RouteRequest.Geometries.GEOJSON)
                .mode(RouteRequest.Mode.AUTO)
                .overview(RouteRequest.Overview.FULL)
                .steps(true)
                .trafficModel(RouteRequest.TrafficModel.BEST_GUESS)
                .addWaypoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .build()

        val roundtrippedRouteRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(routeRequest),
                jacksonTypeRef<RouteRequest>(),
            )

        assertThat(roundtrippedRouteRequest).isEqualTo(routeRequest)
    }
}
