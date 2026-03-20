// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoutingIsochroneParamsTest {

    @Test
    fun create() {
        RoutingIsochroneParams.builder()
            .lat(0.0)
            .lng(0.0)
            .time(0.0)
            .format("format")
            .mode("mode")
            .outputFields("output[fields]")
            .outputGeometry(true)
            .outputInclude("output[include]")
            .outputPrecision(0L)
            .outputSimplify(0.0)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            RoutingIsochroneParams.builder()
                .lat(0.0)
                .lng(0.0)
                .time(0.0)
                .format("format")
                .mode("mode")
                .outputFields("output[fields]")
                .outputGeometry(true)
                .outputInclude("output[include]")
                .outputPrecision(0L)
                .outputSimplify(0.0)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("lat", "0.0")
                    .put("lng", "0.0")
                    .put("time", "0.0")
                    .put("format", "format")
                    .put("mode", "mode")
                    .put("output[fields]", "output[fields]")
                    .put("output[geometry]", "true")
                    .put("output[include]", "output[include]")
                    .put("output[precision]", "0")
                    .put("output[simplify]", "0.0")
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
