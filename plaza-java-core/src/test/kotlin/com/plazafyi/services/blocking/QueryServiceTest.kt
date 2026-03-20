// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.query.OverpassQuery
import com.plazafyi.models.query.QueryExecuteParams
import com.plazafyi.models.query.SparqlQuery
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class QueryServiceTest {

    @Test
    fun execute() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val queryService = client.query()

        val response =
            queryService.execute(
                QueryExecuteParams.builder()
                    .addStep(
                        QueryExecuteParams.Step.builder()
                            .type(QueryExecuteParams.Step.Type.OVERPASS)
                            .query("query")
                            .build()
                    )
                    .build()
            )

        response.validate()
    }

    @Test
    fun overpass() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val queryService = client.query()

        val featureCollection =
            queryService.overpass(
                OverpassQuery.builder()
                    .data("[out:json];node[amenity=cafe](around:500,48.8566,2.3522);out body;")
                    .build()
            )

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

        val sparqlResult =
            queryService.sparql(
                SparqlQuery.builder()
                    .query(
                        "SELECT ?s ?name WHERE { ?s osm:name ?name . ?s osm:amenity \"cafe\" } LIMIT 10"
                    )
                    .build()
            )

        sparqlResult.validate()
    }
}
