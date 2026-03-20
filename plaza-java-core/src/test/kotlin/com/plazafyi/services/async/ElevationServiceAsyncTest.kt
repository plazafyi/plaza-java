// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.elevation.ElevationBatchParams
import com.plazafyi.models.elevation.ElevationLookupParams
import com.plazafyi.models.elevation.ElevationLookupPostParams
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
                ElevationBatchParams.builder()
                    .format("format")
                    .addCoordinate(
                        ElevationBatchParams.Coordinate.builder().lat(48.8566).lng(2.3522).build()
                    )
                    .addCoordinate(
                        ElevationBatchParams.Coordinate.builder().lat(45.764).lng(4.8357).build()
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
                ElevationLookupParams.builder()
                    .format("format")
                    .lat(0.0)
                    .lng(0.0)
                    .locations("locations")
                    .outputFields("output[fields]")
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .build()
            )

        val elevationLookupResult = elevationLookupResultFuture.get()
        elevationLookupResult.validate()
    }

    @Test
    fun lookupPost() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elevationServiceAsync = client.elevation()

        val elevationLookupResultFuture =
            elevationServiceAsync.lookupPost(
                ElevationLookupPostParams.builder()
                    .format("format")
                    .lat(0.0)
                    .lng(0.0)
                    .locations("locations")
                    .outputFields("output[fields]")
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .build()
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

        val elevationProfileResult = elevationProfileResultFuture.get()
        elevationProfileResult.validate()
    }
}
