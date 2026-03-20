// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.optimize

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OptimizeRequestTest {

    @Test
    fun create() {
        val optimizeRequest =
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

        assertThat(optimizeRequest.waypoints())
            .containsExactly(
                OptimizeRequest.Waypoint.builder().lat(48.8566).lng(2.3522).build(),
                OptimizeRequest.Waypoint.builder().lat(48.8606).lng(2.3376).build(),
                OptimizeRequest.Waypoint.builder().lat(48.8584).lng(2.2945).build(),
            )
        assertThat(optimizeRequest.mode()).contains(OptimizeRequest.Mode.AUTO)
        assertThat(optimizeRequest.roundtrip()).contains(false)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val optimizeRequest =
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

        val roundtrippedOptimizeRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(optimizeRequest),
                jacksonTypeRef<OptimizeRequest>(),
            )

        assertThat(roundtrippedOptimizeRequest).isEqualTo(optimizeRequest)
    }
}
