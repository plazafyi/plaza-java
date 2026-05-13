// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.datasets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DatasetListTest {

    @Test
    fun create() {
        val datasetList =
            DatasetList.builder()
                .addDataset(
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
                )
                .build()

        assertThat(datasetList.datasets())
            .containsExactly(
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val datasetList =
            DatasetList.builder()
                .addDataset(
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
                )
                .build()

        val roundtrippedDatasetList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(datasetList),
                jacksonTypeRef<DatasetList>(),
            )

        assertThat(roundtrippedDatasetList).isEqualTo(datasetList)
    }
}
