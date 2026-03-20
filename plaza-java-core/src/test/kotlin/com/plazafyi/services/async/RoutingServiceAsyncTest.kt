// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.routing.MatrixRequest
import com.plazafyi.models.routing.RouteRequest
import com.plazafyi.models.routing.RoutingIsochroneParams
import com.plazafyi.models.routing.RoutingIsochronePostParams
import com.plazafyi.models.routing.RoutingNearestParams
import com.plazafyi.models.routing.RoutingNearestPostParams
import com.plazafyi.models.routing.RoutingRouteParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class RoutingServiceAsyncTest {

    @Test
    fun isochrone() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingServiceAsync = client.routing()

        val responseFuture =
            routingServiceAsync.isochrone(
                RoutingIsochroneParams.builder()
                    .lat(0.0)
                    .lng(0.0)
                    .time(0.0)
                    .format("format")
                    .mode("mode")
                    .outputFields("output[fields]")
                    .outputGeometry(true)
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .outputSimplify(0.0)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun isochronePost() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingServiceAsync = client.routing()

        val responseFuture =
            routingServiceAsync.isochronePost(
                RoutingIsochronePostParams.builder()
                    .lat(0.0)
                    .lng(0.0)
                    .time(0.0)
                    .format("format")
                    .mode("mode")
                    .outputFields("output[fields]")
                    .outputGeometry(true)
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .outputSimplify(0.0)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun matrix() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingServiceAsync = client.routing()

        val matrixResultFuture =
            routingServiceAsync.matrix(
                MatrixRequest.builder()
                    .addDestination(
                        MatrixRequest.Destination.builder().lat(48.8584).lng(2.2945).build()
                    )
                    .addOrigin(MatrixRequest.Origin.builder().lat(48.8566).lng(2.3522).build())
                    .addOrigin(MatrixRequest.Origin.builder().lat(48.8606).lng(2.3376).build())
                    .annotations("annotations")
                    .fallbackSpeed(1.0)
                    .mode(MatrixRequest.Mode.AUTO)
                    .build()
            )

        val matrixResult = matrixResultFuture.get()
        matrixResult.validate()
    }

    @Test
    fun nearest() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingServiceAsync = client.routing()

        val nearestResultFuture =
            routingServiceAsync.nearest(
                RoutingNearestParams.builder()
                    .lat(0.0)
                    .lng(0.0)
                    .outputFields("output[fields]")
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .radius(0L)
                    .build()
            )

        val nearestResult = nearestResultFuture.get()
        nearestResult.validate()
    }

    @Test
    fun nearestPost() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingServiceAsync = client.routing()

        val nearestResultFuture =
            routingServiceAsync.nearestPost(
                RoutingNearestPostParams.builder()
                    .lat(0.0)
                    .lng(0.0)
                    .outputFields("output[fields]")
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .radius(0L)
                    .build()
            )

        val nearestResult = nearestResultFuture.get()
        nearestResult.validate()
    }

    @Test
    fun route() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingServiceAsync = client.routing()

        val routeResultFuture =
            routingServiceAsync.route(
                RoutingRouteParams.builder()
                    .format("format")
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
            )

        val routeResult = routeResultFuture.get()
        routeResult.validate()
    }
}
