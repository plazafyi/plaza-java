// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.BaseDeserializer
import com.plazafyi.core.BaseSerializer
import com.plazafyi.core.JsonValue
import com.plazafyi.core.getOrThrow
import com.plazafyi.errors.PlazaInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines the
 * coordinate structure.
 */
@JsonDeserialize(using = Geometry.Deserializer::class)
@JsonSerialize(using = Geometry.Serializer::class)
class Geometry
private constructor(
    private val point: PointGeometry? = null,
    private val lineString: LineStringGeometry? = null,
    private val polygon: PolygonGeometry? = null,
    private val multiPoint: MultiPointGeometry? = null,
    private val multiLineString: MultiLineStringGeometry? = null,
    private val multiPolygon: MultiPolygonGeometry? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order. Optional
     * third element is altitude in meters.
     */
    fun point(): Optional<PointGeometry> = Optional.ofNullable(point)

    /** GeoJSON LineString geometry per RFC 7946. An ordered sequence of two or more positions. */
    fun lineString(): Optional<LineStringGeometry> = Optional.ofNullable(lineString)

    /**
     * GeoJSON Polygon geometry per RFC 7946. An array of linear rings where the first ring is the
     * exterior boundary and subsequent rings are holes. Each ring must have at least 4 positions
     * with the first and last being identical.
     */
    fun polygon(): Optional<PolygonGeometry> = Optional.ofNullable(polygon)

    /** GeoJSON MultiPoint geometry per RFC 7946. An array of positions. */
    fun multiPoint(): Optional<MultiPointGeometry> = Optional.ofNullable(multiPoint)

    /** GeoJSON MultiLineString geometry per RFC 7946. An array of LineString coordinate arrays. */
    fun multiLineString(): Optional<MultiLineStringGeometry> = Optional.ofNullable(multiLineString)

    /** GeoJSON MultiPolygon geometry per RFC 7946. An array of Polygon coordinate arrays. */
    fun multiPolygon(): Optional<MultiPolygonGeometry> = Optional.ofNullable(multiPolygon)

    fun isPoint(): Boolean = point != null

    fun isLineString(): Boolean = lineString != null

    fun isPolygon(): Boolean = polygon != null

    fun isMultiPoint(): Boolean = multiPoint != null

    fun isMultiLineString(): Boolean = multiLineString != null

    fun isMultiPolygon(): Boolean = multiPolygon != null

    /**
     * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order. Optional
     * third element is altitude in meters.
     */
    fun asPoint(): PointGeometry = point.getOrThrow("point")

    /** GeoJSON LineString geometry per RFC 7946. An ordered sequence of two or more positions. */
    fun asLineString(): LineStringGeometry = lineString.getOrThrow("lineString")

    /**
     * GeoJSON Polygon geometry per RFC 7946. An array of linear rings where the first ring is the
     * exterior boundary and subsequent rings are holes. Each ring must have at least 4 positions
     * with the first and last being identical.
     */
    fun asPolygon(): PolygonGeometry = polygon.getOrThrow("polygon")

    /** GeoJSON MultiPoint geometry per RFC 7946. An array of positions. */
    fun asMultiPoint(): MultiPointGeometry = multiPoint.getOrThrow("multiPoint")

    /** GeoJSON MultiLineString geometry per RFC 7946. An array of LineString coordinate arrays. */
    fun asMultiLineString(): MultiLineStringGeometry = multiLineString.getOrThrow("multiLineString")

    /** GeoJSON MultiPolygon geometry per RFC 7946. An array of Polygon coordinate arrays. */
    fun asMultiPolygon(): MultiPolygonGeometry = multiPolygon.getOrThrow("multiPolygon")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            point != null -> visitor.visitPoint(point)
            lineString != null -> visitor.visitLineString(lineString)
            polygon != null -> visitor.visitPolygon(polygon)
            multiPoint != null -> visitor.visitMultiPoint(multiPoint)
            multiLineString != null -> visitor.visitMultiLineString(multiLineString)
            multiPolygon != null -> visitor.visitMultiPolygon(multiPolygon)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): Geometry = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitPoint(point: PointGeometry) {
                    point.validate()
                }

                override fun visitLineString(lineString: LineStringGeometry) {
                    lineString.validate()
                }

                override fun visitPolygon(polygon: PolygonGeometry) {
                    polygon.validate()
                }

                override fun visitMultiPoint(multiPoint: MultiPointGeometry) {
                    multiPoint.validate()
                }

                override fun visitMultiLineString(multiLineString: MultiLineStringGeometry) {
                    multiLineString.validate()
                }

                override fun visitMultiPolygon(multiPolygon: MultiPolygonGeometry) {
                    multiPolygon.validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitPoint(point: PointGeometry) = point.validity()

                override fun visitLineString(lineString: LineStringGeometry) = lineString.validity()

                override fun visitPolygon(polygon: PolygonGeometry) = polygon.validity()

                override fun visitMultiPoint(multiPoint: MultiPointGeometry) = multiPoint.validity()

                override fun visitMultiLineString(multiLineString: MultiLineStringGeometry) =
                    multiLineString.validity()

                override fun visitMultiPolygon(multiPolygon: MultiPolygonGeometry) =
                    multiPolygon.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Geometry &&
            point == other.point &&
            lineString == other.lineString &&
            polygon == other.polygon &&
            multiPoint == other.multiPoint &&
            multiLineString == other.multiLineString &&
            multiPolygon == other.multiPolygon
    }

    override fun hashCode(): Int =
        Objects.hash(point, lineString, polygon, multiPoint, multiLineString, multiPolygon)

    override fun toString(): String =
        when {
            point != null -> "Geometry{point=$point}"
            lineString != null -> "Geometry{lineString=$lineString}"
            polygon != null -> "Geometry{polygon=$polygon}"
            multiPoint != null -> "Geometry{multiPoint=$multiPoint}"
            multiLineString != null -> "Geometry{multiLineString=$multiLineString}"
            multiPolygon != null -> "Geometry{multiPolygon=$multiPolygon}"
            _json != null -> "Geometry{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid Geometry")
        }

    companion object {

        /**
         * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order.
         * Optional third element is altitude in meters.
         */
        @JvmStatic fun ofPoint(point: PointGeometry) = Geometry(point = point)

        /**
         * GeoJSON LineString geometry per RFC 7946. An ordered sequence of two or more positions.
         */
        @JvmStatic
        fun ofLineString(lineString: LineStringGeometry) = Geometry(lineString = lineString)

        /**
         * GeoJSON Polygon geometry per RFC 7946. An array of linear rings where the first ring is
         * the exterior boundary and subsequent rings are holes. Each ring must have at least 4
         * positions with the first and last being identical.
         */
        @JvmStatic fun ofPolygon(polygon: PolygonGeometry) = Geometry(polygon = polygon)

        /** GeoJSON MultiPoint geometry per RFC 7946. An array of positions. */
        @JvmStatic
        fun ofMultiPoint(multiPoint: MultiPointGeometry) = Geometry(multiPoint = multiPoint)

        /**
         * GeoJSON MultiLineString geometry per RFC 7946. An array of LineString coordinate arrays.
         */
        @JvmStatic
        fun ofMultiLineString(multiLineString: MultiLineStringGeometry) =
            Geometry(multiLineString = multiLineString)

        /** GeoJSON MultiPolygon geometry per RFC 7946. An array of Polygon coordinate arrays. */
        @JvmStatic
        fun ofMultiPolygon(multiPolygon: MultiPolygonGeometry) =
            Geometry(multiPolygon = multiPolygon)
    }

    /** An interface that defines how to map each variant of [Geometry] to a value of type [T]. */
    interface Visitor<out T> {

        /**
         * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order.
         * Optional third element is altitude in meters.
         */
        fun visitPoint(point: PointGeometry): T

        /**
         * GeoJSON LineString geometry per RFC 7946. An ordered sequence of two or more positions.
         */
        fun visitLineString(lineString: LineStringGeometry): T

        /**
         * GeoJSON Polygon geometry per RFC 7946. An array of linear rings where the first ring is
         * the exterior boundary and subsequent rings are holes. Each ring must have at least 4
         * positions with the first and last being identical.
         */
        fun visitPolygon(polygon: PolygonGeometry): T

        /** GeoJSON MultiPoint geometry per RFC 7946. An array of positions. */
        fun visitMultiPoint(multiPoint: MultiPointGeometry): T

        /**
         * GeoJSON MultiLineString geometry per RFC 7946. An array of LineString coordinate arrays.
         */
        fun visitMultiLineString(multiLineString: MultiLineStringGeometry): T

        /** GeoJSON MultiPolygon geometry per RFC 7946. An array of Polygon coordinate arrays. */
        fun visitMultiPolygon(multiPolygon: MultiPolygonGeometry): T

        /**
         * Maps an unknown variant of [Geometry] to a value of type [T].
         *
         * An instance of [Geometry] can contain an unknown variant if it was deserialized from data
         * that doesn't match any known variant. For example, if the SDK is on an older version than
         * the API, then the API may respond with new variants that the SDK is unaware of.
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
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "Point" -> {
                    return tryDeserialize(node, jacksonTypeRef<PointGeometry>())?.let {
                        Geometry(point = it, _json = json)
                    } ?: Geometry(_json = json)
                }
                "LineString" -> {
                    return tryDeserialize(node, jacksonTypeRef<LineStringGeometry>())?.let {
                        Geometry(lineString = it, _json = json)
                    } ?: Geometry(_json = json)
                }
                "Polygon" -> {
                    return tryDeserialize(node, jacksonTypeRef<PolygonGeometry>())?.let {
                        Geometry(polygon = it, _json = json)
                    } ?: Geometry(_json = json)
                }
                "MultiPoint" -> {
                    return tryDeserialize(node, jacksonTypeRef<MultiPointGeometry>())?.let {
                        Geometry(multiPoint = it, _json = json)
                    } ?: Geometry(_json = json)
                }
                "MultiLineString" -> {
                    return tryDeserialize(node, jacksonTypeRef<MultiLineStringGeometry>())?.let {
                        Geometry(multiLineString = it, _json = json)
                    } ?: Geometry(_json = json)
                }
                "MultiPolygon" -> {
                    return tryDeserialize(node, jacksonTypeRef<MultiPolygonGeometry>())?.let {
                        Geometry(multiPolygon = it, _json = json)
                    } ?: Geometry(_json = json)
                }
            }

            return Geometry(_json = json)
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
                value.lineString != null -> generator.writeObject(value.lineString)
                value.polygon != null -> generator.writeObject(value.polygon)
                value.multiPoint != null -> generator.writeObject(value.multiPoint)
                value.multiLineString != null -> generator.writeObject(value.multiLineString)
                value.multiPolygon != null -> generator.writeObject(value.multiPolygon)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Geometry")
            }
        }
    }
}
