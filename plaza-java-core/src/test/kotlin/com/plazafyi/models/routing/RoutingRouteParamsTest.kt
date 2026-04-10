// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.plazafyi.core.http.QueryParams
import com.plazafyi.models.PointGeometry
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoutingRouteParamsTest {

    @Test
    fun create() {
        RoutingRouteParams.builder()
            .format("format")
            .routeRequest(
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
            )
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            RoutingRouteParams.builder()
                .format("format")
                .routeRequest(
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
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("format", "format").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            RoutingRouteParams.builder()
                .routeRequest(
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
                        .build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun body() {
        val params =
            RoutingRouteParams.builder()
                .format("format")
                .routeRequest(
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
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            RoutingRouteParams.builder()
                .routeRequest(
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
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
                    .build()
            )
    }
}
