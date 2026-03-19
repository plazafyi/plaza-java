// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.query

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class QueryOverpassParamsTest {

    @Test
    fun create() {
        QueryOverpassParams.builder()
            .overpassQuery(OverpassQuery.builder().data("data").build())
            .build()
    }

    @Test
    fun body() {
        val params =
            QueryOverpassParams.builder()
                .overpassQuery(OverpassQuery.builder().data("data").build())
                .build()

        val body = params._body()

        assertThat(body).isEqualTo(OverpassQuery.builder().data("data").build())
    }
}
