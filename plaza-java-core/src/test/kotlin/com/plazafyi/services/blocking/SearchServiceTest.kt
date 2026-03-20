// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.search.SearchQueryParams
import com.plazafyi.models.search.SearchQueryPostParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SearchServiceTest {

    @Test
    fun query() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val searchService = client.search()

        val featureCollection =
            searchService.query(
                SearchQueryParams.builder()
                    .q("q")
                    .cursor("cursor")
                    .format("format")
                    .limit(0L)
                    .outputFields("output[fields]")
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .outputSort("output[sort]")
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
        val searchService = client.search()

        val featureCollection =
            searchService.queryPost(
                SearchQueryPostParams.builder()
                    .q("q")
                    .cursor("cursor")
                    .format("format")
                    .limit(0L)
                    .outputFields("output[fields]")
                    .outputInclude("output[include]")
                    .outputPrecision(0L)
                    .outputSort("output[sort]")
                    .build()
            )

        featureCollection.validate()
    }
}
