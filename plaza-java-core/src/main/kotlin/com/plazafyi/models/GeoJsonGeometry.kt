// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.BaseDeserializer
import com.plazafyi.core.BaseSerializer
import com.plazafyi.core.Enum
import com.plazafyi.core.ExcludeMissing
import com.plazafyi.core.JsonField
import com.plazafyi.core.JsonMissing
import com.plazafyi.core.JsonValue
import com.plazafyi.core.allMaxBy
import com.plazafyi.core.checkRequired
import com.plazafyi.core.getOrThrow
import com.plazafyi.core.toImmutable
import com.plazafyi.errors.PlazaInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class GeoJsonGeometry
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val coordinates: JsonField<Coordinates>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("coordinates")
        @ExcludeMissing
        coordinates: JsonField<Coordinates> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(coordinates, type, mutableMapOf())

    /**
     * GeoJSON coordinates array (nesting depth varies by geometry type)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun coordinates(): Coordinates = coordinates.getRequired("coordinates")

    /**
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Returns the raw JSON value of [coordinates].
     *
     * Unlike [coordinates], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("coordinates")
    @ExcludeMissing
    fun _coordinates(): JsonField<Coordinates> = coordinates

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
         * Returns a mutable builder for constructing an instance of [GeoJsonGeometry].
         *
         * The following fields are required:
         * ```java
         * .coordinates()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GeoJsonGeometry]. */
    class Builder internal constructor() {

        private var coordinates: JsonField<Coordinates>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(geoJsonGeometry: GeoJsonGeometry) = apply {
            coordinates = geoJsonGeometry.coordinates
            type = geoJsonGeometry.type
            additionalProperties = geoJsonGeometry.additionalProperties.toMutableMap()
        }

        /** GeoJSON coordinates array (nesting depth varies by geometry type) */
        fun coordinates(coordinates: Coordinates) = coordinates(JsonField.of(coordinates))

        /**
         * Sets [Builder.coordinates] to an arbitrary JSON value.
         *
         * You should usually call [Builder.coordinates] with a well-typed [Coordinates] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun coordinates(coordinates: JsonField<Coordinates>) = apply {
            this.coordinates = coordinates
        }

        /** Alias for calling [coordinates] with `Coordinates.ofNumber(number)`. */
        fun coordinatesOfNumber(number: List<Double>) = coordinates(Coordinates.ofNumber(number))

        /** Alias for calling [coordinates] with `Coordinates.ofLists(lists)`. */
        fun coordinatesOfLists(lists: List<List<Double>>) = coordinates(Coordinates.ofLists(lists))

        /** Alias for calling [coordinates] with `Coordinates.ofLists(lists)`. */
        fun coordinatesOfLists(lists: List<List<List<Double>>>) =
            coordinates(Coordinates.ofLists(lists))

        /** Alias for calling [coordinates] with `Coordinates.ofLists(lists)`. */
        fun coordinatesOfLists(lists: List<List<List<List<Double>>>>) =
            coordinates(Coordinates.ofLists(lists))

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
         * Returns an immutable instance of [GeoJsonGeometry].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .coordinates()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): GeoJsonGeometry =
            GeoJsonGeometry(
                checkRequired("coordinates", coordinates),
                checkRequired("type", type),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): GeoJsonGeometry = apply {
        if (validated) {
            return@apply
        }

        coordinates().validate()
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
        (coordinates.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0)

    /** GeoJSON coordinates array (nesting depth varies by geometry type) */
    @JsonDeserialize(using = Coordinates.Deserializer::class)
    @JsonSerialize(using = Coordinates.Serializer::class)
    class Coordinates
    private constructor(
        private val number: List<Double>? = null,
        private val lists: List<List<Double>>? = null,
        private val lists: List<List<List<Double>>>? = null,
        private val lists: List<List<List<List<Double>>>>? = null,
        private val _json: JsonValue? = null,
    ) {

        fun number(): Optional<List<Double>> = Optional.ofNullable(number)

        fun lists(): Optional<List<List<Double>>> = Optional.ofNullable(lists)

        fun lists(): Optional<List<List<List<Double>>>> = Optional.ofNullable(lists)

        fun lists(): Optional<List<List<List<List<Double>>>>> = Optional.ofNullable(lists)

        fun isNumber(): Boolean = number != null

        fun isLists(): Boolean = lists != null

        fun isLists(): Boolean = lists != null

        fun isLists(): Boolean = lists != null

        fun asNumber(): List<Double> = number.getOrThrow("number")

        fun asLists(): List<List<Double>> = lists.getOrThrow("lists")

        fun asLists(): List<List<List<Double>>> = lists.getOrThrow("lists")

        fun asLists(): List<List<List<List<Double>>>> = lists.getOrThrow("lists")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                number != null -> visitor.visitNumber(number)
                lists != null -> visitor.visitLists(lists)
                lists != null -> visitor.visitLists(lists)
                lists != null -> visitor.visitLists(lists)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Coordinates = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitNumber(number: List<Double>) {}

                    override fun visitLists(lists: List<List<Double>>) {}

                    override fun visitLists(lists: List<List<List<Double>>>) {}

                    override fun visitLists(lists: List<List<List<List<Double>>>>) {}
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitNumber(number: List<Double>) = number.size

                    override fun visitLists(lists: List<List<Double>>) =
                        lists.sumOf { it.size.toInt() }

                    override fun visitLists(lists: List<List<List<Double>>>) =
                        lists.sumOf { it.sumOf { it.size.toInt() }.toInt() }

                    override fun visitLists(lists: List<List<List<List<Double>>>>) =
                        lists.sumOf { it.sumOf { it.sumOf { it.size.toInt() }.toInt() }.toInt() }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Coordinates &&
                number == other.number &&
                lists == other.lists &&
                lists == other.lists &&
                lists == other.lists
        }

        override fun hashCode(): Int = Objects.hash(number, lists, lists, lists)

        override fun toString(): String =
            when {
                number != null -> "Coordinates{number=$number}"
                lists != null -> "Coordinates{lists=$lists}"
                lists != null -> "Coordinates{lists=$lists}"
                lists != null -> "Coordinates{lists=$lists}"
                _json != null -> "Coordinates{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Coordinates")
            }

        companion object {

            @JvmStatic
            fun ofNumber(number: List<Double>) = Coordinates(number = number.toImmutable())

            @JvmStatic
            fun ofLists(lists: List<List<Double>>) = Coordinates(lists = lists.toImmutable())

            @JvmStatic
            fun ofLists(lists: List<List<List<Double>>>) = Coordinates(lists = lists.toImmutable())

            @JvmStatic
            fun ofLists(lists: List<List<List<List<Double>>>>) =
                Coordinates(lists = lists.toImmutable())
        }

        /**
         * An interface that defines how to map each variant of [Coordinates] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitNumber(number: List<Double>): T

            fun visitLists(lists: List<List<Double>>): T

            fun visitLists(lists: List<List<List<Double>>>): T

            fun visitLists(lists: List<List<List<List<Double>>>>): T

            /**
             * Maps an unknown variant of [Coordinates] to a value of type [T].
             *
             * An instance of [Coordinates] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws PlazaInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw PlazaInvalidDataException("Unknown Coordinates: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Coordinates>(Coordinates::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Coordinates {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<List<Double>>())?.let {
                                Coordinates(number = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<List<List<Double>>>())?.let {
                                Coordinates(lists = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<List<List<List<Double>>>>())?.let {
                                Coordinates(lists = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<List<List<List<List<Double>>>>>())
                                ?.let { Coordinates(lists = it, _json = json) },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Coordinates(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Coordinates>(Coordinates::class) {

            override fun serialize(
                value: Coordinates,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.number != null -> generator.writeObject(value.number)
                    value.lists != null -> generator.writeObject(value.lists)
                    value.lists != null -> generator.writeObject(value.lists)
                    value.lists != null -> generator.writeObject(value.lists)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Coordinates")
                }
            }
        }
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

            @JvmField val POINT = of("Point")

            @JvmField val LINE_STRING = of("LineString")

            @JvmField val POLYGON = of("Polygon")

            @JvmField val MULTI_POINT = of("MultiPoint")

            @JvmField val MULTI_LINE_STRING = of("MultiLineString")

            @JvmField val MULTI_POLYGON = of("MultiPolygon")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            POINT,
            LINE_STRING,
            POLYGON,
            MULTI_POINT,
            MULTI_LINE_STRING,
            MULTI_POLYGON,
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
            POINT,
            LINE_STRING,
            POLYGON,
            MULTI_POINT,
            MULTI_LINE_STRING,
            MULTI_POLYGON,
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
                POINT -> Value.POINT
                LINE_STRING -> Value.LINE_STRING
                POLYGON -> Value.POLYGON
                MULTI_POINT -> Value.MULTI_POINT
                MULTI_LINE_STRING -> Value.MULTI_LINE_STRING
                MULTI_POLYGON -> Value.MULTI_POLYGON
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
                POINT -> Known.POINT
                LINE_STRING -> Known.LINE_STRING
                POLYGON -> Known.POLYGON
                MULTI_POINT -> Known.MULTI_POINT
                MULTI_LINE_STRING -> Known.MULTI_LINE_STRING
                MULTI_POLYGON -> Known.MULTI_POLYGON
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

        return other is GeoJsonGeometry &&
            coordinates == other.coordinates &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(coordinates, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "GeoJsonGeometry{coordinates=$coordinates, type=$type, additionalProperties=$additionalProperties}"
}
