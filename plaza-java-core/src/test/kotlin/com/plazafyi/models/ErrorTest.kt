// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ErrorTest {

    @Test
    fun create() {
        val error =
            Error.builder()
                .error(
                    Error.InnerError.builder()
                        .code("code")
                        .message("message")
                        .details(JsonValue.from(mapOf<String, Any>()))
                        .build()
                )
                .build()

        assertThat(error.error())
            .isEqualTo(
                Error.InnerError.builder()
                    .code("code")
                    .message("message")
                    .details(JsonValue.from(mapOf<String, Any>()))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val error =
            Error.builder()
                .error(
                    Error.InnerError.builder()
                        .code("code")
                        .message("message")
                        .details(JsonValue.from(mapOf<String, Any>()))
                        .build()
                )
                .build()

        val roundtrippedError =
            jsonMapper.readValue(jsonMapper.writeValueAsString(error), jacksonTypeRef<Error>())

        assertThat(roundtrippedError).isEqualTo(error)
    }
}
