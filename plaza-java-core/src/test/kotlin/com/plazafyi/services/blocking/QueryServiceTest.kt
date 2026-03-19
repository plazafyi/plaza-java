// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.query.OverpassQuery
import com.plazafyi.models.query.SparqlQuery
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class QueryServiceTest {

    @Test
    fun overpass() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val queryService = client.query()

        val featureCollection = queryService.overpass(OverpassQuery.builder().data("data").build())

        featureCollection.validate()
    }

    @Test
    fun sparql() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val queryService = client.query()

        val sparqlResult = queryService.sparql(SparqlQuery.builder().query("query").build())

        sparqlResult.validate()
    }
}
