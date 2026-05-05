// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.mapmatch

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
import com.plazafyi.models.LineStringGeometry
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * GPS trace to snap to the road network. Provide a GeoJSON LineString geometry representing the GPS
 * trace.
 */
class MapMatchRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val geometry: JsonField<LineStringGeometry>,
    private val radiuses: JsonField<List<Double>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("geometry")
        @ExcludeMissing
        geometry: JsonField<LineStringGeometry> = JsonMissing.of(),
        @JsonProperty("radiuses")
        @ExcludeMissing
        radiuses: JsonField<List<Double>> = JsonMissing.of(),
    ) : this(geometry, radiuses, mutableMapOf())

    /**
     * GeoJSON LineString geometry per RFC 7946. An ordered sequence of two or more positions.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun geometry(): LineStringGeometry = geometry.getRequired("geometry")

    /**
     * Search radius per coordinate in meters. Must have the same length as the geometry coordinates
     * or be omitted entirely. Default: 50m per point.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun radiuses(): Optional<List<Double>> = radiuses.getOptional("radiuses")

    /**
     * Returns the raw JSON value of [geometry].
     *
     * Unlike [geometry], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("geometry")
    @ExcludeMissing
    fun _geometry(): JsonField<LineStringGeometry> = geometry

    /**
     * Returns the raw JSON value of [radiuses].
     *
     * Unlike [radiuses], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("radiuses") @ExcludeMissing fun _radiuses(): JsonField<List<Double>> = radiuses

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
         * Returns a mutable builder for constructing an instance of [MapMatchRequest].
         *
         * The following fields are required:
         * ```java
         * .geometry()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MapMatchRequest]. */
    class Builder internal constructor() {

        private var geometry: JsonField<LineStringGeometry>? = null
        private var radiuses: JsonField<MutableList<Double>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(mapMatchRequest: MapMatchRequest) = apply {
            geometry = mapMatchRequest.geometry
            radiuses = mapMatchRequest.radiuses.map { it.toMutableList() }
            additionalProperties = mapMatchRequest.additionalProperties.toMutableMap()
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

        /**
         * Search radius per coordinate in meters. Must have the same length as the geometry
         * coordinates or be omitted entirely. Default: 50m per point.
         */
        fun radiuses(radiuses: List<Double>?) = radiuses(JsonField.ofNullable(radiuses))

        /** Alias for calling [Builder.radiuses] with `radiuses.orElse(null)`. */
        fun radiuses(radiuses: Optional<List<Double>>) = radiuses(radiuses.getOrNull())

        /**
         * Sets [Builder.radiuses] to an arbitrary JSON value.
         *
         * You should usually call [Builder.radiuses] with a well-typed `List<Double>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun radiuses(radiuses: JsonField<List<Double>>) = apply {
            this.radiuses = radiuses.map { it.toMutableList() }
        }

        /**
         * Adds a single [Double] to [radiuses].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRadius(radius: Double) = apply {
            radiuses =
                (radiuses ?: JsonField.of(mutableListOf())).also {
                    checkKnown("radiuses", it).add(radius)
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
         * Returns an immutable instance of [MapMatchRequest].
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
        fun build(): MapMatchRequest =
            MapMatchRequest(
                checkRequired("geometry", geometry),
                (radiuses ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws PlazaInvalidDataException if any value type in this object doesn't match its expected
     *   type.
     */
    fun validate(): MapMatchRequest = apply {
        if (validated) {
            return@apply
        }

        geometry().validate()
        radiuses()
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
        (geometry.asKnown().getOrNull()?.validity() ?: 0) +
            (radiuses.asKnown().getOrNull()?.size ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MapMatchRequest &&
            geometry == other.geometry &&
            radiuses == other.radiuses &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(geometry, radiuses, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MapMatchRequest{geometry=$geometry, radiuses=$radiuses, additionalProperties=$additionalProperties}"
}
