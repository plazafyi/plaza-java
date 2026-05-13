// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.query

import com.plazafyi.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class QueryExecuteParamsTest {

    @Test
    fun create() {
        QueryExecuteParams.builder()
            .format("format")
            .plazaqlQuery(
                PlazaqlQuery.builder()
                    .data(
                        "\$\$ = search(node, amenity: \"cafe\").around(distance: 500, geometry: point(48.8566, 2.3522));"
                    )
                    .build()
            )
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            QueryExecuteParams.builder()
                .format("format")
                .plazaqlQuery(
                    PlazaqlQuery.builder()
                        .data(
                            "\$\$ = search(node, amenity: \"cafe\").around(distance: 500, geometry: point(48.8566, 2.3522));"
                        )
                        .build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("format", "format").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            QueryExecuteParams.builder()
                .plazaqlQuery(
                    PlazaqlQuery.builder()
                        .data(
                            "\$\$ = search(node, amenity: \"cafe\").around(distance: 500, geometry: point(48.8566, 2.3522));"
                        )
                        .build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun body() {
        val params =
            QueryExecuteParams.builder()
                .format("format")
                .plazaqlQuery(
                    PlazaqlQuery.builder()
                        .data(
                            "\$\$ = search(node, amenity: \"cafe\").around(distance: 500, geometry: point(48.8566, 2.3522));"
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                PlazaqlQuery.builder()
                    .data(
                        "\$\$ = search(node, amenity: \"cafe\").around(distance: 500, geometry: point(48.8566, 2.3522));"
                    )
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            QueryExecuteParams.builder()
                .plazaqlQuery(
                    PlazaqlQuery.builder()
                        .data(
                            "\$\$ = search(node, amenity: \"cafe\").around(distance: 500, geometry: point(48.8566, 2.3522));"
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                PlazaqlQuery.builder()
                    .data(
                        "\$\$ = search(node, amenity: \"cafe\").around(distance: 500, geometry: point(48.8566, 2.3522));"
                    )
                    .build()
            )
    }
}
