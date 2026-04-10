// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MultiPointGeometryTest {

    @Test
    fun create() {
        val multiPointGeometry =
            MultiPointGeometry.builder()
                .addCoordinate(listOf(0.0, 0.0))
                .type(MultiPointGeometry.Type.MULTI_POINT)
                .build()

        assertThat(multiPointGeometry.coordinates()).containsExactly(listOf(0.0, 0.0))
        assertThat(multiPointGeometry.type()).isEqualTo(MultiPointGeometry.Type.MULTI_POINT)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val multiPointGeometry =
            MultiPointGeometry.builder()
                .addCoordinate(listOf(0.0, 0.0))
                .type(MultiPointGeometry.Type.MULTI_POINT)
                .build()

        val roundtrippedMultiPointGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(multiPointGeometry),
                jacksonTypeRef<MultiPointGeometry>(),
            )

        assertThat(roundtrippedMultiPointGeometry).isEqualTo(multiPointGeometry)
    }
}
