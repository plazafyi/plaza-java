// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.features

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.plazafyi.core.ExcludeMissing
import com.plazafyi.core.JsonField
import com.plazafyi.core.JsonMissing
import com.plazafyi.core.JsonValue
import com.plazafyi.errors.PlazaInvalidDataException
import com.plazafyi.models.Geometry
import com.plazafyi.models.LineStringGeometry
import com.plazafyi.models.MultiLineStringGeometry
import com.plazafyi.models.MultiPointGeometry
import com.plazafyi.models.MultiPolygonGeometry
import com.plazafyi.models.PointGeometry
import com.plazafyi.models.PolygonGeometry
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Spatial predicates for filtering features by geographic relationship. Predicates are mutually
 * exclusive — use exactly one per request. The parameter name is the spatial operation, the value
 * is a GeoJSON geometry to test against.
 *
 * | Predicate        | Meaning                                    |
 * |------------------|--------------------------------------------|
 * | `around`         | Within radius meters (requires `radius`)   |
 * | `intersects`     | Feature overlaps the input geometry        |
 * | `within`         | Feature is fully inside the input geometry |
 * | `contains`       | Feature fully contains the input geometry  |
 * | `crosses`        | Feature crosses the input geometry         |
 * | `touches`        | Feature shares boundary but not interior   |
 * | `not_intersects` | Feature does not overlap                   |
 * | `not_within`     | Feature is not fully inside                |
 * | `not_contains`   | Feature does not fully contain             |
 */
