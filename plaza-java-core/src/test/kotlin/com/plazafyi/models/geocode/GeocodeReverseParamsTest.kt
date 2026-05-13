// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.plazafyi.core.http.QueryParams
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GeocodeReverseParamsTest {

    @Test
    fun create() {
        GeocodeReverseParams.builder()
            .format("format")
            .geocodeReverseRequest(
                GeocodeReverseRequest.builder()
                    .geometry(
                        PointGeometry.builder()
                            .addCoordinate(2.3522)
                            .addCoordinate(48.8566)
                            .type(PointGeometry.Type.POINT)
                            .build()
                    )
                    .lang("lang")
                    .limit(1L)
                    .radius(1.0)
                    .build()
            )
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            GeocodeReverseParams.builder()
                .format("format")
                .geocodeReverseRequest(
                    GeocodeReverseRequest.builder()
                        .geometry(
                            PointGeometry.builder()
                                .addCoordinate(2.3522)
                                .addCoordinate(48.8566)
                                .type(PointGeometry.Type.POINT)
                                .build()
                        )
                        .lang("lang")
                        .limit(1L)
                        .radius(1.0)
                        .build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("format", "format").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            GeocodeReverseParams.builder()
                .geocodeReverseRequest(
                    GeocodeReverseRequest.builder()
                        .geometry(
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
            GeocodeReverseParams.builder()
                .format("format")
                .geocodeReverseRequest(
                    GeocodeReverseRequest.builder()
                        .geometry(
                            PointGeometry.builder()
                                .addCoordinate(2.3522)
                                .addCoordinate(48.8566)
                                .type(PointGeometry.Type.POINT)
                                .build()
                        )
                        .lang("lang")
                        .limit(1L)
                        .radius(1.0)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                GeocodeReverseRequest.builder()
                    .geometry(
                        PointGeometry.builder()
                            .addCoordinate(2.3522)
                            .addCoordinate(48.8566)
                            .type(PointGeometry.Type.POINT)
                            .build()
                    )
                    .lang("lang")
                    .limit(1L)
                    .radius(1.0)
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            GeocodeReverseParams.builder()
                .geocodeReverseRequest(
                    GeocodeReverseRequest.builder()
                        .geometry(
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
                GeocodeReverseRequest.builder()
                    .geometry(
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
