// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GeocodeReverseParamsTest {

    @Test
    fun create() {
        GeocodeReverseParams.builder()
            .lat(0.0)
            .lng(0.0)
            .lang("lang")
            .layer("layer")
            .limit(0L)
            .radius(0L)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            GeocodeReverseParams.builder()
                .lat(0.0)
                .lng(0.0)
                .lang("lang")
                .layer("layer")
                .limit(0L)
                .radius(0L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("lat", "0.0")
                    .put("lng", "0.0")
                    .put("lang", "lang")
                    .put("layer", "layer")
                    .put("limit", "0")
                    .put("radius", "0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = GeocodeReverseParams.builder().lat(0.0).lng(0.0).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("lat", "0.0").put("lng", "0.0").build())
    }
}
