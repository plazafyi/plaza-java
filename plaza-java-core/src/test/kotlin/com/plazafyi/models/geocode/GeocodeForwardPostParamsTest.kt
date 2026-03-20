// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GeocodeForwardPostParamsTest {

    @Test
    fun create() {
        GeocodeForwardPostParams.builder()
            .q("q")
            .bbox("bbox")
            .countryCode("country_code")
            .format("format")
            .lang("lang")
            .lat(0.0)
            .layer("layer")
            .limit(0L)
            .lng(0.0)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            GeocodeForwardPostParams.builder()
                .q("q")
                .bbox("bbox")
                .countryCode("country_code")
                .format("format")
                .lang("lang")
                .lat(0.0)
                .layer("layer")
                .limit(0L)
                .lng(0.0)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("q", "q")
                    .put("bbox", "bbox")
                    .put("country_code", "country_code")
                    .put("format", "format")
                    .put("lang", "lang")
                    .put("lat", "0.0")
                    .put("layer", "layer")
                    .put("limit", "0")
                    .put("lng", "0.0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = GeocodeForwardPostParams.builder().q("q").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("q", "q").build())
    }
}
