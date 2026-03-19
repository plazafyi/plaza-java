// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.geocode.GeocodeAutocompleteParams
import com.plazafyi.models.geocode.GeocodeBatchParams
import com.plazafyi.models.geocode.GeocodeForwardParams
import com.plazafyi.models.geocode.GeocodeReverseParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GeocodeServiceTest {

    @Test
    fun autocomplete() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeService = client.geocode()

        val autocompleteResult =
            geocodeService.autocomplete(
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

        autocompleteResult.validate()
    }

    @Test
    fun batch() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeService = client.geocode()

        val response =
            geocodeService.batch(GeocodeBatchParams.builder().addAddress("string").build())

        response.validate()
    }

    @Test
    fun forward() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeService = client.geocode()

        val geocodeResult =
            geocodeService.forward(
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

        geocodeResult.validate()
    }

    @Test
    fun reverse() {
        val client =
            PlazaOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val geocodeService = client.geocode()

        val reverseGeocodeResult =
            geocodeService.reverse(
                GeocodeReverseParams.builder()
                    .lat(0.0)
                    .lng(0.0)
                    .lang("lang")
                    .layer("layer")
                    .limit(0L)
                    .radius(0L)
                    .build()
            )

        reverseGeocodeResult.validate()
    }
}
