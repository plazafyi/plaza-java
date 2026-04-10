// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.plazafyi.core.http.QueryParams
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoutingIsochroneParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun queryParams() {
        val params =
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

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("format", "format").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            RoutingIsochroneParams.builder()
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
                        .build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            RoutingIsochroneParams.builder()
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
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                IsochroneRequest.builder()
                    .geometry(
                        PointGeometry.builder()
                            .addCoordinate(2.3522)
                            .addCoordinate(48.8566)
                            .type(PointGeometry.Type.POINT)
                            .build()
                    )
                    .addTime(1L)
                    .build()
            )
    }
}
