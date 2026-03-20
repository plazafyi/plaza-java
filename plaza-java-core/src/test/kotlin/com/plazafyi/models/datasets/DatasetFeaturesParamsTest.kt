// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.datasets

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DatasetFeaturesParamsTest {

    @Test
    fun create() {
        DatasetFeaturesParams.builder()
            .id("id")
            .cursor("cursor")
            .format("format")
            .limit(0L)
            .outputBuffer(0.0)
            .outputCentroid(true)
            .outputFields("output[fields]")
            .outputGeometry(true)
            .outputInclude("output[include]")
            .outputPrecision(0L)
            .outputSimplify(0.0)
            .outputSort("output[sort]")
            .build()
    }

    @Test
    fun pathParams() {
        val params = DatasetFeaturesParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            DatasetFeaturesParams.builder()
                .id("id")
                .cursor("cursor")
                .format("format")
                .limit(0L)
                .outputBuffer(0.0)
                .outputCentroid(true)
                .outputFields("output[fields]")
                .outputGeometry(true)
                .outputInclude("output[include]")
                .outputPrecision(0L)
                .outputSimplify(0.0)
                .outputSort("output[sort]")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("cursor", "cursor")
                    .put("format", "format")
                    .put("limit", "0")
                    .put("output[buffer]", "0.0")
                    .put("output[centroid]", "true")
                    .put("output[fields]", "output[fields]")
                    .put("output[geometry]", "true")
                    .put("output[include]", "output[include]")
                    .put("output[precision]", "0")
                    .put("output[simplify]", "0.0")
                    .put("output[sort]", "output[sort]")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = DatasetFeaturesParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
