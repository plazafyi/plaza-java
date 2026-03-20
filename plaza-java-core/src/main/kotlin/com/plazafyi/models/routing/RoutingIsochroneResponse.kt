// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.plazafyi.core.Enum
import com.plazafyi.core.ExcludeMissing
import com.plazafyi.core.JsonField
import com.plazafyi.core.JsonMissing
import com.plazafyi.core.JsonValue
import com.plazafyi.core.checkKnown
import com.plazafyi.core.toImmutable
import com.plazafyi.errors.PlazaInvalidDataException
import com.plazafyi.models.GeoJsonFeature
import com.plazafyi.models.GeoJsonGeometry
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * GeoJSON Feature or FeatureCollection representing isochrone polygons — areas reachable within the
 * specified travel time(s). Single time value returns a Feature; comma-separated times return a
 * FeatureCollection with one polygon per contour.
 */
class RoutingIsochroneResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val features: JsonField<List<GeoJsonFeature>>,
    private val geometry: JsonField<GeoJsonGeometry>,
    private val properties: JsonField<Properties>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("features")
        @ExcludeMissing
        features: JsonField<List<GeoJsonFeature>> = JsonMissing.of(),
        @JsonProperty("geometry")
        @ExcludeMissing
        geometry: JsonField<GeoJsonGeometry> = JsonMissing.of(),
        @JsonProperty("properties")
        @ExcludeMissing
        properties: JsonField<Properties> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(features, geometry, properties, type, mutableMapOf())

    /**
     * Array of isochrone polygon Features (multi-contour only)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun features(): Optional<List<GeoJsonFeature>> = features.getOptional("features")

    /**
     * GeoJSON Geometry object per RFC 7946. Coordinates use [longitude, latitude] order. 3D
     * coordinates [lng, lat, elevation] are used for elevation endpoints.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun geometry(): Optional<GeoJsonGeometry> = geometry.getOptional("geometry")

    /**
     * Isochrone metadata
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun properties(): Optional<Properties> = properties.getOptional("properties")

    /**
     * `Feature` for single contour, `FeatureCollection` for multiple contours
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun type(): Optional<Type> = type.getOptional("type")

    /**
     * Returns the raw JSON value of [features].
     *
     * Unlike [features], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("features")
    @ExcludeMissing
    fun _features(): JsonField<List<GeoJsonFeature>> = features

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

        /** Returns a mutable builder for constructing an instance of [RoutingIsochroneResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RoutingIsochroneResponse]. */
    class Builder internal constructor() {

        private var features: JsonField<MutableList<GeoJsonFeature>>? = null
        private var geometry: JsonField<GeoJsonGeometry> = JsonMissing.of()
        private var properties: JsonField<Properties> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(routingIsochroneResponse: RoutingIsochroneResponse) = apply {
            features = routingIsochroneResponse.features.map { it.toMutableList() }
            geometry = routingIsochroneResponse.geometry
            properties = routingIsochroneResponse.properties
            type = routingIsochroneResponse.type
            additionalProperties = routingIsochroneResponse.additionalProperties.toMutableMap()
        }

        /** Array of isochrone polygon Features (multi-contour only) */
        fun features(features: List<GeoJsonFeature>?) = features(JsonField.ofNullable(features))

        /** Alias for calling [Builder.features] with `features.orElse(null)`. */
        fun features(features: Optional<List<GeoJsonFeature>>) = features(features.getOrNull())

        /**
         * Sets [Builder.features] to an arbitrary JSON value.
         *
         * You should usually call [Builder.features] with a well-typed `List<GeoJsonFeature>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun features(features: JsonField<List<GeoJsonFeature>>) = apply {
            this.features = features.map { it.toMutableList() }
        }

        /**
         * Adds a single [GeoJsonFeature] to [features].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFeature(feature: GeoJsonFeature) = apply {
            features =
                (features ?: JsonField.of(mutableListOf())).also {
                    checkKnown("features", it).add(feature)
                }
        }

        /**
         * GeoJSON Geometry object per RFC 7946. Coordinates use [longitude, latitude] order. 3D
         * coordinates [lng, lat, elevation] are used for elevation endpoints.
         */
        fun geometry(geometry: GeoJsonGeometry?) = geometry(JsonField.ofNullable(geometry))

        /** Alias for calling [Builder.geometry] with `geometry.orElse(null)`. */
        fun geometry(geometry: Optional<GeoJsonGeometry>) = geometry(geometry.getOrNull())

        /**
         * Sets [Builder.geometry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.geometry] with a well-typed [GeoJsonGeometry] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun geometry(geometry: JsonField<GeoJsonGeometry>) = apply { this.geometry = geometry }

        /** Isochrone metadata */
        fun properties(properties: Properties?) = properties(JsonField.ofNullable(properties))

        /** Alias for calling [Builder.properties] with `properties.orElse(null)`. */
        fun properties(properties: Optional<Properties>) = properties(properties.getOrNull())

        /**
         * Sets [Builder.properties] to an arbitrary JSON value.
         *
         * You should usually call [Builder.properties] with a well-typed [Properties] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun properties(properties: JsonField<Properties>) = apply { this.properties = properties }

        /** `Feature` for single contour, `FeatureCollection` for multiple contours */
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
         * Returns an immutable instance of [RoutingIsochroneResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RoutingIsochroneResponse =
            RoutingIsochroneResponse(
                (features ?: JsonMissing.of()).map { it.toImmutable() },
                geometry,
                properties,
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RoutingIsochroneResponse = apply {
        if (validated) {
            return@apply
        }

        features().ifPresent { it.forEach { it.validate() } }
        geometry().ifPresent { it.validate() }
        properties().ifPresent { it.validate() }
        type().ifPresent { it.validate() }
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
        (features.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (geometry.asKnown().getOrNull()?.validity() ?: 0) +
            (properties.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0)

    /** Isochrone metadata */
    class Properties
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val areaM2: JsonField<Double>,
        private val maxCostS: JsonField<Double>,
        private val mode: JsonField<Mode>,
        private val timeSeconds: JsonField<Double>,
        private val verticesReached: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("area_m2") @ExcludeMissing areaM2: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("max_cost_s")
            @ExcludeMissing
            maxCostS: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of(),
            @JsonProperty("time_seconds")
            @ExcludeMissing
            timeSeconds: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("vertices_reached")
            @ExcludeMissing
            verticesReached: JsonField<Long> = JsonMissing.of(),
        ) : this(areaM2, maxCostS, mode, timeSeconds, verticesReached, mutableMapOf())

        /**
         * Area of the isochrone polygon in square meters (multi-contour features only)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun areaM2(): Optional<Double> = areaM2.getOptional("area_m2")

        /**
         * Maximum actual travel cost in seconds to the isochrone boundary (single contour only)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun maxCostS(): Optional<Double> = maxCostS.getOptional("max_cost_s")

        /**
         * Travel mode used for the isochrone calculation
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mode(): Optional<Mode> = mode.getOptional("mode")

        /**
         * Travel time budget in seconds
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun timeSeconds(): Optional<Double> = timeSeconds.getOptional("time_seconds")

        /**
         * Number of road network vertices within the isochrone
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun verticesReached(): Optional<Long> = verticesReached.getOptional("vertices_reached")

        /**
         * Returns the raw JSON value of [areaM2].
         *
         * Unlike [areaM2], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("area_m2") @ExcludeMissing fun _areaM2(): JsonField<Double> = areaM2

        /**
         * Returns the raw JSON value of [maxCostS].
         *
         * Unlike [maxCostS], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("max_cost_s") @ExcludeMissing fun _maxCostS(): JsonField<Double> = maxCostS

        /**
         * Returns the raw JSON value of [mode].
         *
         * Unlike [mode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<Mode> = mode

        /**
         * Returns the raw JSON value of [timeSeconds].
         *
         * Unlike [timeSeconds], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("time_seconds")
        @ExcludeMissing
        fun _timeSeconds(): JsonField<Double> = timeSeconds

        /**
         * Returns the raw JSON value of [verticesReached].
         *
         * Unlike [verticesReached], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("vertices_reached")
        @ExcludeMissing
        fun _verticesReached(): JsonField<Long> = verticesReached

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

            private var areaM2: JsonField<Double> = JsonMissing.of()
            private var maxCostS: JsonField<Double> = JsonMissing.of()
            private var mode: JsonField<Mode> = JsonMissing.of()
            private var timeSeconds: JsonField<Double> = JsonMissing.of()
            private var verticesReached: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(properties: Properties) = apply {
                areaM2 = properties.areaM2
                maxCostS = properties.maxCostS
                mode = properties.mode
                timeSeconds = properties.timeSeconds
                verticesReached = properties.verticesReached
                additionalProperties = properties.additionalProperties.toMutableMap()
            }

            /** Area of the isochrone polygon in square meters (multi-contour features only) */
            fun areaM2(areaM2: Double?) = areaM2(JsonField.ofNullable(areaM2))

            /**
             * Alias for [Builder.areaM2].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun areaM2(areaM2: Double) = areaM2(areaM2 as Double?)

            /** Alias for calling [Builder.areaM2] with `areaM2.orElse(null)`. */
            fun areaM2(areaM2: Optional<Double>) = areaM2(areaM2.getOrNull())

            /**
             * Sets [Builder.areaM2] to an arbitrary JSON value.
             *
             * You should usually call [Builder.areaM2] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun areaM2(areaM2: JsonField<Double>) = apply { this.areaM2 = areaM2 }

            /**
             * Maximum actual travel cost in seconds to the isochrone boundary (single contour only)
             */
            fun maxCostS(maxCostS: Double?) = maxCostS(JsonField.ofNullable(maxCostS))

            /**
             * Alias for [Builder.maxCostS].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun maxCostS(maxCostS: Double) = maxCostS(maxCostS as Double?)

            /** Alias for calling [Builder.maxCostS] with `maxCostS.orElse(null)`. */
            fun maxCostS(maxCostS: Optional<Double>) = maxCostS(maxCostS.getOrNull())

            /**
             * Sets [Builder.maxCostS] to an arbitrary JSON value.
             *
             * You should usually call [Builder.maxCostS] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun maxCostS(maxCostS: JsonField<Double>) = apply { this.maxCostS = maxCostS }

            /** Travel mode used for the isochrone calculation */
            fun mode(mode: Mode) = mode(JsonField.of(mode))

            /**
             * Sets [Builder.mode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mode] with a well-typed [Mode] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun mode(mode: JsonField<Mode>) = apply { this.mode = mode }

            /** Travel time budget in seconds */
            fun timeSeconds(timeSeconds: Double) = timeSeconds(JsonField.of(timeSeconds))

            /**
             * Sets [Builder.timeSeconds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timeSeconds] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timeSeconds(timeSeconds: JsonField<Double>) = apply {
                this.timeSeconds = timeSeconds
            }

            /** Number of road network vertices within the isochrone */
            fun verticesReached(verticesReached: Long) =
                verticesReached(JsonField.of(verticesReached))

            /**
             * Sets [Builder.verticesReached] to an arbitrary JSON value.
             *
             * You should usually call [Builder.verticesReached] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun verticesReached(verticesReached: JsonField<Long>) = apply {
                this.verticesReached = verticesReached
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
                    areaM2,
                    maxCostS,
                    mode,
                    timeSeconds,
                    verticesReached,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Properties = apply {
            if (validated) {
                return@apply
            }

            areaM2()
            maxCostS()
            mode().ifPresent { it.validate() }
            timeSeconds()
            verticesReached()
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
            (if (areaM2.asKnown().isPresent) 1 else 0) +
                (if (maxCostS.asKnown().isPresent) 1 else 0) +
                (mode.asKnown().getOrNull()?.validity() ?: 0) +
                (if (timeSeconds.asKnown().isPresent) 1 else 0) +
                (if (verticesReached.asKnown().isPresent) 1 else 0)

        /** Travel mode used for the isochrone calculation */
        class Mode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val AUTO = of("auto")

                @JvmField val FOOT = of("foot")

                @JvmField val BICYCLE = of("bicycle")

                @JvmStatic fun of(value: String) = Mode(JsonField.of(value))
            }

            /** An enum containing [Mode]'s known values. */
            enum class Known {
                AUTO,
                FOOT,
                BICYCLE,
            }

            /**
             * An enum containing [Mode]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Mode] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                AUTO,
                FOOT,
                BICYCLE,
                /** An enum member indicating that [Mode] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    AUTO -> Value.AUTO
                    FOOT -> Value.FOOT
                    BICYCLE -> Value.BICYCLE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws PlazaInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    AUTO -> Known.AUTO
                    FOOT -> Known.FOOT
                    BICYCLE -> Known.BICYCLE
                    else -> throw PlazaInvalidDataException("Unknown Mode: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws PlazaInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    PlazaInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Mode = apply {
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

                return other is Mode && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Properties &&
                areaM2 == other.areaM2 &&
                maxCostS == other.maxCostS &&
                mode == other.mode &&
                timeSeconds == other.timeSeconds &&
                verticesReached == other.verticesReached &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(areaM2, maxCostS, mode, timeSeconds, verticesReached, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Properties{areaM2=$areaM2, maxCostS=$maxCostS, mode=$mode, timeSeconds=$timeSeconds, verticesReached=$verticesReached, additionalProperties=$additionalProperties}"
    }

    /** `Feature` for single contour, `FeatureCollection` for multiple contours */
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

            @JvmField val FEATURE_COLLECTION = of("FeatureCollection")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            FEATURE,
            FEATURE_COLLECTION,
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
            FEATURE_COLLECTION,
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
                FEATURE_COLLECTION -> Value.FEATURE_COLLECTION
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
                FEATURE_COLLECTION -> Known.FEATURE_COLLECTION
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

        return other is RoutingIsochroneResponse &&
            features == other.features &&
            geometry == other.geometry &&
            properties == other.properties &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(features, geometry, properties, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RoutingIsochroneResponse{features=$features, geometry=$geometry, properties=$properties, type=$type, additionalProperties=$additionalProperties}"
}
