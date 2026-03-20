// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.query

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OverpassQueryTest {

    @Test
    fun create() {
        val overpassQuery =
            OverpassQuery.builder()
                .data("[out:json];node[amenity=cafe](around:500,48.8566,2.3522);out body;")
                .build()

        assertThat(overpassQuery.data())
            .isEqualTo("[out:json];node[amenity=cafe](around:500,48.8566,2.3522);out body;")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val overpassQuery =
            OverpassQuery.builder()
                .data("[out:json];node[amenity=cafe](around:500,48.8566,2.3522);out body;")
                .build()

        val roundtrippedOverpassQuery =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(overpassQuery),
                jacksonTypeRef<OverpassQuery>(),
            )

        assertThat(roundtrippedOverpassQuery).isEqualTo(overpassQuery)
    }
}
