// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoutingRouteParamsTest {

    @Test
    fun create() {
        RoutingRouteParams.builder()
            .routeRequest(
                RouteRequest.builder()
                    .destination(
                        RouteRequest.Destination.builder().lat(48.8584).lng(2.2945).build()
                    )
                    .origin(RouteRequest.Origin.builder().lat(48.8566).lng(2.3522).build())
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
                    .addWaypoint(RouteRequest.Waypoint.builder().lat(48.8566).lng(2.3522).build())
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            RoutingRouteParams.builder()
                .routeRequest(
                    RouteRequest.builder()
                        .destination(
                            RouteRequest.Destination.builder().lat(48.8584).lng(2.2945).build()
                        )
                        .origin(RouteRequest.Origin.builder().lat(48.8566).lng(2.3522).build())
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
                            RouteRequest.Waypoint.builder().lat(48.8566).lng(2.3522).build()
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                RouteRequest.builder()
                    .destination(
                        RouteRequest.Destination.builder().lat(48.8584).lng(2.2945).build()
                    )
                    .origin(RouteRequest.Origin.builder().lat(48.8566).lng(2.3522).build())
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
                    .addWaypoint(RouteRequest.Waypoint.builder().lat(48.8566).lng(2.3522).build())
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            RoutingRouteParams.builder()
                .routeRequest(
                    RouteRequest.builder()
                        .destination(
                            RouteRequest.Destination.builder().lat(48.8584).lng(2.2945).build()
                        )
                        .origin(RouteRequest.Origin.builder().lat(48.8566).lng(2.3522).build())
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                RouteRequest.builder()
                    .destination(
                        RouteRequest.Destination.builder().lat(48.8584).lng(2.2945).build()
                    )
                    .origin(RouteRequest.Origin.builder().lat(48.8566).lng(2.3522).build())
                    .build()
            )
    }
}
