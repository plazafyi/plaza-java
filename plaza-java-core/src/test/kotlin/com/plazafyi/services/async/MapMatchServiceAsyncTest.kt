// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.mapmatch.MapMatchRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MapMatchServiceAsyncTest {

    @Test
    fun match() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val mapMatchServiceAsync = client.mapMatch()

        val mapMatchResultFuture =
            mapMatchServiceAsync.match(
                MapMatchRequest.builder()
                    .coordinates(
                        listOf(
                            MapMatchRequest.Coordinate.builder().lat(48.8566).lng(2.3522).build(),
                            MapMatchRequest.Coordinate.builder().lat(48.857).lng(2.353).build(),
                            MapMatchRequest.Coordinate.builder().lat(48.8575).lng(2.354).build(),
                        )
                    )
                    .addRadius(0.0)
                    .build()
            )

        val mapMatchResult = mapMatchResultFuture.get()
        mapMatchResult.validate()
    }
}
