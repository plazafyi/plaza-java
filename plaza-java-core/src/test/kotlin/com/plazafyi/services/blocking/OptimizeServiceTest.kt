// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.MultiPointGeometry
import com.plazafyi.models.optimize.OptimizeCreateParams
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
