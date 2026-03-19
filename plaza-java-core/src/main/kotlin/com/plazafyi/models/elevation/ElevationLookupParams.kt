// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elevation

import com.plazafyi.core.Params
import com.plazafyi.core.http.Headers
import com.plazafyi.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Look up elevation at one or more points */
class ElevationLookupParams
private constructor(
    private val lat: Double?,
    private val lng: Double?,
    private val locations: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Latitude (single point) */
    fun lat(): Optional<Double> = Optional.ofNullable(lat)

    /** Longitude (single point) */
    fun lng(): Optional<Double> = Optional.ofNullable(lng)

    /** Pipe-separated lng,lat pairs (batch) */
    fun locations(): Optional<String> = Optional.ofNullable(locations)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ElevationLookupParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ElevationLookupParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ElevationLookupParams]. */
    class Builder internal constructor() {

        private var lat: Double? = null
        private var lng: Double? = null
        private var locations: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(elevationLookupParams: ElevationLookupParams) = apply {
            lat = elevationLookupParams.lat
            lng = elevationLookupParams.lng
            locations = elevationLookupParams.locations
            additionalHeaders = elevationLookupParams.additionalHeaders.toBuilder()
            additionalQueryParams = elevationLookupParams.additionalQueryParams.toBuilder()
        }

        /** Latitude (single point) */
        fun lat(lat: Double?) = apply { this.lat = lat }

        /**
         * Alias for [Builder.lat].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun lat(lat: Double) = lat(lat as Double?)

        /** Alias for calling [Builder.lat] with `lat.orElse(null)`. */
        fun lat(lat: Optional<Double>) = lat(lat.getOrNull())

        /** Longitude (single point) */
        fun lng(lng: Double?) = apply { this.lng = lng }

        /**
         * Alias for [Builder.lng].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun lng(lng: Double) = lng(lng as Double?)

        /** Alias for calling [Builder.lng] with `lng.orElse(null)`. */
        fun lng(lng: Optional<Double>) = lng(lng.getOrNull())

        /** Pipe-separated lng,lat pairs (batch) */
        fun locations(locations: String?) = apply { this.locations = locations }

        /** Alias for calling [Builder.locations] with `locations.orElse(null)`. */
        fun locations(locations: Optional<String>) = locations(locations.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [ElevationLookupParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ElevationLookupParams =
            ElevationLookupParams(
                lat,
                lng,
                locations,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                lat?.let { put("lat", it.toString()) }
                lng?.let { put("lng", it.toString()) }
                locations?.let { put("locations", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ElevationLookupParams &&
            lat == other.lat &&
            lng == other.lng &&
            locations == other.locations &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(lat, lng, locations, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ElevationLookupParams{lat=$lat, lng=$lng, locations=$locations, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
