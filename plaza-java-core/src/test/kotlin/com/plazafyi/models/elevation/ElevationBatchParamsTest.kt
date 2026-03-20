// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationBatchParamsTest {

    @Test
    fun create() {
        ElevationBatchParams.builder()
            .addCoordinate(
                ElevationBatchParams.Coordinate.builder().lat(48.8566).lng(2.3522).build()
            )
            .addCoordinate(
                ElevationBatchParams.Coordinate.builder().lat(45.764).lng(4.8357).build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            ElevationBatchParams.builder()
                .addCoordinate(
                    ElevationBatchParams.Coordinate.builder().lat(48.8566).lng(2.3522).build()
                )
                .addCoordinate(
                    ElevationBatchParams.Coordinate.builder().lat(45.764).lng(4.8357).build()
                )
                .build()

        val body = params._body()

        assertThat(body.coordinates())
            .containsExactly(
                ElevationBatchParams.Coordinate.builder().lat(48.8566).lng(2.3522).build(),
                ElevationBatchParams.Coordinate.builder().lat(45.764).lng(4.8357).build(),
            )
    }
}
