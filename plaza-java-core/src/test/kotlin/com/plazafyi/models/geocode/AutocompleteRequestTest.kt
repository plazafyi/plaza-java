// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutocompleteRequestTest {

    @Test
    fun create() {
        val autocompleteRequest =
            AutocompleteRequest.builder()
                .q("221B Bak")
                .countryCode("xx")
                .focus(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .lang("lang")
                .layer("layer")
                .limit(1L)
                .build()

        assertThat(autocompleteRequest.q()).isEqualTo("221B Bak")
        assertThat(autocompleteRequest.countryCode()).contains("xx")
        assertThat(autocompleteRequest.focus())
            .contains(
                PointGeometry.builder()
                    .addCoordinate(2.3522)
                    .addCoordinate(48.8566)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )
        assertThat(autocompleteRequest.lang()).contains("lang")
        assertThat(autocompleteRequest.layer()).contains("layer")
        assertThat(autocompleteRequest.limit()).contains(1L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val autocompleteRequest =
            AutocompleteRequest.builder()
                .q("221B Bak")
                .countryCode("xx")
                .focus(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
                .lang("lang")
                .layer("layer")
                .limit(1L)
                .build()

        val roundtrippedAutocompleteRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(autocompleteRequest),
                jacksonTypeRef<AutocompleteRequest>(),
            )

        assertThat(roundtrippedAutocompleteRequest).isEqualTo(autocompleteRequest)
    }
}
