// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.routing

import com.plazafyi.core.JsonValue
import com.plazafyi.core.Params
import com.plazafyi.core.checkRequired
import com.plazafyi.core.http.Headers
import com.plazafyi.core.http.QueryParams
import com.plazafyi.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Calculate an isochrone from a point */
class RoutingIsochronePostParams
private constructor(
    private val lat: Double,
    private val lng: Double,
    private val time: Double,
    private val format: String?,
    private val mode: String?,
    private val outputFields: String?,
    private val outputGeometry: Boolean?,
    private val outputInclude: String?,
    private val outputPrecision: Long?,
    private val outputSimplify: Double?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
    private val additionalBodyProperties: Map<String, JsonValue>,
) : Params {

    /** Latitude */
    fun lat(): Double = lat

    /** Longitude */
    fun lng(): Double = lng

    /** Travel time in seconds (1-7200) */
    fun time(): Double = time

    /** Response format: json (default), geojson, csv, ndjson */
    fun format(): Optional<String> = Optional.ofNullable(format)

    /** Travel mode (auto, foot, bicycle) */
    fun mode(): Optional<String> = Optional.ofNullable(mode)

    /** Comma-separated property fields to include */
    fun outputFields(): Optional<String> = Optional.ofNullable(outputFields)

    /** Include geometry (default true) */
    fun outputGeometry(): Optional<Boolean> = Optional.ofNullable(outputGeometry)

    /** Extra computed fields: bbox, center */
    fun outputInclude(): Optional<String> = Optional.ofNullable(outputInclude)

    /** Coordinate decimal precision (1-15, default 7) */
    fun outputPrecision(): Optional<Long> = Optional.ofNullable(outputPrecision)

    /** Simplify geometry tolerance in meters */
    fun outputSimplify(): Optional<Double> = Optional.ofNullable(outputSimplify)

    /** Additional body properties to send with the request. */
    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [RoutingIsochronePostParams].
         *
         * The following fields are required:
         * ```java
         * .lat()
         * .lng()
         * .time()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RoutingIsochronePostParams]. */
    class Builder internal constructor() {

        private var lat: Double? = null
        private var lng: Double? = null
        private var time: Double? = null
        private var format: String? = null
        private var mode: String? = null
        private var outputFields: String? = null
        private var outputGeometry: Boolean? = null
        private var outputInclude: String? = null
        private var outputPrecision: Long? = null
        private var outputSimplify: Double? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(routingIsochronePostParams: RoutingIsochronePostParams) = apply {
            lat = routingIsochronePostParams.lat
            lng = routingIsochronePostParams.lng
            time = routingIsochronePostParams.time
            format = routingIsochronePostParams.format
            mode = routingIsochronePostParams.mode
            outputFields = routingIsochronePostParams.outputFields
            outputGeometry = routingIsochronePostParams.outputGeometry
            outputInclude = routingIsochronePostParams.outputInclude
            outputPrecision = routingIsochronePostParams.outputPrecision
            outputSimplify = routingIsochronePostParams.outputSimplify
            additionalHeaders = routingIsochronePostParams.additionalHeaders.toBuilder()
            additionalQueryParams = routingIsochronePostParams.additionalQueryParams.toBuilder()
            additionalBodyProperties =
                routingIsochronePostParams.additionalBodyProperties.toMutableMap()
        }

        /** Latitude */
        fun lat(lat: Double) = apply { this.lat = lat }

        /** Longitude */
        fun lng(lng: Double) = apply { this.lng = lng }

        /** Travel time in seconds (1-7200) */
        fun time(time: Double) = apply { this.time = time }

        /** Response format: json (default), geojson, csv, ndjson */
        fun format(format: String?) = apply { this.format = format }

        /** Alias for calling [Builder.format] with `format.orElse(null)`. */
        fun format(format: Optional<String>) = format(format.getOrNull())

        /** Travel mode (auto, foot, bicycle) */
        fun mode(mode: String?) = apply { this.mode = mode }

        /** Alias for calling [Builder.mode] with `mode.orElse(null)`. */
        fun mode(mode: Optional<String>) = mode(mode.getOrNull())

        /** Comma-separated property fields to include */
        fun outputFields(outputFields: String?) = apply { this.outputFields = outputFields }

        /** Alias for calling [Builder.outputFields] with `outputFields.orElse(null)`. */
        fun outputFields(outputFields: Optional<String>) = outputFields(outputFields.getOrNull())

        /** Include geometry (default true) */
        fun outputGeometry(outputGeometry: Boolean?) = apply {
            this.outputGeometry = outputGeometry
        }

        /**
         * Alias for [Builder.outputGeometry].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun outputGeometry(outputGeometry: Boolean) = outputGeometry(outputGeometry as Boolean?)

        /** Alias for calling [Builder.outputGeometry] with `outputGeometry.orElse(null)`. */
        fun outputGeometry(outputGeometry: Optional<Boolean>) =
            outputGeometry(outputGeometry.getOrNull())

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

        /** Simplify geometry tolerance in meters */
        fun outputSimplify(outputSimplify: Double?) = apply { this.outputSimplify = outputSimplify }

        /**
         * Alias for [Builder.outputSimplify].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun outputSimplify(outputSimplify: Double) = outputSimplify(outputSimplify as Double?)

        /** Alias for calling [Builder.outputSimplify] with `outputSimplify.orElse(null)`. */
        fun outputSimplify(outputSimplify: Optional<Double>) =
            outputSimplify(outputSimplify.getOrNull())

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
         * Returns an immutable instance of [RoutingIsochronePostParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .lat()
         * .lng()
         * .time()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RoutingIsochronePostParams =
            RoutingIsochronePostParams(
                checkRequired("lat", lat),
                checkRequired("lng", lng),
                checkRequired("time", time),
                format,
                mode,
                outputFields,
                outputGeometry,
                outputInclude,
                outputPrecision,
                outputSimplify,
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
                put("lat", lat.toString())
                put("lng", lng.toString())
                put("time", time.toString())
                format?.let { put("format", it) }
                mode?.let { put("mode", it) }
                outputFields?.let { put("output[fields]", it) }
                outputGeometry?.let { put("output[geometry]", it.toString()) }
                outputInclude?.let { put("output[include]", it) }
                outputPrecision?.let { put("output[precision]", it.toString()) }
                outputSimplify?.let { put("output[simplify]", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RoutingIsochronePostParams &&
            lat == other.lat &&
            lng == other.lng &&
            time == other.time &&
            format == other.format &&
            mode == other.mode &&
            outputFields == other.outputFields &&
            outputGeometry == other.outputGeometry &&
            outputInclude == other.outputInclude &&
            outputPrecision == other.outputPrecision &&
            outputSimplify == other.outputSimplify &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams &&
            additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int =
        Objects.hash(
            lat,
            lng,
            time,
            format,
            mode,
            outputFields,
            outputGeometry,
            outputInclude,
            outputPrecision,
            outputSimplify,
            additionalHeaders,
            additionalQueryParams,
            additionalBodyProperties,
        )

    override fun toString() =
        "RoutingIsochronePostParams{lat=$lat, lng=$lng, time=$time, format=$format, mode=$mode, outputFields=$outputFields, outputGeometry=$outputGeometry, outputInclude=$outputInclude, outputPrecision=$outputPrecision, outputSimplify=$outputSimplify, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams, additionalBodyProperties=$additionalBodyProperties}"
}
