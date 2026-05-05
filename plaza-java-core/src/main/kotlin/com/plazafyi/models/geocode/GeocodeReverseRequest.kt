// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

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
import com.plazafyi.models.PointGeometry
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Request body for reverse geocoding. Converts coordinates to addresses or place names. */
class GeocodeReverseRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val geometry: JsonField<PointGeometry>,
    private val lang: JsonField<String>,
    private val limit: JsonField<Long>,
    private val radius: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("geometry")
        @ExcludeMissing
        geometry: JsonField<PointGeometry> = JsonMissing.of(),
        @JsonProperty("lang") @ExcludeMissing lang: JsonField<String> = JsonMissing.of(),
        @JsonProperty("limit") @ExcludeMissing limit: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("radius") @ExcludeMissing radius: JsonField<Double> = JsonMissing.of(),
    ) : this(geometry, lang, limit, radius, mutableMapOf())

    /**
     * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order. Optional
     * third element is altitude in meters.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun geometry(): PointGeometry = geometry.getRequired("geometry")

    /**
     * Preferred response language (ISO 639-1)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lang(): Optional<String> = lang.getOptional("lang")

    /**
     * Maximum number of results (default: 1, max: 50)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun limit(): Optional<Long> = limit.getOptional("limit")

    /**
     * Search radius in meters (default: 100)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun radius(): Optional<Double> = radius.getOptional("radius")

    /**
     * Returns the raw JSON value of [geometry].
     *
     * Unlike [geometry], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("geometry") @ExcludeMissing fun _geometry(): JsonField<PointGeometry> = geometry

    /**
     * Returns the raw JSON value of [lang].
     *
     * Unlike [lang], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lang") @ExcludeMissing fun _lang(): JsonField<String> = lang

    /**
     * Returns the raw JSON value of [limit].
     *
     * Unlike [limit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("limit") @ExcludeMissing fun _limit(): JsonField<Long> = limit

    /**
     * Returns the raw JSON value of [radius].
     *
     * Unlike [radius], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("radius") @ExcludeMissing fun _radius(): JsonField<Double> = radius

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
         * Returns a mutable builder for constructing an instance of [GeocodeReverseRequest].
         *
         * The following fields are required:
         * ```java
         * .geometry()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GeocodeReverseRequest]. */
    class Builder internal constructor() {

        private var geometry: JsonField<PointGeometry>? = null
        private var lang: JsonField<String> = JsonMissing.of()
        private var limit: JsonField<Long> = JsonMissing.of()
        private var radius: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(geocodeReverseRequest: GeocodeReverseRequest) = apply {
            geometry = geocodeReverseRequest.geometry
            lang = geocodeReverseRequest.lang
            limit = geocodeReverseRequest.limit
            radius = geocodeReverseRequest.radius
            additionalProperties = geocodeReverseRequest.additionalProperties.toMutableMap()
        }

        /**
         * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order.
         * Optional third element is altitude in meters.
         */
        fun geometry(geometry: PointGeometry) = geometry(JsonField.of(geometry))

        /**
         * Sets [Builder.geometry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.geometry] with a well-typed [PointGeometry] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun geometry(geometry: JsonField<PointGeometry>) = apply { this.geometry = geometry }

        /** Preferred response language (ISO 639-1) */
        fun lang(lang: String?) = lang(JsonField.ofNullable(lang))

        /** Alias for calling [Builder.lang] with `lang.orElse(null)`. */
        fun lang(lang: Optional<String>) = lang(lang.getOrNull())

        /**
         * Sets [Builder.lang] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lang] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun lang(lang: JsonField<String>) = apply { this.lang = lang }

        /** Maximum number of results (default: 1, max: 50) */
        fun limit(limit: Long?) = limit(JsonField.ofNullable(limit))

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /**
         * Sets [Builder.limit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.limit] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun limit(limit: JsonField<Long>) = apply { this.limit = limit }

        /** Search radius in meters (default: 100) */
        fun radius(radius: Double?) = radius(JsonField.ofNullable(radius))

        /**
         * Alias for [Builder.radius].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun radius(radius: Double) = radius(radius as Double?)

        /** Alias for calling [Builder.radius] with `radius.orElse(null)`. */
        fun radius(radius: Optional<Double>) = radius(radius.getOrNull())

        /**
         * Sets [Builder.radius] to an arbitrary JSON value.
         *
         * You should usually call [Builder.radius] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun radius(radius: JsonField<Double>) = apply { this.radius = radius }

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
         * Returns an immutable instance of [GeocodeReverseRequest].
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
        fun build(): GeocodeReverseRequest =
            GeocodeReverseRequest(
                checkRequired("geometry", geometry),
                lang,
                limit,
                radius,
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
    fun validate(): GeocodeReverseRequest = apply {
        if (validated) {
            return@apply
        }

        geometry().validate()
        lang()
        limit()
        radius()
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
            (if (lang.asKnown().isPresent) 1 else 0) +
            (if (limit.asKnown().isPresent) 1 else 0) +
            (if (radius.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is GeocodeReverseRequest &&
            geometry == other.geometry &&
            lang == other.lang &&
            limit == other.limit &&
            radius == other.radius &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(geometry, lang, limit, radius, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "GeocodeReverseRequest{geometry=$geometry, lang=$lang, limit=$limit, radius=$radius, additionalProperties=$additionalProperties}"
}
