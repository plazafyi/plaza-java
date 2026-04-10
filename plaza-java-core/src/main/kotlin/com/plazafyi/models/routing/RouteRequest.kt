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
import com.plazafyi.models.PointGeometry
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Request body for route calculation. Origin and destination are GeoJSON Point geometries. Supports
 * optional waypoints, alternative routes, turn-by-turn steps, and EV routing parameters.
 */
class RouteRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val destination: JsonField<PointGeometry>,
    private val origin: JsonField<PointGeometry>,
    private val alternatives: JsonField<Long>,
    private val annotations: JsonField<Boolean>,
    private val departAt: JsonField<OffsetDateTime>,
    private val ev: JsonField<Ev>,
    private val exclude: JsonField<String>,
    private val geometries: JsonField<Geometries>,
    private val mode: JsonField<Mode>,
    private val overview: JsonField<Overview>,
    private val steps: JsonField<Boolean>,
    private val trafficModel: JsonField<TrafficModel>,
    private val waypoints: JsonField<List<PointGeometry>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("destination")
        @ExcludeMissing
        destination: JsonField<PointGeometry> = JsonMissing.of(),
        @JsonProperty("origin") @ExcludeMissing origin: JsonField<PointGeometry> = JsonMissing.of(),
        @JsonProperty("alternatives")
        @ExcludeMissing
        alternatives: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("annotations")
        @ExcludeMissing
        annotations: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("depart_at")
        @ExcludeMissing
        departAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("ev") @ExcludeMissing ev: JsonField<Ev> = JsonMissing.of(),
        @JsonProperty("exclude") @ExcludeMissing exclude: JsonField<String> = JsonMissing.of(),
        @JsonProperty("geometries")
        @ExcludeMissing
        geometries: JsonField<Geometries> = JsonMissing.of(),
        @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of(),
        @JsonProperty("overview") @ExcludeMissing overview: JsonField<Overview> = JsonMissing.of(),
        @JsonProperty("steps") @ExcludeMissing steps: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("traffic_model")
        @ExcludeMissing
        trafficModel: JsonField<TrafficModel> = JsonMissing.of(),
        @JsonProperty("waypoints")
        @ExcludeMissing
        waypoints: JsonField<List<PointGeometry>> = JsonMissing.of(),
    ) : this(
        destination,
        origin,
        alternatives,
        annotations,
        departAt,
        ev,
        exclude,
        geometries,
        mode,
        overview,
        steps,
        trafficModel,
        waypoints,
        mutableMapOf(),
    )

    /**
     * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order. Optional
     * third element is altitude in meters.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun destination(): PointGeometry = destination.getRequired("destination")

    /**
     * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order. Optional
     * third element is altitude in meters.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun origin(): PointGeometry = origin.getRequired("origin")

    /**
     * Number of alternative routes to return (0-3, default 0). When > 0, response is a
     * FeatureCollection of route Features.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun alternatives(): Optional<Long> = alternatives.getOptional("alternatives")

    /**
     * Include per-edge annotations (speed, duration) on the route (default: false)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun annotations(): Optional<Boolean> = annotations.getOptional("annotations")

    /**
     * Departure time for traffic-aware routing (ISO 8601)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun departAt(): Optional<OffsetDateTime> = departAt.getOptional("depart_at")

    /**
     * Electric vehicle parameters for EV-aware routing
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun ev(): Optional<Ev> = ev.getOptional("ev")

    /**
     * Comma-separated road types to exclude (e.g. `toll,motorway,ferry`)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun exclude(): Optional<String> = exclude.getOptional("exclude")

    /**
     * Geometry encoding format. Default: `geojson`.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun geometries(): Optional<Geometries> = geometries.getOptional("geometries")

    /**
     * Travel mode (default: `auto`)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun mode(): Optional<Mode> = mode.getOptional("mode")

    /**
     * Level of geometry detail: `full` (all points), `simplified` (Douglas-Peucker), `false` (no
     * geometry). Default: `full`.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun overview(): Optional<Overview> = overview.getOptional("overview")

    /**
     * Include turn-by-turn navigation steps (default: false)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun steps(): Optional<Boolean> = steps.getOptional("steps")

    /**
     * Traffic prediction model (only used when `depart_at` is set)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun trafficModel(): Optional<TrafficModel> = trafficModel.getOptional("traffic_model")

    /**
     * Intermediate waypoints to visit in order (maximum 25)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun waypoints(): Optional<List<PointGeometry>> = waypoints.getOptional("waypoints")

    /**
     * Returns the raw JSON value of [destination].
     *
     * Unlike [destination], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("destination")
    @ExcludeMissing
    fun _destination(): JsonField<PointGeometry> = destination

    /**
     * Returns the raw JSON value of [origin].
     *
     * Unlike [origin], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("origin") @ExcludeMissing fun _origin(): JsonField<PointGeometry> = origin

    /**
     * Returns the raw JSON value of [alternatives].
     *
     * Unlike [alternatives], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("alternatives")
    @ExcludeMissing
    fun _alternatives(): JsonField<Long> = alternatives

    /**
     * Returns the raw JSON value of [annotations].
     *
     * Unlike [annotations], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("annotations")
    @ExcludeMissing
    fun _annotations(): JsonField<Boolean> = annotations

    /**
     * Returns the raw JSON value of [departAt].
     *
     * Unlike [departAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("depart_at") @ExcludeMissing fun _departAt(): JsonField<OffsetDateTime> = departAt

    /**
     * Returns the raw JSON value of [ev].
     *
     * Unlike [ev], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ev") @ExcludeMissing fun _ev(): JsonField<Ev> = ev

    /**
     * Returns the raw JSON value of [exclude].
     *
     * Unlike [exclude], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("exclude") @ExcludeMissing fun _exclude(): JsonField<String> = exclude

    /**
     * Returns the raw JSON value of [geometries].
     *
     * Unlike [geometries], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("geometries")
    @ExcludeMissing
    fun _geometries(): JsonField<Geometries> = geometries

    /**
     * Returns the raw JSON value of [mode].
     *
     * Unlike [mode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<Mode> = mode

    /**
     * Returns the raw JSON value of [overview].
     *
     * Unlike [overview], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("overview") @ExcludeMissing fun _overview(): JsonField<Overview> = overview

    /**
     * Returns the raw JSON value of [steps].
     *
     * Unlike [steps], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("steps") @ExcludeMissing fun _steps(): JsonField<Boolean> = steps

    /**
     * Returns the raw JSON value of [trafficModel].
     *
     * Unlike [trafficModel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("traffic_model")
    @ExcludeMissing
    fun _trafficModel(): JsonField<TrafficModel> = trafficModel

    /**
     * Returns the raw JSON value of [waypoints].
     *
     * Unlike [waypoints], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("waypoints")
    @ExcludeMissing
    fun _waypoints(): JsonField<List<PointGeometry>> = waypoints

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
         * Returns a mutable builder for constructing an instance of [RouteRequest].
         *
         * The following fields are required:
         * ```java
         * .destination()
         * .origin()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RouteRequest]. */
    class Builder internal constructor() {

        private var destination: JsonField<PointGeometry>? = null
        private var origin: JsonField<PointGeometry>? = null
        private var alternatives: JsonField<Long> = JsonMissing.of()
        private var annotations: JsonField<Boolean> = JsonMissing.of()
        private var departAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var ev: JsonField<Ev> = JsonMissing.of()
        private var exclude: JsonField<String> = JsonMissing.of()
        private var geometries: JsonField<Geometries> = JsonMissing.of()
        private var mode: JsonField<Mode> = JsonMissing.of()
        private var overview: JsonField<Overview> = JsonMissing.of()
        private var steps: JsonField<Boolean> = JsonMissing.of()
        private var trafficModel: JsonField<TrafficModel> = JsonMissing.of()
        private var waypoints: JsonField<MutableList<PointGeometry>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(routeRequest: RouteRequest) = apply {
            destination = routeRequest.destination
            origin = routeRequest.origin
            alternatives = routeRequest.alternatives
            annotations = routeRequest.annotations
            departAt = routeRequest.departAt
            ev = routeRequest.ev
            exclude = routeRequest.exclude
            geometries = routeRequest.geometries
            mode = routeRequest.mode
            overview = routeRequest.overview
            steps = routeRequest.steps
            trafficModel = routeRequest.trafficModel
            waypoints = routeRequest.waypoints.map { it.toMutableList() }
            additionalProperties = routeRequest.additionalProperties.toMutableMap()
        }

        /**
         * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order.
         * Optional third element is altitude in meters.
         */
        fun destination(destination: PointGeometry) = destination(JsonField.of(destination))

        /**
         * Sets [Builder.destination] to an arbitrary JSON value.
         *
         * You should usually call [Builder.destination] with a well-typed [PointGeometry] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun destination(destination: JsonField<PointGeometry>) = apply {
            this.destination = destination
        }

        /**
         * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order.
         * Optional third element is altitude in meters.
         */
        fun origin(origin: PointGeometry) = origin(JsonField.of(origin))

        /**
         * Sets [Builder.origin] to an arbitrary JSON value.
         *
         * You should usually call [Builder.origin] with a well-typed [PointGeometry] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun origin(origin: JsonField<PointGeometry>) = apply { this.origin = origin }

        /**
         * Number of alternative routes to return (0-3, default 0). When > 0, response is a
         * FeatureCollection of route Features.
         */
        fun alternatives(alternatives: Long) = alternatives(JsonField.of(alternatives))

        /**
         * Sets [Builder.alternatives] to an arbitrary JSON value.
         *
         * You should usually call [Builder.alternatives] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun alternatives(alternatives: JsonField<Long>) = apply { this.alternatives = alternatives }

        /** Include per-edge annotations (speed, duration) on the route (default: false) */
        fun annotations(annotations: Boolean) = annotations(JsonField.of(annotations))

        /**
         * Sets [Builder.annotations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.annotations] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun annotations(annotations: JsonField<Boolean>) = apply { this.annotations = annotations }

        /** Departure time for traffic-aware routing (ISO 8601) */
        fun departAt(departAt: OffsetDateTime?) = departAt(JsonField.ofNullable(departAt))

        /** Alias for calling [Builder.departAt] with `departAt.orElse(null)`. */
        fun departAt(departAt: Optional<OffsetDateTime>) = departAt(departAt.getOrNull())

        /**
         * Sets [Builder.departAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.departAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun departAt(departAt: JsonField<OffsetDateTime>) = apply { this.departAt = departAt }

        /** Electric vehicle parameters for EV-aware routing */
        fun ev(ev: Ev?) = ev(JsonField.ofNullable(ev))

        /** Alias for calling [Builder.ev] with `ev.orElse(null)`. */
        fun ev(ev: Optional<Ev>) = ev(ev.getOrNull())

        /**
         * Sets [Builder.ev] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ev] with a well-typed [Ev] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun ev(ev: JsonField<Ev>) = apply { this.ev = ev }

        /** Comma-separated road types to exclude (e.g. `toll,motorway,ferry`) */
        fun exclude(exclude: String?) = exclude(JsonField.ofNullable(exclude))

        /** Alias for calling [Builder.exclude] with `exclude.orElse(null)`. */
        fun exclude(exclude: Optional<String>) = exclude(exclude.getOrNull())

        /**
         * Sets [Builder.exclude] to an arbitrary JSON value.
         *
         * You should usually call [Builder.exclude] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun exclude(exclude: JsonField<String>) = apply { this.exclude = exclude }

        /** Geometry encoding format. Default: `geojson`. */
        fun geometries(geometries: Geometries) = geometries(JsonField.of(geometries))

        /**
         * Sets [Builder.geometries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.geometries] with a well-typed [Geometries] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun geometries(geometries: JsonField<Geometries>) = apply { this.geometries = geometries }

        /** Travel mode (default: `auto`) */
        fun mode(mode: Mode) = mode(JsonField.of(mode))

        /**
         * Sets [Builder.mode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mode] with a well-typed [Mode] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mode(mode: JsonField<Mode>) = apply { this.mode = mode }

        /**
         * Level of geometry detail: `full` (all points), `simplified` (Douglas-Peucker), `false`
         * (no geometry). Default: `full`.
         */
        fun overview(overview: Overview) = overview(JsonField.of(overview))

        /**
         * Sets [Builder.overview] to an arbitrary JSON value.
         *
         * You should usually call [Builder.overview] with a well-typed [Overview] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun overview(overview: JsonField<Overview>) = apply { this.overview = overview }

        /** Include turn-by-turn navigation steps (default: false) */
        fun steps(steps: Boolean) = steps(JsonField.of(steps))

        /**
         * Sets [Builder.steps] to an arbitrary JSON value.
         *
         * You should usually call [Builder.steps] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun steps(steps: JsonField<Boolean>) = apply { this.steps = steps }

        /** Traffic prediction model (only used when `depart_at` is set) */
        fun trafficModel(trafficModel: TrafficModel?) =
            trafficModel(JsonField.ofNullable(trafficModel))

        /** Alias for calling [Builder.trafficModel] with `trafficModel.orElse(null)`. */
        fun trafficModel(trafficModel: Optional<TrafficModel>) =
            trafficModel(trafficModel.getOrNull())

        /**
         * Sets [Builder.trafficModel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.trafficModel] with a well-typed [TrafficModel] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun trafficModel(trafficModel: JsonField<TrafficModel>) = apply {
            this.trafficModel = trafficModel
        }

        /** Intermediate waypoints to visit in order (maximum 25) */
        fun waypoints(waypoints: List<PointGeometry>?) = waypoints(JsonField.ofNullable(waypoints))

        /** Alias for calling [Builder.waypoints] with `waypoints.orElse(null)`. */
        fun waypoints(waypoints: Optional<List<PointGeometry>>) = waypoints(waypoints.getOrNull())

        /**
         * Sets [Builder.waypoints] to an arbitrary JSON value.
         *
         * You should usually call [Builder.waypoints] with a well-typed `List<PointGeometry>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun waypoints(waypoints: JsonField<List<PointGeometry>>) = apply {
            this.waypoints = waypoints.map { it.toMutableList() }
        }

        /**
         * Adds a single [PointGeometry] to [waypoints].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addWaypoint(waypoint: PointGeometry) = apply {
            waypoints =
                (waypoints ?: JsonField.of(mutableListOf())).also {
                    checkKnown("waypoints", it).add(waypoint)
                }
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
         * Returns an immutable instance of [RouteRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .destination()
         * .origin()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RouteRequest =
            RouteRequest(
                checkRequired("destination", destination),
                checkRequired("origin", origin),
                alternatives,
                annotations,
                departAt,
                ev,
                exclude,
                geometries,
                mode,
                overview,
                steps,
                trafficModel,
                (waypoints ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RouteRequest = apply {
        if (validated) {
            return@apply
        }

        destination().validate()
        origin().validate()
        alternatives()
        annotations()
        departAt()
        ev().ifPresent { it.validate() }
        exclude()
        geometries().ifPresent { it.validate() }
        mode().ifPresent { it.validate() }
        overview().ifPresent { it.validate() }
        steps()
        trafficModel().ifPresent { it.validate() }
        waypoints().ifPresent { it.forEach { it.validate() } }
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
        (destination.asKnown().getOrNull()?.validity() ?: 0) +
            (origin.asKnown().getOrNull()?.validity() ?: 0) +
            (if (alternatives.asKnown().isPresent) 1 else 0) +
            (if (annotations.asKnown().isPresent) 1 else 0) +
            (if (departAt.asKnown().isPresent) 1 else 0) +
            (ev.asKnown().getOrNull()?.validity() ?: 0) +
            (if (exclude.asKnown().isPresent) 1 else 0) +
            (geometries.asKnown().getOrNull()?.validity() ?: 0) +
            (mode.asKnown().getOrNull()?.validity() ?: 0) +
            (overview.asKnown().getOrNull()?.validity() ?: 0) +
            (if (steps.asKnown().isPresent) 1 else 0) +
            (trafficModel.asKnown().getOrNull()?.validity() ?: 0) +
            (waypoints.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** Electric vehicle parameters for EV-aware routing */
    class Ev
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val batteryCapacityWh: JsonField<Double>,
        private val connectorTypes: JsonField<List<String>>,
        private val initialChargePct: JsonField<Double>,
        private val minChargePct: JsonField<Double>,
        private val minPowerKw: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("battery_capacity_wh")
            @ExcludeMissing
            batteryCapacityWh: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("connector_types")
            @ExcludeMissing
            connectorTypes: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("initial_charge_pct")
            @ExcludeMissing
            initialChargePct: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("min_charge_pct")
            @ExcludeMissing
            minChargePct: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("min_power_kw")
            @ExcludeMissing
            minPowerKw: JsonField<Double> = JsonMissing.of(),
        ) : this(
            batteryCapacityWh,
            connectorTypes,
            initialChargePct,
            minChargePct,
            minPowerKw,
            mutableMapOf(),
        )

        /**
         * Total battery capacity in watt-hours (required for EV routing)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun batteryCapacityWh(): Double = batteryCapacityWh.getRequired("battery_capacity_wh")

        /**
         * Acceptable connector types (e.g. `["ccs", "chademo"]`)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun connectorTypes(): Optional<List<String>> = connectorTypes.getOptional("connector_types")

        /**
         * Starting charge as a fraction 0-1 (default: 0.8)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun initialChargePct(): Optional<Double> =
            initialChargePct.getOptional("initial_charge_pct")

        /**
         * Minimum acceptable charge at destination as a fraction 0-1 (default: 0.10)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun minChargePct(): Optional<Double> = minChargePct.getOptional("min_charge_pct")

        /**
         * Minimum charger power in kilowatts
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun minPowerKw(): Optional<Double> = minPowerKw.getOptional("min_power_kw")

        /**
         * Returns the raw JSON value of [batteryCapacityWh].
         *
         * Unlike [batteryCapacityWh], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("battery_capacity_wh")
        @ExcludeMissing
        fun _batteryCapacityWh(): JsonField<Double> = batteryCapacityWh

        /**
         * Returns the raw JSON value of [connectorTypes].
         *
         * Unlike [connectorTypes], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("connector_types")
        @ExcludeMissing
        fun _connectorTypes(): JsonField<List<String>> = connectorTypes

        /**
         * Returns the raw JSON value of [initialChargePct].
         *
         * Unlike [initialChargePct], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("initial_charge_pct")
        @ExcludeMissing
        fun _initialChargePct(): JsonField<Double> = initialChargePct

        /**
         * Returns the raw JSON value of [minChargePct].
         *
         * Unlike [minChargePct], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("min_charge_pct")
        @ExcludeMissing
        fun _minChargePct(): JsonField<Double> = minChargePct

        /**
         * Returns the raw JSON value of [minPowerKw].
         *
         * Unlike [minPowerKw], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("min_power_kw")
        @ExcludeMissing
        fun _minPowerKw(): JsonField<Double> = minPowerKw

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
             * Returns a mutable builder for constructing an instance of [Ev].
             *
             * The following fields are required:
             * ```java
             * .batteryCapacityWh()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Ev]. */
        class Builder internal constructor() {

            private var batteryCapacityWh: JsonField<Double>? = null
            private var connectorTypes: JsonField<MutableList<String>>? = null
            private var initialChargePct: JsonField<Double> = JsonMissing.of()
            private var minChargePct: JsonField<Double> = JsonMissing.of()
            private var minPowerKw: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(ev: Ev) = apply {
                batteryCapacityWh = ev.batteryCapacityWh
                connectorTypes = ev.connectorTypes.map { it.toMutableList() }
                initialChargePct = ev.initialChargePct
                minChargePct = ev.minChargePct
                minPowerKw = ev.minPowerKw
                additionalProperties = ev.additionalProperties.toMutableMap()
            }

            /** Total battery capacity in watt-hours (required for EV routing) */
            fun batteryCapacityWh(batteryCapacityWh: Double) =
                batteryCapacityWh(JsonField.of(batteryCapacityWh))

            /**
             * Sets [Builder.batteryCapacityWh] to an arbitrary JSON value.
             *
             * You should usually call [Builder.batteryCapacityWh] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun batteryCapacityWh(batteryCapacityWh: JsonField<Double>) = apply {
                this.batteryCapacityWh = batteryCapacityWh
            }

            /** Acceptable connector types (e.g. `["ccs", "chademo"]`) */
            fun connectorTypes(connectorTypes: List<String>?) =
                connectorTypes(JsonField.ofNullable(connectorTypes))

            /** Alias for calling [Builder.connectorTypes] with `connectorTypes.orElse(null)`. */
            fun connectorTypes(connectorTypes: Optional<List<String>>) =
                connectorTypes(connectorTypes.getOrNull())

            /**
             * Sets [Builder.connectorTypes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.connectorTypes] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun connectorTypes(connectorTypes: JsonField<List<String>>) = apply {
                this.connectorTypes = connectorTypes.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [connectorTypes].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addConnectorType(connectorType: String) = apply {
                connectorTypes =
                    (connectorTypes ?: JsonField.of(mutableListOf())).also {
                        checkKnown("connectorTypes", it).add(connectorType)
                    }
            }

            /** Starting charge as a fraction 0-1 (default: 0.8) */
            fun initialChargePct(initialChargePct: Double) =
                initialChargePct(JsonField.of(initialChargePct))

            /**
             * Sets [Builder.initialChargePct] to an arbitrary JSON value.
             *
             * You should usually call [Builder.initialChargePct] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun initialChargePct(initialChargePct: JsonField<Double>) = apply {
                this.initialChargePct = initialChargePct
            }

            /** Minimum acceptable charge at destination as a fraction 0-1 (default: 0.10) */
            fun minChargePct(minChargePct: Double) = minChargePct(JsonField.of(minChargePct))

            /**
             * Sets [Builder.minChargePct] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minChargePct] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minChargePct(minChargePct: JsonField<Double>) = apply {
                this.minChargePct = minChargePct
            }

            /** Minimum charger power in kilowatts */
            fun minPowerKw(minPowerKw: Double?) = minPowerKw(JsonField.ofNullable(minPowerKw))

            /**
             * Alias for [Builder.minPowerKw].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun minPowerKw(minPowerKw: Double) = minPowerKw(minPowerKw as Double?)

            /** Alias for calling [Builder.minPowerKw] with `minPowerKw.orElse(null)`. */
            fun minPowerKw(minPowerKw: Optional<Double>) = minPowerKw(minPowerKw.getOrNull())

            /**
             * Sets [Builder.minPowerKw] to an arbitrary JSON value.
             *
             * You should usually call [Builder.minPowerKw] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun minPowerKw(minPowerKw: JsonField<Double>) = apply { this.minPowerKw = minPowerKw }

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
             * Returns an immutable instance of [Ev].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .batteryCapacityWh()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Ev =
                Ev(
                    checkRequired("batteryCapacityWh", batteryCapacityWh),
                    (connectorTypes ?: JsonMissing.of()).map { it.toImmutable() },
                    initialChargePct,
                    minChargePct,
                    minPowerKw,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Ev = apply {
            if (validated) {
                return@apply
            }

            batteryCapacityWh()
            connectorTypes()
            initialChargePct()
            minChargePct()
            minPowerKw()
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
            (if (batteryCapacityWh.asKnown().isPresent) 1 else 0) +
                (connectorTypes.asKnown().getOrNull()?.size ?: 0) +
                (if (initialChargePct.asKnown().isPresent) 1 else 0) +
                (if (minChargePct.asKnown().isPresent) 1 else 0) +
                (if (minPowerKw.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Ev &&
                batteryCapacityWh == other.batteryCapacityWh &&
                connectorTypes == other.connectorTypes &&
                initialChargePct == other.initialChargePct &&
                minChargePct == other.minChargePct &&
                minPowerKw == other.minPowerKw &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                batteryCapacityWh,
                connectorTypes,
                initialChargePct,
                minChargePct,
                minPowerKw,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Ev{batteryCapacityWh=$batteryCapacityWh, connectorTypes=$connectorTypes, initialChargePct=$initialChargePct, minChargePct=$minChargePct, minPowerKw=$minPowerKw, additionalProperties=$additionalProperties}"
    }

    /** Geometry encoding format. Default: `geojson`. */
    class Geometries @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val GEOJSON = of("geojson")

            @JvmField val POLYLINE = of("polyline")

            @JvmField val POLYLINE6 = of("polyline6")

            @JvmStatic fun of(value: String) = Geometries(JsonField.of(value))
        }

        /** An enum containing [Geometries]'s known values. */
        enum class Known {
            GEOJSON,
            POLYLINE,
            POLYLINE6,
        }

        /**
         * An enum containing [Geometries]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Geometries] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            GEOJSON,
            POLYLINE,
            POLYLINE6,
            /**
             * An enum member indicating that [Geometries] was instantiated with an unknown value.
             */
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
                GEOJSON -> Value.GEOJSON
                POLYLINE -> Value.POLYLINE
                POLYLINE6 -> Value.POLYLINE6
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
                GEOJSON -> Known.GEOJSON
                POLYLINE -> Known.POLYLINE
                POLYLINE6 -> Known.POLYLINE6
                else -> throw PlazaInvalidDataException("Unknown Geometries: $value")
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

        fun validate(): Geometries = apply {
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

            return other is Geometries && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Travel mode (default: `auto`) */
    class Mode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
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
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
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
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws PlazaInvalidDataException if this class instance's value is a not a known member.
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
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws PlazaInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { PlazaInvalidDataException("Value is not a String") }

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

    /**
     * Level of geometry detail: `full` (all points), `simplified` (Douglas-Peucker), `false` (no
     * geometry). Default: `full`.
     */
    class Overview @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val FULL = of("full")

            @JvmField val SIMPLIFIED = of("simplified")

            @JvmField val FALSE = of("false")

            @JvmStatic fun of(value: String) = Overview(JsonField.of(value))
        }

        /** An enum containing [Overview]'s known values. */
        enum class Known {
            FULL,
            SIMPLIFIED,
            FALSE,
        }

        /**
         * An enum containing [Overview]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Overview] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            FULL,
            SIMPLIFIED,
            FALSE,
            /** An enum member indicating that [Overview] was instantiated with an unknown value. */
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
                FULL -> Value.FULL
                SIMPLIFIED -> Value.SIMPLIFIED
                FALSE -> Value.FALSE
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
                FULL -> Known.FULL
                SIMPLIFIED -> Known.SIMPLIFIED
                FALSE -> Known.FALSE
                else -> throw PlazaInvalidDataException("Unknown Overview: $value")
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

        fun validate(): Overview = apply {
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

            return other is Overview && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Traffic prediction model (only used when `depart_at` is set) */
    class TrafficModel @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val BEST_GUESS = of("best_guess")

            @JvmField val OPTIMISTIC = of("optimistic")

            @JvmField val PESSIMISTIC = of("pessimistic")

            @JvmStatic fun of(value: String) = TrafficModel(JsonField.of(value))
        }

        /** An enum containing [TrafficModel]'s known values. */
        enum class Known {
            BEST_GUESS,
            OPTIMISTIC,
            PESSIMISTIC,
        }

        /**
         * An enum containing [TrafficModel]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [TrafficModel] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            BEST_GUESS,
            OPTIMISTIC,
            PESSIMISTIC,
            /**
             * An enum member indicating that [TrafficModel] was instantiated with an unknown value.
             */
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
                BEST_GUESS -> Value.BEST_GUESS
                OPTIMISTIC -> Value.OPTIMISTIC
                PESSIMISTIC -> Value.PESSIMISTIC
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
                BEST_GUESS -> Known.BEST_GUESS
                OPTIMISTIC -> Known.OPTIMISTIC
                PESSIMISTIC -> Known.PESSIMISTIC
                else -> throw PlazaInvalidDataException("Unknown TrafficModel: $value")
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

        fun validate(): TrafficModel = apply {
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

            return other is TrafficModel && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RouteRequest &&
            destination == other.destination &&
            origin == other.origin &&
            alternatives == other.alternatives &&
            annotations == other.annotations &&
            departAt == other.departAt &&
            ev == other.ev &&
            exclude == other.exclude &&
            geometries == other.geometries &&
            mode == other.mode &&
            overview == other.overview &&
            steps == other.steps &&
            trafficModel == other.trafficModel &&
            waypoints == other.waypoints &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            destination,
            origin,
            alternatives,
            annotations,
            departAt,
            ev,
            exclude,
            geometries,
            mode,
            overview,
            steps,
            trafficModel,
            waypoints,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RouteRequest{destination=$destination, origin=$origin, alternatives=$alternatives, annotations=$annotations, departAt=$departAt, ev=$ev, exclude=$exclude, geometries=$geometries, mode=$mode, overview=$overview, steps=$steps, trafficModel=$trafficModel, waypoints=$waypoints, additionalProperties=$additionalProperties}"
}
