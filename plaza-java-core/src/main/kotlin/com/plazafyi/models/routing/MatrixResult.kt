// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.plazafyi.core.ExcludeMissing
import com.plazafyi.core.JsonField
import com.plazafyi.core.JsonMissing
import com.plazafyi.core.JsonValue
import com.plazafyi.core.checkKnown
import com.plazafyi.core.checkRequired
import com.plazafyi.core.toImmutable
import com.plazafyi.errors.PlazaInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class MatrixResult
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val distances: JsonField<List<List<Double?>>>,
    private val durations: JsonField<List<List<Double?>>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("distances")
        @ExcludeMissing
        distances: JsonField<List<List<Double?>>> = JsonMissing.of(),
        @JsonProperty("durations")
        @ExcludeMissing
        durations: JsonField<List<List<Double?>>> = JsonMissing.of(),
    ) : this(distances, durations, mutableMapOf())

    /**
     * Distance matrix (meters), origins x destinations
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun distances(): List<List<Double?>> = distances.getRequired("distances")

    /**
     * Duration matrix (seconds), origins x destinations
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun durations(): List<List<Double?>> = durations.getRequired("durations")

    /**
     * Returns the raw JSON value of [distances].
     *
     * Unlike [distances], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("distances")
    @ExcludeMissing
    fun _distances(): JsonField<List<List<Double?>>> = distances

    /**
     * Returns the raw JSON value of [durations].
     *
     * Unlike [durations], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("durations")
    @ExcludeMissing
    fun _durations(): JsonField<List<List<Double?>>> = durations

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MatrixResult].
         *
         * The following fields are required:
         * ```java
         * .distances()
         * .durations()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MatrixResult]. */
    class Builder internal constructor() {

        private var distances: JsonField<MutableList<List<Double?>>>? = null
        private var durations: JsonField<MutableList<List<Double?>>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(matrixResult: MatrixResult) = apply {
            distances = matrixResult.distances.map { it.toMutableList() }
            durations = matrixResult.durations.map { it.toMutableList() }
            additionalProperties = matrixResult.additionalProperties.toMutableMap()
        }

        /** Distance matrix (meters), origins x destinations */
        fun distances(distances: List<List<Double?>>) = distances(JsonField.of(distances))

        /**
         * Sets [Builder.distances] to an arbitrary JSON value.
         *
         * You should usually call [Builder.distances] with a well-typed `List<List<Double?>>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun distances(distances: JsonField<List<List<Double?>>>) = apply {
            this.distances = distances.map { it.toMutableList() }
        }

        /**
         * Adds a single [List<Double?>] to [distances].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDistance(distance: List<Double?>) = apply {
            distances =
                (distances ?: JsonField.of(mutableListOf())).also {
                    checkKnown("distances", it).add(distance)
                }
        }

        /** Duration matrix (seconds), origins x destinations */
        fun durations(durations: List<List<Double?>>) = durations(JsonField.of(durations))

        /**
         * Sets [Builder.durations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.durations] with a well-typed `List<List<Double?>>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun durations(durations: JsonField<List<List<Double?>>>) = apply {
            this.durations = durations.map { it.toMutableList() }
        }

        /**
         * Adds a single [List<Double?>] to [durations].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDuration(duration: List<Double?>) = apply {
            durations =
                (durations ?: JsonField.of(mutableListOf())).also {
                    checkKnown("durations", it).add(duration)
                }
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [MatrixResult].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .distances()
         * .durations()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MatrixResult =
            MatrixResult(
                checkRequired("distances", distances).map { it.toImmutable() },
                checkRequired("durations", durations).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MatrixResult = apply {
        if (validated) {
            return@apply
        }

        distances()
        durations()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: PlazaInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (distances.asKnown().getOrNull()?.sumOf {
            it.sumOf { (if (it == null) 0 else 1).toInt() }.toInt()
        } ?: 0) +
            (durations.asKnown().getOrNull()?.sumOf {
                it.sumOf { (if (it == null) 0 else 1).toInt() }.toInt()
            } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MatrixResult &&
            distances == other.distances &&
            durations == other.durations &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(distances, durations, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MatrixResult{distances=$distances, durations=$durations, additionalProperties=$additionalProperties}"
}
