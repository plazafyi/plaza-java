// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.client.okhttp.PlazaOkHttpClient
import com.plazafyi.core.jsonMapper
import com.plazafyi.models.Geometry
import com.plazafyi.models.PointGeometry
import com.plazafyi.models.features.BatchRequest
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
        assertThat(client.features()).isNotNull()
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
    fun geometryRoundtrip() {
        val jsonMapper = jsonMapper()
        val geometry =
            Geometry.ofPoint(
                PointGeometry.builder()
                    .addCoordinate(2.3522)
                    .addCoordinate(48.8566)
                    .type(PointGeometry.Type.POINT)
                    .build()
            )

        val roundtrippedGeometry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(geometry),
                jacksonTypeRef<Geometry>(),
            )

        assertThat(roundtrippedGeometry).isEqualTo(geometry)
    }
}
