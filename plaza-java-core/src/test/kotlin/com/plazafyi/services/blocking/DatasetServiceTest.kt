// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.datasets.DatasetCreateParams
import com.plazafyi.models.datasets.DatasetFeaturesParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class DatasetServiceTest {

    @Test
    fun create() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetService = client.datasets()

        val dataset =
            datasetService.create(
                DatasetCreateParams.builder()
                    .name("name")
                    .slug("slug")
                    .attribution("attribution")
                    .description("description")
                    .license("license")
                    .sourceUrl("source_url")
                    .build()
            )

        dataset.validate()
    }

    @Test
    fun retrieve() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetService = client.datasets()

        val dataset = datasetService.retrieve("id")

        dataset.validate()
    }

    @Test
    fun list() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetService = client.datasets()

        val datasetList = datasetService.list()

        datasetList.validate()
    }

    @Test
    fun delete() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetService = client.datasets()

        datasetService.delete("id")
    }

    @Test
    fun features() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val datasetService = client.datasets()

        val featureCollection =
            datasetService.features(
                DatasetFeaturesParams.builder().id("id").cursor("cursor").limit(0L).build()
            )

        featureCollection.validate()
    }
}
