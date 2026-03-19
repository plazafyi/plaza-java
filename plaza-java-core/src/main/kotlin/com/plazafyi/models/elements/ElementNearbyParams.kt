// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elements

import com.plazafyi.core.Params
import com.plazafyi.core.checkRequired
import com.plazafyi.core.http.Headers
import com.plazafyi.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Find features near a geographic point */
class ElementNearbyParams
private constructor(
    private val lat: Double,
    private val lng: Double,
    private val limit: Long?,
    private val radius: Long?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Latitude (-90 to 90) */
    fun lat(): Double = lat

    /** Longitude (-180 to 180) */
    fun lng(): Double = lng

    /** Maximum results (default 20, max 100) */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Search radius in meters (default 500, max 10000) */
    fun radius(): Optional<Long> = Optional.ofNullable(radius)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ElementNearbyParams].
         *
         * The following fields are required:
         * ```java
         * .lat()
         * .lng()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ElementNearbyParams]. */
    class Builder internal constructor() {

        private var lat: Double? = null
        private var lng: Double? = null
        private var limit: Long? = null
        private var radius: Long? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(elementNearbyParams: ElementNearbyParams) = apply {
            lat = elementNearbyParams.lat
            lng = elementNearbyParams.lng
            limit = elementNearbyParams.limit
            radius = elementNearbyParams.radius
            additionalHeaders = elementNearbyParams.additionalHeaders.toBuilder()
            additionalQueryParams = elementNearbyParams.additionalQueryParams.toBuilder()
        }

        /** Latitude (-90 to 90) */
        fun lat(lat: Double) = apply { this.lat = lat }

        /** Longitude (-180 to 180) */
        fun lng(lng: Double) = apply { this.lng = lng }

        /** Maximum results (default 20, max 100) */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /** Search radius in meters (default 500, max 10000) */
        fun radius(radius: Long?) = apply { this.radius = radius }

        /**
         * Alias for [Builder.radius].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun radius(radius: Long) = radius(radius as Long?)

        /** Alias for calling [Builder.radius] with `radius.orElse(null)`. */
        fun radius(radius: Optional<Long>) = radius(radius.getOrNull())

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
         * Returns an immutable instance of [ElementNearbyParams].
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
        fun build(): ElementNearbyParams =
            ElementNearbyParams(
                checkRequired("lat", lat),
                checkRequired("lng", lng),
                limit,
                radius,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("lat", lat.toString())
                put("lng", lng.toString())
                limit?.let { put("limit", it.toString()) }
                radius?.let { put("radius", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ElementNearbyParams &&
            lat == other.lat &&
            lng == other.lng &&
            limit == other.limit &&
            radius == other.radius &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(lat, lng, limit, radius, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ElementNearbyParams{lat=$lat, lng=$lng, limit=$limit, radius=$radius, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
