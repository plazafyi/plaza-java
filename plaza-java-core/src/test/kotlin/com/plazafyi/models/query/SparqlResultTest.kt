// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.query

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonFeature
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SparqlResultTest {

    @Test
    fun create() {
        val sparqlResult =
            SparqlResult.builder()
                .addFeature(
                    GeoJsonFeature.builder()
                        .geometry(
                            GeoJsonGeometry.builder()
                                .coordinatesOfNumber(listOf(0.0))
                                .type(GeoJsonGeometry.Type.POINT)
                                .build()
                        )
                        .properties(
                            GeoJsonFeature.Properties.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .type(GeoJsonFeature.Type.FEATURE)
                        .id("id")
                        .osmId(0L)
                        .build()
                )
                .type(SparqlResult.Type.FEATURE_COLLECTION)
                .build()

        assertThat(sparqlResult.features())
            .containsExactly(
                GeoJsonFeature.builder()
                    .geometry(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .properties(
                        GeoJsonFeature.Properties.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .type(GeoJsonFeature.Type.FEATURE)
                    .id("id")
                    .osmId(0L)
                    .build()
            )
        assertThat(sparqlResult.type()).isEqualTo(SparqlResult.Type.FEATURE_COLLECTION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sparqlResult =
            SparqlResult.builder()
                .addFeature(
                    GeoJsonFeature.builder()
                        .geometry(
                            GeoJsonGeometry.builder()
                                .coordinatesOfNumber(listOf(0.0))
                                .type(GeoJsonGeometry.Type.POINT)
                                .build()
                        )
                        .properties(
                            GeoJsonFeature.Properties.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .type(GeoJsonFeature.Type.FEATURE)
                        .id("id")
                        .osmId(0L)
                        .build()
                )
                .type(SparqlResult.Type.FEATURE_COLLECTION)
                .build()

        val roundtrippedSparqlResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sparqlResult),
                jacksonTypeRef<SparqlResult>(),
            )

        assertThat(roundtrippedSparqlResult).isEqualTo(sparqlResult)
    }
}
