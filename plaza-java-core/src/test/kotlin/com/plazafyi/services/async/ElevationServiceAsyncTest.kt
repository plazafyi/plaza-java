// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.GeoJsonGeometry
import com.plazafyi.models.elevation.ElevationLookupParams
import com.plazafyi.models.elevation.ElevationProfileRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ElevationServiceAsyncTest {

    @Test
    fun batch() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elevationServiceAsync = client.elevation()

        val elevationBatchResultFuture =
            elevationServiceAsync.batch(
                ElevationProfileRequest.builder()
                    .geometry(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .build()
            )

        val elevationBatchResult = elevationBatchResultFuture.get()
        elevationBatchResult.validate()
    }

    @Test
    fun lookup() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elevationServiceAsync = client.elevation()

        val elevationLookupResultFuture =
            elevationServiceAsync.lookup(
                ElevationLookupParams.builder().lat(0.0).lng(0.0).locations("locations").build()
            )

        val elevationLookupResult = elevationLookupResultFuture.get()
        elevationLookupResult.validate()
    }

    @Test
    fun profile() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elevationServiceAsync = client.elevation()

        val elevationProfileResultFuture =
            elevationServiceAsync.profile(
                ElevationProfileRequest.builder()
                    .geometry(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .build()
            )

        val elevationProfileResult = elevationProfileResultFuture.get()
        elevationProfileResult.validate()
    }
}
