// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.optimize

import com.plazafyi.core.http.QueryParams
import com.plazafyi.models.MultiPointGeometry
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OptimizeCreateParamsTest {

    @Test
    fun create() {
        OptimizeCreateParams.builder()
            .format("format")
            .optimizeRequest(
                OptimizeRequest.builder()
                    .waypoints(
                        MultiPointGeometry.builder()
                            .coordinates(
                                listOf(
                                    listOf(2.3522, 48.8566),
                                    listOf(2.3376, 48.8606),
                                    listOf(2.2945, 48.8584),
                                )
                            )
                            .type(MultiPointGeometry.Type.MULTI_POINT)
                            .build()
                    )
                    .mode(OptimizeRequest.Mode.AUTO)
                    .roundtrip(false)
                    .build()
            )
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            OptimizeCreateParams.builder()
                .format("format")
                .optimizeRequest(
                    OptimizeRequest.builder()
                        .waypoints(
                            MultiPointGeometry.builder()
                                .coordinates(
                                    listOf(
                                        listOf(2.3522, 48.8566),
                                        listOf(2.3376, 48.8606),
                                        listOf(2.2945, 48.8584),
                                    )
                                )
                                .type(MultiPointGeometry.Type.MULTI_POINT)
                                .build()
                        )
                        .mode(OptimizeRequest.Mode.AUTO)
                        .roundtrip(false)
                        .build()
                )
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("format", "format").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            OptimizeCreateParams.builder()
                .optimizeRequest(
                    OptimizeRequest.builder()
                        .waypoints(
                            MultiPointGeometry.builder()
                                .coordinates(
                                    listOf(
                                        listOf(2.3522, 48.8566),
                                        listOf(2.3376, 48.8606),
                                        listOf(2.2945, 48.8584),
                                    )
                                )
                                .type(MultiPointGeometry.Type.MULTI_POINT)
                                .build()
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
            OptimizeCreateParams.builder()
                .format("format")
                .optimizeRequest(
                    OptimizeRequest.builder()
                        .waypoints(
                            MultiPointGeometry.builder()
                                .coordinates(
                                    listOf(
                                        listOf(2.3522, 48.8566),
                                        listOf(2.3376, 48.8606),
                                        listOf(2.2945, 48.8584),
                                    )
                                )
                                .type(MultiPointGeometry.Type.MULTI_POINT)
                                .build()
                        )
                        .mode(OptimizeRequest.Mode.AUTO)
                        .roundtrip(false)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                OptimizeRequest.builder()
                    .waypoints(
                        MultiPointGeometry.builder()
                            .coordinates(
                                listOf(
                                    listOf(2.3522, 48.8566),
                                    listOf(2.3376, 48.8606),
                                    listOf(2.2945, 48.8584),
                                )
                            )
                            .type(MultiPointGeometry.Type.MULTI_POINT)
                            .build()
                    )
                    .mode(OptimizeRequest.Mode.AUTO)
                    .roundtrip(false)
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            OptimizeCreateParams.builder()
                .optimizeRequest(
                    OptimizeRequest.builder()
                        .waypoints(
                            MultiPointGeometry.builder()
                                .coordinates(
                                    listOf(
                                        listOf(2.3522, 48.8566),
                                        listOf(2.3376, 48.8606),
                                        listOf(2.2945, 48.8584),
                                    )
                                )
                                .type(MultiPointGeometry.Type.MULTI_POINT)
                                .build()
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                OptimizeRequest.builder()
                    .waypoints(
                        MultiPointGeometry.builder()
                            .coordinates(
                                listOf(
                                    listOf(2.3522, 48.8566),
                                    listOf(2.3376, 48.8606),
                                    listOf(2.2945, 48.8584),
                                )
                            )
                            .type(MultiPointGeometry.Type.MULTI_POINT)
                            .build()
                    )
                    .build()
            )
    }
}
