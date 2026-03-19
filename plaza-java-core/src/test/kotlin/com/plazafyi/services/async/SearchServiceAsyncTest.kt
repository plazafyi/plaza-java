// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.search.SearchQueryParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SearchServiceAsyncTest {

    @Test
    fun query() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val searchServiceAsync = client.search()

        val featureCollectionFuture =
            searchServiceAsync.query(
                SearchQueryParams.builder().q("q").cursor("cursor").limit(0L).build()
            )

        val featureCollection = featureCollectionFuture.get()
        featureCollection.validate()
    }
}
