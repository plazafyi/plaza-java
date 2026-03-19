// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.GeoJsonGeometry
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
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .mode(OptimizeRequest.Mode.AUTO)
                    .roundtrip(true)
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
