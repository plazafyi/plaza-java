// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.datasets.DatasetCreateParams
import com.plazafyi.models.datasets.DatasetFeaturesParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class DatasetServiceAsyncTest {

    @Test
    fun create() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetServiceAsync = client.datasets()

        val datasetFuture =
            datasetServiceAsync.create(
                DatasetCreateParams.builder()
                    .name("NYC Bike Lanes")
                    .slug("nyc-bike-lanes")
                    .attribution("attribution")
                    .description("description")
                    .license("license")
                    .sourceUrl("https://example.com")
                    .build()
            )

        val dataset = datasetFuture.get()
        dataset.validate()
    }

    @Test
    fun retrieve() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetServiceAsync = client.datasets()

        val datasetFuture = datasetServiceAsync.retrieve("id")

        val dataset = datasetFuture.get()
        dataset.validate()
    }

    @Test
    fun list() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetServiceAsync = client.datasets()

        val datasetListFuture = datasetServiceAsync.list()

        val datasetList = datasetListFuture.get()
        datasetList.validate()
    }

    @Test
    fun delete() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetServiceAsync = client.datasets()

        val future = datasetServiceAsync.delete("id")

        val response = future.get()
    }

    @Test
    fun features() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetServiceAsync = client.datasets()

        val featureCollectionFuture =
            datasetServiceAsync.features(
                DatasetFeaturesParams.builder()
                    .id("id")
                    .cursor("cursor")
                    .format("format")
                    .limit(0L)
                    .outputBuffer(0.0)
                    .outputCentroid(true)
                    .outputFields("output[fields]")
                    .outputGeometry(true)
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .outputSimplify(0.0)
                    .outputSort("output[sort]")
                    .build()
            )

        val featureCollection = featureCollectionFuture.get()
        featureCollection.validate()
    }
}
