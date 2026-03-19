// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.elements

import com.plazafyi.core.Params
import com.plazafyi.core.http.Headers
import com.plazafyi.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Query features by bounding box or H3 cell */
class ElementQueryParams
private constructor(
    private val bbox: String?,
    private val cursor: String?,
    private val h3: String?,
    private val limit: Long?,
    private val type: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Bounding box: south,west,north,east. At least one of bbox or h3 is required. */
    fun bbox(): Optional<String> = Optional.ofNullable(bbox)

    /** Cursor for pagination */
    fun cursor(): Optional<String> = Optional.ofNullable(cursor)

    /** H3 cell index. At least one of bbox or h3 is required. */
    fun h3(): Optional<String> = Optional.ofNullable(h3)

    /** Maximum results (default 100, max 10000) */
    fun limit(): Optional<Long> = Optional.ofNullable(limit)

    /** Element types (comma-separated: node,way,relation) */
    fun type(): Optional<String> = Optional.ofNullable(type)

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
        private var cursor: String? = null
        private var h3: String? = null
        private var limit: Long? = null
        private var type: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(elementQueryParams: ElementQueryParams) = apply {
            bbox = elementQueryParams.bbox
            cursor = elementQueryParams.cursor
            h3 = elementQueryParams.h3
            limit = elementQueryParams.limit
            type = elementQueryParams.type
            additionalHeaders = elementQueryParams.additionalHeaders.toBuilder()
            additionalQueryParams = elementQueryParams.additionalQueryParams.toBuilder()
        }

        /** Bounding box: south,west,north,east. At least one of bbox or h3 is required. */
        fun bbox(bbox: String?) = apply { this.bbox = bbox }

        /** Alias for calling [Builder.bbox] with `bbox.orElse(null)`. */
        fun bbox(bbox: Optional<String>) = bbox(bbox.getOrNull())

        /** Cursor for pagination */
        fun cursor(cursor: String?) = apply { this.cursor = cursor }

        /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
        fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

        /** H3 cell index. At least one of bbox or h3 is required. */
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
                cursor,
                h3,
                limit,
                type,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                bbox?.let { put("bbox", it) }
                cursor?.let { put("cursor", it) }
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

        return other is ElementQueryParams &&
            bbox == other.bbox &&
            cursor == other.cursor &&
            h3 == other.h3 &&
            limit == other.limit &&
            type == other.type &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(bbox, cursor, h3, limit, type, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ElementQueryParams{bbox=$bbox, cursor=$cursor, h3=$h3, limit=$limit, type=$type, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
