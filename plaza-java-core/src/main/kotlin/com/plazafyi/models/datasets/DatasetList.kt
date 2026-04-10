// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.datasets

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

/** List of datasets visible to the authenticated user. */
class DatasetList
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val datasets: JsonField<List<Dataset>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("datasets")
        @ExcludeMissing
        datasets: JsonField<List<Dataset>> = JsonMissing.of()
    ) : this(datasets, mutableMapOf())

    /**
     * Array of dataset metadata objects
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun datasets(): List<Dataset> = datasets.getRequired("datasets")

    /**
     * Returns the raw JSON value of [datasets].
     *
     * Unlike [datasets], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("datasets") @ExcludeMissing fun _datasets(): JsonField<List<Dataset>> = datasets

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
         * Returns a mutable builder for constructing an instance of [DatasetList].
         *
         * The following fields are required:
         * ```java
         * .datasets()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DatasetList]. */
    class Builder internal constructor() {

        private var datasets: JsonField<MutableList<Dataset>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(datasetList: DatasetList) = apply {
            datasets = datasetList.datasets.map { it.toMutableList() }
            additionalProperties = datasetList.additionalProperties.toMutableMap()
        }

        /** Array of dataset metadata objects */
        fun datasets(datasets: List<Dataset>) = datasets(JsonField.of(datasets))

        /**
         * Sets [Builder.datasets] to an arbitrary JSON value.
         *
         * You should usually call [Builder.datasets] with a well-typed `List<Dataset>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun datasets(datasets: JsonField<List<Dataset>>) = apply {
            this.datasets = datasets.map { it.toMutableList() }
        }

        /**
         * Adds a single [Dataset] to [datasets].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDataset(dataset: Dataset) = apply {
            datasets =
                (datasets ?: JsonField.of(mutableListOf())).also {
                    checkKnown("datasets", it).add(dataset)
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
         * Returns an immutable instance of [DatasetList].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .datasets()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): DatasetList =
            DatasetList(
                checkRequired("datasets", datasets).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): DatasetList = apply {
        if (validated) {
            return@apply
        }

        datasets().forEach { it.validate() }
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
        (datasets.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DatasetList &&
            datasets == other.datasets &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(datasets, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DatasetList{datasets=$datasets, additionalProperties=$additionalProperties}"
}
