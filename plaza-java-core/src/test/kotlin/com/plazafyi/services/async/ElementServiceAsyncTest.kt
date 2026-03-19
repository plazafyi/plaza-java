// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.elements.BatchRequest
import com.plazafyi.models.elements.ElementNearbyParams
import com.plazafyi.models.elements.ElementQueryParams
import com.plazafyi.models.elements.ElementRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ElementServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementServiceAsync = client.elements()

        val geoJsonFeatureFuture =
            elementServiceAsync.retrieve(
                ElementRetrieveParams.builder().type("type").id(0L).build()
            )

        val geoJsonFeature = geoJsonFeatureFuture.get()
        geoJsonFeature.validate()
    }

    @Test
    fun batch() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementServiceAsync = client.elements()

        val featureCollectionFuture =
            elementServiceAsync.batch(
                BatchRequest.builder()
                    .addElement(
                        BatchRequest.Element.builder()
                            .id(0L)
                            .type(BatchRequest.Element.Type.NODE)
                            .build()
                    )
                    .build()
            )

        val featureCollection = featureCollectionFuture.get()
        featureCollection.validate()
    }

    @Test
    fun nearby() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementServiceAsync = client.elements()

        val featureCollectionFuture =
            elementServiceAsync.nearby(
                ElementNearbyParams.builder().lat(0.0).lng(0.0).limit(0L).radius(0L).build()
            )

        val featureCollection = featureCollectionFuture.get()
        featureCollection.validate()
    }

    @Test
    fun query() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementServiceAsync = client.elements()

        val featureCollectionFuture =
            elementServiceAsync.query(
                ElementQueryParams.builder()
                    .bbox("bbox")
                    .cursor("cursor")
                    .h3("h3")
                    .limit(0L)
                    .type("type")
                    .build()
            )

        val featureCollection = featureCollectionFuture.get()
        featureCollection.validate()
    }
}
