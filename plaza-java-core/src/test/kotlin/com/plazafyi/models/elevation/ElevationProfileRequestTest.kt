// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.LineStringGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationProfileRequestTest {

    @Test
    fun create() {
        val elevationProfileRequest =
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

        assertThat(elevationProfileRequest.geometry())
            .isEqualTo(
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val elevationProfileRequest =
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

        val roundtrippedElevationProfileRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(elevationProfileRequest),
                jacksonTypeRef<ElevationProfileRequest>(),
            )

        assertThat(roundtrippedElevationProfileRequest).isEqualTo(elevationProfileRequest)
    }
}
