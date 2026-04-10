// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.plazafyi.models.LineStringGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationProfileParamsTest {

    @Test
    fun create() {
        ElevationProfileParams.builder()
            .elevationProfileRequest(
                ElevationProfileRequest.builder()
                    .geometry(
                        LineStringGeometry.builder()
                            .coordinates(
                                listOf(
                                    listOf(2.3522, 48.8566),
                                    listOf(2.34, 48.858),
                                    listOf(2.2945, 48.8584),
                                )
                            )
                            .type(LineStringGeometry.Type.LINE_STRING)
                            .build()
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
                        .geometry(
                            LineStringGeometry.builder()
                                .coordinates(
                                    listOf(
                                        listOf(2.3522, 48.8566),
                                        listOf(2.34, 48.858),
                                        listOf(2.2945, 48.8584),
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
                ElevationProfileRequest.builder()
                    .geometry(
                        LineStringGeometry.builder()
                            .coordinates(
                                listOf(
                                    listOf(2.3522, 48.8566),
                                    listOf(2.34, 48.858),
                                    listOf(2.2945, 48.8584),
                                )
                            )
                            .type(LineStringGeometry.Type.LINE_STRING)
                            .build()
                    )
                    .build()
            )
    }
}
