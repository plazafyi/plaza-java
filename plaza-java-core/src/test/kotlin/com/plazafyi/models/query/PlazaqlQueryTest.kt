// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.query

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PlazaqlQueryTest {

    @Test
    fun create() {
        val plazaqlQuery =
            PlazaqlQuery.builder()
                .data(
                    "\$\$ = search(node, amenity: \"cafe\").around(distance: 500, geometry: point(48.8566, 2.3522));"
                )
                .build()

        assertThat(plazaqlQuery.data())
            .isEqualTo(
                "\$\$ = search(node, amenity: \"cafe\").around(distance: 500, geometry: point(48.8566, 2.3522));"
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val plazaqlQuery =
            PlazaqlQuery.builder()
                .data(
                    "\$\$ = search(node, amenity: \"cafe\").around(distance: 500, geometry: point(48.8566, 2.3522));"
                )
                .build()

        val roundtrippedPlazaqlQuery =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(plazaqlQuery),
                jacksonTypeRef<PlazaqlQuery>(),
            )

        assertThat(roundtrippedPlazaqlQuery).isEqualTo(plazaqlQuery)
    }
}
