// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.datasets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
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
                        .name("name")
                        .slug("slug")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .attribution("attribution")
                        .description("description")
                        .license("license")
                        .sourceUrl("source_url")
                        .build()
                )
                .build()

        assertThat(datasetList.datasets())
            .containsExactly(
                Dataset.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .insertedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .name("name")
                    .slug("slug")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .attribution("attribution")
                    .description("description")
                    .license("license")
                    .sourceUrl("source_url")
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
                        .name("name")
                        .slug("slug")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .attribution("attribution")
                        .description("description")
                        .license("license")
                        .sourceUrl("source_url")
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
