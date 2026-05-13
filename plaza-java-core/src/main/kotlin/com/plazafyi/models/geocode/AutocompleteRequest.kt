// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.plazafyi.core.ExcludeMissing
import com.plazafyi.core.JsonField
import com.plazafyi.core.JsonMissing
import com.plazafyi.core.JsonValue
import com.plazafyi.core.checkRequired
import com.plazafyi.errors.PlazaInvalidDataException
import com.plazafyi.models.PointGeometry
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Request body for autocomplete suggestions. Optimized for low-latency type-ahead UIs. */
class AutocompleteRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val q: JsonField<String>,
    private val countryCode: JsonField<String>,
    private val focus: JsonField<PointGeometry>,
    private val lang: JsonField<String>,
    private val layer: JsonField<String>,
    private val limit: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("q") @ExcludeMissing q: JsonField<String> = JsonMissing.of(),
        @JsonProperty("country_code")
        @ExcludeMissing
        countryCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("focus") @ExcludeMissing focus: JsonField<PointGeometry> = JsonMissing.of(),
        @JsonProperty("lang") @ExcludeMissing lang: JsonField<String> = JsonMissing.of(),
        @JsonProperty("layer") @ExcludeMissing layer: JsonField<String> = JsonMissing.of(),
        @JsonProperty("limit") @ExcludeMissing limit: JsonField<Long> = JsonMissing.of(),
    ) : this(q, countryCode, focus, lang, layer, limit, mutableMapOf())

    /**
     * Partial address or place name input
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun q(): String = q.getRequired("q")

    /**
     * ISO 3166-1 alpha-2 country code to restrict results
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun countryCode(): Optional<String> = countryCode.getOptional("country_code")

    /**
     * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order. Optional
     * third element is altitude in meters.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun focus(): Optional<PointGeometry> = focus.getOptional("focus")

    /**
     * Preferred response language (ISO 639-1)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lang(): Optional<String> = lang.getOptional("lang")

    /**
     * Filter by result layer (e.g. `address`, `place`, `poi`)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun layer(): Optional<String> = layer.getOptional("layer")

    /**
     * Maximum number of suggestions (default: 5, max: 20)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun limit(): Optional<Long> = limit.getOptional("limit")

    /**
     * Returns the raw JSON value of [q].
     *
     * Unlike [q], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("q") @ExcludeMissing fun _q(): JsonField<String> = q

    /**
     * Returns the raw JSON value of [countryCode].
     *
     * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("country_code")
    @ExcludeMissing
    fun _countryCode(): JsonField<String> = countryCode

    /**
     * Returns the raw JSON value of [focus].
     *
     * Unlike [focus], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("focus") @ExcludeMissing fun _focus(): JsonField<PointGeometry> = focus

    /**
     * Returns the raw JSON value of [lang].
     *
     * Unlike [lang], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("lang") @ExcludeMissing fun _lang(): JsonField<String> = lang

    /**
     * Returns the raw JSON value of [layer].
     *
     * Unlike [layer], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("layer") @ExcludeMissing fun _layer(): JsonField<String> = layer

    /**
     * Returns the raw JSON value of [limit].
     *
     * Unlike [limit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("limit") @ExcludeMissing fun _limit(): JsonField<Long> = limit

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AutocompleteRequest].
         *
         * The following fields are required:
         * ```java
         * .q()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AutocompleteRequest]. */
    class Builder internal constructor() {

        private var q: JsonField<String>? = null
        private var countryCode: JsonField<String> = JsonMissing.of()
        private var focus: JsonField<PointGeometry> = JsonMissing.of()
        private var lang: JsonField<String> = JsonMissing.of()
        private var layer: JsonField<String> = JsonMissing.of()
        private var limit: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(autocompleteRequest: AutocompleteRequest) = apply {
            q = autocompleteRequest.q
            countryCode = autocompleteRequest.countryCode
            focus = autocompleteRequest.focus
            lang = autocompleteRequest.lang
            layer = autocompleteRequest.layer
            limit = autocompleteRequest.limit
            additionalProperties = autocompleteRequest.additionalProperties.toMutableMap()
        }

        /** Partial address or place name input */
        fun q(q: String) = q(JsonField.of(q))

        /**
         * Sets [Builder.q] to an arbitrary JSON value.
         *
         * You should usually call [Builder.q] with a well-typed [String] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun q(q: JsonField<String>) = apply { this.q = q }

        /** ISO 3166-1 alpha-2 country code to restrict results */
        fun countryCode(countryCode: String?) = countryCode(JsonField.ofNullable(countryCode))

        /** Alias for calling [Builder.countryCode] with `countryCode.orElse(null)`. */
        fun countryCode(countryCode: Optional<String>) = countryCode(countryCode.getOrNull())

        /**
         * Sets [Builder.countryCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.countryCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun countryCode(countryCode: JsonField<String>) = apply { this.countryCode = countryCode }

        /**
         * GeoJSON Point geometry per RFC 7946. Coordinates use [longitude, latitude] order.
         * Optional third element is altitude in meters.
         */
        fun focus(focus: PointGeometry?) = focus(JsonField.ofNullable(focus))

        /** Alias for calling [Builder.focus] with `focus.orElse(null)`. */
        fun focus(focus: Optional<PointGeometry>) = focus(focus.getOrNull())

        /**
         * Sets [Builder.focus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.focus] with a well-typed [PointGeometry] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun focus(focus: JsonField<PointGeometry>) = apply { this.focus = focus }

        /** Preferred response language (ISO 639-1) */
        fun lang(lang: String?) = lang(JsonField.ofNullable(lang))

        /** Alias for calling [Builder.lang] with `lang.orElse(null)`. */
        fun lang(lang: Optional<String>) = lang(lang.getOrNull())

        /**
         * Sets [Builder.lang] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lang] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun lang(lang: JsonField<String>) = apply { this.lang = lang }

        /** Filter by result layer (e.g. `address`, `place`, `poi`) */
        fun layer(layer: String?) = layer(JsonField.ofNullable(layer))

        /** Alias for calling [Builder.layer] with `layer.orElse(null)`. */
        fun layer(layer: Optional<String>) = layer(layer.getOrNull())

        /**
         * Sets [Builder.layer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.layer] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun layer(layer: JsonField<String>) = apply { this.layer = layer }

        /** Maximum number of suggestions (default: 5, max: 20) */
        fun limit(limit: Long?) = limit(JsonField.ofNullable(limit))

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

        /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
        fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

        /**
         * Sets [Builder.limit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.limit] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun limit(limit: JsonField<Long>) = apply { this.limit = limit }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [AutocompleteRequest].
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
        fun build(): AutocompleteRequest =
            AutocompleteRequest(
                checkRequired("q", q),
                countryCode,
                focus,
                lang,
                layer,
                limit,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws PlazaInvalidDataException if any value type in this object doesn't match its expected
     *   type.
     */
    fun validate(): AutocompleteRequest = apply {
        if (validated) {
            return@apply
        }

        q()
        countryCode()
        focus().ifPresent { it.validate() }
        lang()
        layer()
        limit()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: PlazaInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (q.asKnown().isPresent) 1 else 0) +
            (if (countryCode.asKnown().isPresent) 1 else 0) +
            (focus.asKnown().getOrNull()?.validity() ?: 0) +
            (if (lang.asKnown().isPresent) 1 else 0) +
            (if (layer.asKnown().isPresent) 1 else 0) +
            (if (limit.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AutocompleteRequest &&
            q == other.q &&
            countryCode == other.countryCode &&
            focus == other.focus &&
            lang == other.lang &&
            layer == other.layer &&
            limit == other.limit &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(q, countryCode, focus, lang, layer, limit, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AutocompleteRequest{q=$q, countryCode=$countryCode, focus=$focus, lang=$lang, layer=$layer, limit=$limit, additionalProperties=$additionalProperties}"
}
