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
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * GeoJSON Feature representing a calculated route. The geometry is a LineString or MultiLineString
 * of the route path. When `alternatives > 0`, the response is a FeatureCollection containing
 * multiple route Features.
 */
class RouteResult
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val geometry: JsonField<Geometry>,
    private val properties: JsonField<Properties>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("geometry") @ExcludeMissing geometry: JsonField<Geometry> = JsonMissing.of(),
        @JsonProperty("properties")
        @ExcludeMissing
        properties: JsonField<Properties> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(geometry, properties, type, mutableMapOf())

    /**
     * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines the
     * coordinate structure.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun geometry(): Geometry = geometry.getRequired("geometry")

    /**
     * Route metadata
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
         * Returns a mutable builder for constructing an instance of [RouteResult].
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

    /** A builder for [RouteResult]. */
    class Builder internal constructor() {

        private var geometry: JsonField<Geometry>? = null
        private var properties: JsonField<Properties>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(routeResult: RouteResult) = apply {
            geometry = routeResult.geometry
            properties = routeResult.properties
            type = routeResult.type
            additionalProperties = routeResult.additionalProperties.toMutableMap()
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

        /** Route metadata */
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
         * Returns an immutable instance of [RouteResult].
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
        fun build(): RouteResult =
            RouteResult(
                checkRequired("geometry", geometry),
                checkRequired("properties", properties),
                checkRequired("type", type),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RouteResult = apply {
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

    /** Route metadata */
    class Properties
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val distanceM: JsonField<Double>,
        private val durationS: JsonField<Double>,
        private val annotations: JsonField<Annotations>,
        private val chargeProfile: JsonField<List<List<Double>>>,
        private val chargingStops: JsonField<List<ChargingStop>>,
        private val edges: JsonField<List<Edge>>,
        private val energyUsedWh: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("distance_m")
            @ExcludeMissing
            distanceM: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("duration_s")
            @ExcludeMissing
            durationS: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("annotations")
            @ExcludeMissing
            annotations: JsonField<Annotations> = JsonMissing.of(),
            @JsonProperty("charge_profile")
            @ExcludeMissing
            chargeProfile: JsonField<List<List<Double>>> = JsonMissing.of(),
            @JsonProperty("charging_stops")
            @ExcludeMissing
            chargingStops: JsonField<List<ChargingStop>> = JsonMissing.of(),
            @JsonProperty("edges") @ExcludeMissing edges: JsonField<List<Edge>> = JsonMissing.of(),
            @JsonProperty("energy_used_wh")
            @ExcludeMissing
            energyUsedWh: JsonField<Double> = JsonMissing.of(),
        ) : this(
            distanceM,
            durationS,
            annotations,
            chargeProfile,
            chargingStops,
            edges,
            energyUsedWh,
            mutableMapOf(),
        )

        /**
         * Total route distance in meters
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun distanceM(): Double = distanceM.getRequired("distance_m")

        /**
         * Estimated travel duration in seconds
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun durationS(): Double = durationS.getRequired("duration_s")

        /**
         * Per-edge annotations (present when `annotations: true` in request)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun annotations(): Optional<Annotations> = annotations.getOptional("annotations")

        /**
         * Battery charge level at route waypoints as [distance_fraction, charge_pct] pairs (EV
         * routes only)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun chargeProfile(): Optional<List<List<Double>>> =
            chargeProfile.getOptional("charge_profile")

        /**
         * Recommended charging stops along the route (EV routes only)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun chargingStops(): Optional<List<ChargingStop>> =
            chargingStops.getOptional("charging_stops")

        /**
         * Edge-level route details (present when `annotations: true`)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun edges(): Optional<List<Edge>> = edges.getOptional("edges")

        /**
         * Total energy consumed in watt-hours (EV routes only)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun energyUsedWh(): Optional<Double> = energyUsedWh.getOptional("energy_used_wh")

        /**
         * Returns the raw JSON value of [distanceM].
         *
         * Unlike [distanceM], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("distance_m") @ExcludeMissing fun _distanceM(): JsonField<Double> = distanceM

        /**
         * Returns the raw JSON value of [durationS].
         *
         * Unlike [durationS], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("duration_s") @ExcludeMissing fun _durationS(): JsonField<Double> = durationS

        /**
         * Returns the raw JSON value of [annotations].
         *
         * Unlike [annotations], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("annotations")
        @ExcludeMissing
        fun _annotations(): JsonField<Annotations> = annotations

        /**
         * Returns the raw JSON value of [chargeProfile].
         *
         * Unlike [chargeProfile], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("charge_profile")
        @ExcludeMissing
        fun _chargeProfile(): JsonField<List<List<Double>>> = chargeProfile

        /**
         * Returns the raw JSON value of [chargingStops].
         *
         * Unlike [chargingStops], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("charging_stops")
        @ExcludeMissing
        fun _chargingStops(): JsonField<List<ChargingStop>> = chargingStops

        /**
         * Returns the raw JSON value of [edges].
         *
         * Unlike [edges], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("edges") @ExcludeMissing fun _edges(): JsonField<List<Edge>> = edges

        /**
         * Returns the raw JSON value of [energyUsedWh].
         *
         * Unlike [energyUsedWh], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("energy_used_wh")
        @ExcludeMissing
        fun _energyUsedWh(): JsonField<Double> = energyUsedWh

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
             * .distanceM()
             * .durationS()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Properties]. */
        class Builder internal constructor() {

            private var distanceM: JsonField<Double>? = null
            private var durationS: JsonField<Double>? = null
            private var annotations: JsonField<Annotations> = JsonMissing.of()
            private var chargeProfile: JsonField<MutableList<List<Double>>>? = null
            private var chargingStops: JsonField<MutableList<ChargingStop>>? = null
            private var edges: JsonField<MutableList<Edge>>? = null
            private var energyUsedWh: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(properties: Properties) = apply {
                distanceM = properties.distanceM
                durationS = properties.durationS
                annotations = properties.annotations
                chargeProfile = properties.chargeProfile.map { it.toMutableList() }
                chargingStops = properties.chargingStops.map { it.toMutableList() }
                edges = properties.edges.map { it.toMutableList() }
                energyUsedWh = properties.energyUsedWh
                additionalProperties = properties.additionalProperties.toMutableMap()
            }

            /** Total route distance in meters */
            fun distanceM(distanceM: Double) = distanceM(JsonField.of(distanceM))

            /**
             * Sets [Builder.distanceM] to an arbitrary JSON value.
             *
             * You should usually call [Builder.distanceM] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun distanceM(distanceM: JsonField<Double>) = apply { this.distanceM = distanceM }

            /** Estimated travel duration in seconds */
            fun durationS(durationS: Double) = durationS(JsonField.of(durationS))

            /**
             * Sets [Builder.durationS] to an arbitrary JSON value.
             *
             * You should usually call [Builder.durationS] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun durationS(durationS: JsonField<Double>) = apply { this.durationS = durationS }

            /** Per-edge annotations (present when `annotations: true` in request) */
            fun annotations(annotations: Annotations?) =
                annotations(JsonField.ofNullable(annotations))

            /** Alias for calling [Builder.annotations] with `annotations.orElse(null)`. */
            fun annotations(annotations: Optional<Annotations>) =
                annotations(annotations.getOrNull())

            /**
             * Sets [Builder.annotations] to an arbitrary JSON value.
             *
             * You should usually call [Builder.annotations] with a well-typed [Annotations] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun annotations(annotations: JsonField<Annotations>) = apply {
                this.annotations = annotations
            }

            /**
             * Battery charge level at route waypoints as [distance_fraction, charge_pct] pairs (EV
             * routes only)
             */
            fun chargeProfile(chargeProfile: List<List<Double>>?) =
                chargeProfile(JsonField.ofNullable(chargeProfile))

            /** Alias for calling [Builder.chargeProfile] with `chargeProfile.orElse(null)`. */
            fun chargeProfile(chargeProfile: Optional<List<List<Double>>>) =
                chargeProfile(chargeProfile.getOrNull())

            /**
             * Sets [Builder.chargeProfile] to an arbitrary JSON value.
             *
             * You should usually call [Builder.chargeProfile] with a well-typed
             * `List<List<Double>>` value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun chargeProfile(chargeProfile: JsonField<List<List<Double>>>) = apply {
                this.chargeProfile = chargeProfile.map { it.toMutableList() }
            }

            /**
             * Adds a single [List<Double>] to [Builder.chargeProfile].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addChargeProfile(chargeProfile: List<Double>) = apply {
                this.chargeProfile =
                    (this.chargeProfile ?: JsonField.of(mutableListOf())).also {
                        checkKnown("chargeProfile", it).add(chargeProfile)
                    }
            }

            /** Recommended charging stops along the route (EV routes only) */
            fun chargingStops(chargingStops: List<ChargingStop>?) =
                chargingStops(JsonField.ofNullable(chargingStops))

            /** Alias for calling [Builder.chargingStops] with `chargingStops.orElse(null)`. */
            fun chargingStops(chargingStops: Optional<List<ChargingStop>>) =
                chargingStops(chargingStops.getOrNull())

            /**
             * Sets [Builder.chargingStops] to an arbitrary JSON value.
             *
             * You should usually call [Builder.chargingStops] with a well-typed
             * `List<ChargingStop>` value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun chargingStops(chargingStops: JsonField<List<ChargingStop>>) = apply {
                this.chargingStops = chargingStops.map { it.toMutableList() }
            }

            /**
             * Adds a single [ChargingStop] to [chargingStops].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addChargingStop(chargingStop: ChargingStop) = apply {
                chargingStops =
                    (chargingStops ?: JsonField.of(mutableListOf())).also {
                        checkKnown("chargingStops", it).add(chargingStop)
                    }
            }

            /** Edge-level route details (present when `annotations: true`) */
            fun edges(edges: List<Edge>?) = edges(JsonField.ofNullable(edges))

            /** Alias for calling [Builder.edges] with `edges.orElse(null)`. */
            fun edges(edges: Optional<List<Edge>>) = edges(edges.getOrNull())

            /**
             * Sets [Builder.edges] to an arbitrary JSON value.
             *
             * You should usually call [Builder.edges] with a well-typed `List<Edge>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun edges(edges: JsonField<List<Edge>>) = apply {
                this.edges = edges.map { it.toMutableList() }
            }

            /**
             * Adds a single [Edge] to [edges].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addEdge(edge: Edge) = apply {
                edges =
                    (edges ?: JsonField.of(mutableListOf())).also {
                        checkKnown("edges", it).add(edge)
                    }
            }

            /** Total energy consumed in watt-hours (EV routes only) */
            fun energyUsedWh(energyUsedWh: Double?) =
                energyUsedWh(JsonField.ofNullable(energyUsedWh))

            /**
             * Alias for [Builder.energyUsedWh].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun energyUsedWh(energyUsedWh: Double) = energyUsedWh(energyUsedWh as Double?)

            /** Alias for calling [Builder.energyUsedWh] with `energyUsedWh.orElse(null)`. */
            fun energyUsedWh(energyUsedWh: Optional<Double>) =
                energyUsedWh(energyUsedWh.getOrNull())

            /**
             * Sets [Builder.energyUsedWh] to an arbitrary JSON value.
             *
             * You should usually call [Builder.energyUsedWh] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun energyUsedWh(energyUsedWh: JsonField<Double>) = apply {
                this.energyUsedWh = energyUsedWh
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
             *
             * The following fields are required:
             * ```java
             * .distanceM()
             * .durationS()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Properties =
                Properties(
                    checkRequired("distanceM", distanceM),
                    checkRequired("durationS", durationS),
                    annotations,
                    (chargeProfile ?: JsonMissing.of()).map { it.toImmutable() },
                    (chargingStops ?: JsonMissing.of()).map { it.toImmutable() },
                    (edges ?: JsonMissing.of()).map { it.toImmutable() },
                    energyUsedWh,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Properties = apply {
            if (validated) {
                return@apply
            }

            distanceM()
            durationS()
            annotations().ifPresent { it.validate() }
            chargeProfile()
            chargingStops().ifPresent { it.forEach { it.validate() } }
            edges().ifPresent { it.forEach { it.validate() } }
            energyUsedWh()
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
                (if (durationS.asKnown().isPresent) 1 else 0) +
                (annotations.asKnown().getOrNull()?.validity() ?: 0) +
                (chargeProfile.asKnown().getOrNull()?.sumOf { it.size.toInt() } ?: 0) +
                (chargingStops.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (edges.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (energyUsedWh.asKnown().isPresent) 1 else 0)

        /** Per-edge annotations (present when `annotations: true` in request) */
        class Annotations
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

                /** Returns a mutable builder for constructing an instance of [Annotations]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Annotations]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(annotations: Annotations) = apply {
                    additionalProperties = annotations.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Annotations].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Annotations = Annotations(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Annotations = apply {
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

                return other is Annotations && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Annotations{additionalProperties=$additionalProperties}"
        }

        class ChargingStop
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

                /** Returns a mutable builder for constructing an instance of [ChargingStop]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChargingStop]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(chargingStop: ChargingStop) = apply {
                    additionalProperties = chargingStop.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [ChargingStop].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ChargingStop = ChargingStop(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): ChargingStop = apply {
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

                return other is ChargingStop && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "ChargingStop{additionalProperties=$additionalProperties}"
        }

        class Edge
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

                /** Returns a mutable builder for constructing an instance of [Edge]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Edge]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(edge: Edge) = apply {
                    additionalProperties = edge.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Edge].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Edge = Edge(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Edge = apply {
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

                return other is Edge && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Edge{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Properties &&
                distanceM == other.distanceM &&
                durationS == other.durationS &&
                annotations == other.annotations &&
                chargeProfile == other.chargeProfile &&
                chargingStops == other.chargingStops &&
                edges == other.edges &&
                energyUsedWh == other.energyUsedWh &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                distanceM,
                durationS,
                annotations,
                chargeProfile,
                chargingStops,
                edges,
                energyUsedWh,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Properties{distanceM=$distanceM, durationS=$durationS, annotations=$annotations, chargeProfile=$chargeProfile, chargingStops=$chargingStops, edges=$edges, energyUsedWh=$energyUsedWh, additionalProperties=$additionalProperties}"
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

        return other is RouteResult &&
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
        "RouteResult{geometry=$geometry, properties=$properties, type=$type, additionalProperties=$additionalProperties}"
}
