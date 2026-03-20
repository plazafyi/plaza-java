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
import com.plazafyi.core.checkRequired
import com.plazafyi.errors.PlazaInvalidDataException
import com.plazafyi.models.GeoJsonGeometry
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * GeoJSON Point Feature representing the nearest point on the road network to the input coordinate.
 * Used for snapping GPS coordinates to roads.
 */
class NearestResult
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
     * GeoJSON Geometry object per RFC 7946. Coordinates use [longitude, latitude] order. 3D
     * coordinates [lng, lat, elevation] are used for elevation endpoints.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun geometry(): GeoJsonGeometry = geometry.getRequired("geometry")

    /**
     * Snap result metadata
     *
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
         * Returns a mutable builder for constructing an instance of [NearestResult].
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

    /** A builder for [NearestResult]. */
    class Builder internal constructor() {

        private var geometry: JsonField<GeoJsonGeometry>? = null
        private var properties: JsonField<Properties>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(nearestResult: NearestResult) = apply {
            geometry = nearestResult.geometry
            properties = nearestResult.properties
            type = nearestResult.type
            additionalProperties = nearestResult.additionalProperties.toMutableMap()
        }

        /**
         * GeoJSON Geometry object per RFC 7946. Coordinates use [longitude, latitude] order. 3D
         * coordinates [lng, lat, elevation] are used for elevation endpoints.
         */
        fun geometry(geometry: GeoJsonGeometry) = geometry(JsonField.of(geometry))

        /**
         * Sets [Builder.geometry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.geometry] with a well-typed [GeoJsonGeometry] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun geometry(geometry: JsonField<GeoJsonGeometry>) = apply { this.geometry = geometry }

        /** Snap result metadata */
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
         * Returns an immutable instance of [NearestResult].
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
        fun build(): NearestResult =
            NearestResult(
                checkRequired("geometry", geometry),
                checkRequired("properties", properties),
                checkRequired("type", type),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): NearestResult = apply {
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

    /** Snap result metadata */
    class Properties
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val distanceM: JsonField<Double>,
        private val edgeId: JsonField<Long>,
        private val edgeLengthM: JsonField<Double>,
        private val highway: JsonField<String>,
        private val osmWayId: JsonField<Long>,
        private val surface: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("distance_m")
            @ExcludeMissing
            distanceM: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("edge_id") @ExcludeMissing edgeId: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("edge_length_m")
            @ExcludeMissing
            edgeLengthM: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("highway") @ExcludeMissing highway: JsonField<String> = JsonMissing.of(),
            @JsonProperty("osm_way_id")
            @ExcludeMissing
            osmWayId: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("surface") @ExcludeMissing surface: JsonField<String> = JsonMissing.of(),
        ) : this(distanceM, edgeId, edgeLengthM, highway, osmWayId, surface, mutableMapOf())

        /**
         * Distance from the input coordinate to the snapped point in meters
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun distanceM(): Optional<Double> = distanceM.getOptional("distance_m")

        /**
         * ID of the road network edge that was snapped to
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun edgeId(): Optional<Long> = edgeId.getOptional("edge_id")

        /**
         * Length of the matched road edge in meters
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun edgeLengthM(): Optional<Double> = edgeLengthM.getOptional("edge_length_m")

        /**
         * OSM highway tag value (e.g. `residential`, `primary`, `motorway`)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun highway(): Optional<String> = highway.getOptional("highway")

        /**
         * OSM way ID of the matched road segment
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun osmWayId(): Optional<Long> = osmWayId.getOptional("osm_way_id")

        /**
         * OSM surface tag value (e.g. `asphalt`, `gravel`, `paved`)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun surface(): Optional<String> = surface.getOptional("surface")

        /**
         * Returns the raw JSON value of [distanceM].
         *
         * Unlike [distanceM], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("distance_m") @ExcludeMissing fun _distanceM(): JsonField<Double> = distanceM

        /**
         * Returns the raw JSON value of [edgeId].
         *
         * Unlike [edgeId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("edge_id") @ExcludeMissing fun _edgeId(): JsonField<Long> = edgeId

        /**
         * Returns the raw JSON value of [edgeLengthM].
         *
         * Unlike [edgeLengthM], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("edge_length_m")
        @ExcludeMissing
        fun _edgeLengthM(): JsonField<Double> = edgeLengthM

        /**
         * Returns the raw JSON value of [highway].
         *
         * Unlike [highway], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("highway") @ExcludeMissing fun _highway(): JsonField<String> = highway

        /**
         * Returns the raw JSON value of [osmWayId].
         *
         * Unlike [osmWayId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("osm_way_id") @ExcludeMissing fun _osmWayId(): JsonField<Long> = osmWayId

        /**
         * Returns the raw JSON value of [surface].
         *
         * Unlike [surface], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("surface") @ExcludeMissing fun _surface(): JsonField<String> = surface

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

            private var distanceM: JsonField<Double> = JsonMissing.of()
            private var edgeId: JsonField<Long> = JsonMissing.of()
            private var edgeLengthM: JsonField<Double> = JsonMissing.of()
            private var highway: JsonField<String> = JsonMissing.of()
            private var osmWayId: JsonField<Long> = JsonMissing.of()
            private var surface: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(properties: Properties) = apply {
                distanceM = properties.distanceM
                edgeId = properties.edgeId
                edgeLengthM = properties.edgeLengthM
                highway = properties.highway
                osmWayId = properties.osmWayId
                surface = properties.surface
                additionalProperties = properties.additionalProperties.toMutableMap()
            }

            /** Distance from the input coordinate to the snapped point in meters */
            fun distanceM(distanceM: Double) = distanceM(JsonField.of(distanceM))

            /**
             * Sets [Builder.distanceM] to an arbitrary JSON value.
             *
             * You should usually call [Builder.distanceM] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun distanceM(distanceM: JsonField<Double>) = apply { this.distanceM = distanceM }

            /** ID of the road network edge that was snapped to */
            fun edgeId(edgeId: Long) = edgeId(JsonField.of(edgeId))

            /**
             * Sets [Builder.edgeId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.edgeId] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun edgeId(edgeId: JsonField<Long>) = apply { this.edgeId = edgeId }

            /** Length of the matched road edge in meters */
            fun edgeLengthM(edgeLengthM: Double) = edgeLengthM(JsonField.of(edgeLengthM))

            /**
             * Sets [Builder.edgeLengthM] to an arbitrary JSON value.
             *
             * You should usually call [Builder.edgeLengthM] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun edgeLengthM(edgeLengthM: JsonField<Double>) = apply {
                this.edgeLengthM = edgeLengthM
            }

            /** OSM highway tag value (e.g. `residential`, `primary`, `motorway`) */
            fun highway(highway: String?) = highway(JsonField.ofNullable(highway))

            /** Alias for calling [Builder.highway] with `highway.orElse(null)`. */
            fun highway(highway: Optional<String>) = highway(highway.getOrNull())

            /**
             * Sets [Builder.highway] to an arbitrary JSON value.
             *
             * You should usually call [Builder.highway] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun highway(highway: JsonField<String>) = apply { this.highway = highway }

            /** OSM way ID of the matched road segment */
            fun osmWayId(osmWayId: Long) = osmWayId(JsonField.of(osmWayId))

            /**
             * Sets [Builder.osmWayId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.osmWayId] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun osmWayId(osmWayId: JsonField<Long>) = apply { this.osmWayId = osmWayId }

            /** OSM surface tag value (e.g. `asphalt`, `gravel`, `paved`) */
            fun surface(surface: String?) = surface(JsonField.ofNullable(surface))

            /** Alias for calling [Builder.surface] with `surface.orElse(null)`. */
            fun surface(surface: Optional<String>) = surface(surface.getOrNull())

            /**
             * Sets [Builder.surface] to an arbitrary JSON value.
             *
             * You should usually call [Builder.surface] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun surface(surface: JsonField<String>) = apply { this.surface = surface }

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
                    distanceM,
                    edgeId,
                    edgeLengthM,
                    highway,
                    osmWayId,
                    surface,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Properties = apply {
            if (validated) {
                return@apply
            }

            distanceM()
            edgeId()
            edgeLengthM()
            highway()
            osmWayId()
            surface()
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
            (if (distanceM.asKnown().isPresent) 1 else 0) +
                (if (edgeId.asKnown().isPresent) 1 else 0) +
                (if (edgeLengthM.asKnown().isPresent) 1 else 0) +
                (if (highway.asKnown().isPresent) 1 else 0) +
                (if (osmWayId.asKnown().isPresent) 1 else 0) +
                (if (surface.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Properties &&
                distanceM == other.distanceM &&
                edgeId == other.edgeId &&
                edgeLengthM == other.edgeLengthM &&
                highway == other.highway &&
                osmWayId == other.osmWayId &&
                surface == other.surface &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                distanceM,
                edgeId,
                edgeLengthM,
                highway,
                osmWayId,
                surface,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Properties{distanceM=$distanceM, edgeId=$edgeId, edgeLengthM=$edgeLengthM, highway=$highway, osmWayId=$osmWayId, surface=$surface, additionalProperties=$additionalProperties}"
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

        return other is NearestResult &&
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
        "NearestResult{geometry=$geometry, properties=$properties, type=$type, additionalProperties=$additionalProperties}"
}
