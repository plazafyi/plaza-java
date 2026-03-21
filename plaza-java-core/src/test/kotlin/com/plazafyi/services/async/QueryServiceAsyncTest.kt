// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.query.OverpassQuery
import com.plazafyi.models.query.QueryExecuteParams
import com.plazafyi.models.query.QueryOverpassParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class QueryServiceAsyncTest {

    @Test
    fun execute() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val queryServiceAsync = client.query()

        val responseFuture =
            queryServiceAsync.execute(
                QueryExecuteParams.builder()
                    .addStep(
                        QueryExecuteParams.Step.builder()
                            .type(QueryExecuteParams.Step.Type.OVERPASS)
                            .query("query")
                            .build()
                    )
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun overpass() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val queryServiceAsync = client.query()

        val featureCollectionFuture =
            queryServiceAsync.overpass(
                QueryOverpassParams.builder()
                    .format("format")
                    .overpassQuery(
                        OverpassQuery.builder()
                            .data(
                                "[out:json];node[amenity=cafe](around:500,48.8566,2.3522);out body;"
                            )
                            .build()
                    )
                    .build()
            )

        val featureCollection = featureCollectionFuture.get()
        featureCollection.validate()
    }
}
