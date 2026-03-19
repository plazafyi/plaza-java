// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RouteRequestTest {

    @Test
    fun create() {
        val routeRequest =
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

        assertThat(routeRequest.destination())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(routeRequest.origin())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(routeRequest.mode()).contains(RouteRequest.Mode.AUTO)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val routeRequest =
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

        val roundtrippedRouteRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(routeRequest),
                jacksonTypeRef<RouteRequest>(),
            )

        assertThat(roundtrippedRouteRequest).isEqualTo(routeRequest)
    }
}
