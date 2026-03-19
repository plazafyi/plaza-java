// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.GeoJsonGeometry
import com.plazafyi.models.elevation.ElevationLookupParams
import com.plazafyi.models.elevation.ElevationProfileRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ElevationServiceTest {

    @Test
    fun batch() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elevationService = client.elevation()

        val elevationBatchResult =
            elevationService.batch(
                ElevationProfileRequest.builder()
                    .geometry(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .build()
            )

        elevationBatchResult.validate()
    }

    @Test
    fun lookup() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elevationService = client.elevation()

        val elevationLookupResult =
            elevationService.lookup(
                ElevationLookupParams.builder().lat(0.0).lng(0.0).locations("locations").build()
            )

        elevationLookupResult.validate()
    }

    @Test
    fun profile() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elevationService = client.elevation()

        val elevationProfileResult =
            elevationService.profile(
                ElevationProfileRequest.builder()
                    .geometry(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .build()
            )

        elevationProfileResult.validate()
    }
}
