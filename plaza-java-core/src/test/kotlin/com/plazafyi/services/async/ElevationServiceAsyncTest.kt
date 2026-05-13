// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.LineStringGeometry
import com.plazafyi.models.PointGeometry
import com.plazafyi.models.elevation.ElevationLookupParams
import com.plazafyi.models.elevation.ElevationLookupRequest
import com.plazafyi.models.elevation.ElevationProfileRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ElevationServiceAsyncTest {

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
                    .elevationLookupRequest(
                        ElevationLookupRequest.builder()
                            .geometry(
                                PointGeometry.builder()
                                    .addCoordinate(2.3522)
                                    .addCoordinate(48.8566)
                                    .type(PointGeometry.Type.POINT)
                                    .build()
                            )
                            .build()
                    )
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
                    .geometry(
                        LineStringGeometry.builder()
                            .coordinates(
                                listOf(
                                    listOf(2.3522, 48.8566),
                                    listOf(2.34, 48.858),
                                    listOf(2.2945, 48.8584),
                                )
                            )
                            .type(LineStringGeometry.Type.LINE_STRING)
                            .build()
                    )
                    .build()
            )

        val elevationProfileResult = elevationProfileResultFuture.get()
        elevationProfileResult.validate()
    }
}
