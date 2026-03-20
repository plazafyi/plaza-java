// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.plazafyi.core.Params
import com.plazafyi.core.http.Headers
import com.plazafyi.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Reverse geocode a coordinate */
class GeocodeReverseParams
private constructor(
    private val format: String?,
    private val lang: String?,
    private val lat: Double?,
    private val layer: String?,
    private val limit: Long?,
    private val lng: Double?,
    private val near: String?,
    private val radius: Long?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Response format: json (default), geojson, csv, ndjson */
    fun format(): Optional<String> = Optional.ofNullable(format)

    /** Language code for localized names (e.g. en, de, fr) */
    fun lang(): Optional<String> = Optional.ofNullable(lang)

    /** Legacy shorthand. Latitude. Use near param instead. */
    fun lat(): Optional<Double> = Optional.ofNullable(lat)

    /** Filter by layer: house or poi */
    fun layer(): Optional<String> = Optional.ofNullable(layer)

    /** Maximum results (default 1, max 20) */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Legacy shorthand. Longitude. Use near param instead. */
    fun lng(): Optional<Double> = Optional.ofNullable(lng)

    /** Point geometry for reverse geocode (lat,lng or GeoJSON). Alternative to lat/lng params. */
    fun near(): Optional<String> = Optional.ofNullable(near)

    /** Search radius in meters (default 200, max 5000) */
    fun radius(): Optional<Long> = Optional.ofNullable(radius)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): GeocodeReverseParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [GeocodeReverseParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GeocodeReverseParams]. */
    class Builder internal constructor() {

        private var format: String? = null
        private var lang: String? = null
        private var lat: Double? = null
        private var layer: String? = null
        private var limit: Long? = null
        private var lng: Double? = null
        private var near: String? = null
        private var radius: Long? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(geocodeReverseParams: GeocodeReverseParams) = apply {
            format = geocodeReverseParams.format
            lang = geocodeReverseParams.lang
            lat = geocodeReverseParams.lat
            layer = geocodeReverseParams.layer
            limit = geocodeReverseParams.limit
            lng = geocodeReverseParams.lng
            near = geocodeReverseParams.near
            radius = geocodeReverseParams.radius
            additionalHeaders = geocodeReverseParams.additionalHeaders.toBuilder()
            additionalQueryParams = geocodeReverseParams.additionalQueryParams.toBuilder()
        }

        /** Response format: json (default), geojson, csv, ndjson */
        fun format(format: String?) = apply { this.format = format }

        /** Alias for calling [Builder.format] with `format.orElse(null)`. */
        fun format(format: Optional<String>) = format(format.getOrNull())

        /** Language code for localized names (e.g. en, de, fr) */
        fun lang(lang: String?) = apply { this.lang = lang }

        /** Alias for calling [Builder.lang] with `lang.orElse(null)`. */
        fun lang(lang: Optional<String>) = lang(lang.getOrNull())

        /** Legacy shorthand. Latitude. Use near param instead. */
        fun lat(lat: Double?) = apply { this.lat = lat }

        /**
         * Alias for [Builder.lat].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun lat(lat: Double) = lat(lat as Double?)

        /** Alias for calling [Builder.lat] with `lat.orElse(null)`. */
        fun lat(lat: Optional<Double>) = lat(lat.getOrNull())

        /** Filter by layer: house or poi */
        fun layer(layer: String?) = apply { this.layer = layer }

        /** Alias for calling [Builder.layer] with `layer.orElse(null)`. */
        fun layer(layer: Optional<String>) = layer(layer.getOrNull())

        /** Maximum results (default 1, max 20) */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /** Legacy shorthand. Longitude. Use near param instead. */
        fun lng(lng: Double?) = apply { this.lng = lng }

        /**
         * Alias for [Builder.lng].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun lng(lng: Double) = lng(lng as Double?)

        /** Alias for calling [Builder.lng] with `lng.orElse(null)`. */
        fun lng(lng: Optional<Double>) = lng(lng.getOrNull())

        /**
         * Point geometry for reverse geocode (lat,lng or GeoJSON). Alternative to lat/lng params.
         */
        fun near(near: String?) = apply { this.near = near }

        /** Alias for calling [Builder.near] with `near.orElse(null)`. */
        fun near(near: Optional<String>) = near(near.getOrNull())

        /** Search radius in meters (default 200, max 5000) */
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
         * Returns an immutable instance of [GeocodeReverseParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): GeocodeReverseParams =
            GeocodeReverseParams(
                format,
                lang,
                lat,
                layer,
                limit,
                lng,
                near,
                radius,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                format?.let { put("format", it) }
                lang?.let { put("lang", it) }
                lat?.let { put("lat", it.toString()) }
                layer?.let { put("layer", it) }
                limit?.let { put("limit", it.toString()) }
                lng?.let { put("lng", it.toString()) }
                near?.let { put("near", it) }
                radius?.let { put("radius", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is GeocodeReverseParams &&
            format == other.format &&
            lang == other.lang &&
            lat == other.lat &&
            layer == other.layer &&
            limit == other.limit &&
            lng == other.lng &&
            near == other.near &&
            radius == other.radius &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            format,
            lang,
            lat,
            layer,
            limit,
            lng,
            near,
            radius,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "GeocodeReverseParams{format=$format, lang=$lang, lat=$lat, layer=$layer, limit=$limit, lng=$lng, near=$near, radius=$radius, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
