// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.elements.BatchRequest
import com.plazafyi.models.elements.ElementNearbyParams
import com.plazafyi.models.elements.ElementNearbyPostParams
import com.plazafyi.models.elements.ElementQueryParams
import com.plazafyi.models.elements.ElementQueryPostParams
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

        val featureCollection = featureCollectionFuture.get()
        featureCollection.validate()
    }

    @Test
    fun lookup() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementServiceAsync = client.elements()

        val geoJsonFeatureFuture = elementServiceAsync.lookup()

        val geoJsonFeature = geoJsonFeatureFuture.get()
        geoJsonFeature.validate()
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

        val featureCollection = featureCollectionFuture.get()
        featureCollection.validate()
    }

    @Test
    fun nearbyPost() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementServiceAsync = client.elements()

        val featureCollectionFuture =
            elementServiceAsync.nearbyPost(
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
                    .contains("contains")
                    .crosses("crosses")
                    .cursor("cursor")
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

        val featureCollection = featureCollectionFuture.get()
        featureCollection.validate()
    }

    @Test
    fun queryPost() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val elementServiceAsync = client.elements()

        val featureCollectionFuture =
            elementServiceAsync.queryPost(
                ElementQueryPostParams.builder()
                    .bbox("bbox")
                    .contains("contains")
                    .crosses("crosses")
                    .cursor("cursor")
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

        val featureCollection = featureCollectionFuture.get()
        featureCollection.validate()
    }
}
