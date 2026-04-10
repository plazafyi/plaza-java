// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.features

import com.plazafyi.core.JsonValue
import com.plazafyi.core.Params
import com.plazafyi.core.http.Headers
import com.plazafyi.core.http.QueryParams
import com.plazafyi.core.immutableEmptyMap
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Query features by spatial predicate, bounding box, or H3 cell */
class FeatureQueryParams
private constructor(
    private val cursor: String?,
    private val format: String?,
    private val h3: String?,
    private val limit: Long?,
    private val type: String?,
    private val spatialPredicate: SpatialPredicate?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Cursor for pagination */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /**
     * Response format. json (default) returns paginated GeoJSON. geojson/csv/ndjson stream via
     * chunked transfer encoding.
     */
    fun format(): Optional<String> = Optional.ofNullable(format)

    /** Legacy shorthand. H3 cell index. Use spatial predicates instead. */
    fun h3(): Optional<String> = Optional.ofNullable(h3)

    /** Maximum results (default 100, max 10000) */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Element types (comma-separated: node,way,relation) */
    fun type(): Optional<String> = Optional.ofNullable(type)

    /**
     * Spatial predicates for filtering features by geographic relationship. Predicates are mutually
     * exclusive — use exactly one per request. The parameter name is the spatial operation, the
     * value is a GeoJSON geometry to test against.
     *
     * | Predicate        | Meaning                                    |
     * |------------------|--------------------------------------------|
     * | `around`         | Within radius meters (requires `radius`)   |
     * | `intersects`     | Feature overlaps the input geometry        |
     * | `within`         | Feature is fully inside the input geometry |
     * | `contains`       | Feature fully contains the input geometry  |
     * | `crosses`        | Feature crosses the input geometry         |
     * | `touches`        | Feature shares boundary but not interior   |
     * | `not_intersects` | Feature does not overlap                   |
     * | `not_within`     | Feature is not fully inside                |
     * | `not_contains`   | Feature does not fully contain             |
     */
    fun spatialPredicate(): Optional<SpatialPredicate> = Optional.ofNullable(spatialPredicate)

    fun _additionalBodyProperties(): Map<String, JsonValue> =
        spatialPredicate?._additionalProperties() ?: immutableEmptyMap()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): FeatureQueryParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [FeatureQueryParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FeatureQueryParams]. */
    class Builder internal constructor() {

        private var cursor: String? = null
        private var format: String? = null
        private var h3: String? = null
        private var limit: Long? = null
        private var type: String? = null
        private var spatialPredicate: SpatialPredicate? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(featureQueryParams: FeatureQueryParams) = apply {
            cursor = featureQueryParams.cursor
            format = featureQueryParams.format
            h3 = featureQueryParams.h3
            limit = featureQueryParams.limit
            type = featureQueryParams.type
            spatialPredicate = featureQueryParams.spatialPredicate
            additionalHeaders = featureQueryParams.additionalHeaders.toBuilder()
            additionalQueryParams = featureQueryParams.additionalQueryParams.toBuilder()
        }

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

        /** Element types (comma-separated: node,way,relation) */
        fun type(type: String?) = apply { this.type = type }

        /** Alias for calling [Builder.type] with `type.orElse(null)`. */
        fun type(type: Optional<String>) = type(type.getOrNull())

        /**
         * Spatial predicates for filtering features by geographic relationship. Predicates are
         * mutually exclusive — use exactly one per request. The parameter name is the spatial
         * operation, the value is a GeoJSON geometry to test against.
         *
         * | Predicate        | Meaning                                    |
         * |------------------|--------------------------------------------|
         * | `around`         | Within radius meters (requires `radius`)   |
         * | `intersects`     | Feature overlaps the input geometry        |
         * | `within`         | Feature is fully inside the input geometry |
         * | `contains`       | Feature fully contains the input geometry  |
         * | `crosses`        | Feature crosses the input geometry         |
         * | `touches`        | Feature shares boundary but not interior   |
         * | `not_intersects` | Feature does not overlap                   |
         * | `not_within`     | Feature is not fully inside                |
         * | `not_contains`   | Feature does not fully contain             |
         */
        fun spatialPredicate(spatialPredicate: SpatialPredicate?) = apply {
            this.spatialPredicate = spatialPredicate
        }

        /** Alias for calling [Builder.spatialPredicate] with `spatialPredicate.orElse(null)`. */
        fun spatialPredicate(spatialPredicate: Optional<SpatialPredicate>) =
            spatialPredicate(spatialPredicate.getOrNull())

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
         * Returns an immutable instance of [FeatureQueryParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): FeatureQueryParams =
            FeatureQueryParams(
                cursor,
                format,
                h3,
                limit,
                type,
                spatialPredicate,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Optional<SpatialPredicate> = Optional.ofNullable(spatialPredicate)

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                cursor?.let { put("cursor", it) }
                format?.let { put("format", it) }
                h3?.let { put("h3", it) }
                limit?.let { put("limit", it.toString()) }
                type?.let { put("type", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FeatureQueryParams &&
            cursor == other.cursor &&
            format == other.format &&
            h3 == other.h3 &&
            limit == other.limit &&
            type == other.type &&
            spatialPredicate == other.spatialPredicate &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            cursor,
            format,
            h3,
            limit,
            type,
            spatialPredicate,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "FeatureQueryParams{cursor=$cursor, format=$format, h3=$h3, limit=$limit, type=$type, spatialPredicate=$spatialPredicate, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
