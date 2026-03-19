// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoutingIsochroneParamsTest {

    @Test
    fun create() {
        RoutingIsochroneParams.builder().lat(0.0).lng(0.0).time(0.0).mode("mode").build()
    }

    @Test
    fun queryParams() {
        val params =
            RoutingIsochroneParams.builder().lat(0.0).lng(0.0).time(0.0).mode("mode").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("lat", "0.0")
                    .put("lng", "0.0")
                    .put("time", "0.0")
                    .put("mode", "mode")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = RoutingIsochroneParams.builder().lat(0.0).lng(0.0).time(0.0).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder().put("lat", "0.0").put("lng", "0.0").put("time", "0.0").build()
            )
    }
}
