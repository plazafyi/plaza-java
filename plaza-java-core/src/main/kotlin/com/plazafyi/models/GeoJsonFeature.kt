// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

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
import com.plazafyi.core.toImmutable
import com.plazafyi.errors.PlazaInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * GeoJSON Feature representing an OSM element. Tags from the original OSM element are flattened
 * directly into `properties` (not nested under a `tags` key). Metadata fields `@type` and `@id`
 * identify the OSM element type and ID within properties.
 */
class GeoJsonFeature
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val geometry: JsonField<Geometry>,
    private val properties: JsonField<Properties>,
    private val type: JsonField<Type>,
    private val id: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("geometry") @ExcludeMissing geometry: JsonField<Geometry> = JsonMissing.of(),
        @JsonProperty("properties")
        @ExcludeMissing
        properties: JsonField<Properties> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
    ) : this(geometry, properties, type, id, mutableMapOf())

    /**
     * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines the
     * coordinate structure.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun geometry(): Geometry = geometry.getRequired("geometry")

    /**
     * OSM tags flattened as key-value pairs, plus `@type` (node/way/relation) and `@id` (OSM ID)
     * metadata fields. May include `distance_m` for proximity queries.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun properties(): Properties = properties.getRequired("properties")

    /**
     * Always `Feature`
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Compound identifier in `type/osm_id` format
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Returns the raw JSON value of [geometry].
     *
     * Unlike [geometry], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("geometry") @ExcludeMissing fun _geometry(): JsonField<Geometry> = geometry

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

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
         * Returns a mutable builder for constructing an instance of [GeoJsonFeature].
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

    /** A builder for [GeoJsonFeature]. */
    class Builder internal constructor() {

        private var geometry: JsonField<Geometry>? = null
        private var properties: JsonField<Properties>? = null
        private var type: JsonField<Type>? = null
        private var id: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(geoJsonFeature: GeoJsonFeature) = apply {
            geometry = geoJsonFeature.geometry
            properties = geoJsonFeature.properties
            type = geoJsonFeature.type
            id = geoJsonFeature.id
            additionalProperties = geoJsonFeature.additionalProperties.toMutableMap()
        }

        /**
         * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines
         * the coordinate structure.
         */
        fun geometry(geometry: Geometry) = geometry(JsonField.of(geometry))

        /**
         * Sets [Builder.geometry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.geometry] with a well-typed [Geometry] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun geometry(geometry: JsonField<Geometry>) = apply { this.geometry = geometry }

        /** Alias for calling [geometry] with `Geometry.ofPoint(point)`. */
        fun geometry(point: PointGeometry) = geometry(Geometry.ofPoint(point))

        /**
         * Alias for calling [geometry] with the following:
         * ```java
         * PointGeometry.builder()
         *     .type(PointGeometry.Type.POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun pointGeometry(coordinates: List<Double>) =
            geometry(
                PointGeometry.builder()
                    .type(PointGeometry.Type.POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [geometry] with `Geometry.ofLineString(lineString)`. */
        fun geometry(lineString: LineStringGeometry) = geometry(Geometry.ofLineString(lineString))

        /**
         * Alias for calling [geometry] with the following:
         * ```java
         * LineStringGeometry.builder()
         *     .type(LineStringGeometry.Type.LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun lineStringGeometry(coordinates: List<List<Double>>) =
            geometry(
                LineStringGeometry.builder()
                    .type(LineStringGeometry.Type.LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [geometry] with `Geometry.ofPolygon(polygon)`. */
        fun geometry(polygon: PolygonGeometry) = geometry(Geometry.ofPolygon(polygon))

        /**
         * Alias for calling [geometry] with the following:
         * ```java
         * PolygonGeometry.builder()
         *     .type(PolygonGeometry.Type.POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun polygonGeometry(coordinates: List<List<List<Double>>>) =
            geometry(
                PolygonGeometry.builder()
                    .type(PolygonGeometry.Type.POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [geometry] with `Geometry.ofMultiPoint(multiPoint)`. */
        fun geometry(multiPoint: MultiPointGeometry) = geometry(Geometry.ofMultiPoint(multiPoint))

        /**
         * Alias for calling [geometry] with the following:
         * ```java
         * MultiPointGeometry.builder()
         *     .type(MultiPointGeometry.Type.MULTI_POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPointGeometry(coordinates: List<List<Double>>) =
            geometry(
                MultiPointGeometry.builder()
                    .type(MultiPointGeometry.Type.MULTI_POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [geometry] with `Geometry.ofMultiLineString(multiLineString)`. */
        fun geometry(multiLineString: MultiLineStringGeometry) =
            geometry(Geometry.ofMultiLineString(multiLineString))

        /**
         * Alias for calling [geometry] with the following:
         * ```java
         * MultiLineStringGeometry.builder()
         *     .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiLineStringGeometry(coordinates: List<List<List<Double>>>) =
            geometry(
                MultiLineStringGeometry.builder()
                    .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [geometry] with `Geometry.ofMultiPolygon(multiPolygon)`. */
        fun geometry(multiPolygon: MultiPolygonGeometry) =
            geometry(Geometry.ofMultiPolygon(multiPolygon))

        /**
         * Alias for calling [geometry] with the following:
         * ```java
         * MultiPolygonGeometry.builder()
         *     .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPolygonGeometry(coordinates: List<List<List<List<Double>>>>) =
            geometry(
                MultiPolygonGeometry.builder()
                    .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /**
         * OSM tags flattened as key-value pairs, plus `@type` (node/way/relation) and `@id` (OSM
         * ID) metadata fields. May include `distance_m` for proximity queries.
         */
        fun properties(properties: Properties) = properties(JsonField.of(properties))

        /**
         * Sets [Builder.properties] to an arbitrary JSON value.
         *
         * You should usually call [Builder.properties] with a well-typed [Properties] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun properties(properties: JsonField<Properties>) = apply { this.properties = properties }

        /** Always `Feature` */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** Compound identifier in `type/osm_id` format */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

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
         * Returns an immutable instance of [GeoJsonFeature].
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
        fun build(): GeoJsonFeature =
            GeoJsonFeature(
                checkRequired("geometry", geometry),
                checkRequired("properties", properties),
                checkRequired("type", type),
                id,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): GeoJsonFeature = apply {
        if (validated) {
            return@apply
        }

        geometry().validate()
        properties().validate()
        type().validate()
        id()
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
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (if (id.asKnown().isPresent) 1 else 0)

    /**
     * OSM tags flattened as key-value pairs, plus `@type` (node/way/relation) and `@id` (OSM ID)
     * metadata fields. May include `distance_m` for proximity queries.
     */
    class Properties
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Properties]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Properties]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(properties: Properties) = apply {
                additionalProperties = properties.additionalProperties.toMutableMap()
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
            fun build(): Properties = Properties(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Properties = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Properties && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Properties{additionalProperties=$additionalProperties}"
    }

    /** Always `Feature` */
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

        return other is GeoJsonFeature &&
            geometry == other.geometry &&
            properties == other.properties &&
            type == other.type &&
            id == other.id &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(geometry, properties, type, id, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "GeoJsonFeature{geometry=$geometry, properties=$properties, type=$type, id=$id, additionalProperties=$additionalProperties}"
}
