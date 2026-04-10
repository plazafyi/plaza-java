// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.plazafyi.core.ExcludeMissing
import com.plazafyi.core.JsonField
import com.plazafyi.core.JsonMissing
import com.plazafyi.core.JsonValue
import com.plazafyi.core.checkRequired
import com.plazafyi.errors.PlazaInvalidDataException
import com.plazafyi.models.LineStringGeometry
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/**
 * Request body for elevation profile along a path. Provide a GeoJSON LineString geometry defining
 * the path.
 */
class ElevationProfileRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val geometry: JsonField<LineStringGeometry>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("geometry")
        @ExcludeMissing
        geometry: JsonField<LineStringGeometry> = JsonMissing.of()
    ) : this(geometry, mutableMapOf())

    /**
     * GeoJSON LineString geometry per RFC 7946. An ordered sequence of two or more positions.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun geometry(): LineStringGeometry = geometry.getRequired("geometry")

    /**
     * Returns the raw JSON value of [geometry].
     *
     * Unlike [geometry], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("geometry")
    @ExcludeMissing
    fun _geometry(): JsonField<LineStringGeometry> = geometry

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
         * Returns a mutable builder for constructing an instance of [ElevationProfileRequest].
         *
         * The following fields are required:
         * ```java
         * .geometry()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ElevationProfileRequest]. */
    class Builder internal constructor() {

        private var geometry: JsonField<LineStringGeometry>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(elevationProfileRequest: ElevationProfileRequest) = apply {
            geometry = elevationProfileRequest.geometry
            additionalProperties = elevationProfileRequest.additionalProperties.toMutableMap()
        }

        /**
         * GeoJSON LineString geometry per RFC 7946. An ordered sequence of two or more positions.
         */
        fun geometry(geometry: LineStringGeometry) = geometry(JsonField.of(geometry))

        /**
         * Sets [Builder.geometry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.geometry] with a well-typed [LineStringGeometry] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun geometry(geometry: JsonField<LineStringGeometry>) = apply { this.geometry = geometry }

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
         * Returns an immutable instance of [ElevationProfileRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .geometry()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ElevationProfileRequest =
            ElevationProfileRequest(
                checkRequired("geometry", geometry),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ElevationProfileRequest = apply {
        if (validated) {
            return@apply
        }

        geometry().validate()
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
    @JvmSynthetic internal fun validity(): Int = (geometry.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ElevationProfileRequest &&
            geometry == other.geometry &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(geometry, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ElevationProfileRequest{geometry=$geometry, additionalProperties=$additionalProperties}"
}
