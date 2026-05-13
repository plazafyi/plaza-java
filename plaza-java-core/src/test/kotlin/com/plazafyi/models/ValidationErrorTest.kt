// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.JsonValue
import com.plazafyi.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ValidationErrorTest {

    @Test
    fun create() {
        val validationError =
            ValidationError.builder()
                .error(
                    ValidationError.Error.builder()
                        .code(ValidationError.Error.Code.VALIDATION_FAILED)
                        .message("message")
                        .details(
                            ValidationError.Error.Details.builder()
                                .putAdditionalProperty(
                                    "name",
                                    JsonValue.from(listOf("can't be blank")),
                                )
                                .putAdditionalProperty(
                                    "slug",
                                    JsonValue.from(listOf("has already been taken")),
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(validationError.error())
            .isEqualTo(
                ValidationError.Error.builder()
                    .code(ValidationError.Error.Code.VALIDATION_FAILED)
                    .message("message")
                    .details(
                        ValidationError.Error.Details.builder()
                            .putAdditionalProperty("name", JsonValue.from(listOf("can't be blank")))
                            .putAdditionalProperty(
                                "slug",
                                JsonValue.from(listOf("has already been taken")),
                            )
                            .build()
                    )
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val validationError =
            ValidationError.builder()
                .error(
                    ValidationError.Error.builder()
                        .code(ValidationError.Error.Code.VALIDATION_FAILED)
                        .message("message")
                        .details(
                            ValidationError.Error.Details.builder()
                                .putAdditionalProperty(
                                    "name",
                                    JsonValue.from(listOf("can't be blank")),
                                )
                                .putAdditionalProperty(
                                    "slug",
                                    JsonValue.from(listOf("has already been taken")),
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedValidationError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(validationError),
                jacksonTypeRef<ValidationError>(),
            )

        assertThat(roundtrippedValidationError).isEqualTo(validationError)
    }
}
