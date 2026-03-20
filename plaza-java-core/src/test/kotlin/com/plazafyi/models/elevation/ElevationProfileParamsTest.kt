// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationProfileParamsTest {

    @Test
    fun create() {
        ElevationProfileParams.builder()
            .elevationProfileRequest(
                ElevationProfileRequest.builder()
                    .coordinates(
                        listOf(
                            ElevationProfileRequest.Coordinate.builder()
                                .lat(48.8566)
                                .lng(2.3522)
                                .build(),
                            ElevationProfileRequest.Coordinate.builder()
                                .lat(48.858)
                                .lng(2.34)
                                .build(),
                            ElevationProfileRequest.Coordinate.builder()
                                .lat(48.8584)
                                .lng(2.2945)
                                .build(),
                        )
                    )
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            ElevationProfileParams.builder()
                .elevationProfileRequest(
                    ElevationProfileRequest.builder()
                        .coordinates(
                            listOf(
                                ElevationProfileRequest.Coordinate.builder()
                                    .lat(48.8566)
                                    .lng(2.3522)
                                    .build(),
                                ElevationProfileRequest.Coordinate.builder()
                                    .lat(48.858)
                                    .lng(2.34)
                                    .build(),
                                ElevationProfileRequest.Coordinate.builder()
                                    .lat(48.8584)
                                    .lng(2.2945)
                                    .build(),
                            )
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                ElevationProfileRequest.builder()
                    .coordinates(
                        listOf(
                            ElevationProfileRequest.Coordinate.builder()
                                .lat(48.8566)
                                .lng(2.3522)
                                .build(),
                            ElevationProfileRequest.Coordinate.builder()
                                .lat(48.858)
                                .lng(2.34)
                                .build(),
                            ElevationProfileRequest.Coordinate.builder()
                                .lat(48.8584)
                                .lng(2.2945)
                                .build(),
                        )
                    )
                    .build()
            )
    }
}
