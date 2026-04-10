// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.features

import com.plazafyi.core.http.QueryParams
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FeatureQueryParamsTest {

    @Test
    fun create() {
        FeatureQueryParams.builder()
            .cursor("cursor")
            .format("format")
            .h3("h3")
            .limit(0L)
            .type("type")
            .spatialPredicate(
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
            )
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            FeatureQueryParams.builder()
                .cursor("cursor")
                .format("format")
                .h3("h3")
                .limit(0L)
                .type("type")
                .spatialPredicate(
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
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("cursor", "cursor")
                    .put("format", "format")
                    .put("h3", "h3")
                    .put("limit", "0")
                    .put("type", "type")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = FeatureQueryParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }

    @Test
    fun body() {
        val params =
            FeatureQueryParams.builder()
                .cursor("cursor")
                .format("format")
                .h3("h3")
                .limit(0L)
                .type("type")
                .spatialPredicate(
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
                )
                .build()

        val body = params._body().getOrNull()

        assertThat(body)
            .isEqualTo(
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
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = FeatureQueryParams.builder().build()

        val body = params._body().getOrNull()
    }
}
