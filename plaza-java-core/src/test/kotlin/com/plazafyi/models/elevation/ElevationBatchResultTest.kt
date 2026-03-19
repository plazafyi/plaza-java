// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ElevationBatchResultTest {

    @Test
    fun create() {
        val elevationBatchResult =
            ElevationBatchResult.builder()
                .addFeature(
                    ElevationLookupResult.builder()
                        .geometry(
                            GeoJsonGeometry.builder()
                                .coordinatesOfNumber(listOf(0.0))
                                .type(GeoJsonGeometry.Type.POINT)
                                .build()
                        )
                        .properties(
                            ElevationLookupResult.Properties.builder().elevationM(0.0).build()
                        )
                        .type(ElevationLookupResult.Type.FEATURE)
                        .build()
                )
                .type(ElevationBatchResult.Type.FEATURE_COLLECTION)
                .build()

        assertThat(elevationBatchResult.features())
            .containsExactly(
                ElevationLookupResult.builder()
                    .geometry(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .properties(ElevationLookupResult.Properties.builder().elevationM(0.0).build())
                    .type(ElevationLookupResult.Type.FEATURE)
                    .build()
            )
        assertThat(elevationBatchResult.type())
            .isEqualTo(ElevationBatchResult.Type.FEATURE_COLLECTION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val elevationBatchResult =
            ElevationBatchResult.builder()
                .addFeature(
                    ElevationLookupResult.builder()
                        .geometry(
                            GeoJsonGeometry.builder()
                                .coordinatesOfNumber(listOf(0.0))
                                .type(GeoJsonGeometry.Type.POINT)
                                .build()
                        )
                        .properties(
                            ElevationLookupResult.Properties.builder().elevationM(0.0).build()
                        )
                        .type(ElevationLookupResult.Type.FEATURE)
                        .build()
                )
                .type(ElevationBatchResult.Type.FEATURE_COLLECTION)
                .build()

        val roundtrippedElevationBatchResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(elevationBatchResult),
                jacksonTypeRef<ElevationBatchResult>(),
            )

        assertThat(roundtrippedElevationBatchResult).isEqualTo(elevationBatchResult)
    }
}
