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
    private val format: String?,
    private val lat: Double?,
    private val lng: Double?,
    private val locations: String?,
    private val outputFields: String?,
    private val outputInclude: String?,
    private val outputPrecision: Long?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Response format: json (default), geojson, csv, ndjson */
    fun format(): Optional<String> = Optional.ofNullable(format)

    /** Latitude (single point) */
    fun lat(): Optional<Double> = Optional.ofNullable(lat)

    /** Longitude (single point) */
    fun lng(): Optional<Double> = Optional.ofNullable(lng)

    /** Pipe-separated lng,lat pairs (batch) */
    fun locations(): Optional<String> = Optional.ofNullable(locations)

    /** Comma-separated property fields to include */
    fun outputFields(): Optional<String> = Optional.ofNullable(outputFields)

    /** Extra computed fields: bbox, center */
    fun outputInclude(): Optional<String> = Optional.ofNullable(outputInclude)

    /** Coordinate decimal precision (1-15, default 7) */
    fun outputPrecision(): Optional<Long> = Optional.ofNullable(outputPrecision)

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

        private var format: String? = null
        private var lat: Double? = null
        private var lng: Double? = null
        private var locations: String? = null
        private var outputFields: String? = null
        private var outputInclude: String? = null
        private var outputPrecision: Long? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(elevationLookupParams: ElevationLookupParams) = apply {
            format = elevationLookupParams.format
            lat = elevationLookupParams.lat
            lng = elevationLookupParams.lng
            locations = elevationLookupParams.locations
            outputFields = elevationLookupParams.outputFields
            outputInclude = elevationLookupParams.outputInclude
            outputPrecision = elevationLookupParams.outputPrecision
            additionalHeaders = elevationLookupParams.additionalHeaders.toBuilder()
            additionalQueryParams = elevationLookupParams.additionalQueryParams.toBuilder()
        }

        /** Response format: json (default), geojson, csv, ndjson */
        fun format(format: String?) = apply { this.format = format }

        /** Alias for calling [Builder.format] with `format.orElse(null)`. */
        fun format(format: Optional<String>) = format(format.getOrNull())

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

        /** Comma-separated property fields to include */
        fun outputFields(outputFields: String?) = apply { this.outputFields = outputFields }

        /** Alias for calling [Builder.outputFields] with `outputFields.orElse(null)`. */
        fun outputFields(outputFields: Optional<String>) = outputFields(outputFields.getOrNull())

        /** Extra computed fields: bbox, center */
        fun outputInclude(outputInclude: String?) = apply { this.outputInclude = outputInclude }

        /** Alias for calling [Builder.outputInclude] with `outputInclude.orElse(null)`. */
        fun outputInclude(outputInclude: Optional<String>) =
            outputInclude(outputInclude.getOrNull())

        /** Coordinate decimal precision (1-15, default 7) */
        fun outputPrecision(outputPrecision: Long?) = apply {
            this.outputPrecision = outputPrecision
        }

        /**
         * Alias for [Builder.outputPrecision].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun outputPrecision(outputPrecision: Long) = outputPrecision(outputPrecision as Long?)

        /** Alias for calling [Builder.outputPrecision] with `outputPrecision.orElse(null)`. */
        fun outputPrecision(outputPrecision: Optional<Long>) =
            outputPrecision(outputPrecision.getOrNull())

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
                format,
                lat,
                lng,
                locations,
                outputFields,
                outputInclude,
                outputPrecision,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                format?.let { put("format", it) }
                lat?.let { put("lat", it.toString()) }
                lng?.let { put("lng", it.toString()) }
                locations?.let { put("locations", it) }
                outputFields?.let { put("output[fields]", it) }
                outputInclude?.let { put("output[include]", it) }
                outputPrecision?.let { put("output[precision]", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ElevationLookupParams &&
            format == other.format &&
            lat == other.lat &&
            lng == other.lng &&
            locations == other.locations &&
            outputFields == other.outputFields &&
            outputInclude == other.outputInclude &&
            outputPrecision == other.outputPrecision &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            format,
            lat,
            lng,
            locations,
            outputFields,
            outputInclude,
            outputPrecision,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "ElevationLookupParams{format=$format, lat=$lat, lng=$lng, locations=$locations, outputFields=$outputFields, outputInclude=$outputInclude, outputPrecision=$outputPrecision, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
