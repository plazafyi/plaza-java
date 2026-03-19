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
            .cursor("cursor")
            .h3("h3")
            .limit(0L)
            .type("type")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ElementQueryParams.builder()
                .bbox("bbox")
                .cursor("cursor")
                .h3("h3")
                .limit(0L)
                .type("type")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("bbox", "bbox")
                    .put("cursor", "cursor")
                    .put("h3", "h3")
                    .put("limit", "0")
                    .put("type", "type")
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
