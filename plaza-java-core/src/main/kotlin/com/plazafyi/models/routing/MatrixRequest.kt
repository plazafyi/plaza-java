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
import com.plazafyi.core.checkRequired
import com.plazafyi.errors.PlazaInvalidDataException
import com.plazafyi.models.GeoJsonGeometry
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class MatrixRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val destinations: JsonField<GeoJsonGeometry>,
    private val origins: JsonField<GeoJsonGeometry>,
    private val mode: JsonField<Mode>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("destinations")
        @ExcludeMissing
        destinations: JsonField<GeoJsonGeometry> = JsonMissing.of(),
        @JsonProperty("origins")
        @ExcludeMissing
        origins: JsonField<GeoJsonGeometry> = JsonMissing.of(),
        @JsonProperty("mode") @ExcludeMissing mode: JsonField<Mode> = JsonMissing.of(),
    ) : this(destinations, origins, mode, mutableMapOf())

    /**
     * Destination points (GeoJSON MultiPoint geometry)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun destinations(): GeoJsonGeometry = destinations.getRequired("destinations")

    /**
     * Origin points (GeoJSON MultiPoint geometry)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun origins(): GeoJsonGeometry = origins.getRequired("origins")

    /**
     * Travel mode
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
    fun _destinations(): JsonField<GeoJsonGeometry> = destinations

    /**
     * Returns the raw JSON value of [origins].
     *
     * Unlike [origins], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("origins") @ExcludeMissing fun _origins(): JsonField<GeoJsonGeometry> = origins

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

        private var destinations: JsonField<GeoJsonGeometry>? = null
        private var origins: JsonField<GeoJsonGeometry>? = null
        private var mode: JsonField<Mode> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(matrixRequest: MatrixRequest) = apply {
            destinations = matrixRequest.destinations
            origins = matrixRequest.origins
            mode = matrixRequest.mode
            additionalProperties = matrixRequest.additionalProperties.toMutableMap()
        }

        /** Destination points (GeoJSON MultiPoint geometry) */
        fun destinations(destinations: GeoJsonGeometry) = destinations(JsonField.of(destinations))

        /**
         * Sets [Builder.destinations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.destinations] with a well-typed [GeoJsonGeometry] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun destinations(destinations: JsonField<GeoJsonGeometry>) = apply {
            this.destinations = destinations
        }

        /** Origin points (GeoJSON MultiPoint geometry) */
        fun origins(origins: GeoJsonGeometry) = origins(JsonField.of(origins))

        /**
         * Sets [Builder.origins] to an arbitrary JSON value.
         *
         * You should usually call [Builder.origins] with a well-typed [GeoJsonGeometry] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun origins(origins: JsonField<GeoJsonGeometry>) = apply { this.origins = origins }

        /** Travel mode */
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
                checkRequired("destinations", destinations),
                checkRequired("origins", origins),
                mode,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MatrixRequest = apply {
        if (validated) {
            return@apply
        }

        destinations().validate()
        origins().validate()
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
        (destinations.asKnown().getOrNull()?.validity() ?: 0) +
            (origins.asKnown().getOrNull()?.validity() ?: 0) +
            (mode.asKnown().getOrNull()?.validity() ?: 0)

    /** Travel mode */
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
            mode == other.mode &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(destinations, origins, mode, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MatrixRequest{destinations=$destinations, origins=$origins, mode=$mode, additionalProperties=$additionalProperties}"
}
