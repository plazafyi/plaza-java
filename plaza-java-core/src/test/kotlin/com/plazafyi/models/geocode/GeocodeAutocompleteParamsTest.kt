// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.plazafyi.core.http.QueryParams
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GeocodeAutocompleteParamsTest {

    @Test
    fun create() {
        GeocodeAutocompleteParams.builder()
            .format("format")
            .autocompleteRequest(
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
            )
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            GeocodeAutocompleteParams.builder()
                .format("format")
                .autocompleteRequest(
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
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("format", "format").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            GeocodeAutocompleteParams.builder()
                .autocompleteRequest(AutocompleteRequest.builder().q("221B Bak").build())
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun body() {
        val params =
            GeocodeAutocompleteParams.builder()
                .format("format")
                .autocompleteRequest(
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
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            GeocodeAutocompleteParams.builder()
                .autocompleteRequest(AutocompleteRequest.builder().q("221B Bak").build())
                .build()

        val body = params._body()

        assertThat(body).isEqualTo(AutocompleteRequest.builder().q("221B Bak").build())
    }
}
