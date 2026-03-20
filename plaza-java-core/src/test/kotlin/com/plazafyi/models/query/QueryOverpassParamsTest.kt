// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.query

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class QueryOverpassParamsTest {

    @Test
    fun create() {
        QueryOverpassParams.builder()
            .format("format")
            .overpassQuery(
                OverpassQuery.builder()
                    .data("[out:json];node[amenity=cafe](around:500,48.8566,2.3522);out body;")
                    .build()
            )
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            QueryOverpassParams.builder()
                .format("format")
                .overpassQuery(
                    OverpassQuery.builder()
                        .data("[out:json];node[amenity=cafe](around:500,48.8566,2.3522);out body;")
                        .build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("format", "format").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            QueryOverpassParams.builder()
                .overpassQuery(
                    OverpassQuery.builder()
                        .data("[out:json];node[amenity=cafe](around:500,48.8566,2.3522);out body;")
                        .build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun body() {
        val params =
            QueryOverpassParams.builder()
                .format("format")
                .overpassQuery(
                    OverpassQuery.builder()
                        .data("[out:json];node[amenity=cafe](around:500,48.8566,2.3522);out body;")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                OverpassQuery.builder()
                    .data("[out:json];node[amenity=cafe](around:500,48.8566,2.3522);out body;")
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            QueryOverpassParams.builder()
                .overpassQuery(
                    OverpassQuery.builder()
                        .data("[out:json];node[amenity=cafe](around:500,48.8566,2.3522);out body;")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                OverpassQuery.builder()
                    .data("[out:json];node[amenity=cafe](around:500,48.8566,2.3522);out body;")
                    .build()
            )
    }
}
