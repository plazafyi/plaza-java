// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.PointGeometry
import com.plazafyi.models.geocode.AutocompleteRequest
import com.plazafyi.models.geocode.GeocodeAutocompleteParams
import com.plazafyi.models.geocode.GeocodeBatchParams
import com.plazafyi.models.geocode.GeocodeForwardParams
import com.plazafyi.models.geocode.GeocodeForwardRequest
import com.plazafyi.models.geocode.GeocodeReverseParams
import com.plazafyi.models.geocode.GeocodeReverseRequest
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
                    .format("format")
                    .autocompleteRequest(
                        AutocompleteRequest.builder()
                            .q("221B Bak")
                            .countryCode("xx")
                            .focus(
                                PointGeometry.builder()
                                    .addCoordinate(2.3522)
                                    .addCoordinate(48.8566)
                                    .type(PointGeometry.Type.POINT)
                                    .build()
                            )
                            .lang("lang")
                            .layer("layer")
                            .limit(1L)
                            .build()
                    )
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
                    .format("format")
                    .geocodeForwardRequest(
                        GeocodeForwardRequest.builder()
                            .q("221B Baker Street, London")
                            .countryCode("xx")
                            .focus(
                                PointGeometry.builder()
                                    .addCoordinate(2.3522)
                                    .addCoordinate(48.8566)
                                    .type(PointGeometry.Type.POINT)
                                    .build()
                            )
                            .lang("lang")
                            .layer("layer")
                            .limit(1L)
                            .build()
                    )
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
                    .format("format")
                    .geocodeReverseRequest(
                        GeocodeReverseRequest.builder()
                            .geometry(
                                PointGeometry.builder()
                                    .addCoordinate(2.3522)
                                    .addCoordinate(48.8566)
                                    .type(PointGeometry.Type.POINT)
                                    .build()
                            )
                            .lang("lang")
                            .limit(1L)
                            .radius(1.0)
                            .build()
                    )
                    .build()
            )

        val reverseGeocodeResult = reverseGeocodeResultFuture.get()
        reverseGeocodeResult.validate()
    }
}
