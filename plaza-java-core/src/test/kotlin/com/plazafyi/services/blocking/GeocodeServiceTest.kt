// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClient
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

        reverseGeocodeResult.validate()
    }
}
