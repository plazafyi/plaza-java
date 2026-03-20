// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.search

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SearchQueryPostParamsTest {

    @Test
    fun create() {
        SearchQueryPostParams.builder()
            .q("q")
            .cursor("cursor")
            .limit(0L)
            .outputFields("output[fields]")
            .outputInclude("output[include]")
            .outputPrecision(0L)
            .outputSort("output[sort]")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            SearchQueryPostParams.builder()
                .q("q")
                .cursor("cursor")
                .limit(0L)
                .outputFields("output[fields]")
                .outputInclude("output[include]")
                .outputPrecision(0L)
                .outputSort("output[sort]")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("q", "q")
                    .put("cursor", "cursor")
                    .put("limit", "0")
                    .put("output[fields]", "output[fields]")
                    .put("output[include]", "output[include]")
                    .put("output[precision]", "0")
                    .put("output[sort]", "output[sort]")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = SearchQueryPostParams.builder().q("q").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("q", "q").build())
    }
}
