// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.datasets

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class Dataset
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val insertedAt: JsonField<OffsetDateTime>,
    private val name: JsonField<String>,
    private val slug: JsonField<String>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val attribution: JsonField<String>,
    private val description: JsonField<String>,
    private val license: JsonField<String>,
    private val sourceUrl: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("inserted_at")
        @ExcludeMissing
        insertedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("slug") @ExcludeMissing slug: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated_at")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("attribution")
        @ExcludeMissing
        attribution: JsonField<String> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("license") @ExcludeMissing license: JsonField<String> = JsonMissing.of(),
        @JsonProperty("source_url") @ExcludeMissing sourceUrl: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        insertedAt,
        name,
        slug,
        updatedAt,
        attribution,
        description,
        license,
        sourceUrl,
        mutableMapOf(),
    )

    /**
     * Dataset ID
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Creation timestamp
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun insertedAt(): OffsetDateTime = insertedAt.getRequired("inserted_at")

    /**
     * Dataset name
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * URL-friendly slug
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun slug(): String = slug.getRequired("slug")

    /**
     * Last update timestamp
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updated_at")

    /**
     * Attribution text
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun attribution(): Optional<String> = attribution.getOptional("attribution")

    /**
     * Dataset description
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * License identifier
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun license(): Optional<String> = license.getOptional("license")

    /**
     * Source data URL
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sourceUrl(): Optional<String> = sourceUrl.getOptional("source_url")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [insertedAt].
     *
     * Unlike [insertedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inserted_at")
    @ExcludeMissing
    fun _insertedAt(): JsonField<OffsetDateTime> = insertedAt

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [slug].
     *
     * Unlike [slug], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("slug") @ExcludeMissing fun _slug(): JsonField<String> = slug

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    /**
     * Returns the raw JSON value of [attribution].
     *
     * Unlike [attribution], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("attribution") @ExcludeMissing fun _attribution(): JsonField<String> = attribution

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [license].
     *
     * Unlike [license], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("license") @ExcludeMissing fun _license(): JsonField<String> = license

    /**
     * Returns the raw JSON value of [sourceUrl].
     *
     * Unlike [sourceUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source_url") @ExcludeMissing fun _sourceUrl(): JsonField<String> = sourceUrl

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
         * Returns a mutable builder for constructing an instance of [Dataset].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .insertedAt()
         * .name()
         * .slug()
         * .updatedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Dataset]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var insertedAt: JsonField<OffsetDateTime>? = null
        private var name: JsonField<String>? = null
        private var slug: JsonField<String>? = null
        private var updatedAt: JsonField<OffsetDateTime>? = null
        private var attribution: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var license: JsonField<String> = JsonMissing.of()
        private var sourceUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(dataset: Dataset) = apply {
            id = dataset.id
            insertedAt = dataset.insertedAt
            name = dataset.name
            slug = dataset.slug
            updatedAt = dataset.updatedAt
            attribution = dataset.attribution
            description = dataset.description
            license = dataset.license
            sourceUrl = dataset.sourceUrl
            additionalProperties = dataset.additionalProperties.toMutableMap()
        }

        /** Dataset ID */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Creation timestamp */
        fun insertedAt(insertedAt: OffsetDateTime) = insertedAt(JsonField.of(insertedAt))

        /**
         * Sets [Builder.insertedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.insertedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun insertedAt(insertedAt: JsonField<OffsetDateTime>) = apply {
            this.insertedAt = insertedAt
        }

        /** Dataset name */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** URL-friendly slug */
        fun slug(slug: String) = slug(JsonField.of(slug))

        /**
         * Sets [Builder.slug] to an arbitrary JSON value.
         *
         * You should usually call [Builder.slug] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun slug(slug: JsonField<String>) = apply { this.slug = slug }

        /** Last update timestamp */
        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        /** Attribution text */
        fun attribution(attribution: String?) = attribution(JsonField.ofNullable(attribution))

        /** Alias for calling [Builder.attribution] with `attribution.orElse(null)`. */
        fun attribution(attribution: Optional<String>) = attribution(attribution.getOrNull())

        /**
         * Sets [Builder.attribution] to an arbitrary JSON value.
         *
         * You should usually call [Builder.attribution] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun attribution(attribution: JsonField<String>) = apply { this.attribution = attribution }

        /** Dataset description */
        fun description(description: String?) = description(JsonField.ofNullable(description))

        /** Alias for calling [Builder.description] with `description.orElse(null)`. */
        fun description(description: Optional<String>) = description(description.getOrNull())

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** License identifier */
        fun license(license: String?) = license(JsonField.ofNullable(license))

        /** Alias for calling [Builder.license] with `license.orElse(null)`. */
        fun license(license: Optional<String>) = license(license.getOrNull())

        /**
         * Sets [Builder.license] to an arbitrary JSON value.
         *
         * You should usually call [Builder.license] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun license(license: JsonField<String>) = apply { this.license = license }

        /** Source data URL */
        fun sourceUrl(sourceUrl: String?) = sourceUrl(JsonField.ofNullable(sourceUrl))

        /** Alias for calling [Builder.sourceUrl] with `sourceUrl.orElse(null)`. */
        fun sourceUrl(sourceUrl: Optional<String>) = sourceUrl(sourceUrl.getOrNull())

        /**
         * Sets [Builder.sourceUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sourceUrl(sourceUrl: JsonField<String>) = apply { this.sourceUrl = sourceUrl }

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
         * Returns an immutable instance of [Dataset].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .insertedAt()
         * .name()
         * .slug()
         * .updatedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Dataset =
            Dataset(
                checkRequired("id", id),
                checkRequired("insertedAt", insertedAt),
                checkRequired("name", name),
                checkRequired("slug", slug),
                checkRequired("updatedAt", updatedAt),
                attribution,
                description,
                license,
                sourceUrl,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Dataset = apply {
        if (validated) {
            return@apply
        }

        id()
        insertedAt()
        name()
        slug()
        updatedAt()
        attribution()
        description()
        license()
        sourceUrl()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (insertedAt.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (slug.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (attribution.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (license.asKnown().isPresent) 1 else 0) +
            (if (sourceUrl.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Dataset &&
            id == other.id &&
            insertedAt == other.insertedAt &&
            name == other.name &&
            slug == other.slug &&
            updatedAt == other.updatedAt &&
            attribution == other.attribution &&
            description == other.description &&
            license == other.license &&
            sourceUrl == other.sourceUrl &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            insertedAt,
            name,
            slug,
            updatedAt,
            attribution,
            description,
            license,
            sourceUrl,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Dataset{id=$id, insertedAt=$insertedAt, name=$name, slug=$slug, updatedAt=$updatedAt, attribution=$attribution, description=$description, license=$license, sourceUrl=$sourceUrl, additionalProperties=$additionalProperties}"
}
