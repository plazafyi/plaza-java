// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

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

/** GeoJSON LineString Feature with 3D coordinates representing an elevation profile */
class ElevationProfileResult
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
         * Returns a mutable builder for constructing an instance of [ElevationProfileResult].
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

    /** A builder for [ElevationProfileResult]. */
    class Builder internal constructor() {

        private var geometry: JsonField<GeoJsonGeometry>? = null
        private var properties: JsonField<Properties>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(elevationProfileResult: ElevationProfileResult) = apply {
            geometry = elevationProfileResult.geometry
            properties = elevationProfileResult.properties
            type = elevationProfileResult.type
            additionalProperties = elevationProfileResult.additionalProperties.toMutableMap()
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
         * Returns an immutable instance of [ElevationProfileResult].
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
        fun build(): ElevationProfileResult =
            ElevationProfileResult(
                checkRequired("geometry", geometry),
                checkRequired("properties", properties),
                checkRequired("type", type),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ElevationProfileResult = apply {
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
        private val avgElevationM: JsonField<Double>,
        private val maxElevationM: JsonField<Double>,
        private val minElevationM: JsonField<Double>,
        private val totalAscentM: JsonField<Double>,
        private val totalDescentM: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("avg_elevation_m")
            @ExcludeMissing
            avgElevationM: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("max_elevation_m")
            @ExcludeMissing
            maxElevationM: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("min_elevation_m")
            @ExcludeMissing
            minElevationM: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("total_ascent_m")
            @ExcludeMissing
            totalAscentM: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("total_descent_m")
            @ExcludeMissing
            totalDescentM: JsonField<Double> = JsonMissing.of(),
        ) : this(
            avgElevationM,
            maxElevationM,
            minElevationM,
            totalAscentM,
            totalDescentM,
            mutableMapOf(),
        )

        /**
         * Average elevation along profile
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun avgElevationM(): Optional<Double> = avgElevationM.getOptional("avg_elevation_m")

        /**
         * Maximum elevation along profile
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxElevationM(): Optional<Double> = maxElevationM.getOptional("max_elevation_m")

        /**
         * Minimum elevation along profile
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun minElevationM(): Optional<Double> = minElevationM.getOptional("min_elevation_m")

        /**
         * Total elevation gain in meters
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun totalAscentM(): Optional<Double> = totalAscentM.getOptional("total_ascent_m")

        /**
         * Total elevation loss in meters
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun totalDescentM(): Optional<Double> = totalDescentM.getOptional("total_descent_m")

        /**
         * Returns the raw JSON value of [avgElevationM].
         *
         * Unlike [avgElevationM], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("avg_elevation_m")
        @ExcludeMissing
        fun _avgElevationM(): JsonField<Double> = avgElevationM

        /**
         * Returns the raw JSON value of [maxElevationM].
         *
         * Unlike [maxElevationM], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("max_elevation_m")
        @ExcludeMissing
        fun _maxElevationM(): JsonField<Double> = maxElevationM

        /**
         * Returns the raw JSON value of [minElevationM].
         *
         * Unlike [minElevationM], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("min_elevation_m")
        @ExcludeMissing
        fun _minElevationM(): JsonField<Double> = minElevationM

        /**
         * Returns the raw JSON value of [totalAscentM].
         *
         * Unlike [totalAscentM], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("total_ascent_m")
        @ExcludeMissing
        fun _totalAscentM(): JsonField<Double> = totalAscentM

        /**
         * Returns the raw JSON value of [totalDescentM].
         *
         * Unlike [totalDescentM], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("total_descent_m")
        @ExcludeMissing
        fun _totalDescentM(): JsonField<Double> = totalDescentM

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

            private var avgElevationM: JsonField<Double> = JsonMissing.of()
            private var maxElevationM: JsonField<Double> = JsonMissing.of()
            private var minElevationM: JsonField<Double> = JsonMissing.of()
            private var totalAscentM: JsonField<Double> = JsonMissing.of()
            private var totalDescentM: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(properties: Properties) = apply {
                avgElevationM = properties.avgElevationM
                maxElevationM = properties.maxElevationM
                minElevationM = properties.minElevationM
                totalAscentM = properties.totalAscentM
                totalDescentM = properties.totalDescentM
                additionalProperties = properties.additionalProperties.toMutableMap()
            }

            /** Average elevation along profile */
            fun avgElevationM(avgElevationM: Double) = avgElevationM(JsonField.of(avgElevationM))

            /**
             * Sets [Builder.avgElevationM] to an arbitrary JSON value.
             *
             * You should usually call [Builder.avgElevationM] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun avgElevationM(avgElevationM: JsonField<Double>) = apply {
                this.avgElevationM = avgElevationM
            }

            /** Maximum elevation along profile */
            fun maxElevationM(maxElevationM: Double) = maxElevationM(JsonField.of(maxElevationM))

            /**
             * Sets [Builder.maxElevationM] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxElevationM] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxElevationM(maxElevationM: JsonField<Double>) = apply {
                this.maxElevationM = maxElevationM
            }

            /** Minimum elevation along profile */
            fun minElevationM(minElevationM: Double) = minElevationM(JsonField.of(minElevationM))

            /**
             * Sets [Builder.minElevationM] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minElevationM] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minElevationM(minElevationM: JsonField<Double>) = apply {
                this.minElevationM = minElevationM
            }

            /** Total elevation gain in meters */
            fun totalAscentM(totalAscentM: Double) = totalAscentM(JsonField.of(totalAscentM))

            /**
             * Sets [Builder.totalAscentM] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalAscentM] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalAscentM(totalAscentM: JsonField<Double>) = apply {
                this.totalAscentM = totalAscentM
            }

            /** Total elevation loss in meters */
            fun totalDescentM(totalDescentM: Double) = totalDescentM(JsonField.of(totalDescentM))

            /**
             * Sets [Builder.totalDescentM] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalDescentM] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalDescentM(totalDescentM: JsonField<Double>) = apply {
                this.totalDescentM = totalDescentM
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
             * Returns an immutable instance of [Properties].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Properties =
                Properties(
                    avgElevationM,
                    maxElevationM,
                    minElevationM,
                    totalAscentM,
                    totalDescentM,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Properties = apply {
            if (validated) {
                return@apply
            }

            avgElevationM()
            maxElevationM()
            minElevationM()
            totalAscentM()
            totalDescentM()
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
            (if (avgElevationM.asKnown().isPresent) 1 else 0) +
                (if (maxElevationM.asKnown().isPresent) 1 else 0) +
                (if (minElevationM.asKnown().isPresent) 1 else 0) +
                (if (totalAscentM.asKnown().isPresent) 1 else 0) +
                (if (totalDescentM.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Properties &&
                avgElevationM == other.avgElevationM &&
                maxElevationM == other.maxElevationM &&
                minElevationM == other.minElevationM &&
                totalAscentM == other.totalAscentM &&
                totalDescentM == other.totalDescentM &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                avgElevationM,
                maxElevationM,
                minElevationM,
                totalAscentM,
                totalDescentM,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Properties{avgElevationM=$avgElevationM, maxElevationM=$maxElevationM, minElevationM=$minElevationM, totalAscentM=$totalAscentM, totalDescentM=$totalDescentM, additionalProperties=$additionalProperties}"
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

        return other is ElevationProfileResult &&
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
        "ElevationProfileResult{geometry=$geometry, properties=$properties, type=$type, additionalProperties=$additionalProperties}"
}
