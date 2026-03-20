// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elements

import com.plazafyi.core.JsonValue
import com.plazafyi.core.Params
import com.plazafyi.core.http.Headers
import com.plazafyi.core.http.QueryParams
import com.plazafyi.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Find features near a geographic point */
class ElementNearbyPostParams
private constructor(
    private val lat: Double?,
    private val limit: Long?,
    private val lng: Double?,
    private val near: String?,
    private val outputBuffer: Double?,
    private val outputCentroid: Boolean?,
    private val outputFields: String?,
    private val outputGeometry: Boolean?,
    private val outputInclude: String?,
    private val outputPrecision: Long?,
    private val outputSimplify: Double?,
    private val outputSort: String?,
    private val radius: Long?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
    private val additionalBodyProperties: Map<String, JsonValue>,
) : Params {

    /** Legacy shorthand. Latitude (-90 to 90). Use near param instead. */
    fun lat(): Optional<Double> = Optional.ofNullable(lat)

    /** Maximum results (default 20, max 100) */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Legacy shorthand. Longitude (-180 to 180). Use near param instead. */
    fun lng(): Optional<Double> = Optional.ofNullable(lng)

    /** Point geometry for proximity search (lat,lng or GeoJSON). Alternative to lat/lng params. */
    fun near(): Optional<String> = Optional.ofNullable(near)

    /** Buffer geometry by meters */
    fun outputBuffer(): Optional<Double> = Optional.ofNullable(outputBuffer)

    /** Replace geometry with centroid */
    fun outputCentroid(): Optional<Boolean> = Optional.ofNullable(outputCentroid)

    /** Comma-separated property fields to include */
    fun outputFields(): Optional<String> = Optional.ofNullable(outputFields)

    /** Include geometry (default true) */
    fun outputGeometry(): Optional<Boolean> = Optional.ofNullable(outputGeometry)

    /** Extra computed fields: bbox, distance, center */
    fun outputInclude(): Optional<String> = Optional.ofNullable(outputInclude)

    /** Coordinate decimal precision (1-15, default 7) */
    fun outputPrecision(): Optional<Long> = Optional.ofNullable(outputPrecision)

    /** Simplify geometry tolerance in meters */
    fun outputSimplify(): Optional<Double> = Optional.ofNullable(outputSimplify)

    /** Sort by: distance, name, osm_id */
    fun outputSort(): Optional<String> = Optional.ofNullable(outputSort)

    /** Search radius in meters (default 500, max 10000) */
    fun radius(): Optional<Long> = Optional.ofNullable(radius)

    /** Additional body properties to send with the request. */
    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ElementNearbyPostParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ElementNearbyPostParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ElementNearbyPostParams]. */
    class Builder internal constructor() {

        private var lat: Double? = null
        private var limit: Long? = null
        private var lng: Double? = null
        private var near: String? = null
        private var outputBuffer: Double? = null
        private var outputCentroid: Boolean? = null
        private var outputFields: String? = null
        private var outputGeometry: Boolean? = null
        private var outputInclude: String? = null
        private var outputPrecision: Long? = null
        private var outputSimplify: Double? = null
        private var outputSort: String? = null
        private var radius: Long? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(elementNearbyPostParams: ElementNearbyPostParams) = apply {
            lat = elementNearbyPostParams.lat
            limit = elementNearbyPostParams.limit
            lng = elementNearbyPostParams.lng
            near = elementNearbyPostParams.near
            outputBuffer = elementNearbyPostParams.outputBuffer
            outputCentroid = elementNearbyPostParams.outputCentroid
            outputFields = elementNearbyPostParams.outputFields
            outputGeometry = elementNearbyPostParams.outputGeometry
            outputInclude = elementNearbyPostParams.outputInclude
            outputPrecision = elementNearbyPostParams.outputPrecision
            outputSimplify = elementNearbyPostParams.outputSimplify
            outputSort = elementNearbyPostParams.outputSort
            radius = elementNearbyPostParams.radius
            additionalHeaders = elementNearbyPostParams.additionalHeaders.toBuilder()
            additionalQueryParams = elementNearbyPostParams.additionalQueryParams.toBuilder()
            additionalBodyProperties =
                elementNearbyPostParams.additionalBodyProperties.toMutableMap()
        }

        /** Legacy shorthand. Latitude (-90 to 90). Use near param instead. */
        fun lat(lat: Double?) = apply { this.lat = lat }

        /**
         * Alias for [Builder.lat].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun lat(lat: Double) = lat(lat as Double?)

        /** Alias for calling [Builder.lat] with `lat.orElse(null)`. */
        fun lat(lat: Optional<Double>) = lat(lat.getOrNull())

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

        /** Legacy shorthand. Longitude (-180 to 180). Use near param instead. */
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
         * Point geometry for proximity search (lat,lng or GeoJSON). Alternative to lat/lng params.
         */
        fun near(near: String?) = apply { this.near = near }

        /** Alias for calling [Builder.near] with `near.orElse(null)`. */
        fun near(near: Optional<String>) = near(near.getOrNull())

        /** Buffer geometry by meters */
        fun outputBuffer(outputBuffer: Double?) = apply { this.outputBuffer = outputBuffer }

        /**
         * Alias for [Builder.outputBuffer].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun outputBuffer(outputBuffer: Double) = outputBuffer(outputBuffer as Double?)

        /** Alias for calling [Builder.outputBuffer] with `outputBuffer.orElse(null)`. */
        fun outputBuffer(outputBuffer: Optional<Double>) = outputBuffer(outputBuffer.getOrNull())

        /** Replace geometry with centroid */
        fun outputCentroid(outputCentroid: Boolean?) = apply {
            this.outputCentroid = outputCentroid
        }

        /**
         * Alias for [Builder.outputCentroid].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun outputCentroid(outputCentroid: Boolean) = outputCentroid(outputCentroid as Boolean?)

        /** Alias for calling [Builder.outputCentroid] with `outputCentroid.orElse(null)`. */
        fun outputCentroid(outputCentroid: Optional<Boolean>) =
            outputCentroid(outputCentroid.getOrNull())

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

        /** Extra computed fields: bbox, distance, center */
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

        /** Sort by: distance, name, osm_id */
        fun outputSort(outputSort: String?) = apply { this.outputSort = outputSort }

        /** Alias for calling [Builder.outputSort] with `outputSort.orElse(null)`. */
        fun outputSort(outputSort: Optional<String>) = outputSort(outputSort.getOrNull())

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
         * Returns an immutable instance of [ElementNearbyPostParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ElementNearbyPostParams =
            ElementNearbyPostParams(
                lat,
                limit,
                lng,
                near,
                outputBuffer,
                outputCentroid,
                outputFields,
                outputGeometry,
                outputInclude,
                outputPrecision,
                outputSimplify,
                outputSort,
                radius,
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
                lat?.let { put("lat", it.toString()) }
                limit?.let { put("limit", it.toString()) }
                lng?.let { put("lng", it.toString()) }
                near?.let { put("near", it) }
                outputBuffer?.let { put("output[buffer]", it.toString()) }
                outputCentroid?.let { put("output[centroid]", it.toString()) }
                outputFields?.let { put("output[fields]", it) }
                outputGeometry?.let { put("output[geometry]", it.toString()) }
                outputInclude?.let { put("output[include]", it) }
                outputPrecision?.let { put("output[precision]", it.toString()) }
                outputSimplify?.let { put("output[simplify]", it.toString()) }
                outputSort?.let { put("output[sort]", it) }
                radius?.let { put("radius", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ElementNearbyPostParams &&
            lat == other.lat &&
            limit == other.limit &&
            lng == other.lng &&
            near == other.near &&
            outputBuffer == other.outputBuffer &&
            outputCentroid == other.outputCentroid &&
            outputFields == other.outputFields &&
            outputGeometry == other.outputGeometry &&
            outputInclude == other.outputInclude &&
            outputPrecision == other.outputPrecision &&
            outputSimplify == other.outputSimplify &&
            outputSort == other.outputSort &&
            radius == other.radius &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams &&
            additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int =
        Objects.hash(
            lat,
            limit,
            lng,
            near,
            outputBuffer,
            outputCentroid,
            outputFields,
            outputGeometry,
            outputInclude,
            outputPrecision,
            outputSimplify,
            outputSort,
            radius,
            additionalHeaders,
            additionalQueryParams,
            additionalBodyProperties,
        )

    override fun toString() =
        "ElementNearbyPostParams{lat=$lat, limit=$limit, lng=$lng, near=$near, outputBuffer=$outputBuffer, outputCentroid=$outputCentroid, outputFields=$outputFields, outputGeometry=$outputGeometry, outputInclude=$outputInclude, outputPrecision=$outputPrecision, outputSimplify=$outputSimplify, outputSort=$outputSort, radius=$radius, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams, additionalBodyProperties=$additionalBodyProperties}"
}
