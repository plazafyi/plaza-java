// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

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
import com.plazafyi.core.ExcludeMissing
import com.plazafyi.core.JsonField
import com.plazafyi.core.JsonMissing
import com.plazafyi.core.JsonValue
import com.plazafyi.core.allMaxBy
import com.plazafyi.core.checkRequired
import com.plazafyi.core.getOrThrow
import com.plazafyi.errors.PlazaInvalidDataException
import com.plazafyi.models.MultiPointGeometry
import com.plazafyi.models.PointGeometry
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Request body for elevation lookup. Accepts a single Point or a MultiPoint geometry. */
class ElevationLookupRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val geometry: JsonField<Geometry>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("geometry") @ExcludeMissing geometry: JsonField<Geometry> = JsonMissing.of()
    ) : this(geometry, mutableMapOf())

    /**
     * Point or MultiPoint geometry to look up elevations for
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun geometry(): Geometry = geometry.getRequired("geometry")

    /**
     * Returns the raw JSON value of [geometry].
     *
     * Unlike [geometry], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("geometry") @ExcludeMissing fun _geometry(): JsonField<Geometry> = geometry

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
         * Returns a mutable builder for constructing an instance of [ElevationLookupRequest].
         *
         * The following fields are required:
         * ```java
         * .geometry()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ElevationLookupRequest]. */
    class Builder internal constructor() {

        private var geometry: JsonField<Geometry>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(elevationLookupRequest: ElevationLookupRequest) = apply {
            geometry = elevationLookupRequest.geometry
            additionalProperties = elevationLookupRequest.additionalProperties.toMutableMap()
        }

        /** Point or MultiPoint geometry to look up elevations for */
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

        /** Alias for calling [geometry] with `Geometry.ofMultiPoint(multiPoint)`. */
        fun geometry(multiPoint: MultiPointGeometry) = geometry(Geometry.ofMultiPoint(multiPoint))

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
         * Returns an immutable instance of [ElevationLookupRequest].
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
        fun build(): ElevationLookupRequest =
            ElevationLookupRequest(
                checkRequired("geometry", geometry),
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
    fun validate(): ElevationLookupRequest = apply {
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

    /** Point or MultiPoint geometry to look up elevations for */
    @JsonDeserialize(using = Geometry.Deserializer::class)
    @JsonSerialize(using = Geometry.Serializer::class)
    class Geometry
    private constructor(
        private val point: PointGeometry? = null,
        private val multiPoint: MultiPointGeometry? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order.
         * Optional third element is altitude in meters.
         */
        fun point(): Optional<PointGeometry> = Optional.ofNullable(point)

        /** GeoJSON MultiPoint geometry per RFC 7946. An array of positions. */
        fun multiPoint(): Optional<MultiPointGeometry> = Optional.ofNullable(multiPoint)

        fun isPoint(): Boolean = point != null

        fun isMultiPoint(): Boolean = multiPoint != null

        /**
         * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order.
         * Optional third element is altitude in meters.
         */
        fun asPoint(): PointGeometry = point.getOrThrow("point")

        /** GeoJSON MultiPoint geometry per RFC 7946. An array of positions. */
        fun asMultiPoint(): MultiPointGeometry = multiPoint.getOrThrow("multiPoint")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.plazafyi.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = geometry.accept(new Geometry.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitPoint(PointGeometry point) {
         *         return Optional.of(point.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws PlazaInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
         *   the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                point != null -> visitor.visitPoint(point)
                multiPoint != null -> visitor.visitMultiPoint(multiPoint)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws PlazaInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Geometry = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitPoint(point: PointGeometry) {
                        point.validate()
                    }

                    override fun visitMultiPoint(multiPoint: MultiPointGeometry) {
                        multiPoint.validate()
                    }
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
                    override fun visitPoint(point: PointGeometry) = point.validity()

                    override fun visitMultiPoint(multiPoint: MultiPointGeometry) =
                        multiPoint.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Geometry && point == other.point && multiPoint == other.multiPoint
        }

        override fun hashCode(): Int = Objects.hash(point, multiPoint)

        override fun toString(): String =
            when {
                point != null -> "Geometry{point=$point}"
                multiPoint != null -> "Geometry{multiPoint=$multiPoint}"
                _json != null -> "Geometry{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Geometry")
            }

        companion object {

            /**
             * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order.
             * Optional third element is altitude in meters.
             */
            @JvmStatic fun ofPoint(point: PointGeometry) = Geometry(point = point)

            /** GeoJSON MultiPoint geometry per RFC 7946. An array of positions. */
            @JvmStatic
            fun ofMultiPoint(multiPoint: MultiPointGeometry) = Geometry(multiPoint = multiPoint)
        }

        /**
         * An interface that defines how to map each variant of [Geometry] to a value of type [T].
         */
        interface Visitor<out T> {

            /**
             * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order.
             * Optional third element is altitude in meters.
             */
            fun visitPoint(point: PointGeometry): T

            /** GeoJSON MultiPoint geometry per RFC 7946. An array of positions. */
            fun visitMultiPoint(multiPoint: MultiPointGeometry): T

            /**
             * Maps an unknown variant of [Geometry] to a value of type [T].
             *
             * An instance of [Geometry] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws PlazaInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw PlazaInvalidDataException("Unknown Geometry: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Geometry>(Geometry::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Geometry {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<PointGeometry>())?.let {
                                Geometry(point = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<MultiPointGeometry>())?.let {
                                Geometry(multiPoint = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Geometry(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Geometry>(Geometry::class) {

            override fun serialize(
                value: Geometry,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.point != null -> generator.writeObject(value.point)
                    value.multiPoint != null -> generator.writeObject(value.multiPoint)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Geometry")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ElevationLookupRequest &&
            geometry == other.geometry &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(geometry, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ElevationLookupRequest{geometry=$geometry, additionalProperties=$additionalProperties}"
}
