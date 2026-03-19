// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.GeoJsonGeometry
import com.plazafyi.models.optimize.OptimizeRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OptimizeServiceAsyncTest {

    @Test
    fun create() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val optimizeServiceAsync = client.optimize()

        val optimizeResultFuture =
            optimizeServiceAsync.create(
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

        val optimizeResult = optimizeResultFuture.get()
        optimizeResult.validate()
    }

    @Test
    fun retrieve() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val optimizeServiceAsync = client.optimize()

        val optimizeJobStatusFuture = optimizeServiceAsync.retrieve("job_id")

        val optimizeJobStatus = optimizeJobStatusFuture.get()
        optimizeJobStatus.validate()
    }
}
