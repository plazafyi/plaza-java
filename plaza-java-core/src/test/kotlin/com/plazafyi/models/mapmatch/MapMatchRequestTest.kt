// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.mapmatch

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MapMatchRequestTest {

    @Test
    fun create() {
        val mapMatchRequest =
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

        assertThat(mapMatchRequest.coordinates())
            .containsExactly(
                MapMatchRequest.Coordinate.builder().lat(48.8566).lng(2.3522).build(),
                MapMatchRequest.Coordinate.builder().lat(48.857).lng(2.353).build(),
                MapMatchRequest.Coordinate.builder().lat(48.8575).lng(2.354).build(),
            )
        assertThat(mapMatchRequest.radiuses().getOrNull()).containsExactly(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mapMatchRequest =
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

        val roundtrippedMapMatchRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mapMatchRequest),
                jacksonTypeRef<MapMatchRequest>(),
            )

        assertThat(roundtrippedMapMatchRequest).isEqualTo(mapMatchRequest)
    }
}
