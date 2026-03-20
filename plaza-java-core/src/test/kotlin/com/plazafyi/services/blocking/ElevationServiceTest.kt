// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.elevation.ElevationBatchParams
import com.plazafyi.models.elevation.ElevationLookupParams
import com.plazafyi.models.elevation.ElevationLookupPostParams
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
                ElevationBatchParams.builder()
                    .addCoordinate(
                        ElevationBatchParams.Coordinate.builder().lat(48.8566).lng(2.3522).build()
                    )
                    .addCoordinate(
                        ElevationBatchParams.Coordinate.builder().lat(45.764).lng(4.8357).build()
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
                ElevationLookupParams.builder()
                    .lat(0.0)
                    .lng(0.0)
                    .locations("locations")
                    .outputFields("output[fields]")
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .build()
            )

        elevationLookupResult.validate()
    }

    @Test
    fun lookupPost() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elevationService = client.elevation()

        val elevationLookupResult =
            elevationService.lookupPost(
                ElevationLookupPostParams.builder()
                    .lat(0.0)
                    .lng(0.0)
                    .locations("locations")
                    .outputFields("output[fields]")
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .build()
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
                    .coordinates(
                        listOf(
                            ElevationProfileRequest.Coordinate.builder()
                                .lat(48.8566)
                                .lng(2.3522)
                                .build(),
                            ElevationProfileRequest.Coordinate.builder()
                                .lat(48.858)
                                .lng(2.34)
                                .build(),
                            ElevationProfileRequest.Coordinate.builder()
                                .lat(48.8584)
                                .lng(2.2945)
                                .build(),
                        )
                    )
                    .build()
            )

        elevationProfileResult.validate()
    }
}
