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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Request body for isochrone calculation. Computes areas reachable from a point within the given
 * travel time(s).
 */
class IsochroneRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val geometry: JsonField<PointGeometry>,
    private val time: JsonField<List<Long>>,
    private val mode: JsonField<Mode>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("geometry")
        @ExcludeMissing
        geometry: JsonField<PointGeometry> = JsonMissing.of(),
        @JsonProperty("time") @ExcludeMissing time: JsonField<List<Long>> = JsonMissing.of(),
        @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of(),
    ) : this(geometry, time, mode, mutableMapOf())

    /**
     * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order. Optional
     * third element is altitude in meters.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun geometry(): PointGeometry = geometry.getRequired("geometry")

    /**
     * Travel time budgets in seconds. Each value produces one contour polygon.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun time(): List<Long> = time.getRequired("time")

    /**
     * Travel mode (default: `auto`)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun mode(): Optional<Mode> = mode.getOptional("mode")

    /**
     * Returns the raw JSON value of [geometry].
     *
     * Unlike [geometry], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("geometry") @ExcludeMissing fun _geometry(): JsonField<PointGeometry> = geometry

    /**
     * Returns the raw JSON value of [time].
     *
     * Unlike [time], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("time") @ExcludeMissing fun _time(): JsonField<List<Long>> = time

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
         * Returns a mutable builder for constructing an instance of [IsochroneRequest].
         *
         * The following fields are required:
         * ```java
         * .geometry()
         * .time()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [IsochroneRequest]. */
    class Builder internal constructor() {

        private var geometry: JsonField<PointGeometry>? = null
        private var time: JsonField<MutableList<Long>>? = null
        private var mode: JsonField<Mode> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(isochroneRequest: IsochroneRequest) = apply {
            geometry = isochroneRequest.geometry
            time = isochroneRequest.time.map { it.toMutableList() }
            mode = isochroneRequest.mode
            additionalProperties = isochroneRequest.additionalProperties.toMutableMap()
        }

        /**
         * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order.
         * Optional third element is altitude in meters.
         */
        fun geometry(geometry: PointGeometry) = geometry(JsonField.of(geometry))

        /**
         * Sets [Builder.geometry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.geometry] with a well-typed [PointGeometry] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun geometry(geometry: JsonField<PointGeometry>) = apply { this.geometry = geometry }

        /** Travel time budgets in seconds. Each value produces one contour polygon. */
        fun time(time: List<Long>) = time(JsonField.of(time))

        /**
         * Sets [Builder.time] to an arbitrary JSON value.
         *
         * You should usually call [Builder.time] with a well-typed `List<Long>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun time(time: JsonField<List<Long>>) = apply {
            this.time = time.map { it.toMutableList() }
        }

        /**
         * Adds a single [Long] to [Builder.time].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTime(time: Long) = apply {
            this.time =
                (this.time ?: JsonField.of(mutableListOf())).also {
                    checkKnown("time", it).add(time)
                }
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
         * Returns an immutable instance of [IsochroneRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .geometry()
         * .time()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): IsochroneRequest =
            IsochroneRequest(
                checkRequired("geometry", geometry),
                checkRequired("time", time).map { it.toImmutable() },
                mode,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): IsochroneRequest = apply {
        if (validated) {
            return@apply
        }

        geometry().validate()
        time()
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
        (geometry.asKnown().getOrNull()?.validity() ?: 0) +
            (time.asKnown().getOrNull()?.size ?: 0) +
            (mode.asKnown().getOrNull()?.validity() ?: 0)

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

        return other is IsochroneRequest &&
            geometry == other.geometry &&
            time == other.time &&
            mode == other.mode &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(geometry, time, mode, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "IsochroneRequest{geometry=$geometry, time=$time, mode=$mode, additionalProperties=$additionalProperties}"
}
