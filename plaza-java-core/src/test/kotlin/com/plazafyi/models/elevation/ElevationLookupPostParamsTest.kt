// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationLookupPostParamsTest {

    @Test
    fun create() {
        ElevationLookupPostParams.builder()
            .lat(0.0)
            .lng(0.0)
            .locations("locations")
            .outputFields("output[fields]")
            .outputInclude("output[include]")
            .outputPrecision(0L)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ElevationLookupPostParams.builder()
                .lat(0.0)
                .lng(0.0)
                .locations("locations")
                .outputFields("output[fields]")
                .outputInclude("output[include]")
                .outputPrecision(0L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("lat", "0.0")
                    .put("lng", "0.0")
                    .put("locations", "locations")
                    .put("output[fields]", "output[fields]")
                    .put("output[include]", "output[include]")
                    .put("output[precision]", "0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ElevationLookupPostParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
