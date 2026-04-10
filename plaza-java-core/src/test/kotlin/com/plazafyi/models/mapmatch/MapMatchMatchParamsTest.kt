// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.mapmatch

import com.plazafyi.models.LineStringGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MapMatchMatchParamsTest {

    @Test
    fun create() {
        MapMatchMatchParams.builder()
            .mapMatchRequest(
                MapMatchRequest.builder()
                    .geometry(
                        LineStringGeometry.builder()
                            .coordinates(
                                listOf(
                                    listOf(2.3522, 48.8566),
                                    listOf(2.353, 48.857),
                                    listOf(2.354, 48.8575),
                                )
                            )
                            .type(LineStringGeometry.Type.LINE_STRING)
                            .build()
                    )
                    .addRadius(0.0)
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            MapMatchMatchParams.builder()
                .mapMatchRequest(
                    MapMatchRequest.builder()
                        .geometry(
                            LineStringGeometry.builder()
                                .coordinates(
                                    listOf(
                                        listOf(2.3522, 48.8566),
                                        listOf(2.353, 48.857),
                                        listOf(2.354, 48.8575),
                                    )
                                )
                                .type(LineStringGeometry.Type.LINE_STRING)
                                .build()
                        )
                        .addRadius(0.0)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                MapMatchRequest.builder()
                    .geometry(
                        LineStringGeometry.builder()
                            .coordinates(
                                listOf(
                                    listOf(2.3522, 48.8566),
                                    listOf(2.353, 48.857),
                                    listOf(2.354, 48.8575),
                                )
                            )
                            .type(LineStringGeometry.Type.LINE_STRING)
                            .build()
                    )
                    .addRadius(0.0)
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MapMatchMatchParams.builder()
                .mapMatchRequest(
                    MapMatchRequest.builder()
                        .geometry(
                            LineStringGeometry.builder()
                                .coordinates(
                                    listOf(
                                        listOf(2.3522, 48.8566),
                                        listOf(2.353, 48.857),
                                        listOf(2.354, 48.8575),
                                    )
                                )
                                .type(LineStringGeometry.Type.LINE_STRING)
                                .build()
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                MapMatchRequest.builder()
                    .geometry(
                        LineStringGeometry.builder()
                            .coordinates(
                                listOf(
                                    listOf(2.3522, 48.8566),
                                    listOf(2.353, 48.857),
                                    listOf(2.354, 48.8575),
                                )
                            )
                            .type(LineStringGeometry.Type.LINE_STRING)
                            .build()
                    )
                    .build()
            )
    }
}
