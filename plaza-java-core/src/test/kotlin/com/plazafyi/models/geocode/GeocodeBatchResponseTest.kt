// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GeocodeBatchResponseTest {

    @Test
    fun create() {
        val geocodeBatchResponse = GeocodeBatchResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val geocodeBatchResponse = GeocodeBatchResponse.builder().build()

        val roundtrippedGeocodeBatchResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geocodeBatchResponse),
                jacksonTypeRef<GeocodeBatchResponse>(),
            )

        assertThat(roundtrippedGeocodeBatchResponse).isEqualTo(geocodeBatchResponse)
    }
}
