// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationBatchParamsTest {

    @Test
    fun create() {
        ElevationBatchParams.builder()
            .format("format")
            .addCoordinate(
                ElevationBatchParams.Coordinate.builder().lat(48.8566).lng(2.3522).build()
            )
            .addCoordinate(
                ElevationBatchParams.Coordinate.builder().lat(45.764).lng(4.8357).build()
            )
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ElevationBatchParams.builder()
                .format("format")
                .addCoordinate(
                    ElevationBatchParams.Coordinate.builder().lat(48.8566).lng(2.3522).build()
                )
                .addCoordinate(
                    ElevationBatchParams.Coordinate.builder().lat(45.764).lng(4.8357).build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("format", "format").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ElevationBatchParams.builder()
                .addCoordinate(
                    ElevationBatchParams.Coordinate.builder().lat(48.8566).lng(2.3522).build()
                )
                .addCoordinate(
                    ElevationBatchParams.Coordinate.builder().lat(45.764).lng(4.8357).build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun body() {
        val params =
            ElevationBatchParams.builder()
                .format("format")
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

    @Test
    fun bodyWithoutOptionalFields() {
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
