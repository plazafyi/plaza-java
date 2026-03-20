// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elements

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElementQueryParamsTest {

    @Test
    fun create() {
        ElementQueryParams.builder()
            .bbox("bbox")
            .contains("contains")
            .crosses("crosses")
            .cursor("cursor")
            .h3("h3")
            .intersects("intersects")
            .limit(0L)
            .near("near")
            .outputBuffer(0.0)
            .outputCentroid(true)
            .outputFields("output[fields]")
            .outputGeometry(true)
            .outputInclude("output[include]")
            .outputPrecision(0L)
            .outputSimplify(0.0)
            .outputSort("output[sort]")
            .radius(0.0)
            .touches("touches")
            .type("type")
            .within("within")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ElementQueryParams.builder()
                .bbox("bbox")
                .contains("contains")
                .crosses("crosses")
                .cursor("cursor")
                .h3("h3")
                .intersects("intersects")
                .limit(0L)
                .near("near")
                .outputBuffer(0.0)
                .outputCentroid(true)
                .outputFields("output[fields]")
                .outputGeometry(true)
                .outputInclude("output[include]")
                .outputPrecision(0L)
                .outputSimplify(0.0)
                .outputSort("output[sort]")
                .radius(0.0)
                .touches("touches")
                .type("type")
                .within("within")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("bbox", "bbox")
                    .put("contains", "contains")
                    .put("crosses", "crosses")
                    .put("cursor", "cursor")
                    .put("h3", "h3")
                    .put("intersects", "intersects")
                    .put("limit", "0")
                    .put("near", "near")
                    .put("output[buffer]", "0.0")
                    .put("output[centroid]", "true")
                    .put("output[fields]", "output[fields]")
                    .put("output[geometry]", "true")
                    .put("output[include]", "output[include]")
                    .put("output[precision]", "0")
                    .put("output[simplify]", "0.0")
                    .put("output[sort]", "output[sort]")
                    .put("radius", "0.0")
                    .put("touches", "touches")
                    .put("type", "type")
                    .put("within", "within")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ElementQueryParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
