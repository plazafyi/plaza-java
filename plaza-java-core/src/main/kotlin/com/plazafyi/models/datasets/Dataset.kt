// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.datasets

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.plazafyi.core.Enum
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

/**
 * Metadata for a custom dataset. Datasets contain user-uploaded geospatial features separate from
 * the OSM data.
 */
class Dataset
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val insertedAt: JsonField<OffsetDateTime>,
    private val name: JsonField<String>,
    private val scope: JsonField<Scope>,
    private val slug: JsonField<String>,
    private val status: JsonField<Status>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val addressCount: JsonField<Long>,
    private val attribution: JsonField<String>,
    private val description: JsonField<String>,
    private val edgeCount: JsonField<Long>,
    private val errorMessage: JsonField<String>,
    private val featureCount: JsonField<Long>,
    private val license: JsonField<String>,
    private val schemaDefinition: JsonValue,
    private val sourceFormat: JsonField<String>,
    private val sourceUrl: JsonField<String>,
    private val storageBytes: JsonField<Long>,
    private val strictMode: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("inserted_at")
        @ExcludeMissing
        insertedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("scope") @ExcludeMissing scope: JsonField<Scope> = JsonMissing.of(),
        @JsonProperty("slug") @ExcludeMissing slug: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("updated_at")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("address_count")
        @ExcludeMissing
        addressCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("attribution")
        @ExcludeMissing
        attribution: JsonField<String> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("edge_count") @ExcludeMissing edgeCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("error_message")
        @ExcludeMissing
        errorMessage: JsonField<String> = JsonMissing.of(),
        @JsonProperty("feature_count")
        @ExcludeMissing
        featureCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("license") @ExcludeMissing license: JsonField<String> = JsonMissing.of(),
        @JsonProperty("schema_definition")
        @ExcludeMissing
        schemaDefinition: JsonValue = JsonMissing.of(),
        @JsonProperty("source_format")
        @ExcludeMissing
        sourceFormat: JsonField<String> = JsonMissing.of(),
        @JsonProperty("source_url") @ExcludeMissing sourceUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("storage_bytes")
        @ExcludeMissing
        storageBytes: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("strict_mode")
        @ExcludeMissing
        strictMode: JsonField<Boolean> = JsonMissing.of(),
    ) : this(
        id,
        insertedAt,
        name,
        scope,
        slug,
        status,
        updatedAt,
        addressCount,
        attribution,
        description,
        edgeCount,
        errorMessage,
        featureCount,
        license,
        schemaDefinition,
        sourceFormat,
        sourceUrl,
        storageBytes,
        strictMode,
        mutableMapOf(),
    )

    /**
     * Dataset UUID
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Creation timestamp (UTC)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun insertedAt(): OffsetDateTime = insertedAt.getRequired("inserted_at")

    /**
     * Human-readable dataset name
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * Dataset scope: plaza (managed by Plaza) or user (user-owned)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun scope(): Scope = scope.getRequired("scope")

    /**
     * URL-friendly identifier
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun slug(): String = slug.getRequired("slug")

    /**
     * Current processing status
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * Last update timestamp (UTC)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updated_at")

    /**
     * Number of addresses in this dataset
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun addressCount(): Optional<Long> = addressCount.getOptional("address_count")

    /**
     * Required attribution text
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
     * Number of routing edges in this dataset
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun edgeCount(): Optional<Long> = edgeCount.getOptional("edge_count")

    /**
     * Error message if status is 'error'
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun errorMessage(): Optional<String> = errorMessage.getOptional("error_message")

    /**
     * Number of features in this dataset
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun featureCount(): Optional<Long> = featureCount.getOptional("feature_count")

    /**
     * License identifier (e.g. CC-BY-4.0)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun license(): Optional<String> = license.getOptional("license")

    /**
     * Detected or user-defined property schema
     *
     * This arbitrary value can be deserialized into a custom type using the `convert` method:
     * ```java
     * MyClass myObject = dataset.schemaDefinition().convert(MyClass.class);
     * ```
     */
    @JsonProperty("schema_definition")
    @ExcludeMissing
    fun _schemaDefinition(): JsonValue = schemaDefinition

    /**
     * Data format (geojson)
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sourceFormat(): Optional<String> = sourceFormat.getOptional("source_format")

    /**
     * URL of the original data source
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sourceUrl(): Optional<String> = sourceUrl.getOptional("source_url")

    /**
     * Total storage consumed in bytes
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun storageBytes(): Optional<Long> = storageBytes.getOptional("storage_bytes")

    /**
     * Whether strict schema validation is enabled
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun strictMode(): Optional<Boolean> = strictMode.getOptional("strict_mode")

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
     * Returns the raw JSON value of [scope].
     *
     * Unlike [scope], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("scope") @ExcludeMissing fun _scope(): JsonField<Scope> = scope

    /**
     * Returns the raw JSON value of [slug].
     *
     * Unlike [slug], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("slug") @ExcludeMissing fun _slug(): JsonField<String> = slug

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    /**
     * Returns the raw JSON value of [addressCount].
     *
     * Unlike [addressCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("address_count")
    @ExcludeMissing
    fun _addressCount(): JsonField<Long> = addressCount

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
     * Returns the raw JSON value of [edgeCount].
     *
     * Unlike [edgeCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("edge_count") @ExcludeMissing fun _edgeCount(): JsonField<Long> = edgeCount

    /**
     * Returns the raw JSON value of [errorMessage].
     *
     * Unlike [errorMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error_message")
    @ExcludeMissing
    fun _errorMessage(): JsonField<String> = errorMessage

    /**
     * Returns the raw JSON value of [featureCount].
     *
     * Unlike [featureCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("feature_count")
    @ExcludeMissing
    fun _featureCount(): JsonField<Long> = featureCount

    /**
     * Returns the raw JSON value of [license].
     *
     * Unlike [license], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("license") @ExcludeMissing fun _license(): JsonField<String> = license

    /**
     * Returns the raw JSON value of [sourceFormat].
     *
     * Unlike [sourceFormat], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source_format")
    @ExcludeMissing
    fun _sourceFormat(): JsonField<String> = sourceFormat

    /**
     * Returns the raw JSON value of [sourceUrl].
     *
     * Unlike [sourceUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source_url") @ExcludeMissing fun _sourceUrl(): JsonField<String> = sourceUrl

    /**
     * Returns the raw JSON value of [storageBytes].
     *
     * Unlike [storageBytes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("storage_bytes")
    @ExcludeMissing
    fun _storageBytes(): JsonField<Long> = storageBytes

    /**
     * Returns the raw JSON value of [strictMode].
     *
     * Unlike [strictMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("strict_mode") @ExcludeMissing fun _strictMode(): JsonField<Boolean> = strictMode

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
         * .scope()
         * .slug()
         * .status()
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
        private var scope: JsonField<Scope>? = null
        private var slug: JsonField<String>? = null
        private var status: JsonField<Status>? = null
        private var updatedAt: JsonField<OffsetDateTime>? = null
        private var addressCount: JsonField<Long> = JsonMissing.of()
        private var attribution: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var edgeCount: JsonField<Long> = JsonMissing.of()
        private var errorMessage: JsonField<String> = JsonMissing.of()
        private var featureCount: JsonField<Long> = JsonMissing.of()
        private var license: JsonField<String> = JsonMissing.of()
        private var schemaDefinition: JsonValue = JsonMissing.of()
        private var sourceFormat: JsonField<String> = JsonMissing.of()
        private var sourceUrl: JsonField<String> = JsonMissing.of()
        private var storageBytes: JsonField<Long> = JsonMissing.of()
        private var strictMode: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(dataset: Dataset) = apply {
            id = dataset.id
            insertedAt = dataset.insertedAt
            name = dataset.name
            scope = dataset.scope
            slug = dataset.slug
            status = dataset.status
            updatedAt = dataset.updatedAt
            addressCount = dataset.addressCount
            attribution = dataset.attribution
            description = dataset.description
            edgeCount = dataset.edgeCount
            errorMessage = dataset.errorMessage
            featureCount = dataset.featureCount
            license = dataset.license
            schemaDefinition = dataset.schemaDefinition
            sourceFormat = dataset.sourceFormat
            sourceUrl = dataset.sourceUrl
            storageBytes = dataset.storageBytes
            strictMode = dataset.strictMode
            additionalProperties = dataset.additionalProperties.toMutableMap()
        }

        /** Dataset UUID */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Creation timestamp (UTC) */
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

        /** Human-readable dataset name */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Dataset scope: plaza (managed by Plaza) or user (user-owned) */
        fun scope(scope: Scope) = scope(JsonField.of(scope))

        /**
         * Sets [Builder.scope] to an arbitrary JSON value.
         *
         * You should usually call [Builder.scope] with a well-typed [Scope] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun scope(scope: JsonField<Scope>) = apply { this.scope = scope }

        /** URL-friendly identifier */
        fun slug(slug: String) = slug(JsonField.of(slug))

        /**
         * Sets [Builder.slug] to an arbitrary JSON value.
         *
         * You should usually call [Builder.slug] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun slug(slug: JsonField<String>) = apply { this.slug = slug }

        /** Current processing status */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** Last update timestamp (UTC) */
        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        /** Number of addresses in this dataset */
        fun addressCount(addressCount: Long) = addressCount(JsonField.of(addressCount))

        /**
         * Sets [Builder.addressCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.addressCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun addressCount(addressCount: JsonField<Long>) = apply { this.addressCount = addressCount }

        /** Required attribution text */
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

        /** Number of routing edges in this dataset */
        fun edgeCount(edgeCount: Long) = edgeCount(JsonField.of(edgeCount))

        /**
         * Sets [Builder.edgeCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.edgeCount] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun edgeCount(edgeCount: JsonField<Long>) = apply { this.edgeCount = edgeCount }

        /** Error message if status is 'error' */
        fun errorMessage(errorMessage: String?) = errorMessage(JsonField.ofNullable(errorMessage))

        /** Alias for calling [Builder.errorMessage] with `errorMessage.orElse(null)`. */
        fun errorMessage(errorMessage: Optional<String>) = errorMessage(errorMessage.getOrNull())

        /**
         * Sets [Builder.errorMessage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.errorMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun errorMessage(errorMessage: JsonField<String>) = apply {
            this.errorMessage = errorMessage
        }

        /** Number of features in this dataset */
        fun featureCount(featureCount: Long) = featureCount(JsonField.of(featureCount))

        /**
         * Sets [Builder.featureCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.featureCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun featureCount(featureCount: JsonField<Long>) = apply { this.featureCount = featureCount }

        /** License identifier (e.g. CC-BY-4.0) */
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

        /** Detected or user-defined property schema */
        fun schemaDefinition(schemaDefinition: JsonValue) = apply {
            this.schemaDefinition = schemaDefinition
        }

        /** Data format (geojson) */
        fun sourceFormat(sourceFormat: String?) = sourceFormat(JsonField.ofNullable(sourceFormat))

        /** Alias for calling [Builder.sourceFormat] with `sourceFormat.orElse(null)`. */
        fun sourceFormat(sourceFormat: Optional<String>) = sourceFormat(sourceFormat.getOrNull())

        /**
         * Sets [Builder.sourceFormat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceFormat] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sourceFormat(sourceFormat: JsonField<String>) = apply {
            this.sourceFormat = sourceFormat
        }

        /** URL of the original data source */
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

        /** Total storage consumed in bytes */
        fun storageBytes(storageBytes: Long) = storageBytes(JsonField.of(storageBytes))

        /**
         * Sets [Builder.storageBytes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.storageBytes] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun storageBytes(storageBytes: JsonField<Long>) = apply { this.storageBytes = storageBytes }

        /** Whether strict schema validation is enabled */
        fun strictMode(strictMode: Boolean) = strictMode(JsonField.of(strictMode))

        /**
         * Sets [Builder.strictMode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.strictMode] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun strictMode(strictMode: JsonField<Boolean>) = apply { this.strictMode = strictMode }

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
         * .scope()
         * .slug()
         * .status()
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
                checkRequired("scope", scope),
                checkRequired("slug", slug),
                checkRequired("status", status),
                checkRequired("updatedAt", updatedAt),
                addressCount,
                attribution,
                description,
                edgeCount,
                errorMessage,
                featureCount,
                license,
                schemaDefinition,
                sourceFormat,
                sourceUrl,
                storageBytes,
                strictMode,
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
    fun validate(): Dataset = apply {
        if (validated) {
            return@apply
        }

        id()
        insertedAt()
        name()
        scope().validate()
        slug()
        status().validate()
        updatedAt()
        addressCount()
        attribution()
        description()
        edgeCount()
        errorMessage()
        featureCount()
        license()
        sourceFormat()
        sourceUrl()
        storageBytes()
        strictMode()
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
            (scope.asKnown().getOrNull()?.validity() ?: 0) +
            (if (slug.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (addressCount.asKnown().isPresent) 1 else 0) +
            (if (attribution.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (edgeCount.asKnown().isPresent) 1 else 0) +
            (if (errorMessage.asKnown().isPresent) 1 else 0) +
            (if (featureCount.asKnown().isPresent) 1 else 0) +
            (if (license.asKnown().isPresent) 1 else 0) +
            (if (sourceFormat.asKnown().isPresent) 1 else 0) +
            (if (sourceUrl.asKnown().isPresent) 1 else 0) +
            (if (storageBytes.asKnown().isPresent) 1 else 0) +
            (if (strictMode.asKnown().isPresent) 1 else 0)

    /** Dataset scope: plaza (managed by Plaza) or user (user-owned) */
    class Scope @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val PLAZA = of("plaza")

            @JvmField val USER = of("user")

            @JvmStatic fun of(value: String) = Scope(JsonField.of(value))
        }

        /** An enum containing [Scope]'s known values. */
        enum class Known {
            PLAZA,
            USER,
        }

        /**
         * An enum containing [Scope]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Scope] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PLAZA,
            USER,
            /** An enum member indicating that [Scope] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                PLAZA -> Value.PLAZA
                USER -> Value.USER
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws PlazaInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                PLAZA -> Known.PLAZA
                USER -> Known.USER
                else -> throw PlazaInvalidDataException("Unknown Scope: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws PlazaInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { PlazaInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws PlazaInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Scope = apply {
            if (validated) {
                return@apply
            }

            known()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Scope && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Current processing status */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val PENDING = of("pending")

            @JvmField val PROCESSING = of("processing")

            @JvmField val READY = of("ready")

            @JvmField val ERROR = of("error")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            PENDING,
            PROCESSING,
            READY,
            ERROR,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PENDING,
            PROCESSING,
            READY,
            ERROR,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                PENDING -> Value.PENDING
                PROCESSING -> Value.PROCESSING
                READY -> Value.READY
                ERROR -> Value.ERROR
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws PlazaInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                PENDING -> Known.PENDING
                PROCESSING -> Known.PROCESSING
                READY -> Known.READY
                ERROR -> Known.ERROR
                else -> throw PlazaInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws PlazaInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { PlazaInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws PlazaInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Status = apply {
            if (validated) {
                return@apply
            }

            known()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Dataset &&
            id == other.id &&
            insertedAt == other.insertedAt &&
            name == other.name &&
            scope == other.scope &&
            slug == other.slug &&
            status == other.status &&
            updatedAt == other.updatedAt &&
            addressCount == other.addressCount &&
            attribution == other.attribution &&
            description == other.description &&
            edgeCount == other.edgeCount &&
            errorMessage == other.errorMessage &&
            featureCount == other.featureCount &&
            license == other.license &&
            schemaDefinition == other.schemaDefinition &&
            sourceFormat == other.sourceFormat &&
            sourceUrl == other.sourceUrl &&
            storageBytes == other.storageBytes &&
            strictMode == other.strictMode &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            insertedAt,
            name,
            scope,
            slug,
            status,
            updatedAt,
            addressCount,
            attribution,
            description,
            edgeCount,
            errorMessage,
            featureCount,
            license,
            schemaDefinition,
            sourceFormat,
            sourceUrl,
            storageBytes,
            strictMode,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Dataset{id=$id, insertedAt=$insertedAt, name=$name, scope=$scope, slug=$slug, status=$status, updatedAt=$updatedAt, addressCount=$addressCount, attribution=$attribution, description=$description, edgeCount=$edgeCount, errorMessage=$errorMessage, featureCount=$featureCount, license=$license, schemaDefinition=$schemaDefinition, sourceFormat=$sourceFormat, sourceUrl=$sourceUrl, storageBytes=$storageBytes, strictMode=$strictMode, additionalProperties=$additionalProperties}"
}
