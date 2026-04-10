// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.optimize

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
import com.plazafyi.core.checkRequired
import com.plazafyi.core.toImmutable
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
import kotlin.jvm.optionals.getOrNull

/**
 * Completed optimization result as a GeoJSON FeatureCollection. Each Feature is a waypoint in
 * optimized visit order. Top-level fields provide summary statistics.
 */
class OptimizeCompletedResult
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val features: JsonField<List<Feature>>,
    private val optimization: JsonField<String>,
    private val roundtrip: JsonField<Boolean>,
    private val totalCostS: JsonField<Double>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("features")
        @ExcludeMissing
        features: JsonField<List<Feature>> = JsonMissing.of(),
        @JsonProperty("optimization")
        @ExcludeMissing
        optimization: JsonField<String> = JsonMissing.of(),
        @JsonProperty("roundtrip") @ExcludeMissing roundtrip: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("total_cost_s")
        @ExcludeMissing
        totalCostS: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(features, optimization, roundtrip, totalCostS, type, mutableMapOf())

    /**
     * Waypoints in optimized visit order
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun features(): List<Feature> = features.getRequired("features")

    /**
     * Optimization method used (e.g. `nearest_neighbor`, `2opt`)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun optimization(): String = optimization.getRequired("optimization")

    /**
     * Whether the route returns to the starting waypoint
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun roundtrip(): Boolean = roundtrip.getRequired("roundtrip")

    /**
     * Total travel time for the optimized route in seconds
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun totalCostS(): Double = totalCostS.getRequired("total_cost_s")

    /**
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Returns the raw JSON value of [features].
     *
     * Unlike [features], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("features") @ExcludeMissing fun _features(): JsonField<List<Feature>> = features

    /**
     * Returns the raw JSON value of [optimization].
     *
     * Unlike [optimization], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("optimization")
    @ExcludeMissing
    fun _optimization(): JsonField<String> = optimization

    /**
     * Returns the raw JSON value of [roundtrip].
     *
     * Unlike [roundtrip], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("roundtrip") @ExcludeMissing fun _roundtrip(): JsonField<Boolean> = roundtrip

    /**
     * Returns the raw JSON value of [totalCostS].
     *
     * Unlike [totalCostS], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total_cost_s") @ExcludeMissing fun _totalCostS(): JsonField<Double> = totalCostS

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
         * Returns a mutable builder for constructing an instance of [OptimizeCompletedResult].
         *
         * The following fields are required:
         * ```java
         * .features()
         * .optimization()
         * .roundtrip()
         * .totalCostS()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OptimizeCompletedResult]. */
    class Builder internal constructor() {

        private var features: JsonField<MutableList<Feature>>? = null
        private var optimization: JsonField<String>? = null
        private var roundtrip: JsonField<Boolean>? = null
        private var totalCostS: JsonField<Double>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(optimizeCompletedResult: OptimizeCompletedResult) = apply {
            features = optimizeCompletedResult.features.map { it.toMutableList() }
            optimization = optimizeCompletedResult.optimization
            roundtrip = optimizeCompletedResult.roundtrip
            totalCostS = optimizeCompletedResult.totalCostS
            type = optimizeCompletedResult.type
            additionalProperties = optimizeCompletedResult.additionalProperties.toMutableMap()
        }

        /** Waypoints in optimized visit order */
        fun features(features: List<Feature>) = features(JsonField.of(features))

        /**
         * Sets [Builder.features] to an arbitrary JSON value.
         *
         * You should usually call [Builder.features] with a well-typed `List<Feature>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun features(features: JsonField<List<Feature>>) = apply {
            this.features = features.map { it.toMutableList() }
        }

        /**
         * Adds a single [Feature] to [features].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFeature(feature: Feature) = apply {
            features =
                (features ?: JsonField.of(mutableListOf())).also {
                    checkKnown("features", it).add(feature)
                }
        }

        /** Optimization method used (e.g. `nearest_neighbor`, `2opt`) */
        fun optimization(optimization: String) = optimization(JsonField.of(optimization))

        /**
         * Sets [Builder.optimization] to an arbitrary JSON value.
         *
         * You should usually call [Builder.optimization] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun optimization(optimization: JsonField<String>) = apply {
            this.optimization = optimization
        }

        /** Whether the route returns to the starting waypoint */
        fun roundtrip(roundtrip: Boolean) = roundtrip(JsonField.of(roundtrip))

        /**
         * Sets [Builder.roundtrip] to an arbitrary JSON value.
         *
         * You should usually call [Builder.roundtrip] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun roundtrip(roundtrip: JsonField<Boolean>) = apply { this.roundtrip = roundtrip }

        /** Total travel time for the optimized route in seconds */
        fun totalCostS(totalCostS: Double) = totalCostS(JsonField.of(totalCostS))

        /**
         * Sets [Builder.totalCostS] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalCostS] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun totalCostS(totalCostS: JsonField<Double>) = apply { this.totalCostS = totalCostS }

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
         * Returns an immutable instance of [OptimizeCompletedResult].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .features()
         * .optimization()
         * .roundtrip()
         * .totalCostS()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OptimizeCompletedResult =
            OptimizeCompletedResult(
                checkRequired("features", features).map { it.toImmutable() },
                checkRequired("optimization", optimization),
                checkRequired("roundtrip", roundtrip),
                checkRequired("totalCostS", totalCostS),
                checkRequired("type", type),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OptimizeCompletedResult = apply {
        if (validated) {
            return@apply
        }

        features().forEach { it.validate() }
        optimization()
        roundtrip()
        totalCostS()
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
        (features.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (optimization.asKnown().isPresent) 1 else 0) +
            (if (roundtrip.asKnown().isPresent) 1 else 0) +
            (if (totalCostS.asKnown().isPresent) 1 else 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0)

    /** GeoJSON Point Feature representing an optimized waypoint with cost data. */
    class Feature
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val geometry: JsonField<Geometry>,
        private val properties: JsonField<Properties>,
        private val type: JsonField<Type>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("geometry")
            @ExcludeMissing
            geometry: JsonField<Geometry> = JsonMissing.of(),
            @JsonProperty("properties")
            @ExcludeMissing
            properties: JsonField<Properties> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        ) : this(geometry, properties, type, mutableMapOf())

        /**
         * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines
         * the coordinate structure.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun geometry(): Geometry = geometry.getRequired("geometry")

        /**
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun properties(): Properties = properties.getRequired("properties")

        /**
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

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
             * Returns a mutable builder for constructing an instance of [Feature].
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

        /** A builder for [Feature]. */
        class Builder internal constructor() {

            private var geometry: JsonField<Geometry>? = null
            private var properties: JsonField<Properties>? = null
            private var type: JsonField<Type>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(feature: Feature) = apply {
                geometry = feature.geometry
                properties = feature.properties
                type = feature.type
                additionalProperties = feature.additionalProperties.toMutableMap()
            }

            /**
             * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field
             * determines the coordinate structure.
             */
            fun geometry(geometry: Geometry) = geometry(JsonField.of(geometry))

            /**
             * Sets [Builder.geometry] to an arbitrary JSON value.
             *
             * You should usually call [Builder.geometry] with a well-typed [Geometry] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
            fun geometry(lineString: LineStringGeometry) =
                geometry(Geometry.ofLineString(lineString))

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
            fun geometry(multiPoint: MultiPointGeometry) =
                geometry(Geometry.ofMultiPoint(multiPoint))

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

            fun properties(properties: Properties) = properties(JsonField.of(properties))

            /**
             * Sets [Builder.properties] to an arbitrary JSON value.
             *
             * You should usually call [Builder.properties] with a well-typed [Properties] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun properties(properties: JsonField<Properties>) = apply {
                this.properties = properties
            }

            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
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
             * Returns an immutable instance of [Feature].
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
            fun build(): Feature =
                Feature(
                    checkRequired("geometry", geometry),
                    checkRequired("properties", properties),
                    checkRequired("type", type),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Feature = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
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
            private val costS: JsonField<Double>,
            private val cumulativeCostS: JsonField<Double>,
            private val waypointIndex: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("cost_s") @ExcludeMissing costS: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("cumulative_cost_s")
                @ExcludeMissing
                cumulativeCostS: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("waypoint_index")
                @ExcludeMissing
                waypointIndex: JsonField<Long> = JsonMissing.of(),
            ) : this(costS, cumulativeCostS, waypointIndex, mutableMapOf())

            /**
             * Travel time in seconds from the previous waypoint to this one (0 for the first
             * waypoint)
             *
             * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun costS(): Double = costS.getRequired("cost_s")

            /**
             * Cumulative travel time in seconds from the start to this waypoint
             *
             * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun cumulativeCostS(): Double = cumulativeCostS.getRequired("cumulative_cost_s")

            /**
             * Position of this waypoint in the optimized visit order (0-based)
             *
             * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun waypointIndex(): Long = waypointIndex.getRequired("waypoint_index")

            /**
             * Returns the raw JSON value of [costS].
             *
             * Unlike [costS], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("cost_s") @ExcludeMissing fun _costS(): JsonField<Double> = costS

            /**
             * Returns the raw JSON value of [cumulativeCostS].
             *
             * Unlike [cumulativeCostS], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("cumulative_cost_s")
            @ExcludeMissing
            fun _cumulativeCostS(): JsonField<Double> = cumulativeCostS

            /**
             * Returns the raw JSON value of [waypointIndex].
             *
             * Unlike [waypointIndex], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("waypoint_index")
            @ExcludeMissing
            fun _waypointIndex(): JsonField<Long> = waypointIndex

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
                 * Returns a mutable builder for constructing an instance of [Properties].
                 *
                 * The following fields are required:
                 * ```java
                 * .costS()
                 * .cumulativeCostS()
                 * .waypointIndex()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Properties]. */
            class Builder internal constructor() {

                private var costS: JsonField<Double>? = null
                private var cumulativeCostS: JsonField<Double>? = null
                private var waypointIndex: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(properties: Properties) = apply {
                    costS = properties.costS
                    cumulativeCostS = properties.cumulativeCostS
                    waypointIndex = properties.waypointIndex
                    additionalProperties = properties.additionalProperties.toMutableMap()
                }

                /**
                 * Travel time in seconds from the previous waypoint to this one (0 for the first
                 * waypoint)
                 */
                fun costS(costS: Double) = costS(JsonField.of(costS))

                /**
                 * Sets [Builder.costS] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.costS] with a well-typed [Double] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun costS(costS: JsonField<Double>) = apply { this.costS = costS }

                /** Cumulative travel time in seconds from the start to this waypoint */
                fun cumulativeCostS(cumulativeCostS: Double) =
                    cumulativeCostS(JsonField.of(cumulativeCostS))

                /**
                 * Sets [Builder.cumulativeCostS] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cumulativeCostS] with a well-typed [Double]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun cumulativeCostS(cumulativeCostS: JsonField<Double>) = apply {
                    this.cumulativeCostS = cumulativeCostS
                }

                /** Position of this waypoint in the optimized visit order (0-based) */
                fun waypointIndex(waypointIndex: Long) = waypointIndex(JsonField.of(waypointIndex))

                /**
                 * Sets [Builder.waypointIndex] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.waypointIndex] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun waypointIndex(waypointIndex: JsonField<Long>) = apply {
                    this.waypointIndex = waypointIndex
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Properties].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .costS()
                 * .cumulativeCostS()
                 * .waypointIndex()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Properties =
                    Properties(
                        checkRequired("costS", costS),
                        checkRequired("cumulativeCostS", cumulativeCostS),
                        checkRequired("waypointIndex", waypointIndex),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Properties = apply {
                if (validated) {
                    return@apply
                }

                costS()
                cumulativeCostS()
                waypointIndex()
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
                (if (costS.asKnown().isPresent) 1 else 0) +
                    (if (cumulativeCostS.asKnown().isPresent) 1 else 0) +
                    (if (waypointIndex.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Properties &&
                    costS == other.costS &&
                    cumulativeCostS == other.cumulativeCostS &&
                    waypointIndex == other.waypointIndex &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(costS, cumulativeCostS, waypointIndex, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Properties{costS=$costS, cumulativeCostS=$cumulativeCostS, waypointIndex=$waypointIndex, additionalProperties=$additionalProperties}"
        }

        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                FEATURE,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                    FEATURE -> Value.FEATURE
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
                    FEATURE -> Known.FEATURE
                    else -> throw PlazaInvalidDataException("Unknown Type: $value")
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

            return other is Feature &&
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
            "Feature{geometry=$geometry, properties=$properties, type=$type, additionalProperties=$additionalProperties}"
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

            @JvmField val FEATURE_COLLECTION = of("FeatureCollection")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            FEATURE_COLLECTION
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

        return other is OptimizeCompletedResult &&
            features == other.features &&
            optimization == other.optimization &&
            roundtrip == other.roundtrip &&
            totalCostS == other.totalCostS &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(features, optimization, roundtrip, totalCostS, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OptimizeCompletedResult{features=$features, optimization=$optimization, roundtrip=$roundtrip, totalCostS=$totalCostS, type=$type, additionalProperties=$additionalProperties}"
}
