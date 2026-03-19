// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.elements.BatchRequest
import com.plazafyi.models.elements.ElementNearbyParams
import com.plazafyi.models.elements.ElementQueryParams
import com.plazafyi.models.elements.ElementRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ElementServiceTest {

    @Test
    fun retrieve() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementService = client.elements()

        val geoJsonFeature =
            elementService.retrieve(ElementRetrieveParams.builder().type("type").id(0L).build())

        geoJsonFeature.validate()
    }

    @Test
    fun batch() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementService = client.elements()

        val featureCollection =
            elementService.batch(
                BatchRequest.builder()
                    .addElement(
                        BatchRequest.Element.builder()
                            .id(0L)
                            .type(BatchRequest.Element.Type.NODE)
                            .build()
                    )
                    .build()
            )

        featureCollection.validate()
    }

    @Test
    fun nearby() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementService = client.elements()

        val featureCollection =
            elementService.nearby(
                ElementNearbyParams.builder().lat(0.0).lng(0.0).limit(0L).radius(0L).build()
            )

        featureCollection.validate()
    }

    @Test
    fun query() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementService = client.elements()

        val featureCollection =
            elementService.query(
                ElementQueryParams.builder()
                    .bbox("bbox")
                    .cursor("cursor")
                    .h3("h3")
                    .limit(0L)
                    .type("type")
                    .build()
            )

        featureCollection.validate()
    }
}
