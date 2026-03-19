// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.query.OverpassQuery
import com.plazafyi.models.query.SparqlQuery
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class QueryServiceAsyncTest {

    @Test
    fun overpass() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val queryServiceAsync = client.query()

        val featureCollectionFuture =
            queryServiceAsync.overpass(OverpassQuery.builder().data("data").build())

        val featureCollection = featureCollectionFuture.get()
        featureCollection.validate()
    }

    @Test
    fun sparql() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val queryServiceAsync = client.query()

        val sparqlResultFuture =
            queryServiceAsync.sparql(SparqlQuery.builder().query("query").build())

        val sparqlResult = sparqlResultFuture.get()
        sparqlResult.validate()
    }
}
