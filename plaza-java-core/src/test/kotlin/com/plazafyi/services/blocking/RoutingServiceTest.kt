// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.GeoJsonGeometry
import com.plazafyi.models.routing.MatrixRequest
import com.plazafyi.models.routing.RouteRequest
import com.plazafyi.models.routing.RoutingIsochroneParams
import com.plazafyi.models.routing.RoutingNearestParams
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

        val geoJsonFeature =
            routingService.isochrone(
                RoutingIsochroneParams.builder().lat(0.0).lng(0.0).time(0.0).mode("mode").build()
            )

        geoJsonFeature.validate()
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
                    .destinations(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .origins(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
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
                RoutingNearestParams.builder().lat(0.0).lng(0.0).radius(0L).build()
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
                RouteRequest.builder()
                    .destination(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .origin(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .mode(RouteRequest.Mode.AUTO)
                    .build()
            )

        routeResult.validate()
    }
}
