// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.features.BatchRequest
import com.plazafyi.models.features.FeatureQueryParams
import com.plazafyi.models.features.FeatureRetrieveParams
import com.plazafyi.models.features.SpatialPredicate
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FeatureServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val featureServiceAsync = client.features()

        val geoJsonFeatureFuture =
            featureServiceAsync.retrieve(
                FeatureRetrieveParams.builder().type("type").id(0L).build()
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
        val featureServiceAsync = client.features()

        val featureCollectionFuture =
            featureServiceAsync.batch(
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
    fun query() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val featureServiceAsync = client.features()

        val featureCollectionFuture =
            featureServiceAsync.query(
                FeatureQueryParams.builder()
                    .cursor("cursor")
                    .format("format")
                    .h3("h3")
                    .limit(0L)
                    .type("type")
                    .spatialPredicate(
                        SpatialPredicate.builder()
                            .pointAround(listOf(2.3522, 48.8566))
                            .pointContains(listOf(2.3522, 48.8566))
                            .pointCrosses(listOf(2.3522, 48.8566))
                            .pointIntersects(listOf(2.3522, 48.8566))
                            .pointNotContains(listOf(2.3522, 48.8566))
                            .pointNotIntersects(listOf(2.3522, 48.8566))
                            .pointNotWithin(listOf(2.3522, 48.8566))
                            .radius(500.0)
                            .pointTouches(listOf(2.3522, 48.8566))
                            .pointWithin(listOf(2.3522, 48.8566))
                            .build()
                    )
                    .build()
            )

        val featureCollection = featureCollectionFuture.get()
        featureCollection.validate()
    }
}
