// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.mapmatch

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.LineStringGeometry
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MapMatchRequestTest {

    @Test
    fun create() {
        val mapMatchRequest =
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

        assertThat(mapMatchRequest.geometry())
            .isEqualTo(
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
        assertThat(mapMatchRequest.radiuses().getOrNull()).containsExactly(0.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mapMatchRequest =
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

        val roundtrippedMapMatchRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mapMatchRequest),
                jacksonTypeRef<MapMatchRequest>(),
            )

        assertThat(roundtrippedMapMatchRequest).isEqualTo(mapMatchRequest)
    }
}
