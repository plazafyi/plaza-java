// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.datasets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
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
                .name("name")
                .slug("slug")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .attribution("attribution")
                .description("description")
                .license("license")
                .sourceUrl("source_url")
                .build()

        assertThat(dataset.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(dataset.insertedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(dataset.name()).isEqualTo("name")
        assertThat(dataset.slug()).isEqualTo("slug")
        assertThat(dataset.updatedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(dataset.attribution()).contains("attribution")
        assertThat(dataset.description()).contains("description")
        assertThat(dataset.license()).contains("license")
        assertThat(dataset.sourceUrl()).contains("source_url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val dataset =
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

        val roundtrippedDataset =
            jsonMapper.readValue(jsonMapper.writeValueAsString(dataset), jacksonTypeRef<Dataset>())

        assertThat(roundtrippedDataset).isEqualTo(dataset)
    }
}
