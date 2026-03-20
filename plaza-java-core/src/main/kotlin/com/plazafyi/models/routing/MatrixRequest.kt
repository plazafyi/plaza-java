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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Request body for distance matrix calculation. Computes travel durations (and optionally
 * distances) between every origin-destination pair. Maximum 2,500 pairs (origins × destinations),
 * each list capped at 50 coordinates.
 */
class MatrixRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val destinations: JsonField<List<Destination>>,
    private val origins: JsonField<List<Origin>>,
    private val annotations: JsonField<String>,
    private val fallbackSpeed: JsonField<Double>,
    private val mode: JsonField<Mode>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("destinations")
        @ExcludeMissing
        destinations: JsonField<List<Destination>> = JsonMissing.of(),
        @JsonProperty("origins")
        @ExcludeMissing
        origins: JsonField<List<Origin>> = JsonMissing.of(),
        @JsonProperty("annotations")
        @ExcludeMissing
        annotations: JsonField<String> = JsonMissing.of(),
        @JsonProperty("fallback_speed")
        @ExcludeMissing
        fallbackSpeed: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of(),
    ) : this(destinations, origins, annotations, fallbackSpeed, mode, mutableMapOf())

    /**
     * Array of destination coordinates (max 50)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun destinations(): List<Destination> = destinations.getRequired("destinations")

    /**
     * Array of origin coordinates (max 50)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun origins(): List<Origin> = origins.getRequired("origins")

    /**
     * Comma-separated list of annotations to include: `duration` (always included), `distance`.
     * Example: `duration,distance`.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun annotations(): Optional<String> = annotations.getOptional("annotations")

    /**
     * Fallback speed in km/h for pairs where no route exists. When set, unreachable pairs get
     * estimated values instead of null.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fallbackSpeed(): Optional<Double> = fallbackSpeed.getOptional("fallback_speed")

    /**
     * Travel mode (default: `auto`)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun mode(): Optional<Mode> = mode.getOptional("mode")

    /**
     * Returns the raw JSON value of [destinations].
     *
     * Unlike [destinations], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("destinations")
    @ExcludeMissing
    fun _destinations(): JsonField<List<Destination>> = destinations

    /**
     * Returns the raw JSON value of [origins].
     *
     * Unlike [origins], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("origins") @ExcludeMissing fun _origins(): JsonField<List<Origin>> = origins

    /**
     * Returns the raw JSON value of [annotations].
     *
     * Unlike [annotations], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("annotations") @ExcludeMissing fun _annotations(): JsonField<String> = annotations

    /**
     * Returns the raw JSON value of [fallbackSpeed].
     *
     * Unlike [fallbackSpeed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("fallback_speed")
    @ExcludeMissing
    fun _fallbackSpeed(): JsonField<Double> = fallbackSpeed

    /**
     * Returns the raw JSON value of [mode].
     *
     * Unlike [mode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<Mode> = mode

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
         * Returns a mutable builder for constructing an instance of [MatrixRequest].
         *
         * The following fields are required:
         * ```java
         * .destinations()
         * .origins()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MatrixRequest]. */
    class Builder internal constructor() {

        private var destinations: JsonField<MutableList<Destination>>? = null
        private var origins: JsonField<MutableList<Origin>>? = null
        private var annotations: JsonField<String> = JsonMissing.of()
        private var fallbackSpeed: JsonField<Double> = JsonMissing.of()
        private var mode: JsonField<Mode> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(matrixRequest: MatrixRequest) = apply {
            destinations = matrixRequest.destinations.map { it.toMutableList() }
            origins = matrixRequest.origins.map { it.toMutableList() }
            annotations = matrixRequest.annotations
            fallbackSpeed = matrixRequest.fallbackSpeed
            mode = matrixRequest.mode
            additionalProperties = matrixRequest.additionalProperties.toMutableMap()
        }

        /** Array of destination coordinates (max 50) */
        fun destinations(destinations: List<Destination>) = destinations(JsonField.of(destinations))

        /**
         * Sets [Builder.destinations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.destinations] with a well-typed `List<Destination>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun destinations(destinations: JsonField<List<Destination>>) = apply {
            this.destinations = destinations.map { it.toMutableList() }
        }

        /**
         * Adds a single [Destination] to [destinations].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDestination(destination: Destination) = apply {
            destinations =
                (destinations ?: JsonField.of(mutableListOf())).also {
                    checkKnown("destinations", it).add(destination)
                }
        }

        /** Array of origin coordinates (max 50) */
        fun origins(origins: List<Origin>) = origins(JsonField.of(origins))

        /**
         * Sets [Builder.origins] to an arbitrary JSON value.
         *
         * You should usually call [Builder.origins] with a well-typed `List<Origin>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun origins(origins: JsonField<List<Origin>>) = apply {
            this.origins = origins.map { it.toMutableList() }
        }

        /**
         * Adds a single [Origin] to [origins].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addOrigin(origin: Origin) = apply {
            origins =
                (origins ?: JsonField.of(mutableListOf())).also {
                    checkKnown("origins", it).add(origin)
                }
        }

        /**
         * Comma-separated list of annotations to include: `duration` (always included), `distance`.
         * Example: `duration,distance`.
         */
        fun annotations(annotations: String) = annotations(JsonField.of(annotations))

        /**
         * Sets [Builder.annotations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.annotations] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun annotations(annotations: JsonField<String>) = apply { this.annotations = annotations }

        /**
         * Fallback speed in km/h for pairs where no route exists. When set, unreachable pairs get
         * estimated values instead of null.
         */
        fun fallbackSpeed(fallbackSpeed: Double?) =
            fallbackSpeed(JsonField.ofNullable(fallbackSpeed))

        /**
         * Alias for [Builder.fallbackSpeed].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun fallbackSpeed(fallbackSpeed: Double) = fallbackSpeed(fallbackSpeed as Double?)

        /** Alias for calling [Builder.fallbackSpeed] with `fallbackSpeed.orElse(null)`. */
        fun fallbackSpeed(fallbackSpeed: Optional<Double>) =
            fallbackSpeed(fallbackSpeed.getOrNull())

        /**
         * Sets [Builder.fallbackSpeed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fallbackSpeed] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fallbackSpeed(fallbackSpeed: JsonField<Double>) = apply {
            this.fallbackSpeed = fallbackSpeed
        }

        /** Travel mode (default: `auto`) */
        fun mode(mode: Mode) = mode(JsonField.of(mode))

        /**
         * Sets [Builder.mode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mode] with a well-typed [Mode] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mode(mode: JsonField<Mode>) = apply { this.mode = mode }

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
         * Returns an immutable instance of [MatrixRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .destinations()
         * .origins()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MatrixRequest =
            MatrixRequest(
                checkRequired("destinations", destinations).map { it.toImmutable() },
                checkRequired("origins", origins).map { it.toImmutable() },
                annotations,
                fallbackSpeed,
                mode,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MatrixRequest = apply {
        if (validated) {
            return@apply
        }

        destinations().forEach { it.validate() }
        origins().forEach { it.validate() }
        annotations()
        fallbackSpeed()
        mode().ifPresent { it.validate() }
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
        (destinations.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (origins.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (annotations.asKnown().isPresent) 1 else 0) +
            (if (fallbackSpeed.asKnown().isPresent) 1 else 0) +
            (mode.asKnown().getOrNull()?.validity() ?: 0)

    /** Geographic coordinate as a JSON object with `lat` and `lng` fields. */
    class Destination
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val lat: JsonField<Double>,
        private val lng: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("lat") @ExcludeMissing lat: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("lng") @ExcludeMissing lng: JsonField<Double> = JsonMissing.of(),
        ) : this(lat, lng, mutableMapOf())

        /**
         * Latitude in decimal degrees (-90 to 90)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun lat(): Double = lat.getRequired("lat")

        /**
         * Longitude in decimal degrees (-180 to 180)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun lng(): Double = lng.getRequired("lng")

        /**
         * Returns the raw JSON value of [lat].
         *
         * Unlike [lat], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("lat") @ExcludeMissing fun _lat(): JsonField<Double> = lat

        /**
         * Returns the raw JSON value of [lng].
         *
         * Unlike [lng], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("lng") @ExcludeMissing fun _lng(): JsonField<Double> = lng

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
             * Returns a mutable builder for constructing an instance of [Destination].
             *
             * The following fields are required:
             * ```java
             * .lat()
             * .lng()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Destination]. */
        class Builder internal constructor() {

            private var lat: JsonField<Double>? = null
            private var lng: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(destination: Destination) = apply {
                lat = destination.lat
                lng = destination.lng
                additionalProperties = destination.additionalProperties.toMutableMap()
            }

            /** Latitude in decimal degrees (-90 to 90) */
            fun lat(lat: Double) = lat(JsonField.of(lat))

            /**
             * Sets [Builder.lat] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lat] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun lat(lat: JsonField<Double>) = apply { this.lat = lat }

            /** Longitude in decimal degrees (-180 to 180) */
            fun lng(lng: Double) = lng(JsonField.of(lng))

            /**
             * Sets [Builder.lng] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lng] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun lng(lng: JsonField<Double>) = apply { this.lng = lng }

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
             * Returns an immutable instance of [Destination].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .lat()
             * .lng()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Destination =
                Destination(
                    checkRequired("lat", lat),
                    checkRequired("lng", lng),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Destination = apply {
            if (validated) {
                return@apply
            }

            lat()
            lng()
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
            (if (lat.asKnown().isPresent) 1 else 0) + (if (lng.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Destination &&
                lat == other.lat &&
                lng == other.lng &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(lat, lng, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Destination{lat=$lat, lng=$lng, additionalProperties=$additionalProperties}"
    }

    /** Geographic coordinate as a JSON object with `lat` and `lng` fields. */
    class Origin
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val lat: JsonField<Double>,
        private val lng: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("lat") @ExcludeMissing lat: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("lng") @ExcludeMissing lng: JsonField<Double> = JsonMissing.of(),
        ) : this(lat, lng, mutableMapOf())

        /**
         * Latitude in decimal degrees (-90 to 90)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun lat(): Double = lat.getRequired("lat")

        /**
         * Longitude in decimal degrees (-180 to 180)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun lng(): Double = lng.getRequired("lng")

        /**
         * Returns the raw JSON value of [lat].
         *
         * Unlike [lat], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("lat") @ExcludeMissing fun _lat(): JsonField<Double> = lat

        /**
         * Returns the raw JSON value of [lng].
         *
         * Unlike [lng], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("lng") @ExcludeMissing fun _lng(): JsonField<Double> = lng

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
             * Returns a mutable builder for constructing an instance of [Origin].
             *
             * The following fields are required:
             * ```java
             * .lat()
             * .lng()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Origin]. */
        class Builder internal constructor() {

            private var lat: JsonField<Double>? = null
            private var lng: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(origin: Origin) = apply {
                lat = origin.lat
                lng = origin.lng
                additionalProperties = origin.additionalProperties.toMutableMap()
            }

            /** Latitude in decimal degrees (-90 to 90) */
            fun lat(lat: Double) = lat(JsonField.of(lat))

            /**
             * Sets [Builder.lat] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lat] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun lat(lat: JsonField<Double>) = apply { this.lat = lat }

            /** Longitude in decimal degrees (-180 to 180) */
            fun lng(lng: Double) = lng(JsonField.of(lng))

            /**
             * Sets [Builder.lng] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lng] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun lng(lng: JsonField<Double>) = apply { this.lng = lng }

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
             * Returns an immutable instance of [Origin].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .lat()
             * .lng()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Origin =
                Origin(
                    checkRequired("lat", lat),
                    checkRequired("lng", lng),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Origin = apply {
            if (validated) {
                return@apply
            }

            lat()
            lng()
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
            (if (lat.asKnown().isPresent) 1 else 0) + (if (lng.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Origin &&
                lat == other.lat &&
                lng == other.lng &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(lat, lng, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Origin{lat=$lat, lng=$lng, additionalProperties=$additionalProperties}"
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MatrixRequest &&
            destinations == other.destinations &&
            origins == other.origins &&
            annotations == other.annotations &&
            fallbackSpeed == other.fallbackSpeed &&
            mode == other.mode &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(destinations, origins, annotations, fallbackSpeed, mode, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MatrixRequest{destinations=$destinations, origins=$origins, annotations=$annotations, fallbackSpeed=$fallbackSpeed, mode=$mode, additionalProperties=$additionalProperties}"
}
