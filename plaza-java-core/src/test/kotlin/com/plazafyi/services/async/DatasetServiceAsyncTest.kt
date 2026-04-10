// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.datasets.DatasetCreateParams
import com.plazafyi.models.datasets.DatasetListParams
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
                    .strictMode(true)
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

        val datasetListFuture =
            datasetServiceAsync.list(DatasetListParams.builder().scope("scope").build())

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
}
