// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elements

import com.plazafyi.core.Params
import com.plazafyi.core.http.Headers
import com.plazafyi.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Query features by spatial predicate, bounding box, or H3 cell */
class ElementQueryParams
private constructor(
    private val bbox: String?,
    private val contains: String?,
    private val crosses: String?,
    private val cursor: String?,
    private val format: String?,
    private val h3: String?,
    private val intersects: String?,
    private val limit: Long?,
    private val near: String?,
    private val outputBuffer: Double?,
    private val outputCentroid: Boolean?,
    private val outputFields: String?,
    private val outputGeometry: Boolean?,
    private val outputInclude: String?,
    private val outputPrecision: Long?,
    private val outputSimplify: Double?,
    private val outputSort: String?,
    private val radius: Double?,
    private val touches: String?,
    private val type: String?,
    private val within: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Legacy shorthand. Bounding box: south,west,north,east. Use spatial predicates (near, within,
     * intersects) instead.
     */
    fun bbox(): Optional<String> = Optional.ofNullable(bbox)

    /** Geometry that features must contain */
    fun contains(): Optional<String> = Optional.ofNullable(contains)

    /** Geometry that features must cross */
    fun crosses(): Optional<String> = Optional.ofNullable(crosses)

    /** Cursor for pagination */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /**
     * Response format. json (default) returns paginated GeoJSON. geojson/csv/ndjson stream via
     * chunked transfer encoding.
     */
    fun format(): Optional<String> = Optional.ofNullable(format)

    /** Legacy shorthand. H3 cell index. Use spatial predicates instead. */
    fun h3(): Optional<String> = Optional.ofNullable(h3)

    /** Geometry that features must intersect */
    fun intersects(): Optional<String> = Optional.ofNullable(intersects)

    /** Maximum results (default 100, max 10000) */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Point geometry for proximity search (lat,lng). Requires radius. */
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

    /** Search radius in meters (for near) or buffer distance (for other predicates) */
    fun radius(): Optional<Double> = Optional.ofNullable(radius)

    /** Geometry that features must touch */
    fun touches(): Optional<String> = Optional.ofNullable(touches)

    /** Element types (comma-separated: node,way,relation) */
    fun type(): Optional<String> = Optional.ofNullable(type)

    /** Geometry that features must be within */
    fun within(): Optional<String> = Optional.ofNullable(within)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ElementQueryParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ElementQueryParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ElementQueryParams]. */
    class Builder internal constructor() {

        private var bbox: String? = null
        private var contains: String? = null
        private var crosses: String? = null
        private var cursor: String? = null
        private var format: String? = null
        private var h3: String? = null
        private var intersects: String? = null
        private var limit: Long? = null
        private var near: String? = null
        private var outputBuffer: Double? = null
        private var outputCentroid: Boolean? = null
        private var outputFields: String? = null
        private var outputGeometry: Boolean? = null
        private var outputInclude: String? = null
        private var outputPrecision: Long? = null
        private var outputSimplify: Double? = null
        private var outputSort: String? = null
        private var radius: Double? = null
        private var touches: String? = null
        private var type: String? = null
        private var within: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(elementQueryParams: ElementQueryParams) = apply {
            bbox = elementQueryParams.bbox
            contains = elementQueryParams.contains
            crosses = elementQueryParams.crosses
            cursor = elementQueryParams.cursor
            format = elementQueryParams.format
            h3 = elementQueryParams.h3
            intersects = elementQueryParams.intersects
            limit = elementQueryParams.limit
            near = elementQueryParams.near
            outputBuffer = elementQueryParams.outputBuffer
            outputCentroid = elementQueryParams.outputCentroid
            outputFields = elementQueryParams.outputFields
            outputGeometry = elementQueryParams.outputGeometry
            outputInclude = elementQueryParams.outputInclude
            outputPrecision = elementQueryParams.outputPrecision
            outputSimplify = elementQueryParams.outputSimplify
            outputSort = elementQueryParams.outputSort
            radius = elementQueryParams.radius
            touches = elementQueryParams.touches
            type = elementQueryParams.type
            within = elementQueryParams.within
            additionalHeaders = elementQueryParams.additionalHeaders.toBuilder()
            additionalQueryParams = elementQueryParams.additionalQueryParams.toBuilder()
        }

        /**
         * Legacy shorthand. Bounding box: south,west,north,east. Use spatial predicates (near,
         * within, intersects) instead.
         */
        fun bbox(bbox: String?) = apply { this.bbox = bbox }

        /** Alias for calling [Builder.bbox] with `bbox.orElse(null)`. */
        fun bbox(bbox: Optional<String>) = bbox(bbox.getOrNull())

        /** Geometry that features must contain */
        fun contains(contains: String?) = apply { this.contains = contains }

        /** Alias for calling [Builder.contains] with `contains.orElse(null)`. */
        fun contains(contains: Optional<String>) = contains(contains.getOrNull())

        /** Geometry that features must cross */
        fun crosses(crosses: String?) = apply { this.crosses = crosses }

        /** Alias for calling [Builder.crosses] with `crosses.orElse(null)`. */
        fun crosses(crosses: Optional<String>) = crosses(crosses.getOrNull())

        /** Cursor for pagination */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
        fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

        /**
         * Response format. json (default) returns paginated GeoJSON. geojson/csv/ndjson stream via
         * chunked transfer encoding.
         */
        fun format(format: String?) = apply { this.format = format }

        /** Alias for calling [Builder.format] with `format.orElse(null)`. */
        fun format(format: Optional<String>) = format(format.getOrNull())

        /** Legacy shorthand. H3 cell index. Use spatial predicates instead. */
        fun h3(h3: String?) = apply { this.h3 = h3 }

        /** Alias for calling [Builder.h3] with `h3.orElse(null)`. */
        fun h3(h3: Optional<String>) = h3(h3.getOrNull())

        /** Geometry that features must intersect */
        fun intersects(intersects: String?) = apply { this.intersects = intersects }

        /** Alias for calling [Builder.intersects] with `intersects.orElse(null)`. */
        fun intersects(intersects: Optional<String>) = intersects(intersects.getOrNull())

        /** Maximum results (default 100, max 10000) */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /** Point geometry for proximity search (lat,lng). Requires radius. */
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

        /** Search radius in meters (for near) or buffer distance (for other predicates) */
        fun radius(radius: Double?) = apply { this.radius = radius }

        /**
         * Alias for [Builder.radius].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun radius(radius: Double) = radius(radius as Double?)

        /** Alias for calling [Builder.radius] with `radius.orElse(null)`. */
        fun radius(radius: Optional<Double>) = radius(radius.getOrNull())

        /** Geometry that features must touch */
        fun touches(touches: String?) = apply { this.touches = touches }

        /** Alias for calling [Builder.touches] with `touches.orElse(null)`. */
        fun touches(touches: Optional<String>) = touches(touches.getOrNull())

        /** Element types (comma-separated: node,way,relation) */
        fun type(type: String?) = apply { this.type = type }

        /** Alias for calling [Builder.type] with `type.orElse(null)`. */
        fun type(type: Optional<String>) = type(type.getOrNull())

        /** Geometry that features must be within */
        fun within(within: String?) = apply { this.within = within }

        /** Alias for calling [Builder.within] with `within.orElse(null)`. */
        fun within(within: Optional<String>) = within(within.getOrNull())

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
         * Returns an immutable instance of [ElementQueryParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ElementQueryParams =
            ElementQueryParams(
                bbox,
                contains,
                crosses,
                cursor,
                format,
                h3,
                intersects,
                limit,
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
                touches,
                type,
                within,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                bbox?.let { put("bbox", it) }
                contains?.let { put("contains", it) }
                crosses?.let { put("crosses", it) }
                cursor?.let { put("cursor", it) }
                format?.let { put("format", it) }
                h3?.let { put("h3", it) }
                intersects?.let { put("intersects", it) }
                limit?.let { put("limit", it.toString()) }
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
                touches?.let { put("touches", it) }
                type?.let { put("type", it) }
                within?.let { put("within", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ElementQueryParams &&
            bbox == other.bbox &&
            contains == other.contains &&
            crosses == other.crosses &&
            cursor == other.cursor &&
            format == other.format &&
            h3 == other.h3 &&
            intersects == other.intersects &&
            limit == other.limit &&
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
            touches == other.touches &&
            type == other.type &&
            within == other.within &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            bbox,
            contains,
            crosses,
            cursor,
            format,
            h3,
            intersects,
            limit,
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
            touches,
            type,
            within,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "ElementQueryParams{bbox=$bbox, contains=$contains, crosses=$crosses, cursor=$cursor, format=$format, h3=$h3, intersects=$intersects, limit=$limit, near=$near, outputBuffer=$outputBuffer, outputCentroid=$outputCentroid, outputFields=$outputFields, outputGeometry=$outputGeometry, outputInclude=$outputInclude, outputPrecision=$outputPrecision, outputSimplify=$outputSimplify, outputSort=$outputSort, radius=$radius, touches=$touches, type=$type, within=$within, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
