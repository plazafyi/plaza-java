// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
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
import com.plazafyi.models.features.FeatureQueryParams
import com.plazafyi.models.features.SpatialPredicate
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
    fun featuresQuery400() {
        val featureService = client.features()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery400WithRawResponse() {
        val featureService = client.features().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery401() {
        val featureService = client.features()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery401WithRawResponse() {
        val featureService = client.features().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery403() {
        val featureService = client.features()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery403WithRawResponse() {
        val featureService = client.features().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery404() {
        val featureService = client.features()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery404WithRawResponse() {
        val featureService = client.features().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery422() {
        val featureService = client.features()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery422WithRawResponse() {
        val featureService = client.features().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery429() {
        val featureService = client.features()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery429WithRawResponse() {
        val featureService = client.features().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery500() {
        val featureService = client.features()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery500WithRawResponse() {
        val featureService = client.features().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery999() {
        val featureService = client.features()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQuery999WithRawResponse() {
        val featureService = client.features().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun featuresQueryInvalidJsonBody() {
        val featureService = client.features()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<PlazaException> {
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
