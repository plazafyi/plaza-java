// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.GeoJsonGeometry
import com.plazafyi.models.elements.BatchRequest
import com.plazafyi.models.optimize.OptimizeCompletedResult
import com.plazafyi.models.optimize.OptimizeResult
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream("META-INF/proguard/plaza-java-core.pro")

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = PlazaOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.elements()).isNotNull()
        assertThat(client.datasets()).isNotNull()
        assertThat(client.geocode()).isNotNull()
        assertThat(client.search()).isNotNull()
        assertThat(client.routing()).isNotNull()
        assertThat(client.elevation()).isNotNull()
        assertThat(client.mapMatch()).isNotNull()
        assertThat(client.optimize()).isNotNull()
        assertThat(client.query()).isNotNull()
        assertThat(client.tiles()).isNotNull()
    }

    @Test
    fun batchRequestRoundtrip() {
        val jsonMapper = jsonMapper()
        val batchRequest =
            BatchRequest.builder()
                .addElement(
                    BatchRequest.Element.builder()
                        .id(21154906L)
                        .type(BatchRequest.Element.Type.NODE)
                        .build()
                )
                .addElement(
                    BatchRequest.Element.builder()
                        .id(4589123L)
                        .type(BatchRequest.Element.Type.WAY)
                        .build()
                )
                .build()

        val roundtrippedBatchRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchRequest),
                jacksonTypeRef<BatchRequest>(),
            )

        assertThat(roundtrippedBatchRequest).isEqualTo(batchRequest)
    }

    @Test
    fun optimizeResultRoundtrip() {
        val jsonMapper = jsonMapper()
        val optimizeResult =
            OptimizeResult.ofCompleted(
                OptimizeCompletedResult.builder()
                    .addFeature(
                        OptimizeCompletedResult.Feature.builder()
                            .geometry(
                                GeoJsonGeometry.builder()
                                    .coordinatesOfPoint(listOf(2.3522, 48.8566))
                                    .type(GeoJsonGeometry.Type.POINT)
                                    .build()
                            )
                            .properties(
                                OptimizeCompletedResult.Feature.Properties.builder()
                                    .costS(0.0)
                                    .cumulativeCostS(0.0)
                                    .waypointIndex(0L)
                                    .build()
                            )
                            .type(OptimizeCompletedResult.Feature.Type.FEATURE)
                            .build()
                    )
                    .optimization("optimization")
                    .roundtrip(true)
                    .totalCostS(0.0)
                    .type(OptimizeCompletedResult.Type.FEATURE_COLLECTION)
                    .build()
            )

        val roundtrippedOptimizeResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(optimizeResult),
                jacksonTypeRef<OptimizeResult>(),
            )

        assertThat(roundtrippedOptimizeResult).isEqualTo(optimizeResult)
    }
}
