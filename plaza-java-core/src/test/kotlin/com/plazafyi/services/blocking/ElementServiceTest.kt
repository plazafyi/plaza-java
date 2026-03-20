// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.elements.BatchRequest
import com.plazafyi.models.elements.ElementNearbyParams
import com.plazafyi.models.elements.ElementNearbyPostParams
import com.plazafyi.models.elements.ElementQueryParams
import com.plazafyi.models.elements.ElementQueryPostParams
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
                            .id(21154906L)
                            .type(BatchRequest.Element.Type.NODE)
                            .build()
                    )
                    .addElement(
                        BatchRequest.Element.builder()
                            .id(4589123L)
                            .type(BatchRequest.Element.Type.WAY)
                            .build()
                    )
                    .build()
            )

        featureCollection.validate()
    }

    @Test
    fun lookup() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementService = client.elements()

        val geoJsonFeature = elementService.lookup()

        geoJsonFeature.validate()
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
                ElementNearbyParams.builder()
                    .lat(0.0)
                    .limit(0L)
                    .lng(0.0)
                    .near("near")
                    .outputBuffer(0.0)
                    .outputCentroid(true)
                    .outputFields("output[fields]")
                    .outputGeometry(true)
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .outputSimplify(0.0)
                    .outputSort("output[sort]")
                    .radius(0L)
                    .build()
            )

        featureCollection.validate()
    }

    @Test
    fun nearbyPost() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementService = client.elements()

        val featureCollection =
            elementService.nearbyPost(
                ElementNearbyPostParams.builder()
                    .lat(0.0)
                    .limit(0L)
                    .lng(0.0)
                    .near("near")
                    .outputBuffer(0.0)
                    .outputCentroid(true)
                    .outputFields("output[fields]")
                    .outputGeometry(true)
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .outputSimplify(0.0)
                    .outputSort("output[sort]")
                    .radius(0L)
                    .build()
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
                    .contains("contains")
                    .crosses("crosses")
                    .cursor("cursor")
                    .format("format")
                    .h3("h3")
                    .intersects("intersects")
                    .limit(0L)
                    .near("near")
                    .outputBuffer(0.0)
                    .outputCentroid(true)
                    .outputFields("output[fields]")
                    .outputGeometry(true)
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .outputSimplify(0.0)
                    .outputSort("output[sort]")
                    .radius(0.0)
                    .touches("touches")
                    .type("type")
                    .within("within")
                    .build()
            )

        featureCollection.validate()
    }

    @Test
    fun queryPost() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementService = client.elements()

        val featureCollection =
            elementService.queryPost(
                ElementQueryPostParams.builder()
                    .bbox("bbox")
                    .contains("contains")
                    .crosses("crosses")
                    .cursor("cursor")
                    .format("format")
                    .h3("h3")
                    .intersects("intersects")
                    .limit(0L)
                    .near("near")
                    .outputBuffer(0.0)
                    .outputCentroid(true)
                    .outputFields("output[fields]")
                    .outputGeometry(true)
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .outputSimplify(0.0)
                    .outputSort("output[sort]")
                    .radius(0.0)
                    .touches("touches")
                    .type("type")
                    .within("within")
                    .build()
            )

        featureCollection.validate()
    }
}
