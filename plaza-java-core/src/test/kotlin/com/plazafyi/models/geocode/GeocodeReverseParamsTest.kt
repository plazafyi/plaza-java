// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GeocodeReverseParamsTest {

    @Test
    fun create() {
        GeocodeReverseParams.builder()
            .format("format")
            .lang("lang")
            .lat(0.0)
            .layer("layer")
            .limit(0L)
            .lng(0.0)
            .near("near")
            .radius(0L)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            GeocodeReverseParams.builder()
                .format("format")
                .lang("lang")
                .lat(0.0)
                .layer("layer")
                .limit(0L)
                .lng(0.0)
                .near("near")
                .radius(0L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("format", "format")
                    .put("lang", "lang")
                    .put("lat", "0.0")
                    .put("layer", "layer")
                    .put("limit", "0")
                    .put("lng", "0.0")
                    .put("near", "near")
                    .put("radius", "0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = GeocodeReverseParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
