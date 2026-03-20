// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.mapmatch

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
import com.plazafyi.models.GeoJsonGeometry
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Map matching result as a GeoJSON FeatureCollection. Each Feature is a snapped tracepoint. The
 * top-level `matchings` array contains the matched sub-routes connecting consecutive tracepoints.
 */
class MapMatchResult
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val features: JsonField<List<Feature>>,
    private val matchings: JsonField<List<Matching>>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("features")
        @ExcludeMissing
        features: JsonField<List<Feature>> = JsonMissing.of(),
        @JsonProperty("matchings")
        @ExcludeMissing
        matchings: JsonField<List<Matching>> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(features, matchings, type, mutableMapOf())

    /**
     * Snapped tracepoint Features in input order
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun features(): List<Feature> = features.getRequired("features")

    /**
     * Matched sub-routes. Each matching connects a contiguous sequence of tracepoints that could be
     * matched to roads.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun matchings(): List<Matching> = matchings.getRequired("matchings")

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
     * Returns the raw JSON value of [matchings].
     *
     * Unlike [matchings], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("matchings")
    @ExcludeMissing
    fun _matchings(): JsonField<List<Matching>> = matchings

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
         * Returns a mutable builder for constructing an instance of [MapMatchResult].
         *
         * The following fields are required:
         * ```java
         * .features()
         * .matchings()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MapMatchResult]. */
    class Builder internal constructor() {

        private var features: JsonField<MutableList<Feature>>? = null
        private var matchings: JsonField<MutableList<Matching>>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(mapMatchResult: MapMatchResult) = apply {
            features = mapMatchResult.features.map { it.toMutableList() }
            matchings = mapMatchResult.matchings.map { it.toMutableList() }
            type = mapMatchResult.type
            additionalProperties = mapMatchResult.additionalProperties.toMutableMap()
        }

        /** Snapped tracepoint Features in input order */
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

        /**
         * Matched sub-routes. Each matching connects a contiguous sequence of tracepoints that
         * could be matched to roads.
         */
        fun matchings(matchings: List<Matching>) = matchings(JsonField.of(matchings))

        /**
         * Sets [Builder.matchings] to an arbitrary JSON value.
         *
         * You should usually call [Builder.matchings] with a well-typed `List<Matching>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun matchings(matchings: JsonField<List<Matching>>) = apply {
            this.matchings = matchings.map { it.toMutableList() }
        }

        /**
         * Adds a single [Matching] to [matchings].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMatching(matching: Matching) = apply {
            matchings =
                (matchings ?: JsonField.of(mutableListOf())).also {
                    checkKnown("matchings", it).add(matching)
                }
        }

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
         * Returns an immutable instance of [MapMatchResult].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .features()
         * .matchings()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MapMatchResult =
            MapMatchResult(
                checkRequired("features", features).map { it.toImmutable() },
                checkRequired("matchings", matchings).map { it.toImmutable() },
                checkRequired("type", type),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MapMatchResult = apply {
        if (validated) {
            return@apply
        }

        features().forEach { it.validate() }
        matchings().forEach { it.validate() }
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
            (matchings.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0)

    /** GeoJSON Point Feature representing a GPS point snapped to the road network. */
    class Feature
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
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun geometry(): GeoJsonGeometry = geometry.getRequired("geometry")

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
        @JsonProperty("geometry")
        @ExcludeMissing
        fun _geometry(): JsonField<GeoJsonGeometry> = geometry

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

            private var geometry: JsonField<GeoJsonGeometry>? = null
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
            private val distanceM: JsonField<Double>,
            private val edgeId: JsonField<Long>,
            private val matchingsIndex: JsonField<Long>,
            private val name: JsonField<String>,
            private val original: JsonField<List<Double>>,
            private val waypointIndex: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("distance_m")
                @ExcludeMissing
                distanceM: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("edge_id") @ExcludeMissing edgeId: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("matchings_index")
                @ExcludeMissing
                matchingsIndex: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("original")
                @ExcludeMissing
                original: JsonField<List<Double>> = JsonMissing.of(),
                @JsonProperty("waypoint_index")
                @ExcludeMissing
                waypointIndex: JsonField<Long> = JsonMissing.of(),
            ) : this(
                distanceM,
                edgeId,
                matchingsIndex,
                name,
                original,
                waypointIndex,
                mutableMapOf(),
            )

            /**
             * Distance from the original GPS point to the snapped point in meters
             *
             * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun distanceM(): Optional<Double> = distanceM.getOptional("distance_m")

            /**
             * Road edge ID the point was snapped to
             *
             * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun edgeId(): Optional<Long> = edgeId.getOptional("edge_id")

            /**
             * Index into the `matchings` array indicating which matching sub-route this point
             * belongs to
             *
             * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun matchingsIndex(): Optional<Long> = matchingsIndex.getOptional("matchings_index")

            /**
             * Road name at the snapped point
             *
             * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Original GPS coordinate as [lng, lat]
             *
             * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun original(): Optional<List<Double>> = original.getOptional("original")

            /**
             * Index of this tracepoint in the original `coordinates` array
             *
             * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun waypointIndex(): Optional<Long> = waypointIndex.getOptional("waypoint_index")

            /**
             * Returns the raw JSON value of [distanceM].
             *
             * Unlike [distanceM], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("distance_m")
            @ExcludeMissing
            fun _distanceM(): JsonField<Double> = distanceM

            /**
             * Returns the raw JSON value of [edgeId].
             *
             * Unlike [edgeId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("edge_id") @ExcludeMissing fun _edgeId(): JsonField<Long> = edgeId

            /**
             * Returns the raw JSON value of [matchingsIndex].
             *
             * Unlike [matchingsIndex], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("matchings_index")
            @ExcludeMissing
            fun _matchingsIndex(): JsonField<Long> = matchingsIndex

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [original].
             *
             * Unlike [original], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("original")
            @ExcludeMissing
            fun _original(): JsonField<List<Double>> = original

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

                /** Returns a mutable builder for constructing an instance of [Properties]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Properties]. */
            class Builder internal constructor() {

                private var distanceM: JsonField<Double> = JsonMissing.of()
                private var edgeId: JsonField<Long> = JsonMissing.of()
                private var matchingsIndex: JsonField<Long> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var original: JsonField<MutableList<Double>>? = null
                private var waypointIndex: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(properties: Properties) = apply {
                    distanceM = properties.distanceM
                    edgeId = properties.edgeId
                    matchingsIndex = properties.matchingsIndex
                    name = properties.name
                    original = properties.original.map { it.toMutableList() }
                    waypointIndex = properties.waypointIndex
                    additionalProperties = properties.additionalProperties.toMutableMap()
                }

                /** Distance from the original GPS point to the snapped point in meters */
                fun distanceM(distanceM: Double) = distanceM(JsonField.of(distanceM))

                /**
                 * Sets [Builder.distanceM] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.distanceM] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun distanceM(distanceM: JsonField<Double>) = apply { this.distanceM = distanceM }

                /** Road edge ID the point was snapped to */
                fun edgeId(edgeId: Long) = edgeId(JsonField.of(edgeId))

                /**
                 * Sets [Builder.edgeId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.edgeId] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun edgeId(edgeId: JsonField<Long>) = apply { this.edgeId = edgeId }

                /**
                 * Index into the `matchings` array indicating which matching sub-route this point
                 * belongs to
                 */
                fun matchingsIndex(matchingsIndex: Long) =
                    matchingsIndex(JsonField.of(matchingsIndex))

                /**
                 * Sets [Builder.matchingsIndex] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.matchingsIndex] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun matchingsIndex(matchingsIndex: JsonField<Long>) = apply {
                    this.matchingsIndex = matchingsIndex
                }

                /** Road name at the snapped point */
                fun name(name: String?) = name(JsonField.ofNullable(name))

                /** Alias for calling [Builder.name] with `name.orElse(null)`. */
                fun name(name: Optional<String>) = name(name.getOrNull())

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Original GPS coordinate as [lng, lat] */
                fun original(original: List<Double>) = original(JsonField.of(original))

                /**
                 * Sets [Builder.original] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.original] with a well-typed `List<Double>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun original(original: JsonField<List<Double>>) = apply {
                    this.original = original.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Double] to [Builder.original].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addOriginal(original: Double) = apply {
                    this.original =
                        (this.original ?: JsonField.of(mutableListOf())).also {
                            checkKnown("original", it).add(original)
                        }
                }

                /** Index of this tracepoint in the original `coordinates` array */
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
                 */
                fun build(): Properties =
                    Properties(
                        distanceM,
                        edgeId,
                        matchingsIndex,
                        name,
                        (original ?: JsonMissing.of()).map { it.toImmutable() },
                        waypointIndex,
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
                matchingsIndex()
                name()
                original()
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
                (if (distanceM.asKnown().isPresent) 1 else 0) +
                    (if (edgeId.asKnown().isPresent) 1 else 0) +
                    (if (matchingsIndex.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (original.asKnown().getOrNull()?.size ?: 0) +
                    (if (waypointIndex.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Properties &&
                    distanceM == other.distanceM &&
                    edgeId == other.edgeId &&
                    matchingsIndex == other.matchingsIndex &&
                    name == other.name &&
                    original == other.original &&
                    waypointIndex == other.waypointIndex &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    distanceM,
                    edgeId,
                    matchingsIndex,
                    name,
                    original,
                    waypointIndex,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Properties{distanceM=$distanceM, edgeId=$edgeId, matchingsIndex=$matchingsIndex, name=$name, original=$original, waypointIndex=$waypointIndex, additionalProperties=$additionalProperties}"
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

    class Matching
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

            /** Returns a mutable builder for constructing an instance of [Matching]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Matching]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(matching: Matching) = apply {
                additionalProperties = matching.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Matching].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Matching = Matching(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Matching = apply {
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

            return other is Matching && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Matching{additionalProperties=$additionalProperties}"
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

        return other is MapMatchResult &&
            features == other.features &&
            matchings == other.matchings &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(features, matchings, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MapMatchResult{features=$features, matchings=$matchings, type=$type, additionalProperties=$additionalProperties}"
}
