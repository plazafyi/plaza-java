// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.tiles

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TileGetParamsTest {

    @Test
    fun create() {
        TileGetParams.builder().z(0L).x(0L).y(0L).build()
    }

    @Test
    fun pathParams() {
        val params = TileGetParams.builder().z(0L).x(0L).y(0L).build()

        assertThat(params._pathParam(0)).isEqualTo("0")
        assertThat(params._pathParam(1)).isEqualTo("0")
        assertThat(params._pathParam(2)).isEqualTo("0")
        // out-of-bound path param
        assertThat(params._pathParam(3)).isEqualTo("")
    }
}
