// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationProfileRequestTest {

    @Test
    fun create() {
        val elevationProfileRequest =
            ElevationProfileRequest.builder()
                .coordinates(
                    listOf(
                        ElevationProfileRequest.Coordinate.builder()
                            .lat(48.8566)
                            .lng(2.3522)
                            .build(),
                        ElevationProfileRequest.Coordinate.builder().lat(48.858).lng(2.34).build(),
                        ElevationProfileRequest.Coordinate.builder()
                            .lat(48.8584)
                            .lng(2.2945)
                            .build(),
                    )
                )
                .build()

        assertThat(elevationProfileRequest.coordinates())
            .containsExactly(
                ElevationProfileRequest.Coordinate.builder().lat(48.8566).lng(2.3522).build(),
                ElevationProfileRequest.Coordinate.builder().lat(48.858).lng(2.34).build(),
                ElevationProfileRequest.Coordinate.builder().lat(48.8584).lng(2.2945).build(),
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val elevationProfileRequest =
            ElevationProfileRequest.builder()
                .coordinates(
                    listOf(
                        ElevationProfileRequest.Coordinate.builder()
                            .lat(48.8566)
                            .lng(2.3522)
                            .build(),
                        ElevationProfileRequest.Coordinate.builder().lat(48.858).lng(2.34).build(),
                        ElevationProfileRequest.Coordinate.builder()
                            .lat(48.8584)
                            .lng(2.2945)
                            .build(),
                    )
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
