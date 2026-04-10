// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.plazafyi.client.PlazaClient
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.models.features.FeatureQueryParams
import com.plazafyi.models.features.SpatialPredicate
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: PlazaClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            PlazaOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun query() {
        val featureService = client.features()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        featureService.query(
            FeatureQueryParams.builder()
                .cursor("cursor")
                .format("format")
                .h3("h3")
                .limit(0L)
                .type("type")
                .spatialPredicate(
                    SpatialPredicate.builder()
                        .pointAround(listOf(2.3522, 48.8566))
                        .pointContains(listOf(2.3522, 48.8566))
                        .pointCrosses(listOf(2.3522, 48.8566))
                        .pointIntersects(listOf(2.3522, 48.8566))
                        .pointNotContains(listOf(2.3522, 48.8566))
                        .pointNotIntersects(listOf(2.3522, 48.8566))
                        .pointNotWithin(listOf(2.3522, 48.8566))
                        .radius(500.0)
                        .pointTouches(listOf(2.3522, 48.8566))
                        .pointWithin(listOf(2.3522, 48.8566))
                        .build()
                )
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
        )
    }
}
