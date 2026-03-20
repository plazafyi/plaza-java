// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elements

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElementNearbyPostParamsTest {

    @Test
    fun create() {
        ElementNearbyPostParams.builder()
            .lat(0.0)
            .limit(0L)
            .lng(0.0)
            .near("near")
            .outputBuffer(0.0)
            .outputCentroid(true)
            .outputFields("output[fields]")
            .outputGeometry(true)
            .outputInclude("output[include]")
            .outputPrecision(0L)
            .outputSimplify(0.0)
            .outputSort("output[sort]")
            .radius(0L)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ElementNearbyPostParams.builder()
                .lat(0.0)
                .limit(0L)
                .lng(0.0)
                .near("near")
                .outputBuffer(0.0)
                .outputCentroid(true)
                .outputFields("output[fields]")
                .outputGeometry(true)
                .outputInclude("output[include]")
                .outputPrecision(0L)
                .outputSimplify(0.0)
                .outputSort("output[sort]")
                .radius(0L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("lat", "0.0")
                    .put("limit", "0")
                    .put("lng", "0.0")
                    .put("near", "near")
                    .put("output[buffer]", "0.0")
                    .put("output[centroid]", "true")
                    .put("output[fields]", "output[fields]")
                    .put("output[geometry]", "true")
                    .put("output[include]", "output[include]")
                    .put("output[precision]", "0")
                    .put("output[simplify]", "0.0")
                    .put("output[sort]", "output[sort]")
                    .put("radius", "0")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ElementNearbyPostParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
