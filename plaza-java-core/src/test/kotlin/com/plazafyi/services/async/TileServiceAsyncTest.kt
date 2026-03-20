// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.plazafyi.TestServerExtension
import com.plazafyi.client.okhttp.PlazaOkHttpClientAsync
import com.plazafyi.models.tiles.TileGetParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class TileServiceAsyncTest {

    @Test
    fun get(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            PlazaOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
        val tileServiceAsync = client.tiles()
        stubFor(get(anyUrl()).willReturn(ok().withBody("abc")))

        val tileFuture = tileServiceAsync.get(TileGetParams.builder().z(0L).x(0L).y(0L).build())

        val tile = tileFuture.get()
        assertThat(tile.body()).hasContent("abc")
    }
}
