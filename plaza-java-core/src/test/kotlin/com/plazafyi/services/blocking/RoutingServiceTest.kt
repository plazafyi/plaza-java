// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.PointGeometry
import com.plazafyi.models.routing.IsochroneRequest
import com.plazafyi.models.routing.MatrixRequest
import com.plazafyi.models.routing.NearestRequest
import com.plazafyi.models.routing.RouteRequest
import com.plazafyi.models.routing.RoutingIsochroneParams
import com.plazafyi.models.routing.RoutingRouteParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class RoutingServiceTest {

    @Test
    fun isochrone() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingService = client.routing()

        val response =
            routingService.isochrone(
                RoutingIsochroneParams.builder()
                    .format("format")
                    .isochroneRequest(
                        IsochroneRequest.builder()
                            .geometry(
                                PointGeometry.builder()
                                    .addCoordinate(2.3522)
                                    .addCoordinate(48.8566)
                                    .type(PointGeometry.Type.POINT)
                                    .build()
                            )
                            .addTime(1L)
                            .mode(IsochroneRequest.Mode.AUTO)
                            .build()
                    )
                    .build()
            )

        response.validate()
    }

    @Test
    fun matrix() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingService = client.routing()

        val matrixResult =
            routingService.matrix(
                MatrixRequest.builder()
                    .addDestination(
                        PointGeometry.builder()
                            .addCoordinate(2.2945)
                            .addCoordinate(48.8584)
                            .type(PointGeometry.Type.POINT)
                            .build()
                    )
                    .addOrigin(
                        PointGeometry.builder()
                            .addCoordinate(2.3522)
                            .addCoordinate(48.8566)
                            .type(PointGeometry.Type.POINT)
                            .build()
                    )
                    .addOrigin(
                        PointGeometry.builder()
                            .addCoordinate(2.3376)
                            .addCoordinate(48.8606)
                            .type(PointGeometry.Type.POINT)
                            .build()
                    )
                    .annotations("annotations")
                    .fallbackSpeed(1.0)
                    .mode(MatrixRequest.Mode.AUTO)
                    .build()
            )

        matrixResult.validate()
    }

    @Test
    fun nearest() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingService = client.routing()

        val nearestResult =
            routingService.nearest(
                NearestRequest.builder()
                    .geometry(
                        PointGeometry.builder()
                            .addCoordinate(2.3522)
                            .addCoordinate(48.8566)
                            .type(PointGeometry.Type.POINT)
                            .build()
                    )
                    .radius(1.0)
                    .build()
            )

        nearestResult.validate()
    }

    @Test
    fun route() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingService = client.routing()

        val routeResult =
            routingService.route(
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
            )

        routeResult.validate()
    }
}
