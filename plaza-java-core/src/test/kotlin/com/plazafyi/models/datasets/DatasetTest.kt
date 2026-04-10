// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.datasets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DatasetTest {

    @Test
    fun create() {
        val dataset =
            Dataset.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .insertedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .name("NYC Bike Lanes")
                .scope(Dataset.Scope.PLAZA)
                .slug("nyc-bike-lanes")
                .status(Dataset.Status.PENDING)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addressCount(0L)
                .attribution("attribution")
                .description("description")
                .edgeCount(0L)
                .errorMessage("error_message")
                .featureCount(0L)
                .license("license")
                .schemaDefinition(JsonValue.from(mapOf<String, Any>()))
                .sourceFormat("source_format")
                .sourceUrl("https://example.com")
                .storageBytes(0L)
                .strictMode(true)
                .build()

        assertThat(dataset.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(dataset.insertedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(dataset.name()).isEqualTo("NYC Bike Lanes")
        assertThat(dataset.scope()).isEqualTo(Dataset.Scope.PLAZA)
        assertThat(dataset.slug()).isEqualTo("nyc-bike-lanes")
        assertThat(dataset.status()).isEqualTo(Dataset.Status.PENDING)
        assertThat(dataset.updatedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(dataset.addressCount()).contains(0L)
        assertThat(dataset.attribution()).contains("attribution")
        assertThat(dataset.description()).contains("description")
        assertThat(dataset.edgeCount()).contains(0L)
        assertThat(dataset.errorMessage()).contains("error_message")
        assertThat(dataset.featureCount()).contains(0L)
        assertThat(dataset.license()).contains("license")
        assertThat(dataset._schemaDefinition()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(dataset.sourceFormat()).contains("source_format")
        assertThat(dataset.sourceUrl()).contains("https://example.com")
        assertThat(dataset.storageBytes()).contains(0L)
        assertThat(dataset.strictMode()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val dataset =
            Dataset.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .insertedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .name("NYC Bike Lanes")
                .scope(Dataset.Scope.PLAZA)
                .slug("nyc-bike-lanes")
                .status(Dataset.Status.PENDING)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addressCount(0L)
                .attribution("attribution")
                .description("description")
                .edgeCount(0L)
                .errorMessage("error_message")
                .featureCount(0L)
                .license("license")
                .schemaDefinition(JsonValue.from(mapOf<String, Any>()))
                .sourceFormat("source_format")
                .sourceUrl("https://example.com")
                .storageBytes(0L)
                .strictMode(true)
                .build()

        val roundtrippedDataset =
            jsonMapper.readValue(jsonMapper.writeValueAsString(dataset), jacksonTypeRef<Dataset>())

        assertThat(roundtrippedDataset).isEqualTo(dataset)
    }
}