class SpatialPredicate
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val around: JsonField<Geometry>,
    private val contains: JsonField<Geometry>,
    private val crosses: JsonField<Geometry>,
    private val intersects: JsonField<Geometry>,
    private val notContains: JsonField<Geometry>,
    private val notIntersects: JsonField<Geometry>,
    private val notWithin: JsonField<Geometry>,
    private val radius: JsonField<Double>,
    private val touches: JsonField<Geometry>,
    private val within: JsonField<Geometry>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("around") @ExcludeMissing around: JsonField<Geometry> = JsonMissing.of(),
        @JsonProperty("contains") @ExcludeMissing contains: JsonField<Geometry> = JsonMissing.of(),
        @JsonProperty("crosses") @ExcludeMissing crosses: JsonField<Geometry> = JsonMissing.of(),
        @JsonProperty("intersects")
        @ExcludeMissing
        intersects: JsonField<Geometry> = JsonMissing.of(),
        @JsonProperty("not_contains")
        @ExcludeMissing
        notContains: JsonField<Geometry> = JsonMissing.of(),
        @JsonProperty("not_intersects")
        @ExcludeMissing
        notIntersects: JsonField<Geometry> = JsonMissing.of(),
        @JsonProperty("not_within")
        @ExcludeMissing
        notWithin: JsonField<Geometry> = JsonMissing.of(),
        @JsonProperty("radius") @ExcludeMissing radius: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("touches") @ExcludeMissing touches: JsonField<Geometry> = JsonMissing.of(),
        @JsonProperty("within") @ExcludeMissing within: JsonField<Geometry> = JsonMissing.of(),
    ) : this(
        around,
        contains,
        crosses,
        intersects,
        notContains,
        notIntersects,
        notWithin,
        radius,
        touches,
        within,
        mutableMapOf(),
    )

    /**
     * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines the
     * coordinate structure.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun around(): Optional<Geometry> = around.getOptional("around")

    /**
     * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines the
     * coordinate structure.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contains(): Optional<Geometry> = contains.getOptional("contains")

    /**
     * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines the
     * coordinate structure.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun crosses(): Optional<Geometry> = crosses.getOptional("crosses")

    /**
     * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines the
     * coordinate structure.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun intersects(): Optional<Geometry> = intersects.getOptional("intersects")

    /**
     * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines the
     * coordinate structure.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun notContains(): Optional<Geometry> = notContains.getOptional("not_contains")

    /**
     * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines the
     * coordinate structure.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun notIntersects(): Optional<Geometry> = notIntersects.getOptional("not_intersects")

    /**
     * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines the
     * coordinate structure.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun notWithin(): Optional<Geometry> = notWithin.getOptional("not_within")

    /**
     * Search radius in meters. Required for `around`, optional buffer for other predicates.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun radius(): Optional<Double> = radius.getOptional("radius")

    /**
     * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines the
     * coordinate structure.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun touches(): Optional<Geometry> = touches.getOptional("touches")

    /**
     * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines the
     * coordinate structure.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun within(): Optional<Geometry> = within.getOptional("within")

    /**
     * Returns the raw JSON value of [around].
     *
     * Unlike [around], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("around") @ExcludeMissing fun _around(): JsonField<Geometry> = around

    /**
     * Returns the raw JSON value of [contains].
     *
     * Unlike [contains], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contains") @ExcludeMissing fun _contains(): JsonField<Geometry> = contains

    /**
     * Returns the raw JSON value of [crosses].
     *
     * Unlike [crosses], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("crosses") @ExcludeMissing fun _crosses(): JsonField<Geometry> = crosses

    /**
     * Returns the raw JSON value of [intersects].
     *
     * Unlike [intersects], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("intersects") @ExcludeMissing fun _intersects(): JsonField<Geometry> = intersects

    /**
     * Returns the raw JSON value of [notContains].
     *
     * Unlike [notContains], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("not_contains")
    @ExcludeMissing
    fun _notContains(): JsonField<Geometry> = notContains

    /**
     * Returns the raw JSON value of [notIntersects].
     *
     * Unlike [notIntersects], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("not_intersects")
    @ExcludeMissing
    fun _notIntersects(): JsonField<Geometry> = notIntersects

    /**
     * Returns the raw JSON value of [notWithin].
     *
     * Unlike [notWithin], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("not_within") @ExcludeMissing fun _notWithin(): JsonField<Geometry> = notWithin

    /**
     * Returns the raw JSON value of [radius].
     *
     * Unlike [radius], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("radius") @ExcludeMissing fun _radius(): JsonField<Double> = radius

    /**
     * Returns the raw JSON value of [touches].
     *
     * Unlike [touches], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("touches") @ExcludeMissing fun _touches(): JsonField<Geometry> = touches

    /**
     * Returns the raw JSON value of [within].
     *
     * Unlike [within], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("within") @ExcludeMissing fun _within(): JsonField<Geometry> = within

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

        /** Returns a mutable builder for constructing an instance of [SpatialPredicate]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SpatialPredicate]. */
    class Builder internal constructor() {

        private var around: JsonField<Geometry> = JsonMissing.of()
        private var contains: JsonField<Geometry> = JsonMissing.of()
        private var crosses: JsonField<Geometry> = JsonMissing.of()
        private var intersects: JsonField<Geometry> = JsonMissing.of()
        private var notContains: JsonField<Geometry> = JsonMissing.of()
        private var notIntersects: JsonField<Geometry> = JsonMissing.of()
        private var notWithin: JsonField<Geometry> = JsonMissing.of()
        private var radius: JsonField<Double> = JsonMissing.of()
        private var touches: JsonField<Geometry> = JsonMissing.of()
        private var within: JsonField<Geometry> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(spatialPredicate: SpatialPredicate) = apply {
            around = spatialPredicate.around
            contains = spatialPredicate.contains
            crosses = spatialPredicate.crosses
            intersects = spatialPredicate.intersects
            notContains = spatialPredicate.notContains
            notIntersects = spatialPredicate.notIntersects
            notWithin = spatialPredicate.notWithin
            radius = spatialPredicate.radius
            touches = spatialPredicate.touches
            within = spatialPredicate.within
            additionalProperties = spatialPredicate.additionalProperties.toMutableMap()
        }

        /**
         * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines
         * the coordinate structure.
         */
        fun around(around: Geometry) = around(JsonField.of(around))

        /**
         * Sets [Builder.around] to an arbitrary JSON value.
         *
         * You should usually call [Builder.around] with a well-typed [Geometry] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun around(around: JsonField<Geometry>) = apply { this.around = around }

        /** Alias for calling [around] with `Geometry.ofPoint(point)`. */
        fun around(point: PointGeometry) = around(Geometry.ofPoint(point))

        /**
         * Alias for calling [around] with the following:
         * ```java
         * PointGeometry.builder()
         *     .type(PointGeometry.Type.POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun pointAround(coordinates: List<Double>) =
            around(
                PointGeometry.builder()
                    .type(PointGeometry.Type.POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [around] with `Geometry.ofLineString(lineString)`. */
        fun around(lineString: LineStringGeometry) = around(Geometry.ofLineString(lineString))

        /**
         * Alias for calling [around] with the following:
         * ```java
         * LineStringGeometry.builder()
         *     .type(LineStringGeometry.Type.LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun lineStringAround(coordinates: List<List<Double>>) =
            around(
                LineStringGeometry.builder()
                    .type(LineStringGeometry.Type.LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [around] with `Geometry.ofPolygon(polygon)`. */
        fun around(polygon: PolygonGeometry) = around(Geometry.ofPolygon(polygon))

        /**
         * Alias for calling [around] with the following:
         * ```java
         * PolygonGeometry.builder()
         *     .type(PolygonGeometry.Type.POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun polygonAround(coordinates: List<List<List<Double>>>) =
            around(
                PolygonGeometry.builder()
                    .type(PolygonGeometry.Type.POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [around] with `Geometry.ofMultiPoint(multiPoint)`. */
        fun around(multiPoint: MultiPointGeometry) = around(Geometry.ofMultiPoint(multiPoint))

        /**
         * Alias for calling [around] with the following:
         * ```java
         * MultiPointGeometry.builder()
         *     .type(MultiPointGeometry.Type.MULTI_POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPointAround(coordinates: List<List<Double>>) =
            around(
                MultiPointGeometry.builder()
                    .type(MultiPointGeometry.Type.MULTI_POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [around] with `Geometry.ofMultiLineString(multiLineString)`. */
        fun around(multiLineString: MultiLineStringGeometry) =
            around(Geometry.ofMultiLineString(multiLineString))

        /**
         * Alias for calling [around] with the following:
         * ```java
         * MultiLineStringGeometry.builder()
         *     .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiLineStringAround(coordinates: List<List<List<Double>>>) =
            around(
                MultiLineStringGeometry.builder()
                    .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [around] with `Geometry.ofMultiPolygon(multiPolygon)`. */
        fun around(multiPolygon: MultiPolygonGeometry) =
            around(Geometry.ofMultiPolygon(multiPolygon))

        /**
         * Alias for calling [around] with the following:
         * ```java
         * MultiPolygonGeometry.builder()
         *     .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPolygonAround(coordinates: List<List<List<List<Double>>>>) =
            around(
                MultiPolygonGeometry.builder()
                    .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /**
         * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines
         * the coordinate structure.
         */
        fun contains(contains: Geometry) = contains(JsonField.of(contains))

        /**
         * Sets [Builder.contains] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contains] with a well-typed [Geometry] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contains(contains: JsonField<Geometry>) = apply { this.contains = contains }

        /** Alias for calling [contains] with `Geometry.ofPoint(point)`. */
        fun contains(point: PointGeometry) = contains(Geometry.ofPoint(point))

        /**
         * Alias for calling [contains] with the following:
         * ```java
         * PointGeometry.builder()
         *     .type(PointGeometry.Type.POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun pointContains(coordinates: List<Double>) =
            contains(
                PointGeometry.builder()
                    .type(PointGeometry.Type.POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [contains] with `Geometry.ofLineString(lineString)`. */
        fun contains(lineString: LineStringGeometry) = contains(Geometry.ofLineString(lineString))

        /**
         * Alias for calling [contains] with the following:
         * ```java
         * LineStringGeometry.builder()
         *     .type(LineStringGeometry.Type.LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun lineStringContains(coordinates: List<List<Double>>) =
            contains(
                LineStringGeometry.builder()
                    .type(LineStringGeometry.Type.LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [contains] with `Geometry.ofPolygon(polygon)`. */
        fun contains(polygon: PolygonGeometry) = contains(Geometry.ofPolygon(polygon))

        /**
         * Alias for calling [contains] with the following:
         * ```java
         * PolygonGeometry.builder()
         *     .type(PolygonGeometry.Type.POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun polygonContains(coordinates: List<List<List<Double>>>) =
            contains(
                PolygonGeometry.builder()
                    .type(PolygonGeometry.Type.POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [contains] with `Geometry.ofMultiPoint(multiPoint)`. */
        fun contains(multiPoint: MultiPointGeometry) = contains(Geometry.ofMultiPoint(multiPoint))

        /**
         * Alias for calling [contains] with the following:
         * ```java
         * MultiPointGeometry.builder()
         *     .type(MultiPointGeometry.Type.MULTI_POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPointContains(coordinates: List<List<Double>>) =
            contains(
                MultiPointGeometry.builder()
                    .type(MultiPointGeometry.Type.MULTI_POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [contains] with `Geometry.ofMultiLineString(multiLineString)`. */
        fun contains(multiLineString: MultiLineStringGeometry) =
            contains(Geometry.ofMultiLineString(multiLineString))

        /**
         * Alias for calling [contains] with the following:
         * ```java
         * MultiLineStringGeometry.builder()
         *     .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiLineStringContains(coordinates: List<List<List<Double>>>) =
            contains(
                MultiLineStringGeometry.builder()
                    .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [contains] with `Geometry.ofMultiPolygon(multiPolygon)`. */
        fun contains(multiPolygon: MultiPolygonGeometry) =
            contains(Geometry.ofMultiPolygon(multiPolygon))

        /**
         * Alias for calling [contains] with the following:
         * ```java
         * MultiPolygonGeometry.builder()
         *     .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPolygonContains(coordinates: List<List<List<List<Double>>>>) =
            contains(
                MultiPolygonGeometry.builder()
                    .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /**
         * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines
         * the coordinate structure.
         */
        fun crosses(crosses: Geometry) = crosses(JsonField.of(crosses))

        /**
         * Sets [Builder.crosses] to an arbitrary JSON value.
         *
         * You should usually call [Builder.crosses] with a well-typed [Geometry] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun crosses(crosses: JsonField<Geometry>) = apply { this.crosses = crosses }

        /** Alias for calling [crosses] with `Geometry.ofPoint(point)`. */
        fun crosses(point: PointGeometry) = crosses(Geometry.ofPoint(point))

        /**
         * Alias for calling [crosses] with the following:
         * ```java
         * PointGeometry.builder()
         *     .type(PointGeometry.Type.POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun pointCrosses(coordinates: List<Double>) =
            crosses(
                PointGeometry.builder()
                    .type(PointGeometry.Type.POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [crosses] with `Geometry.ofLineString(lineString)`. */
        fun crosses(lineString: LineStringGeometry) = crosses(Geometry.ofLineString(lineString))

        /**
         * Alias for calling [crosses] with the following:
         * ```java
         * LineStringGeometry.builder()
         *     .type(LineStringGeometry.Type.LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun lineStringCrosses(coordinates: List<List<Double>>) =
            crosses(
                LineStringGeometry.builder()
                    .type(LineStringGeometry.Type.LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [crosses] with `Geometry.ofPolygon(polygon)`. */
        fun crosses(polygon: PolygonGeometry) = crosses(Geometry.ofPolygon(polygon))

        /**
         * Alias for calling [crosses] with the following:
         * ```java
         * PolygonGeometry.builder()
         *     .type(PolygonGeometry.Type.POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun polygonCrosses(coordinates: List<List<List<Double>>>) =
            crosses(
                PolygonGeometry.builder()
                    .type(PolygonGeometry.Type.POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [crosses] with `Geometry.ofMultiPoint(multiPoint)`. */
        fun crosses(multiPoint: MultiPointGeometry) = crosses(Geometry.ofMultiPoint(multiPoint))

        /**
         * Alias for calling [crosses] with the following:
         * ```java
         * MultiPointGeometry.builder()
         *     .type(MultiPointGeometry.Type.MULTI_POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPointCrosses(coordinates: List<List<Double>>) =
            crosses(
                MultiPointGeometry.builder()
                    .type(MultiPointGeometry.Type.MULTI_POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [crosses] with `Geometry.ofMultiLineString(multiLineString)`. */
        fun crosses(multiLineString: MultiLineStringGeometry) =
            crosses(Geometry.ofMultiLineString(multiLineString))

        /**
         * Alias for calling [crosses] with the following:
         * ```java
         * MultiLineStringGeometry.builder()
         *     .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiLineStringCrosses(coordinates: List<List<List<Double>>>) =
            crosses(
                MultiLineStringGeometry.builder()
                    .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [crosses] with `Geometry.ofMultiPolygon(multiPolygon)`. */
        fun crosses(multiPolygon: MultiPolygonGeometry) =
            crosses(Geometry.ofMultiPolygon(multiPolygon))

        /**
         * Alias for calling [crosses] with the following:
         * ```java
         * MultiPolygonGeometry.builder()
         *     .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPolygonCrosses(coordinates: List<List<List<List<Double>>>>) =
            crosses(
                MultiPolygonGeometry.builder()
                    .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /**
         * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines
         * the coordinate structure.
         */
        fun intersects(intersects: Geometry) = intersects(JsonField.of(intersects))

        /**
         * Sets [Builder.intersects] to an arbitrary JSON value.
         *
         * You should usually call [Builder.intersects] with a well-typed [Geometry] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun intersects(intersects: JsonField<Geometry>) = apply { this.intersects = intersects }

        /** Alias for calling [intersects] with `Geometry.ofPoint(point)`. */
        fun intersects(point: PointGeometry) = intersects(Geometry.ofPoint(point))

        /**
         * Alias for calling [intersects] with the following:
         * ```java
         * PointGeometry.builder()
         *     .type(PointGeometry.Type.POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun pointIntersects(coordinates: List<Double>) =
            intersects(
                PointGeometry.builder()
                    .type(PointGeometry.Type.POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [intersects] with `Geometry.ofLineString(lineString)`. */
        fun intersects(lineString: LineStringGeometry) =
            intersects(Geometry.ofLineString(lineString))

        /**
         * Alias for calling [intersects] with the following:
         * ```java
         * LineStringGeometry.builder()
         *     .type(LineStringGeometry.Type.LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun lineStringIntersects(coordinates: List<List<Double>>) =
            intersects(
                LineStringGeometry.builder()
                    .type(LineStringGeometry.Type.LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [intersects] with `Geometry.ofPolygon(polygon)`. */
        fun intersects(polygon: PolygonGeometry) = intersects(Geometry.ofPolygon(polygon))

        /**
         * Alias for calling [intersects] with the following:
         * ```java
         * PolygonGeometry.builder()
         *     .type(PolygonGeometry.Type.POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun polygonIntersects(coordinates: List<List<List<Double>>>) =
            intersects(
                PolygonGeometry.builder()
                    .type(PolygonGeometry.Type.POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [intersects] with `Geometry.ofMultiPoint(multiPoint)`. */
        fun intersects(multiPoint: MultiPointGeometry) =
            intersects(Geometry.ofMultiPoint(multiPoint))

        /**
         * Alias for calling [intersects] with the following:
         * ```java
         * MultiPointGeometry.builder()
         *     .type(MultiPointGeometry.Type.MULTI_POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPointIntersects(coordinates: List<List<Double>>) =
            intersects(
                MultiPointGeometry.builder()
                    .type(MultiPointGeometry.Type.MULTI_POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [intersects] with `Geometry.ofMultiLineString(multiLineString)`. */
        fun intersects(multiLineString: MultiLineStringGeometry) =
            intersects(Geometry.ofMultiLineString(multiLineString))

        /**
         * Alias for calling [intersects] with the following:
         * ```java
         * MultiLineStringGeometry.builder()
         *     .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiLineStringIntersects(coordinates: List<List<List<Double>>>) =
            intersects(
                MultiLineStringGeometry.builder()
                    .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [intersects] with `Geometry.ofMultiPolygon(multiPolygon)`. */
        fun intersects(multiPolygon: MultiPolygonGeometry) =
            intersects(Geometry.ofMultiPolygon(multiPolygon))

        /**
         * Alias for calling [intersects] with the following:
         * ```java
         * MultiPolygonGeometry.builder()
         *     .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPolygonIntersects(coordinates: List<List<List<List<Double>>>>) =
            intersects(
                MultiPolygonGeometry.builder()
                    .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /**
         * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines
         * the coordinate structure.
         */
        fun notContains(notContains: Geometry) = notContains(JsonField.of(notContains))

        /**
         * Sets [Builder.notContains] to an arbitrary JSON value.
         *
         * You should usually call [Builder.notContains] with a well-typed [Geometry] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun notContains(notContains: JsonField<Geometry>) = apply { this.notContains = notContains }

        /** Alias for calling [notContains] with `Geometry.ofPoint(point)`. */
        fun notContains(point: PointGeometry) = notContains(Geometry.ofPoint(point))

        /**
         * Alias for calling [notContains] with the following:
         * ```java
         * PointGeometry.builder()
         *     .type(PointGeometry.Type.POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun pointNotContains(coordinates: List<Double>) =
            notContains(
                PointGeometry.builder()
                    .type(PointGeometry.Type.POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notContains] with `Geometry.ofLineString(lineString)`. */
        fun notContains(lineString: LineStringGeometry) =
            notContains(Geometry.ofLineString(lineString))

        /**
         * Alias for calling [notContains] with the following:
         * ```java
         * LineStringGeometry.builder()
         *     .type(LineStringGeometry.Type.LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun lineStringNotContains(coordinates: List<List<Double>>) =
            notContains(
                LineStringGeometry.builder()
                    .type(LineStringGeometry.Type.LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notContains] with `Geometry.ofPolygon(polygon)`. */
        fun notContains(polygon: PolygonGeometry) = notContains(Geometry.ofPolygon(polygon))

        /**
         * Alias for calling [notContains] with the following:
         * ```java
         * PolygonGeometry.builder()
         *     .type(PolygonGeometry.Type.POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun polygonNotContains(coordinates: List<List<List<Double>>>) =
            notContains(
                PolygonGeometry.builder()
                    .type(PolygonGeometry.Type.POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notContains] with `Geometry.ofMultiPoint(multiPoint)`. */
        fun notContains(multiPoint: MultiPointGeometry) =
            notContains(Geometry.ofMultiPoint(multiPoint))

        /**
         * Alias for calling [notContains] with the following:
         * ```java
         * MultiPointGeometry.builder()
         *     .type(MultiPointGeometry.Type.MULTI_POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPointNotContains(coordinates: List<List<Double>>) =
            notContains(
                MultiPointGeometry.builder()
                    .type(MultiPointGeometry.Type.MULTI_POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notContains] with `Geometry.ofMultiLineString(multiLineString)`. */
        fun notContains(multiLineString: MultiLineStringGeometry) =
            notContains(Geometry.ofMultiLineString(multiLineString))

        /**
         * Alias for calling [notContains] with the following:
         * ```java
         * MultiLineStringGeometry.builder()
         *     .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiLineStringNotContains(coordinates: List<List<List<Double>>>) =
            notContains(
                MultiLineStringGeometry.builder()
                    .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notContains] with `Geometry.ofMultiPolygon(multiPolygon)`. */
        fun notContains(multiPolygon: MultiPolygonGeometry) =
            notContains(Geometry.ofMultiPolygon(multiPolygon))

        /**
         * Alias for calling [notContains] with the following:
         * ```java
         * MultiPolygonGeometry.builder()
         *     .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPolygonNotContains(coordinates: List<List<List<List<Double>>>>) =
            notContains(
                MultiPolygonGeometry.builder()
                    .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /**
         * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines
         * the coordinate structure.
         */
        fun notIntersects(notIntersects: Geometry) = notIntersects(JsonField.of(notIntersects))

        /**
         * Sets [Builder.notIntersects] to an arbitrary JSON value.
         *
         * You should usually call [Builder.notIntersects] with a well-typed [Geometry] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun notIntersects(notIntersects: JsonField<Geometry>) = apply {
            this.notIntersects = notIntersects
        }

        /** Alias for calling [notIntersects] with `Geometry.ofPoint(point)`. */
        fun notIntersects(point: PointGeometry) = notIntersects(Geometry.ofPoint(point))

        /**
         * Alias for calling [notIntersects] with the following:
         * ```java
         * PointGeometry.builder()
         *     .type(PointGeometry.Type.POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun pointNotIntersects(coordinates: List<Double>) =
            notIntersects(
                PointGeometry.builder()
                    .type(PointGeometry.Type.POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notIntersects] with `Geometry.ofLineString(lineString)`. */
        fun notIntersects(lineString: LineStringGeometry) =
            notIntersects(Geometry.ofLineString(lineString))

        /**
         * Alias for calling [notIntersects] with the following:
         * ```java
         * LineStringGeometry.builder()
         *     .type(LineStringGeometry.Type.LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun lineStringNotIntersects(coordinates: List<List<Double>>) =
            notIntersects(
                LineStringGeometry.builder()
                    .type(LineStringGeometry.Type.LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notIntersects] with `Geometry.ofPolygon(polygon)`. */
        fun notIntersects(polygon: PolygonGeometry) = notIntersects(Geometry.ofPolygon(polygon))

        /**
         * Alias for calling [notIntersects] with the following:
         * ```java
         * PolygonGeometry.builder()
         *     .type(PolygonGeometry.Type.POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun polygonNotIntersects(coordinates: List<List<List<Double>>>) =
            notIntersects(
                PolygonGeometry.builder()
                    .type(PolygonGeometry.Type.POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notIntersects] with `Geometry.ofMultiPoint(multiPoint)`. */
        fun notIntersects(multiPoint: MultiPointGeometry) =
            notIntersects(Geometry.ofMultiPoint(multiPoint))

        /**
         * Alias for calling [notIntersects] with the following:
         * ```java
         * MultiPointGeometry.builder()
         *     .type(MultiPointGeometry.Type.MULTI_POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPointNotIntersects(coordinates: List<List<Double>>) =
            notIntersects(
                MultiPointGeometry.builder()
                    .type(MultiPointGeometry.Type.MULTI_POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notIntersects] with `Geometry.ofMultiLineString(multiLineString)`. */
        fun notIntersects(multiLineString: MultiLineStringGeometry) =
            notIntersects(Geometry.ofMultiLineString(multiLineString))

        /**
         * Alias for calling [notIntersects] with the following:
         * ```java
         * MultiLineStringGeometry.builder()
         *     .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiLineStringNotIntersects(coordinates: List<List<List<Double>>>) =
            notIntersects(
                MultiLineStringGeometry.builder()
                    .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notIntersects] with `Geometry.ofMultiPolygon(multiPolygon)`. */
        fun notIntersects(multiPolygon: MultiPolygonGeometry) =
            notIntersects(Geometry.ofMultiPolygon(multiPolygon))

        /**
         * Alias for calling [notIntersects] with the following:
         * ```java
         * MultiPolygonGeometry.builder()
         *     .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPolygonNotIntersects(coordinates: List<List<List<List<Double>>>>) =
            notIntersects(
                MultiPolygonGeometry.builder()
                    .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /**
         * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines
         * the coordinate structure.
         */
        fun notWithin(notWithin: Geometry) = notWithin(JsonField.of(notWithin))

        /**
         * Sets [Builder.notWithin] to an arbitrary JSON value.
         *
         * You should usually call [Builder.notWithin] with a well-typed [Geometry] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun notWithin(notWithin: JsonField<Geometry>) = apply { this.notWithin = notWithin }

        /** Alias for calling [notWithin] with `Geometry.ofPoint(point)`. */
        fun notWithin(point: PointGeometry) = notWithin(Geometry.ofPoint(point))

        /**
         * Alias for calling [notWithin] with the following:
         * ```java
         * PointGeometry.builder()
         *     .type(PointGeometry.Type.POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun pointNotWithin(coordinates: List<Double>) =
            notWithin(
                PointGeometry.builder()
                    .type(PointGeometry.Type.POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notWithin] with `Geometry.ofLineString(lineString)`. */
        fun notWithin(lineString: LineStringGeometry) = notWithin(Geometry.ofLineString(lineString))

        /**
         * Alias for calling [notWithin] with the following:
         * ```java
         * LineStringGeometry.builder()
         *     .type(LineStringGeometry.Type.LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun lineStringNotWithin(coordinates: List<List<Double>>) =
            notWithin(
                LineStringGeometry.builder()
                    .type(LineStringGeometry.Type.LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notWithin] with `Geometry.ofPolygon(polygon)`. */
        fun notWithin(polygon: PolygonGeometry) = notWithin(Geometry.ofPolygon(polygon))

        /**
         * Alias for calling [notWithin] with the following:
         * ```java
         * PolygonGeometry.builder()
         *     .type(PolygonGeometry.Type.POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun polygonNotWithin(coordinates: List<List<List<Double>>>) =
            notWithin(
                PolygonGeometry.builder()
                    .type(PolygonGeometry.Type.POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notWithin] with `Geometry.ofMultiPoint(multiPoint)`. */
        fun notWithin(multiPoint: MultiPointGeometry) = notWithin(Geometry.ofMultiPoint(multiPoint))

        /**
         * Alias for calling [notWithin] with the following:
         * ```java
         * MultiPointGeometry.builder()
         *     .type(MultiPointGeometry.Type.MULTI_POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPointNotWithin(coordinates: List<List<Double>>) =
            notWithin(
                MultiPointGeometry.builder()
                    .type(MultiPointGeometry.Type.MULTI_POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notWithin] with `Geometry.ofMultiLineString(multiLineString)`. */
        fun notWithin(multiLineString: MultiLineStringGeometry) =
            notWithin(Geometry.ofMultiLineString(multiLineString))

        /**
         * Alias for calling [notWithin] with the following:
         * ```java
         * MultiLineStringGeometry.builder()
         *     .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiLineStringNotWithin(coordinates: List<List<List<Double>>>) =
            notWithin(
                MultiLineStringGeometry.builder()
                    .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [notWithin] with `Geometry.ofMultiPolygon(multiPolygon)`. */
        fun notWithin(multiPolygon: MultiPolygonGeometry) =
            notWithin(Geometry.ofMultiPolygon(multiPolygon))

        /**
         * Alias for calling [notWithin] with the following:
         * ```java
         * MultiPolygonGeometry.builder()
         *     .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPolygonNotWithin(coordinates: List<List<List<List<Double>>>>) =
            notWithin(
                MultiPolygonGeometry.builder()
                    .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /** Search radius in meters. Required for `around`, optional buffer for other predicates. */
        fun radius(radius: Double) = radius(JsonField.of(radius))

        /**
         * Sets [Builder.radius] to an arbitrary JSON value.
         *
         * You should usually call [Builder.radius] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun radius(radius: JsonField<Double>) = apply { this.radius = radius }

        /**
         * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines
         * the coordinate structure.
         */
        fun touches(touches: Geometry) = touches(JsonField.of(touches))

        /**
         * Sets [Builder.touches] to an arbitrary JSON value.
         *
         * You should usually call [Builder.touches] with a well-typed [Geometry] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun touches(touches: JsonField<Geometry>) = apply { this.touches = touches }

        /** Alias for calling [touches] with `Geometry.ofPoint(point)`. */
        fun touches(point: PointGeometry) = touches(Geometry.ofPoint(point))

        /**
         * Alias for calling [touches] with the following:
         * ```java
         * PointGeometry.builder()
         *     .type(PointGeometry.Type.POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun pointTouches(coordinates: List<Double>) =
            touches(
                PointGeometry.builder()
                    .type(PointGeometry.Type.POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [touches] with `Geometry.ofLineString(lineString)`. */
        fun touches(lineString: LineStringGeometry) = touches(Geometry.ofLineString(lineString))

        /**
         * Alias for calling [touches] with the following:
         * ```java
         * LineStringGeometry.builder()
         *     .type(LineStringGeometry.Type.LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun lineStringTouches(coordinates: List<List<Double>>) =
            touches(
                LineStringGeometry.builder()
                    .type(LineStringGeometry.Type.LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [touches] with `Geometry.ofPolygon(polygon)`. */
        fun touches(polygon: PolygonGeometry) = touches(Geometry.ofPolygon(polygon))

        /**
         * Alias for calling [touches] with the following:
         * ```java
         * PolygonGeometry.builder()
         *     .type(PolygonGeometry.Type.POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun polygonTouches(coordinates: List<List<List<Double>>>) =
            touches(
                PolygonGeometry.builder()
                    .type(PolygonGeometry.Type.POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [touches] with `Geometry.ofMultiPoint(multiPoint)`. */
        fun touches(multiPoint: MultiPointGeometry) = touches(Geometry.ofMultiPoint(multiPoint))

        /**
         * Alias for calling [touches] with the following:
         * ```java
         * MultiPointGeometry.builder()
         *     .type(MultiPointGeometry.Type.MULTI_POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPointTouches(coordinates: List<List<Double>>) =
            touches(
                MultiPointGeometry.builder()
                    .type(MultiPointGeometry.Type.MULTI_POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [touches] with `Geometry.ofMultiLineString(multiLineString)`. */
        fun touches(multiLineString: MultiLineStringGeometry) =
            touches(Geometry.ofMultiLineString(multiLineString))

        /**
         * Alias for calling [touches] with the following:
         * ```java
         * MultiLineStringGeometry.builder()
         *     .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiLineStringTouches(coordinates: List<List<List<Double>>>) =
            touches(
                MultiLineStringGeometry.builder()
                    .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [touches] with `Geometry.ofMultiPolygon(multiPolygon)`. */
        fun touches(multiPolygon: MultiPolygonGeometry) =
            touches(Geometry.ofMultiPolygon(multiPolygon))

        /**
         * Alias for calling [touches] with the following:
         * ```java
         * MultiPolygonGeometry.builder()
         *     .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPolygonTouches(coordinates: List<List<List<List<Double>>>>) =
            touches(
                MultiPolygonGeometry.builder()
                    .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /**
         * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines
         * the coordinate structure.
         */
        fun within(within: Geometry) = within(JsonField.of(within))

        /**
         * Sets [Builder.within] to an arbitrary JSON value.
         *
         * You should usually call [Builder.within] with a well-typed [Geometry] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun within(within: JsonField<Geometry>) = apply { this.within = within }

        /** Alias for calling [within] with `Geometry.ofPoint(point)`. */
        fun within(point: PointGeometry) = within(Geometry.ofPoint(point))

        /**
         * Alias for calling [within] with the following:
         * ```java
         * PointGeometry.builder()
         *     .type(PointGeometry.Type.POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun pointWithin(coordinates: List<Double>) =
            within(
                PointGeometry.builder()
                    .type(PointGeometry.Type.POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [within] with `Geometry.ofLineString(lineString)`. */
        fun within(lineString: LineStringGeometry) = within(Geometry.ofLineString(lineString))

        /**
         * Alias for calling [within] with the following:
         * ```java
         * LineStringGeometry.builder()
         *     .type(LineStringGeometry.Type.LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun lineStringWithin(coordinates: List<List<Double>>) =
            within(
                LineStringGeometry.builder()
                    .type(LineStringGeometry.Type.LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [within] with `Geometry.ofPolygon(polygon)`. */
        fun within(polygon: PolygonGeometry) = within(Geometry.ofPolygon(polygon))

        /**
         * Alias for calling [within] with the following:
         * ```java
         * PolygonGeometry.builder()
         *     .type(PolygonGeometry.Type.POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun polygonWithin(coordinates: List<List<List<Double>>>) =
            within(
                PolygonGeometry.builder()
                    .type(PolygonGeometry.Type.POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [within] with `Geometry.ofMultiPoint(multiPoint)`. */
        fun within(multiPoint: MultiPointGeometry) = within(Geometry.ofMultiPoint(multiPoint))

        /**
         * Alias for calling [within] with the following:
         * ```java
         * MultiPointGeometry.builder()
         *     .type(MultiPointGeometry.Type.MULTI_POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPointWithin(coordinates: List<List<Double>>) =
            within(
                MultiPointGeometry.builder()
                    .type(MultiPointGeometry.Type.MULTI_POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [within] with `Geometry.ofMultiLineString(multiLineString)`. */
        fun within(multiLineString: MultiLineStringGeometry) =
            within(Geometry.ofMultiLineString(multiLineString))

        /**
         * Alias for calling [within] with the following:
         * ```java
         * MultiLineStringGeometry.builder()
         *     .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiLineStringWithin(coordinates: List<List<List<Double>>>) =
            within(
                MultiLineStringGeometry.builder()
                    .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [within] with `Geometry.ofMultiPolygon(multiPolygon)`. */
        fun within(multiPolygon: MultiPolygonGeometry) =
            within(Geometry.ofMultiPolygon(multiPolygon))

        /**
         * Alias for calling [within] with the following:
         * ```java
         * MultiPolygonGeometry.builder()
         *     .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPolygonWithin(coordinates: List<List<List<List<Double>>>>) =
            within(
                MultiPolygonGeometry.builder()
                    .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

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
         * Returns an immutable instance of [SpatialPredicate].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SpatialPredicate =
            SpatialPredicate(
                around,
                contains,
                crosses,
                intersects,
                notContains,
                notIntersects,
                notWithin,
                radius,
                touches,
                within,
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
    fun validate(): SpatialPredicate = apply {
        if (validated) {
            return@apply
        }

        around().ifPresent { it.validate() }
        contains().ifPresent { it.validate() }
        crosses().ifPresent { it.validate() }
        intersects().ifPresent { it.validate() }
        notContains().ifPresent { it.validate() }
        notIntersects().ifPresent { it.validate() }
        notWithin().ifPresent { it.validate() }
        radius()
        touches().ifPresent { it.validate() }
        within().ifPresent { it.validate() }
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
        (around.asKnown().getOrNull()?.validity() ?: 0) +
            (contains.asKnown().getOrNull()?.validity() ?: 0) +
            (crosses.asKnown().getOrNull()?.validity() ?: 0) +
            (intersects.asKnown().getOrNull()?.validity() ?: 0) +
            (notContains.asKnown().getOrNull()?.validity() ?: 0) +
            (notIntersects.asKnown().getOrNull()?.validity() ?: 0) +
            (notWithin.asKnown().getOrNull()?.validity() ?: 0) +
            (if (radius.asKnown().isPresent) 1 else 0) +
            (touches.asKnown().getOrNull()?.validity() ?: 0) +
            (within.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SpatialPredicate &&
            around == other.around &&
            contains == other.contains &&
            crosses == other.crosses &&
            intersects == other.intersects &&
            notContains == other.notContains &&
            notIntersects == other.notIntersects &&
            notWithin == other.notWithin &&
            radius == other.radius &&
            touches == other.touches &&
            within == other.within &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            around,
            contains,
            crosses,
            intersects,
            notContains,
            notIntersects,
            notWithin,
            radius,
            touches,
            within,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SpatialPredicate{around=$around, contains=$contains, crosses=$crosses, intersects=$intersects, notContains=$notContains, notIntersects=$notIntersects, notWithin=$notWithin, radius=$radius, touches=$touches, within=$within, additionalProperties=$additionalProperties}"
}
