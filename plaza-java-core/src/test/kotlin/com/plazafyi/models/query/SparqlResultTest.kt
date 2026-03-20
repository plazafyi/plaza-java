// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.query

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SparqlResultTest {

    @Test
    fun create() {
        val sparqlResult =
            SparqlResult.builder()
                .addResult(
                    SparqlResult.Result.builder()
                        .geometry(
                            GeoJsonGeometry.builder()
                                .coordinatesOfPoint(listOf(2.3522, 48.8566))
                                .type(GeoJsonGeometry.Type.POINT)
                                .build()
                        )
                        .properties(
                            SparqlResult.Result.Properties.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .type(SparqlResult.Result.Type.FEATURE)
                        .id("id")
                        .build()
                )
                .build()

        assertThat(sparqlResult.results())
            .containsExactly(
                SparqlResult.Result.builder()
                    .geometry(
                        GeoJsonGeometry.builder()
                            .coordinatesOfPoint(listOf(2.3522, 48.8566))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .properties(
                        SparqlResult.Result.Properties.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .type(SparqlResult.Result.Type.FEATURE)
                    .id("id")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sparqlResult =
            SparqlResult.builder()
                .addResult(
                    SparqlResult.Result.builder()
                        .geometry(
                            GeoJsonGeometry.builder()
                                .coordinatesOfPoint(listOf(2.3522, 48.8566))
                                .type(GeoJsonGeometry.Type.POINT)
                                .build()
                        )
                        .properties(
                            SparqlResult.Result.Properties.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .type(SparqlResult.Result.Type.FEATURE)
                        .id("id")
                        .build()
                )
                .build()

        val roundtrippedSparqlResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sparqlResult),
                jacksonTypeRef<SparqlResult>(),
            )

        assertThat(roundtrippedSparqlResult).isEqualTo(sparqlResult)
    }
}
