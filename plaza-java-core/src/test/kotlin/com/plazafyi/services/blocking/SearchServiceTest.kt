// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.search.SearchQueryParams
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
                SearchQueryParams.builder().q("q").cursor("cursor").limit(0L).build()
            )

        featureCollection.validate()
    }
}
