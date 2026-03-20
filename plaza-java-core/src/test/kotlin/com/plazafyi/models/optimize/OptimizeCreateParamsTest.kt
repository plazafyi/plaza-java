// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.optimize

import com.plazafyi.core.http.QueryParams
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
                        listOf(
                            OptimizeRequest.Waypoint.builder().lat(48.8566).lng(2.3522).build(),
                            OptimizeRequest.Waypoint.builder().lat(48.8606).lng(2.3376).build(),
                            OptimizeRequest.Waypoint.builder().lat(48.8584).lng(2.2945).build(),
                        )
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
                            listOf(
                                OptimizeRequest.Waypoint.builder().lat(48.8566).lng(2.3522).build(),
                                OptimizeRequest.Waypoint.builder().lat(48.8606).lng(2.3376).build(),
                                OptimizeRequest.Waypoint.builder().lat(48.8584).lng(2.2945).build(),
                            )
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
                            listOf(
                                OptimizeRequest.Waypoint.builder().lat(48.8566).lng(2.3522).build(),
                                OptimizeRequest.Waypoint.builder().lat(48.8606).lng(2.3376).build(),
                                OptimizeRequest.Waypoint.builder().lat(48.8584).lng(2.2945).build(),
                            )
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
                            listOf(
                                OptimizeRequest.Waypoint.builder().lat(48.8566).lng(2.3522).build(),
                                OptimizeRequest.Waypoint.builder().lat(48.8606).lng(2.3376).build(),
                                OptimizeRequest.Waypoint.builder().lat(48.8584).lng(2.2945).build(),
                            )
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
                        listOf(
                            OptimizeRequest.Waypoint.builder().lat(48.8566).lng(2.3522).build(),
                            OptimizeRequest.Waypoint.builder().lat(48.8606).lng(2.3376).build(),
                            OptimizeRequest.Waypoint.builder().lat(48.8584).lng(2.2945).build(),
                        )
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
                            listOf(
                                OptimizeRequest.Waypoint.builder().lat(48.8566).lng(2.3522).build(),
                                OptimizeRequest.Waypoint.builder().lat(48.8606).lng(2.3376).build(),
                                OptimizeRequest.Waypoint.builder().lat(48.8584).lng(2.2945).build(),
                            )
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                OptimizeRequest.builder()
                    .waypoints(
                        listOf(
                            OptimizeRequest.Waypoint.builder().lat(48.8566).lng(2.3522).build(),
                            OptimizeRequest.Waypoint.builder().lat(48.8606).lng(2.3376).build(),
                            OptimizeRequest.Waypoint.builder().lat(48.8584).lng(2.2945).build(),
                        )
                    )
                    .build()
            )
    }
}
