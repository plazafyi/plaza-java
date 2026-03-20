// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.plazafyi.core.JsonValue
import com.plazafyi.core.Params
import com.plazafyi.core.checkRequired
import com.plazafyi.core.http.Headers
import com.plazafyi.core.http.QueryParams
import com.plazafyi.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Forward geocode an address */
class GeocodeForwardPostParams
private constructor(
    private val q: String,
    private val bbox: String?,
    private val countryCode: String?,
    private val format: String?,
    private val lang: String?,
    private val lat: Double?,
    private val layer: String?,
    private val limit: Long?,
    private val lng: Double?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
    private val additionalBodyProperties: Map<String, JsonValue>,
) : Params {

    /** Address or place name */
    fun q(): String = q

    /** Bounding box filter: south,west,north,east */
    fun bbox(): Optional<String> = Optional.ofNullable(bbox)

    /** ISO 3166-1 alpha-2 country code filter */
    fun countryCode(): Optional<String> = Optional.ofNullable(countryCode)

    /** Response format: json (default), geojson, csv, ndjson */
    fun format(): Optional<String> = Optional.ofNullable(format)

    /** Language code for localized names (e.g. en, de, fr) */
    fun lang(): Optional<String> = Optional.ofNullable(lang)

    /** Focus latitude */
    fun lat(): Optional<Double> = Optional.ofNullable(lat)

    /** Filter by layer: address, poi, or admin */
    fun layer(): Optional<String> = Optional.ofNullable(layer)

    /** Maximum results (default 20, max 100) */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Focus longitude */
    fun lng(): Optional<Double> = Optional.ofNullable(lng)

    /** Additional body properties to send with the request. */
    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [GeocodeForwardPostParams].
         *
         * The following fields are required:
         * ```java
         * .q()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GeocodeForwardPostParams]. */
    class Builder internal constructor() {

        private var q: String? = null
        private var bbox: String? = null
        private var countryCode: String? = null
        private var format: String? = null
        private var lang: String? = null
        private var lat: Double? = null
        private var layer: String? = null
        private var limit: Long? = null
        private var lng: Double? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(geocodeForwardPostParams: GeocodeForwardPostParams) = apply {
            q = geocodeForwardPostParams.q
            bbox = geocodeForwardPostParams.bbox
            countryCode = geocodeForwardPostParams.countryCode
            format = geocodeForwardPostParams.format
            lang = geocodeForwardPostParams.lang
            lat = geocodeForwardPostParams.lat
            layer = geocodeForwardPostParams.layer
            limit = geocodeForwardPostParams.limit
            lng = geocodeForwardPostParams.lng
            additionalHeaders = geocodeForwardPostParams.additionalHeaders.toBuilder()
            additionalQueryParams = geocodeForwardPostParams.additionalQueryParams.toBuilder()
            additionalBodyProperties =
                geocodeForwardPostParams.additionalBodyProperties.toMutableMap()
        }

        /** Address or place name */
        fun q(q: String) = apply { this.q = q }

        /** Bounding box filter: south,west,north,east */
        fun bbox(bbox: String?) = apply { this.bbox = bbox }

        /** Alias for calling [Builder.bbox] with `bbox.orElse(null)`. */
        fun bbox(bbox: Optional<String>) = bbox(bbox.getOrNull())

        /** ISO 3166-1 alpha-2 country code filter */
        fun countryCode(countryCode: String?) = apply { this.countryCode = countryCode }

        /** Alias for calling [Builder.countryCode] with `countryCode.orElse(null)`. */
        fun countryCode(countryCode: Optional<String>) = countryCode(countryCode.getOrNull())

        /** Response format: json (default), geojson, csv, ndjson */
        fun format(format: String?) = apply { this.format = format }

        /** Alias for calling [Builder.format] with `format.orElse(null)`. */
        fun format(format: Optional<String>) = format(format.getOrNull())

        /** Language code for localized names (e.g. en, de, fr) */
        fun lang(lang: String?) = apply { this.lang = lang }

        /** Alias for calling [Builder.lang] with `lang.orElse(null)`. */
        fun lang(lang: Optional<String>) = lang(lang.getOrNull())

        /** Focus latitude */
        fun lat(lat: Double?) = apply { this.lat = lat }

        /**
         * Alias for [Builder.lat].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun lat(lat: Double) = lat(lat as Double?)

        /** Alias for calling [Builder.lat] with `lat.orElse(null)`. */
        fun lat(lat: Optional<Double>) = lat(lat.getOrNull())

        /** Filter by layer: address, poi, or admin */
        fun layer(layer: String?) = apply { this.layer = layer }

        /** Alias for calling [Builder.layer] with `layer.orElse(null)`. */
        fun layer(layer: Optional<String>) = layer(layer.getOrNull())

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

        /** Focus longitude */
        fun lng(lng: Double?) = apply { this.lng = lng }

        /**
         * Alias for [Builder.lng].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun lng(lng: Double) = lng(lng as Double?)

        /** Alias for calling [Builder.lng] with `lng.orElse(null)`. */
        fun lng(lng: Optional<Double>) = lng(lng.getOrNull())

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

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            putAllAdditionalBodyProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply {
            additionalBodyProperties.remove(key)
        }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalBodyProperty)
        }

        /**
         * Returns an immutable instance of [GeocodeForwardPostParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .q()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): GeocodeForwardPostParams =
            GeocodeForwardPostParams(
                checkRequired("q", q),
                bbox,
                countryCode,
                format,
                lang,
                lat,
                layer,
                limit,
                lng,
                additionalHeaders.build(),
                additionalQueryParams.build(),
                additionalBodyProperties.toImmutable(),
            )
    }

    fun _body(): Optional<Map<String, JsonValue>> =
        Optional.ofNullable(additionalBodyProperties.ifEmpty { null })

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("q", q)
                bbox?.let { put("bbox", it) }
                countryCode?.let { put("country_code", it) }
                format?.let { put("format", it) }
                lang?.let { put("lang", it) }
                lat?.let { put("lat", it.toString()) }
                layer?.let { put("layer", it) }
                limit?.let { put("limit", it.toString()) }
                lng?.let { put("lng", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is GeocodeForwardPostParams &&
            q == other.q &&
            bbox == other.bbox &&
            countryCode == other.countryCode &&
            format == other.format &&
            lang == other.lang &&
            lat == other.lat &&
            layer == other.layer &&
            limit == other.limit &&
            lng == other.lng &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams &&
            additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int =
        Objects.hash(
            q,
            bbox,
            countryCode,
            format,
            lang,
            lat,
            layer,
            limit,
            lng,
            additionalHeaders,
            additionalQueryParams,
            additionalBodyProperties,
        )

    override fun toString() =
        "GeocodeForwardPostParams{q=$q, bbox=$bbox, countryCode=$countryCode, format=$format, lang=$lang, lat=$lat, layer=$layer, limit=$limit, lng=$lng, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams, additionalBodyProperties=$additionalBodyProperties}"
}
