// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.GeoJsonGeometry
import com.plazafyi.models.mapmatch.MapMatchRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MapMatchServiceTest {

    @Test
    fun match() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val mapMatchService = client.mapMatch()

        val mapMatchResult =
            mapMatchService.match(
                MapMatchRequest.builder()
                    .trace(
                        GeoJsonGeometry.builder()
                            .coordinatesOfNumber(listOf(0.0))
                            .type(GeoJsonGeometry.Type.POINT)
                            .build()
                    )
                    .addRadius(0.0)
                    .build()
            )

        mapMatchResult.validate()
    }
}
