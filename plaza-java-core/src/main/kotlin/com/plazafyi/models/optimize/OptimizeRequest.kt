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
import com.plazafyi.core.checkRequired
import com.plazafyi.errors.PlazaInvalidDataException
import com.plazafyi.models.MultiPointGeometry
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Route optimization (Travelling Salesman) request. Finds the most efficient order to visit a set
 * of waypoints. Minimum 2 waypoints, maximum 50. For large inputs, the request may be processed
 * asynchronously.
 */
class OptimizeRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val waypoints: JsonField<MultiPointGeometry>,
    private val mode: JsonField<Mode>,
    private val roundtrip: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("waypoints")
        @ExcludeMissing
        waypoints: JsonField<MultiPointGeometry> = JsonMissing.of(),
        @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of(),
        @JsonProperty("roundtrip") @ExcludeMissing roundtrip: JsonField<Boolean> = JsonMissing.of(),
    ) : this(waypoints, mode, roundtrip, mutableMapOf())

    /**
     * GeoJSON MultiPoint geometry per RFC 7946. An array of positions.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun waypoints(): MultiPointGeometry = waypoints.getRequired("waypoints")

    /**
     * Travel mode (default: `auto`)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun mode(): Optional<Mode> = mode.getOptional("mode")

    /**
     * Whether the route should return to the starting waypoint (default: true)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun roundtrip(): Optional<Boolean> = roundtrip.getOptional("roundtrip")

    /**
     * Returns the raw JSON value of [waypoints].
     *
     * Unlike [waypoints], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("waypoints")
    @ExcludeMissing
    fun _waypoints(): JsonField<MultiPointGeometry> = waypoints

    /**
     * Returns the raw JSON value of [mode].
     *
     * Unlike [mode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<Mode> = mode

    /**
     * Returns the raw JSON value of [roundtrip].
     *
     * Unlike [roundtrip], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("roundtrip") @ExcludeMissing fun _roundtrip(): JsonField<Boolean> = roundtrip

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
         * Returns a mutable builder for constructing an instance of [OptimizeRequest].
         *
         * The following fields are required:
         * ```java
         * .waypoints()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OptimizeRequest]. */
    class Builder internal constructor() {

        private var waypoints: JsonField<MultiPointGeometry>? = null
        private var mode: JsonField<Mode> = JsonMissing.of()
        private var roundtrip: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(optimizeRequest: OptimizeRequest) = apply {
            waypoints = optimizeRequest.waypoints
            mode = optimizeRequest.mode
            roundtrip = optimizeRequest.roundtrip
            additionalProperties = optimizeRequest.additionalProperties.toMutableMap()
        }

        /** GeoJSON MultiPoint geometry per RFC 7946. An array of positions. */
        fun waypoints(waypoints: MultiPointGeometry) = waypoints(JsonField.of(waypoints))

        /**
         * Sets [Builder.waypoints] to an arbitrary JSON value.
         *
         * You should usually call [Builder.waypoints] with a well-typed [MultiPointGeometry] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun waypoints(waypoints: JsonField<MultiPointGeometry>) = apply {
            this.waypoints = waypoints
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

        /** Whether the route should return to the starting waypoint (default: true) */
        fun roundtrip(roundtrip: Boolean) = roundtrip(JsonField.of(roundtrip))

        /**
         * Sets [Builder.roundtrip] to an arbitrary JSON value.
         *
         * You should usually call [Builder.roundtrip] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun roundtrip(roundtrip: JsonField<Boolean>) = apply { this.roundtrip = roundtrip }

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
         * Returns an immutable instance of [OptimizeRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .waypoints()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OptimizeRequest =
            OptimizeRequest(
                checkRequired("waypoints", waypoints),
                mode,
                roundtrip,
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
    fun validate(): OptimizeRequest = apply {
        if (validated) {
            return@apply
        }

        waypoints().validate()
        mode().ifPresent { it.validate() }
        roundtrip()
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
        (waypoints.asKnown().getOrNull()?.validity() ?: 0) +
            (mode.asKnown().getOrNull()?.validity() ?: 0) +
            (if (roundtrip.asKnown().isPresent) 1 else 0)

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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws PlazaInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

        return other is OptimizeRequest &&
            waypoints == other.waypoints &&
            mode == other.mode &&
            roundtrip == other.roundtrip &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(waypoints, mode, roundtrip, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OptimizeRequest{waypoints=$waypoints, mode=$mode, roundtrip=$roundtrip, additionalProperties=$additionalProperties}"
}
