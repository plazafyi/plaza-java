// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.mapmatch

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MapMatchMatchParamsTest {

    @Test
    fun create() {
        MapMatchMatchParams.builder()
            .mapMatchRequest(
                MapMatchRequest.builder()
                    .coordinates(
                        listOf(
                            MapMatchRequest.Coordinate.builder().lat(48.8566).lng(2.3522).build(),
                            MapMatchRequest.Coordinate.builder().lat(48.857).lng(2.353).build(),
                            MapMatchRequest.Coordinate.builder().lat(48.8575).lng(2.354).build(),
                        )
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
                        .coordinates(
                            listOf(
                                MapMatchRequest.Coordinate.builder()
                                    .lat(48.8566)
                                    .lng(2.3522)
                                    .build(),
                                MapMatchRequest.Coordinate.builder().lat(48.857).lng(2.353).build(),
                                MapMatchRequest.Coordinate.builder().lat(48.8575).lng(2.354).build(),
                            )
                        )
                        .addRadius(0.0)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                MapMatchRequest.builder()
                    .coordinates(
                        listOf(
                            MapMatchRequest.Coordinate.builder().lat(48.8566).lng(2.3522).build(),
                            MapMatchRequest.Coordinate.builder().lat(48.857).lng(2.353).build(),
                            MapMatchRequest.Coordinate.builder().lat(48.8575).lng(2.354).build(),
                        )
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
                        .coordinates(
                            listOf(
                                MapMatchRequest.Coordinate.builder()
                                    .lat(48.8566)
                                    .lng(2.3522)
                                    .build(),
                                MapMatchRequest.Coordinate.builder().lat(48.857).lng(2.353).build(),
                                MapMatchRequest.Coordinate.builder().lat(48.8575).lng(2.354).build(),
                            )
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                MapMatchRequest.builder()
                    .coordinates(
                        listOf(
                            MapMatchRequest.Coordinate.builder().lat(48.8566).lng(2.3522).build(),
                            MapMatchRequest.Coordinate.builder().lat(48.857).lng(2.353).build(),
                            MapMatchRequest.Coordinate.builder().lat(48.8575).lng(2.354).build(),
                        )
                    )
                    .build()
            )
    }
}
