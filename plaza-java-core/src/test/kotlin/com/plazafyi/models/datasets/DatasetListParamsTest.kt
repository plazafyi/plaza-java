// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.datasets

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DatasetListParamsTest {

    @Test
    fun create() {
        DatasetListParams.builder().scope("scope").build()
    }

    @Test
    fun queryParams() {
        val params = DatasetListParams.builder().scope("scope").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("scope", "scope").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = DatasetListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
