// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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
import kotlin.jvm.optionals.getOrNull

/**
 * Request body for elevation profile along a path. Provide at least 2 coordinates defining the
 * path. Maximum 50 coordinates per request.
 */
class ElevationProfileRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val coordinates: JsonField<List<Coordinate>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("coordinates")
        @ExcludeMissing
        coordinates: JsonField<List<Coordinate>> = JsonMissing.of()
    ) : this(coordinates, mutableMapOf())

    /**
     * Path coordinates in order of travel (min 2, max 50)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun coordinates(): List<Coordinate> = coordinates.getRequired("coordinates")

    /**
     * Returns the raw JSON value of [coordinates].
     *
     * Unlike [coordinates], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("coordinates")
    @ExcludeMissing
    fun _coordinates(): JsonField<List<Coordinate>> = coordinates

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
         * Returns a mutable builder for constructing an instance of [ElevationProfileRequest].
         *
         * The following fields are required:
         * ```java
         * .coordinates()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ElevationProfileRequest]. */
    class Builder internal constructor() {

        private var coordinates: JsonField<MutableList<Coordinate>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(elevationProfileRequest: ElevationProfileRequest) = apply {
            coordinates = elevationProfileRequest.coordinates.map { it.toMutableList() }
            additionalProperties = elevationProfileRequest.additionalProperties.toMutableMap()
        }

        /** Path coordinates in order of travel (min 2, max 50) */
        fun coordinates(coordinates: List<Coordinate>) = coordinates(JsonField.of(coordinates))

        /**
         * Sets [Builder.coordinates] to an arbitrary JSON value.
         *
         * You should usually call [Builder.coordinates] with a well-typed `List<Coordinate>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun coordinates(coordinates: JsonField<List<Coordinate>>) = apply {
            this.coordinates = coordinates.map { it.toMutableList() }
        }

        /**
         * Adds a single [Coordinate] to [coordinates].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCoordinate(coordinate: Coordinate) = apply {
            coordinates =
                (coordinates ?: JsonField.of(mutableListOf())).also {
                    checkKnown("coordinates", it).add(coordinate)
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
         * Returns an immutable instance of [ElevationProfileRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .coordinates()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ElevationProfileRequest =
            ElevationProfileRequest(
                checkRequired("coordinates", coordinates).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ElevationProfileRequest = apply {
        if (validated) {
            return@apply
        }

        coordinates().forEach { it.validate() }
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
        (coordinates.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** Geographic coordinate as a JSON object with `lat` and `lng` fields. */
    class Coordinate
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
             * Returns a mutable builder for constructing an instance of [Coordinate].
             *
             * The following fields are required:
             * ```java
             * .lat()
             * .lng()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Coordinate]. */
        class Builder internal constructor() {

            private var lat: JsonField<Double>? = null
            private var lng: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(coordinate: Coordinate) = apply {
                lat = coordinate.lat
                lng = coordinate.lng
                additionalProperties = coordinate.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Coordinate].
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
            fun build(): Coordinate =
                Coordinate(
                    checkRequired("lat", lat),
                    checkRequired("lng", lng),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Coordinate = apply {
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

            return other is Coordinate &&
                lat == other.lat &&
                lng == other.lng &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(lat, lng, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Coordinate{lat=$lat, lng=$lng, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ElevationProfileRequest &&
            coordinates == other.coordinates &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(coordinates, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ElevationProfileRequest{coordinates=$coordinates, additionalProperties=$additionalProperties}"
}
