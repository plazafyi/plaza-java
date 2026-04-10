// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.features

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FeatureRetrieveParamsTest {

    @Test
    fun create() {
        FeatureRetrieveParams.builder().type("type").id(0L).build()
    }

    @Test
    fun pathParams() {
        val params = FeatureRetrieveParams.builder().type("type").id(0L).build()

        assertThat(params._pathParam(0)).isEqualTo("type")
        assertThat(params._pathParam(1)).isEqualTo("0")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
