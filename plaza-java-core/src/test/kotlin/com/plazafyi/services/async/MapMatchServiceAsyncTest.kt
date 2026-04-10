// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.LineStringGeometry
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
                    .geometry(
                        LineStringGeometry.builder()
                            .coordinates(
                                listOf(
                                    listOf(2.3522, 48.8566),
                                    listOf(2.353, 48.857),
                                    listOf(2.354, 48.8575),
                                )
                            )
                            .type(LineStringGeometry.Type.LINE_STRING)
                            .build()
                    )
                    .addRadius(0.0)
                    .build()
            )

        val mapMatchResult = mapMatchResultFuture.get()
        mapMatchResult.validate()
    }
}
