// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RouteResultTest {

    @Test
    fun create() {
        val routeResult =
            RouteResult.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    RouteResult.Properties.builder()
                        .distance(0.0)
                        .duration(0.0)
                        .mode("mode")
                        .build()
                )
                .type(RouteResult.Type.FEATURE)
                .build()

        assertThat(routeResult.geometry())
            .isEqualTo(
                GeoJsonGeometry.builder()
                    .coordinatesOfNumber(listOf(0.0))
                    .type(GeoJsonGeometry.Type.POINT)
                    .build()
            )
        assertThat(routeResult.properties())
            .isEqualTo(
                RouteResult.Properties.builder().distance(0.0).duration(0.0).mode("mode").build()
            )
        assertThat(routeResult.type()).isEqualTo(RouteResult.Type.FEATURE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val routeResult =
            RouteResult.builder()
                .geometry(
                    GeoJsonGeometry.builder()
                        .coordinatesOfNumber(listOf(0.0))
                        .type(GeoJsonGeometry.Type.POINT)
                        .build()
                )
                .properties(
                    RouteResult.Properties.builder()
                        .distance(0.0)
                        .duration(0.0)
                        .mode("mode")
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
