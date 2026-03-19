// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.geocode.GeocodeAutocompleteParams
import com.plazafyi.models.geocode.GeocodeBatchParams
import com.plazafyi.models.geocode.GeocodeForwardParams
import com.plazafyi.models.geocode.GeocodeReverseParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GeocodeServiceAsyncTest {

    @Test
    fun autocomplete() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeServiceAsync = client.geocode()

        val autocompleteResultFuture =
            geocodeServiceAsync.autocomplete(
                GeocodeAutocompleteParams.builder()
                    .q("q")
                    .countryCode("country_code")
                    .lang("lang")
                    .lat(0.0)
                    .layer("layer")
                    .limit(0L)
                    .lng(0.0)
                    .build()
            )

        val autocompleteResult = autocompleteResultFuture.get()
        autocompleteResult.validate()
    }

    @Test
    fun batch() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeServiceAsync = client.geocode()

        val responseFuture =
            geocodeServiceAsync.batch(GeocodeBatchParams.builder().addAddress("string").build())

        val response = responseFuture.get()
        response.validate()
    }

    @Test
    fun forward() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeServiceAsync = client.geocode()

        val geocodeResultFuture =
            geocodeServiceAsync.forward(
                GeocodeForwardParams.builder()
                    .q("q")
                    .bbox("bbox")
                    .countryCode("country_code")
                    .lang("lang")
                    .lat(0.0)
                    .layer("layer")
                    .limit(0L)
                    .lng(0.0)
                    .build()
            )

        val geocodeResult = geocodeResultFuture.get()
        geocodeResult.validate()
    }

    @Test
    fun reverse() {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeServiceAsync = client.geocode()

        val reverseGeocodeResultFuture =
            geocodeServiceAsync.reverse(
                GeocodeReverseParams.builder()
                    .lat(0.0)
                    .lng(0.0)
                    .lang("lang")
                    .layer("layer")
                    .limit(0L)
                    .radius(0L)
                    .build()
            )

        val reverseGeocodeResult = reverseGeocodeResultFuture.get()
        reverseGeocodeResult.validate()
    }
}
