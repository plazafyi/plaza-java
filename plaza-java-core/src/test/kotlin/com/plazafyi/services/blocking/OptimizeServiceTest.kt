// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.optimize.OptimizeRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OptimizeServiceTest {

    @Test
    fun create() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val optimizeService = client.optimize()

        val optimizeResult =
            optimizeService.create(
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

        optimizeResult.validate()
    }

    @Test
    fun retrieve() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val optimizeService = client.optimize()

        val optimizeJobStatus = optimizeService.retrieve("job_id")

        optimizeJobStatus.validate()
    }
}
