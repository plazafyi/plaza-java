// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.plazafyi.client.PlazaClient
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.core.JsonValue
import com.plazafyi.core.http.Headers
import com.plazafyi.core.jsonMapper
import com.plazafyi.errors.BadRequestException
import com.plazafyi.errors.InternalServerException
import com.plazafyi.errors.NotFoundException
import com.plazafyi.errors.PermissionDeniedException
import com.plazafyi.errors.PlazaException
import com.plazafyi.errors.RateLimitException
import com.plazafyi.errors.UnauthorizedException
import com.plazafyi.errors.UnexpectedStatusCodeException
import com.plazafyi.errors.UnprocessableEntityException
import com.plazafyi.models.elements.ElementQueryParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

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
    fun elementsQuery400() {
        val elementService = client.elements()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery400WithRawResponse() {
        val elementService = client.elements().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery401() {
        val elementService = client.elements()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery401WithRawResponse() {
        val elementService = client.elements().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery403() {
        val elementService = client.elements()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery403WithRawResponse() {
        val elementService = client.elements().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery404() {
        val elementService = client.elements()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery404WithRawResponse() {
        val elementService = client.elements().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery422() {
        val elementService = client.elements()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery422WithRawResponse() {
        val elementService = client.elements().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery429() {
        val elementService = client.elements()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery429WithRawResponse() {
        val elementService = client.elements().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery500() {
        val elementService = client.elements()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery500WithRawResponse() {
        val elementService = client.elements().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery999() {
        val elementService = client.elements()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQuery999WithRawResponse() {
        val elementService = client.elements().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun elementsQueryInvalidJsonBody() {
        val elementService = client.elements()
        stubFor(
            get(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<PlazaException> {
                elementService.query(
                    ElementQueryParams.builder()
                        .bbox("bbox")
                        .contains("contains")
                        .crosses("crosses")
                        .cursor("cursor")
                        .format("format")
                        .h3("h3")
                        .intersects("intersects")
                        .limit(0L)
                        .near("near")
                        .outputBuffer(0.0)
                        .outputCentroid(true)
                        .outputFields("output[fields]")
                        .outputGeometry(true)
                        .outputInclude("output[include]")
                        .outputPrecision(0L)
                        .outputSimplify(0.0)
                        .outputSort("output[sort]")
                        .radius(0.0)
                        .touches("touches")
                        .type("type")
                        .within("within")
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
