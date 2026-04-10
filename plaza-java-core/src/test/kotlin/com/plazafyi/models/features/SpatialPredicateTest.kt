// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.features

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.Geometry
import com.plazafyi.models.PointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpatialPredicateTest {

    @Test
    fun create() {
        val spatialPredicate =
            SpatialPredicate.builder()
                .pointAround(listOf(2.3522, 48.8566))
                .pointContains(listOf(2.3522, 48.8566))
                .pointCrosses(listOf(2.3522, 48.8566))
                .pointIntersects(listOf(2.3522, 48.8566))
                .pointNotContains(listOf(2.3522, 48.8566))
                .pointNotIntersects(listOf(2.3522, 48.8566))
                .pointNotWithin(listOf(2.3522, 48.8566))
                .radius(500.0)
                .pointTouches(listOf(2.3522, 48.8566))
                .pointWithin(listOf(2.3522, 48.8566))
                .build()

        assertThat(spatialPredicate.around())
            .contains(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.contains())
            .contains(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.crosses())
            .contains(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.intersects())
            .contains(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.notContains())
            .contains(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.notIntersects())
            .contains(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.notWithin())
            .contains(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.radius()).contains(500.0)
        assertThat(spatialPredicate.touches())
            .contains(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
        assertThat(spatialPredicate.within())
            .contains(
                Geometry.ofPoint(
                    PointGeometry.builder()
                        .addCoordinate(2.3522)
                        .addCoordinate(48.8566)
                        .type(PointGeometry.Type.POINT)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val spatialPredicate =
            SpatialPredicate.builder()
                .pointAround(listOf(2.3522, 48.8566))
                .pointContains(listOf(2.3522, 48.8566))
                .pointCrosses(listOf(2.3522, 48.8566))
                .pointIntersects(listOf(2.3522, 48.8566))
                .pointNotContains(listOf(2.3522, 48.8566))
                .pointNotIntersects(listOf(2.3522, 48.8566))
                .pointNotWithin(listOf(2.3522, 48.8566))
                .radius(500.0)
                .pointTouches(listOf(2.3522, 48.8566))
                .pointWithin(listOf(2.3522, 48.8566))
                .build()

        val roundtrippedSpatialPredicate =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(spatialPredicate),
                jacksonTypeRef<SpatialPredicate>(),
            )

        assertThat(roundtrippedSpatialPredicate).isEqualTo(spatialPredicate)
    }
}
