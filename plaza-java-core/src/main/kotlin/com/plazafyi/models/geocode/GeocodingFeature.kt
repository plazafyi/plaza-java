// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.plazafyi.core.Enum
import com.plazafyi.core.ExcludeMissing
import com.plazafyi.core.JsonField
import com.plazafyi.core.JsonMissing
import com.plazafyi.core.JsonValue
import com.plazafyi.core.checkRequired
import com.plazafyi.errors.PlazaInvalidDataException
import com.plazafyi.models.GeoJsonGeometry
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class GeocodingFeature
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val geometry: JsonField<GeoJsonGeometry>,
    private val properties: JsonField<Properties>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("geometry")
        @ExcludeMissing
        geometry: JsonField<GeoJsonGeometry> = JsonMissing.of(),
        @JsonProperty("properties")
        @ExcludeMissing
        properties: JsonField<Properties> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(geometry, properties, type, mutableMapOf())

    /**
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun geometry(): GeoJsonGeometry = geometry.getRequired("geometry")

    /**
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun properties(): Properties = properties.getRequired("properties")

    /**
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Returns the raw JSON value of [geometry].
     *
     * Unlike [geometry], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("geometry") @ExcludeMissing fun _geometry(): JsonField<GeoJsonGeometry> = geometry

    /**
     * Returns the raw JSON value of [properties].
     *
     * Unlike [properties], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("properties")
    @ExcludeMissing
    fun _properties(): JsonField<Properties> = properties

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
         * Returns a mutable builder for constructing an instance of [GeocodingFeature].
         *
         * The following fields are required:
         * ```java
         * .geometry()
         * .properties()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GeocodingFeature]. */
    class Builder internal constructor() {

        private var geometry: JsonField<GeoJsonGeometry>? = null
        private var properties: JsonField<Properties>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(geocodingFeature: GeocodingFeature) = apply {
            geometry = geocodingFeature.geometry
            properties = geocodingFeature.properties
            type = geocodingFeature.type
            additionalProperties = geocodingFeature.additionalProperties.toMutableMap()
        }

        fun geometry(geometry: GeoJsonGeometry) = geometry(JsonField.of(geometry))

        /**
         * Sets [Builder.geometry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.geometry] with a well-typed [GeoJsonGeometry] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun geometry(geometry: JsonField<GeoJsonGeometry>) = apply { this.geometry = geometry }

        fun properties(properties: Properties) = properties(JsonField.of(properties))

        /**
         * Sets [Builder.properties] to an arbitrary JSON value.
         *
         * You should usually call [Builder.properties] with a well-typed [Properties] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun properties(properties: JsonField<Properties>) = apply { this.properties = properties }

        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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
         * Returns an immutable instance of [GeocodingFeature].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .geometry()
         * .properties()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): GeocodingFeature =
            GeocodingFeature(
                checkRequired("geometry", geometry),
                checkRequired("properties", properties),
                checkRequired("type", type),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): GeocodingFeature = apply {
        if (validated) {
            return@apply
        }

        geometry().validate()
        properties().validate()
        type().validate()
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
            (properties.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0)

    class Properties
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val countryCode: JsonField<String>,
        private val displayName: JsonField<String>,
        private val distanceM: JsonField<Double>,
        private val osmId: JsonField<Long>,
        private val osmType: JsonField<String>,
        private val score: JsonField<Double>,
        private val source: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("country_code")
            @ExcludeMissing
            countryCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("display_name")
            @ExcludeMissing
            displayName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("distance_m")
            @ExcludeMissing
            distanceM: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("osm_id") @ExcludeMissing osmId: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("osm_type") @ExcludeMissing osmType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("score") @ExcludeMissing score: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
        ) : this(countryCode, displayName, distanceM, osmId, osmType, score, source, mutableMapOf())

        /**
         * ISO 3166-1 alpha-2 country code
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun countryCode(): Optional<String> = countryCode.getOptional("country_code")

        /**
         * Formatted address or place name
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun displayName(): Optional<String> = displayName.getOptional("display_name")

        /**
         * Distance in meters
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun distanceM(): Optional<Double> = distanceM.getOptional("distance_m")

        /**
         * OpenStreetMap ID
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun osmId(): Optional<Long> = osmId.getOptional("osm_id")

        /**
         * OSM element type
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun osmType(): Optional<String> = osmType.getOptional("osm_type")

        /**
         * Match confidence score
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun score(): Optional<Double> = score.getOptional("score")

        /**
         * Result source (address, place, interpolation)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun source(): Optional<String> = source.getOptional("source")

        /**
         * Returns the raw JSON value of [countryCode].
         *
         * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("country_code")
        @ExcludeMissing
        fun _countryCode(): JsonField<String> = countryCode

        /**
         * Returns the raw JSON value of [displayName].
         *
         * Unlike [displayName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("display_name")
        @ExcludeMissing
        fun _displayName(): JsonField<String> = displayName

        /**
         * Returns the raw JSON value of [distanceM].
         *
         * Unlike [distanceM], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("distance_m") @ExcludeMissing fun _distanceM(): JsonField<Double> = distanceM

        /**
         * Returns the raw JSON value of [osmId].
         *
         * Unlike [osmId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("osm_id") @ExcludeMissing fun _osmId(): JsonField<Long> = osmId

        /**
         * Returns the raw JSON value of [osmType].
         *
         * Unlike [osmType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("osm_type") @ExcludeMissing fun _osmType(): JsonField<String> = osmType

        /**
         * Returns the raw JSON value of [score].
         *
         * Unlike [score], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Double> = score

        /**
         * Returns the raw JSON value of [source].
         *
         * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

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

            /** Returns a mutable builder for constructing an instance of [Properties]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Properties]. */
        class Builder internal constructor() {

            private var countryCode: JsonField<String> = JsonMissing.of()
            private var displayName: JsonField<String> = JsonMissing.of()
            private var distanceM: JsonField<Double> = JsonMissing.of()
            private var osmId: JsonField<Long> = JsonMissing.of()
            private var osmType: JsonField<String> = JsonMissing.of()
            private var score: JsonField<Double> = JsonMissing.of()
            private var source: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(properties: Properties) = apply {
                countryCode = properties.countryCode
                displayName = properties.displayName
                distanceM = properties.distanceM
                osmId = properties.osmId
                osmType = properties.osmType
                score = properties.score
                source = properties.source
                additionalProperties = properties.additionalProperties.toMutableMap()
            }

            /** ISO 3166-1 alpha-2 country code */
            fun countryCode(countryCode: String?) = countryCode(JsonField.ofNullable(countryCode))

            /** Alias for calling [Builder.countryCode] with `countryCode.orElse(null)`. */
            fun countryCode(countryCode: Optional<String>) = countryCode(countryCode.getOrNull())

            /**
             * Sets [Builder.countryCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.countryCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun countryCode(countryCode: JsonField<String>) = apply {
                this.countryCode = countryCode
            }

            /** Formatted address or place name */
            fun displayName(displayName: String) = displayName(JsonField.of(displayName))

            /**
             * Sets [Builder.displayName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.displayName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun displayName(displayName: JsonField<String>) = apply {
                this.displayName = displayName
            }

            /** Distance in meters */
            fun distanceM(distanceM: Double?) = distanceM(JsonField.ofNullable(distanceM))

            /**
             * Alias for [Builder.distanceM].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun distanceM(distanceM: Double) = distanceM(distanceM as Double?)

            /** Alias for calling [Builder.distanceM] with `distanceM.orElse(null)`. */
            fun distanceM(distanceM: Optional<Double>) = distanceM(distanceM.getOrNull())

            /**
             * Sets [Builder.distanceM] to an arbitrary JSON value.
             *
             * You should usually call [Builder.distanceM] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun distanceM(distanceM: JsonField<Double>) = apply { this.distanceM = distanceM }

            /** OpenStreetMap ID */
            fun osmId(osmId: Long?) = osmId(JsonField.ofNullable(osmId))

            /**
             * Alias for [Builder.osmId].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun osmId(osmId: Long) = osmId(osmId as Long?)

            /** Alias for calling [Builder.osmId] with `osmId.orElse(null)`. */
            fun osmId(osmId: Optional<Long>) = osmId(osmId.getOrNull())

            /**
             * Sets [Builder.osmId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.osmId] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun osmId(osmId: JsonField<Long>) = apply { this.osmId = osmId }

            /** OSM element type */
            fun osmType(osmType: String?) = osmType(JsonField.ofNullable(osmType))

            /** Alias for calling [Builder.osmType] with `osmType.orElse(null)`. */
            fun osmType(osmType: Optional<String>) = osmType(osmType.getOrNull())

            /**
             * Sets [Builder.osmType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.osmType] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun osmType(osmType: JsonField<String>) = apply { this.osmType = osmType }

            /** Match confidence score */
            fun score(score: Double?) = score(JsonField.ofNullable(score))

            /**
             * Alias for [Builder.score].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun score(score: Double) = score(score as Double?)

            /** Alias for calling [Builder.score] with `score.orElse(null)`. */
            fun score(score: Optional<Double>) = score(score.getOrNull())

            /**
             * Sets [Builder.score] to an arbitrary JSON value.
             *
             * You should usually call [Builder.score] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun score(score: JsonField<Double>) = apply { this.score = score }

            /** Result source (address, place, interpolation) */
            fun source(source: String?) = source(JsonField.ofNullable(source))

            /** Alias for calling [Builder.source] with `source.orElse(null)`. */
            fun source(source: Optional<String>) = source(source.getOrNull())

            /**
             * Sets [Builder.source] to an arbitrary JSON value.
             *
             * You should usually call [Builder.source] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun source(source: JsonField<String>) = apply { this.source = source }

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
             * Returns an immutable instance of [Properties].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Properties =
                Properties(
                    countryCode,
                    displayName,
                    distanceM,
                    osmId,
                    osmType,
                    score,
                    source,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Properties = apply {
            if (validated) {
                return@apply
            }

            countryCode()
            displayName()
            distanceM()
            osmId()
            osmType()
            score()
            source()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (countryCode.asKnown().isPresent) 1 else 0) +
                (if (displayName.asKnown().isPresent) 1 else 0) +
                (if (distanceM.asKnown().isPresent) 1 else 0) +
                (if (osmId.asKnown().isPresent) 1 else 0) +
                (if (osmType.asKnown().isPresent) 1 else 0) +
                (if (score.asKnown().isPresent) 1 else 0) +
                (if (source.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Properties &&
                countryCode == other.countryCode &&
                displayName == other.displayName &&
                distanceM == other.distanceM &&
                osmId == other.osmId &&
                osmType == other.osmType &&
                score == other.score &&
                source == other.source &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                countryCode,
                displayName,
                distanceM,
                osmId,
                osmType,
                score,
                source,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Properties{countryCode=$countryCode, displayName=$displayName, distanceM=$distanceM, osmId=$osmId, osmType=$osmType, score=$score, source=$source, additionalProperties=$additionalProperties}"
    }

    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val FEATURE = of("Feature")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            FEATURE
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            FEATURE,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                FEATURE -> Value.FEATURE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws PlazaInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                FEATURE -> Known.FEATURE
                else -> throw PlazaInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws PlazaInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { PlazaInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Type = apply {
            if (validated) {
                return@apply
            }

            known()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is GeocodingFeature &&
            geometry == other.geometry &&
            properties == other.properties &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(geometry, properties, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "GeocodingFeature{geometry=$geometry, properties=$properties, type=$type, additionalProperties=$additionalProperties}"
}
