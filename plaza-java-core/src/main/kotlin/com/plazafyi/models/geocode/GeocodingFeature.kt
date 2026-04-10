// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.geocode

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
import com.plazafyi.core.toImmutable
import com.plazafyi.errors.PlazaInvalidDataException
import com.plazafyi.models.Geometry
import com.plazafyi.models.LineStringGeometry
import com.plazafyi.models.MultiLineStringGeometry
import com.plazafyi.models.MultiPointGeometry
import com.plazafyi.models.MultiPolygonGeometry
import com.plazafyi.models.PointGeometry
import com.plazafyi.models.PolygonGeometry
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * GeoJSON Feature representing a geocoding result. The geometry is always a Point. Properties
 * include the formatted display name, OSM metadata, confidence score, and source type.
 */
class GeocodingFeature
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val geometry: JsonField<Geometry>,
    private val properties: JsonField<Properties>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("geometry") @ExcludeMissing geometry: JsonField<Geometry> = JsonMissing.of(),
        @JsonProperty("properties")
        @ExcludeMissing
        properties: JsonField<Properties> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(geometry, properties, type, mutableMapOf())

    /**
     * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines the
     * coordinate structure.
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun geometry(): Geometry = geometry.getRequired("geometry")

    /**
     * Geocoding result properties
     *
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun properties(): Properties = properties.getRequired("properties")

    /**
     * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Returns the raw JSON value of [geometry].
     *
     * Unlike [geometry], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("geometry") @ExcludeMissing fun _geometry(): JsonField<Geometry> = geometry

    /**
     * Returns the raw JSON value of [properties].
     *
     * Unlike [properties], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("properties")
    @ExcludeMissing
    fun _properties(): JsonField<Properties> = properties

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
         * Returns a mutable builder for constructing an instance of [GeocodingFeature].
         *
         * The following fields are required:
         * ```java
         * .geometry()
         * .properties()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GeocodingFeature]. */
    class Builder internal constructor() {

        private var geometry: JsonField<Geometry>? = null
        private var properties: JsonField<Properties>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(geocodingFeature: GeocodingFeature) = apply {
            geometry = geocodingFeature.geometry
            properties = geocodingFeature.properties
            type = geocodingFeature.type
            additionalProperties = geocodingFeature.additionalProperties.toMutableMap()
        }

        /**
         * GeoJSON Geometry object per RFC 7946. Discriminated union — the `type` field determines
         * the coordinate structure.
         */
        fun geometry(geometry: Geometry) = geometry(JsonField.of(geometry))

        /**
         * Sets [Builder.geometry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.geometry] with a well-typed [Geometry] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun geometry(geometry: JsonField<Geometry>) = apply { this.geometry = geometry }

        /** Alias for calling [geometry] with `Geometry.ofPoint(point)`. */
        fun geometry(point: PointGeometry) = geometry(Geometry.ofPoint(point))

        /**
         * Alias for calling [geometry] with the following:
         * ```java
         * PointGeometry.builder()
         *     .type(PointGeometry.Type.POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun pointGeometry(coordinates: List<Double>) =
            geometry(
                PointGeometry.builder()
                    .type(PointGeometry.Type.POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [geometry] with `Geometry.ofLineString(lineString)`. */
        fun geometry(lineString: LineStringGeometry) = geometry(Geometry.ofLineString(lineString))

        /**
         * Alias for calling [geometry] with the following:
         * ```java
         * LineStringGeometry.builder()
         *     .type(LineStringGeometry.Type.LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun lineStringGeometry(coordinates: List<List<Double>>) =
            geometry(
                LineStringGeometry.builder()
                    .type(LineStringGeometry.Type.LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [geometry] with `Geometry.ofPolygon(polygon)`. */
        fun geometry(polygon: PolygonGeometry) = geometry(Geometry.ofPolygon(polygon))

        /**
         * Alias for calling [geometry] with the following:
         * ```java
         * PolygonGeometry.builder()
         *     .type(PolygonGeometry.Type.POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun polygonGeometry(coordinates: List<List<List<Double>>>) =
            geometry(
                PolygonGeometry.builder()
                    .type(PolygonGeometry.Type.POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [geometry] with `Geometry.ofMultiPoint(multiPoint)`. */
        fun geometry(multiPoint: MultiPointGeometry) = geometry(Geometry.ofMultiPoint(multiPoint))

        /**
         * Alias for calling [geometry] with the following:
         * ```java
         * MultiPointGeometry.builder()
         *     .type(MultiPointGeometry.Type.MULTI_POINT)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPointGeometry(coordinates: List<List<Double>>) =
            geometry(
                MultiPointGeometry.builder()
                    .type(MultiPointGeometry.Type.MULTI_POINT)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [geometry] with `Geometry.ofMultiLineString(multiLineString)`. */
        fun geometry(multiLineString: MultiLineStringGeometry) =
            geometry(Geometry.ofMultiLineString(multiLineString))

        /**
         * Alias for calling [geometry] with the following:
         * ```java
         * MultiLineStringGeometry.builder()
         *     .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiLineStringGeometry(coordinates: List<List<List<Double>>>) =
            geometry(
                MultiLineStringGeometry.builder()
                    .type(MultiLineStringGeometry.Type.MULTI_LINE_STRING)
                    .coordinates(coordinates)
                    .build()
            )

        /** Alias for calling [geometry] with `Geometry.ofMultiPolygon(multiPolygon)`. */
        fun geometry(multiPolygon: MultiPolygonGeometry) =
            geometry(Geometry.ofMultiPolygon(multiPolygon))

        /**
         * Alias for calling [geometry] with the following:
         * ```java
         * MultiPolygonGeometry.builder()
         *     .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
         *     .coordinates(coordinates)
         *     .build()
         * ```
         */
        fun multiPolygonGeometry(coordinates: List<List<List<List<Double>>>>) =
            geometry(
                MultiPolygonGeometry.builder()
                    .type(MultiPolygonGeometry.Type.MULTI_POLYGON)
                    .coordinates(coordinates)
                    .build()
            )

        /** Geocoding result properties */
        fun properties(properties: Properties) = properties(JsonField.of(properties))

        /**
         * Sets [Builder.properties] to an arbitrary JSON value.
         *
         * You should usually call [Builder.properties] with a well-typed [Properties] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun properties(properties: JsonField<Properties>) = apply { this.properties = properties }

        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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
         * Returns an immutable instance of [GeocodingFeature].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .geometry()
         * .properties()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): GeocodingFeature =
            GeocodingFeature(
                checkRequired("geometry", geometry),
                checkRequired("properties", properties),
                checkRequired("type", type),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): GeocodingFeature = apply {
        if (validated) {
            return@apply
        }

        geometry().validate()
        properties().validate()
        type().validate()
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
        (geometry.asKnown().getOrNull()?.validity() ?: 0) +
            (properties.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0)

    /** Geocoding result properties */
    class Properties
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val displayName: JsonField<String>,
        private val category: JsonField<String>,
        private val city: JsonField<String>,
        private val confidence: JsonField<Double>,
        private val country: JsonField<String>,
        private val countryCode: JsonField<String>,
        private val distanceM: JsonField<Double>,
        private val fullAddress: JsonField<String>,
        private val houseNumber: JsonField<String>,
        private val interpolated: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val osmId: JsonField<Long>,
        private val osmType: JsonField<OsmType>,
        private val postcode: JsonField<String>,
        private val score: JsonField<Double>,
        private val source: JsonField<Source>,
        private val state: JsonField<String>,
        private val street: JsonField<String>,
        private val subcategory: JsonField<String>,
        private val tags: JsonField<Tags>,
        private val wikipedia: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("display_name")
            @ExcludeMissing
            displayName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("category")
            @ExcludeMissing
            category: JsonField<String> = JsonMissing.of(),
            @JsonProperty("city") @ExcludeMissing city: JsonField<String> = JsonMissing.of(),
            @JsonProperty("confidence")
            @ExcludeMissing
            confidence: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
            @JsonProperty("country_code")
            @ExcludeMissing
            countryCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("distance_m")
            @ExcludeMissing
            distanceM: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("full_address")
            @ExcludeMissing
            fullAddress: JsonField<String> = JsonMissing.of(),
            @JsonProperty("house_number")
            @ExcludeMissing
            houseNumber: JsonField<String> = JsonMissing.of(),
            @JsonProperty("interpolated")
            @ExcludeMissing
            interpolated: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("osm_id") @ExcludeMissing osmId: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("osm_type")
            @ExcludeMissing
            osmType: JsonField<OsmType> = JsonMissing.of(),
            @JsonProperty("postcode")
            @ExcludeMissing
            postcode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("score") @ExcludeMissing score: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("source") @ExcludeMissing source: JsonField<Source> = JsonMissing.of(),
            @JsonProperty("state") @ExcludeMissing state: JsonField<String> = JsonMissing.of(),
            @JsonProperty("street") @ExcludeMissing street: JsonField<String> = JsonMissing.of(),
            @JsonProperty("subcategory")
            @ExcludeMissing
            subcategory: JsonField<String> = JsonMissing.of(),
            @JsonProperty("tags") @ExcludeMissing tags: JsonField<Tags> = JsonMissing.of(),
            @JsonProperty("wikipedia")
            @ExcludeMissing
            wikipedia: JsonField<String> = JsonMissing.of(),
        ) : this(
            displayName,
            category,
            city,
            confidence,
            country,
            countryCode,
            distanceM,
            fullAddress,
            houseNumber,
            interpolated,
            name,
            osmId,
            osmType,
            postcode,
            score,
            source,
            state,
            street,
            subcategory,
            tags,
            wikipedia,
            mutableMapOf(),
        )

        /**
         * Formatted address or place name
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun displayName(): String = displayName.getRequired("display_name")

        /**
         * POI category (e.g. restaurant, cafe, park). Present for place results.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun category(): Optional<String> = category.getOptional("category")

        /**
         * City or town name. Present for address results.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun city(): Optional<String> = city.getOptional("city")

        /**
         * Interpolation confidence (0-1). Present only for interpolated results.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun confidence(): Optional<Double> = confidence.getOptional("confidence")

        /**
         * Country name. Present for reverse geocode address results.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun country(): Optional<String> = country.getOptional("country")

        /**
         * ISO 3166-1 alpha-2 country code
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun countryCode(): Optional<String> = countryCode.getOptional("country_code")

        /**
         * Distance from the query point in meters (reverse geocode / nearby only)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun distanceM(): Optional<Double> = distanceM.getOptional("distance_m")

        /**
         * Complete formatted address from the database. Present for reverse geocode address
         * results.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fullAddress(): Optional<String> = fullAddress.getOptional("full_address")

        /**
         * House or building number. Present for address and interpolated results.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun houseNumber(): Optional<String> = houseNumber.getOptional("house_number")

        /**
         * Whether this result was estimated by address interpolation rather than an exact database
         * match.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun interpolated(): Optional<Boolean> = interpolated.getOptional("interpolated")

        /**
         * Place name (raw). Present for reverse geocode place results.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * OpenStreetMap element ID (null for interpolated results)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun osmId(): Optional<Long> = osmId.getOptional("osm_id")

        /**
         * OSM element type (node, way, relation)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun osmType(): Optional<OsmType> = osmType.getOptional("osm_type")

        /**
         * Postal code. Present for reverse geocode address results.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun postcode(): Optional<String> = postcode.getOptional("postcode")

        /**
         * Relevance score (higher is better). Incorporates text match quality, spatial proximity
         * boost, and popularity signals. Not bounded to 0-1.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun score(): Optional<Double> = score.getOptional("score")

        /**
         * Result source indicating how the result was found: structured (exact field match), fuzzy
         * (trigram similarity), address (reverse geocode address), place (reverse geocode POI),
         * interpolation (estimated from neighboring addresses)
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun source(): Optional<Source> = source.getOptional("source")

        /**
         * State or province name. Present for reverse geocode address results.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun state(): Optional<String> = state.getOptional("state")

        /**
         * Street name. Present for address and interpolated results.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun street(): Optional<String> = street.getOptional("street")

        /**
         * POI subcategory. Present for place results.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun subcategory(): Optional<String> = subcategory.getOptional("subcategory")

        /**
         * Raw OSM tags. Present for place results.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tags(): Optional<Tags> = tags.getOptional("tags")

        /**
         * Wikipedia article reference (e.g. en:Eiffel Tower). Present for notable places.
         *
         * @throws PlazaInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun wikipedia(): Optional<String> = wikipedia.getOptional("wikipedia")

        /**
         * Returns the raw JSON value of [displayName].
         *
         * Unlike [displayName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("display_name")
        @ExcludeMissing
        fun _displayName(): JsonField<String> = displayName

        /**
         * Returns the raw JSON value of [category].
         *
         * Unlike [category], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("category") @ExcludeMissing fun _category(): JsonField<String> = category

        /**
         * Returns the raw JSON value of [city].
         *
         * Unlike [city], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

        /**
         * Returns the raw JSON value of [confidence].
         *
         * Unlike [confidence], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("confidence")
        @ExcludeMissing
        fun _confidence(): JsonField<Double> = confidence

        /**
         * Returns the raw JSON value of [country].
         *
         * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

        /**
         * Returns the raw JSON value of [countryCode].
         *
         * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("country_code")
        @ExcludeMissing
        fun _countryCode(): JsonField<String> = countryCode

        /**
         * Returns the raw JSON value of [distanceM].
         *
         * Unlike [distanceM], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("distance_m") @ExcludeMissing fun _distanceM(): JsonField<Double> = distanceM

        /**
         * Returns the raw JSON value of [fullAddress].
         *
         * Unlike [fullAddress], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("full_address")
        @ExcludeMissing
        fun _fullAddress(): JsonField<String> = fullAddress

        /**
         * Returns the raw JSON value of [houseNumber].
         *
         * Unlike [houseNumber], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("house_number")
        @ExcludeMissing
        fun _houseNumber(): JsonField<String> = houseNumber

        /**
         * Returns the raw JSON value of [interpolated].
         *
         * Unlike [interpolated], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("interpolated")
        @ExcludeMissing
        fun _interpolated(): JsonField<Boolean> = interpolated

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [osmId].
         *
         * Unlike [osmId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("osm_id") @ExcludeMissing fun _osmId(): JsonField<Long> = osmId

        /**
         * Returns the raw JSON value of [osmType].
         *
         * Unlike [osmType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("osm_type") @ExcludeMissing fun _osmType(): JsonField<OsmType> = osmType

        /**
         * Returns the raw JSON value of [postcode].
         *
         * Unlike [postcode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("postcode") @ExcludeMissing fun _postcode(): JsonField<String> = postcode

        /**
         * Returns the raw JSON value of [score].
         *
         * Unlike [score], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Double> = score

        /**
         * Returns the raw JSON value of [source].
         *
         * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<Source> = source

        /**
         * Returns the raw JSON value of [state].
         *
         * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("state") @ExcludeMissing fun _state(): JsonField<String> = state

        /**
         * Returns the raw JSON value of [street].
         *
         * Unlike [street], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("street") @ExcludeMissing fun _street(): JsonField<String> = street

        /**
         * Returns the raw JSON value of [subcategory].
         *
         * Unlike [subcategory], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("subcategory")
        @ExcludeMissing
        fun _subcategory(): JsonField<String> = subcategory

        /**
         * Returns the raw JSON value of [tags].
         *
         * Unlike [tags], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tags") @ExcludeMissing fun _tags(): JsonField<Tags> = tags

        /**
         * Returns the raw JSON value of [wikipedia].
         *
         * Unlike [wikipedia], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("wikipedia") @ExcludeMissing fun _wikipedia(): JsonField<String> = wikipedia

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
             * Returns a mutable builder for constructing an instance of [Properties].
             *
             * The following fields are required:
             * ```java
             * .displayName()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Properties]. */
        class Builder internal constructor() {

            private var displayName: JsonField<String>? = null
            private var category: JsonField<String> = JsonMissing.of()
            private var city: JsonField<String> = JsonMissing.of()
            private var confidence: JsonField<Double> = JsonMissing.of()
            private var country: JsonField<String> = JsonMissing.of()
            private var countryCode: JsonField<String> = JsonMissing.of()
            private var distanceM: JsonField<Double> = JsonMissing.of()
            private var fullAddress: JsonField<String> = JsonMissing.of()
            private var houseNumber: JsonField<String> = JsonMissing.of()
            private var interpolated: JsonField<Boolean> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var osmId: JsonField<Long> = JsonMissing.of()
            private var osmType: JsonField<OsmType> = JsonMissing.of()
            private var postcode: JsonField<String> = JsonMissing.of()
            private var score: JsonField<Double> = JsonMissing.of()
            private var source: JsonField<Source> = JsonMissing.of()
            private var state: JsonField<String> = JsonMissing.of()
            private var street: JsonField<String> = JsonMissing.of()
            private var subcategory: JsonField<String> = JsonMissing.of()
            private var tags: JsonField<Tags> = JsonMissing.of()
            private var wikipedia: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(properties: Properties) = apply {
                displayName = properties.displayName
                category = properties.category
                city = properties.city
                confidence = properties.confidence
                country = properties.country
                countryCode = properties.countryCode
                distanceM = properties.distanceM
                fullAddress = properties.fullAddress
                houseNumber = properties.houseNumber
                interpolated = properties.interpolated
                name = properties.name
                osmId = properties.osmId
                osmType = properties.osmType
                postcode = properties.postcode
                score = properties.score
                source = properties.source
                state = properties.state
                street = properties.street
                subcategory = properties.subcategory
                tags = properties.tags
                wikipedia = properties.wikipedia
                additionalProperties = properties.additionalProperties.toMutableMap()
            }

            /** Formatted address or place name */
            fun displayName(displayName: String) = displayName(JsonField.of(displayName))

            /**
             * Sets [Builder.displayName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.displayName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun displayName(displayName: JsonField<String>) = apply {
                this.displayName = displayName
            }

            /** POI category (e.g. restaurant, cafe, park). Present for place results. */
            fun category(category: String?) = category(JsonField.ofNullable(category))

            /** Alias for calling [Builder.category] with `category.orElse(null)`. */
            fun category(category: Optional<String>) = category(category.getOrNull())

            /**
             * Sets [Builder.category] to an arbitrary JSON value.
             *
             * You should usually call [Builder.category] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun category(category: JsonField<String>) = apply { this.category = category }

            /** City or town name. Present for address results. */
            fun city(city: String?) = city(JsonField.ofNullable(city))

            /** Alias for calling [Builder.city] with `city.orElse(null)`. */
            fun city(city: Optional<String>) = city(city.getOrNull())

            /**
             * Sets [Builder.city] to an arbitrary JSON value.
             *
             * You should usually call [Builder.city] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun city(city: JsonField<String>) = apply { this.city = city }

            /** Interpolation confidence (0-1). Present only for interpolated results. */
            fun confidence(confidence: Double?) = confidence(JsonField.ofNullable(confidence))

            /**
             * Alias for [Builder.confidence].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun confidence(confidence: Double) = confidence(confidence as Double?)

            /** Alias for calling [Builder.confidence] with `confidence.orElse(null)`. */
            fun confidence(confidence: Optional<Double>) = confidence(confidence.getOrNull())

            /**
             * Sets [Builder.confidence] to an arbitrary JSON value.
             *
             * You should usually call [Builder.confidence] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun confidence(confidence: JsonField<Double>) = apply { this.confidence = confidence }

            /** Country name. Present for reverse geocode address results. */
            fun country(country: String?) = country(JsonField.ofNullable(country))

            /** Alias for calling [Builder.country] with `country.orElse(null)`. */
            fun country(country: Optional<String>) = country(country.getOrNull())

            /**
             * Sets [Builder.country] to an arbitrary JSON value.
             *
             * You should usually call [Builder.country] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun country(country: JsonField<String>) = apply { this.country = country }

            /** ISO 3166-1 alpha-2 country code */
            fun countryCode(countryCode: String?) = countryCode(JsonField.ofNullable(countryCode))

            /** Alias for calling [Builder.countryCode] with `countryCode.orElse(null)`. */
            fun countryCode(countryCode: Optional<String>) = countryCode(countryCode.getOrNull())

            /**
             * Sets [Builder.countryCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.countryCode] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun countryCode(countryCode: JsonField<String>) = apply {
                this.countryCode = countryCode
            }

            /** Distance from the query point in meters (reverse geocode / nearby only) */
            fun distanceM(distanceM: Double?) = distanceM(JsonField.ofNullable(distanceM))

            /**
             * Alias for [Builder.distanceM].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun distanceM(distanceM: Double) = distanceM(distanceM as Double?)

            /** Alias for calling [Builder.distanceM] with `distanceM.orElse(null)`. */
            fun distanceM(distanceM: Optional<Double>) = distanceM(distanceM.getOrNull())

            /**
             * Sets [Builder.distanceM] to an arbitrary JSON value.
             *
             * You should usually call [Builder.distanceM] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun distanceM(distanceM: JsonField<Double>) = apply { this.distanceM = distanceM }

            /**
             * Complete formatted address from the database. Present for reverse geocode address
             * results.
             */
            fun fullAddress(fullAddress: String?) = fullAddress(JsonField.ofNullable(fullAddress))

            /** Alias for calling [Builder.fullAddress] with `fullAddress.orElse(null)`. */
            fun fullAddress(fullAddress: Optional<String>) = fullAddress(fullAddress.getOrNull())

            /**
             * Sets [Builder.fullAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fullAddress] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fullAddress(fullAddress: JsonField<String>) = apply {
                this.fullAddress = fullAddress
            }

            /** House or building number. Present for address and interpolated results. */
            fun houseNumber(houseNumber: String?) = houseNumber(JsonField.ofNullable(houseNumber))

            /** Alias for calling [Builder.houseNumber] with `houseNumber.orElse(null)`. */
            fun houseNumber(houseNumber: Optional<String>) = houseNumber(houseNumber.getOrNull())

            /**
             * Sets [Builder.houseNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.houseNumber] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun houseNumber(houseNumber: JsonField<String>) = apply {
                this.houseNumber = houseNumber
            }

            /**
             * Whether this result was estimated by address interpolation rather than an exact
             * database match.
             */
            fun interpolated(interpolated: Boolean?) =
                interpolated(JsonField.ofNullable(interpolated))

            /**
             * Alias for [Builder.interpolated].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun interpolated(interpolated: Boolean) = interpolated(interpolated as Boolean?)

            /** Alias for calling [Builder.interpolated] with `interpolated.orElse(null)`. */
            fun interpolated(interpolated: Optional<Boolean>) =
                interpolated(interpolated.getOrNull())

            /**
             * Sets [Builder.interpolated] to an arbitrary JSON value.
             *
             * You should usually call [Builder.interpolated] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun interpolated(interpolated: JsonField<Boolean>) = apply {
                this.interpolated = interpolated
            }

            /** Place name (raw). Present for reverse geocode place results. */
            fun name(name: String?) = name(JsonField.ofNullable(name))

            /** Alias for calling [Builder.name] with `name.orElse(null)`. */
            fun name(name: Optional<String>) = name(name.getOrNull())

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** OpenStreetMap element ID (null for interpolated results) */
            fun osmId(osmId: Long?) = osmId(JsonField.ofNullable(osmId))

            /**
             * Alias for [Builder.osmId].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun osmId(osmId: Long) = osmId(osmId as Long?)

            /** Alias for calling [Builder.osmId] with `osmId.orElse(null)`. */
            fun osmId(osmId: Optional<Long>) = osmId(osmId.getOrNull())

            /**
             * Sets [Builder.osmId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.osmId] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun osmId(osmId: JsonField<Long>) = apply { this.osmId = osmId }

            /** OSM element type (node, way, relation) */
            fun osmType(osmType: OsmType?) = osmType(JsonField.ofNullable(osmType))

            /** Alias for calling [Builder.osmType] with `osmType.orElse(null)`. */
            fun osmType(osmType: Optional<OsmType>) = osmType(osmType.getOrNull())

            /**
             * Sets [Builder.osmType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.osmType] with a well-typed [OsmType] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun osmType(osmType: JsonField<OsmType>) = apply { this.osmType = osmType }

            /** Postal code. Present for reverse geocode address results. */
            fun postcode(postcode: String?) = postcode(JsonField.ofNullable(postcode))

            /** Alias for calling [Builder.postcode] with `postcode.orElse(null)`. */
            fun postcode(postcode: Optional<String>) = postcode(postcode.getOrNull())

            /**
             * Sets [Builder.postcode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.postcode] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun postcode(postcode: JsonField<String>) = apply { this.postcode = postcode }

            /**
             * Relevance score (higher is better). Incorporates text match quality, spatial
             * proximity boost, and popularity signals. Not bounded to 0-1.
             */
            fun score(score: Double?) = score(JsonField.ofNullable(score))

            /**
             * Alias for [Builder.score].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun score(score: Double) = score(score as Double?)

            /** Alias for calling [Builder.score] with `score.orElse(null)`. */
            fun score(score: Optional<Double>) = score(score.getOrNull())

            /**
             * Sets [Builder.score] to an arbitrary JSON value.
             *
             * You should usually call [Builder.score] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun score(score: JsonField<Double>) = apply { this.score = score }

            /**
             * Result source indicating how the result was found: structured (exact field match),
             * fuzzy (trigram similarity), address (reverse geocode address), place (reverse geocode
             * POI), interpolation (estimated from neighboring addresses)
             */
            fun source(source: Source?) = source(JsonField.ofNullable(source))

            /** Alias for calling [Builder.source] with `source.orElse(null)`. */
            fun source(source: Optional<Source>) = source(source.getOrNull())

            /**
             * Sets [Builder.source] to an arbitrary JSON value.
             *
             * You should usually call [Builder.source] with a well-typed [Source] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun source(source: JsonField<Source>) = apply { this.source = source }

            /** State or province name. Present for reverse geocode address results. */
            fun state(state: String?) = state(JsonField.ofNullable(state))

            /** Alias for calling [Builder.state] with `state.orElse(null)`. */
            fun state(state: Optional<String>) = state(state.getOrNull())

            /**
             * Sets [Builder.state] to an arbitrary JSON value.
             *
             * You should usually call [Builder.state] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun state(state: JsonField<String>) = apply { this.state = state }

            /** Street name. Present for address and interpolated results. */
            fun street(street: String?) = street(JsonField.ofNullable(street))

            /** Alias for calling [Builder.street] with `street.orElse(null)`. */
            fun street(street: Optional<String>) = street(street.getOrNull())

            /**
             * Sets [Builder.street] to an arbitrary JSON value.
             *
             * You should usually call [Builder.street] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun street(street: JsonField<String>) = apply { this.street = street }

            /** POI subcategory. Present for place results. */
            fun subcategory(subcategory: String?) = subcategory(JsonField.ofNullable(subcategory))

            /** Alias for calling [Builder.subcategory] with `subcategory.orElse(null)`. */
            fun subcategory(subcategory: Optional<String>) = subcategory(subcategory.getOrNull())

            /**
             * Sets [Builder.subcategory] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subcategory] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subcategory(subcategory: JsonField<String>) = apply {
                this.subcategory = subcategory
            }

            /** Raw OSM tags. Present for place results. */
            fun tags(tags: Tags?) = tags(JsonField.ofNullable(tags))

            /** Alias for calling [Builder.tags] with `tags.orElse(null)`. */
            fun tags(tags: Optional<Tags>) = tags(tags.getOrNull())

            /**
             * Sets [Builder.tags] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tags] with a well-typed [Tags] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun tags(tags: JsonField<Tags>) = apply { this.tags = tags }

            /** Wikipedia article reference (e.g. en:Eiffel Tower). Present for notable places. */
            fun wikipedia(wikipedia: String?) = wikipedia(JsonField.ofNullable(wikipedia))

            /** Alias for calling [Builder.wikipedia] with `wikipedia.orElse(null)`. */
            fun wikipedia(wikipedia: Optional<String>) = wikipedia(wikipedia.getOrNull())

            /**
             * Sets [Builder.wikipedia] to an arbitrary JSON value.
             *
             * You should usually call [Builder.wikipedia] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun wikipedia(wikipedia: JsonField<String>) = apply { this.wikipedia = wikipedia }

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
             * Returns an immutable instance of [Properties].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .displayName()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Properties =
                Properties(
                    checkRequired("displayName", displayName),
                    category,
                    city,
                    confidence,
                    country,
                    countryCode,
                    distanceM,
                    fullAddress,
                    houseNumber,
                    interpolated,
                    name,
                    osmId,
                    osmType,
                    postcode,
                    score,
                    source,
                    state,
                    street,
                    subcategory,
                    tags,
                    wikipedia,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Properties = apply {
            if (validated) {
                return@apply
            }

            displayName()
            category()
            city()
            confidence()
            country()
            countryCode()
            distanceM()
            fullAddress()
            houseNumber()
            interpolated()
            name()
            osmId()
            osmType().ifPresent { it.validate() }
            postcode()
            score()
            source().ifPresent { it.validate() }
            state()
            street()
            subcategory()
            tags().ifPresent { it.validate() }
            wikipedia()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (displayName.asKnown().isPresent) 1 else 0) +
                (if (category.asKnown().isPresent) 1 else 0) +
                (if (city.asKnown().isPresent) 1 else 0) +
                (if (confidence.asKnown().isPresent) 1 else 0) +
                (if (country.asKnown().isPresent) 1 else 0) +
                (if (countryCode.asKnown().isPresent) 1 else 0) +
                (if (distanceM.asKnown().isPresent) 1 else 0) +
                (if (fullAddress.asKnown().isPresent) 1 else 0) +
                (if (houseNumber.asKnown().isPresent) 1 else 0) +
                (if (interpolated.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (osmId.asKnown().isPresent) 1 else 0) +
                (osmType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (postcode.asKnown().isPresent) 1 else 0) +
                (if (score.asKnown().isPresent) 1 else 0) +
                (source.asKnown().getOrNull()?.validity() ?: 0) +
                (if (state.asKnown().isPresent) 1 else 0) +
                (if (street.asKnown().isPresent) 1 else 0) +
                (if (subcategory.asKnown().isPresent) 1 else 0) +
                (tags.asKnown().getOrNull()?.validity() ?: 0) +
                (if (wikipedia.asKnown().isPresent) 1 else 0)

        /** OSM element type (node, way, relation) */
        class OsmType @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val NODE = of("node")

                @JvmField val WAY = of("way")

                @JvmField val RELATION = of("relation")

                @JvmStatic fun of(value: String) = OsmType(JsonField.of(value))
            }

            /** An enum containing [OsmType]'s known values. */
            enum class Known {
                NODE,
                WAY,
                RELATION,
            }

            /**
             * An enum containing [OsmType]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [OsmType] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                NODE,
                WAY,
                RELATION,
                /**
                 * An enum member indicating that [OsmType] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    NODE -> Value.NODE
                    WAY -> Value.WAY
                    RELATION -> Value.RELATION
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws PlazaInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    NODE -> Known.NODE
                    WAY -> Known.WAY
                    RELATION -> Known.RELATION
                    else -> throw PlazaInvalidDataException("Unknown OsmType: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws PlazaInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    PlazaInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): OsmType = apply {
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

                return other is OsmType && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * Result source indicating how the result was found: structured (exact field match), fuzzy
         * (trigram similarity), address (reverse geocode address), place (reverse geocode POI),
         * interpolation (estimated from neighboring addresses)
         */
        class Source @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val STRUCTURED = of("structured")

                @JvmField val FUZZY = of("fuzzy")

                @JvmField val ADDRESS = of("address")

                @JvmField val PLACE = of("place")

                @JvmField val INTERPOLATION = of("interpolation")

                @JvmStatic fun of(value: String) = Source(JsonField.of(value))
            }

            /** An enum containing [Source]'s known values. */
            enum class Known {
                STRUCTURED,
                FUZZY,
                ADDRESS,
                PLACE,
                INTERPOLATION,
            }

            /**
             * An enum containing [Source]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Source] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                STRUCTURED,
                FUZZY,
                ADDRESS,
                PLACE,
                INTERPOLATION,
                /**
                 * An enum member indicating that [Source] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    STRUCTURED -> Value.STRUCTURED
                    FUZZY -> Value.FUZZY
                    ADDRESS -> Value.ADDRESS
                    PLACE -> Value.PLACE
                    INTERPOLATION -> Value.INTERPOLATION
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws PlazaInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    STRUCTURED -> Known.STRUCTURED
                    FUZZY -> Known.FUZZY
                    ADDRESS -> Known.ADDRESS
                    PLACE -> Known.PLACE
                    INTERPOLATION -> Known.INTERPOLATION
                    else -> throw PlazaInvalidDataException("Unknown Source: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws PlazaInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    PlazaInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Source = apply {
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

                return other is Source && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Raw OSM tags. Present for place results. */
        class Tags
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Tags]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Tags]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(tags: Tags) = apply {
                    additionalProperties = tags.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Tags].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Tags = Tags(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Tags = apply {
                if (validated) {
                    return@apply
                }

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
            @JvmSynthetic
            internal fun validity(): Int =
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Tags && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Tags{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Properties &&
                displayName == other.displayName &&
                category == other.category &&
                city == other.city &&
                confidence == other.confidence &&
                country == other.country &&
                countryCode == other.countryCode &&
                distanceM == other.distanceM &&
                fullAddress == other.fullAddress &&
                houseNumber == other.houseNumber &&
                interpolated == other.interpolated &&
                name == other.name &&
                osmId == other.osmId &&
                osmType == other.osmType &&
                postcode == other.postcode &&
                score == other.score &&
                source == other.source &&
                state == other.state &&
                street == other.street &&
                subcategory == other.subcategory &&
                tags == other.tags &&
                wikipedia == other.wikipedia &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                displayName,
                category,
                city,
                confidence,
                country,
                countryCode,
                distanceM,
                fullAddress,
                houseNumber,
                interpolated,
                name,
                osmId,
                osmType,
                postcode,
                score,
                source,
                state,
                street,
                subcategory,
                tags,
                wikipedia,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Properties{displayName=$displayName, category=$category, city=$city, confidence=$confidence, country=$country, countryCode=$countryCode, distanceM=$distanceM, fullAddress=$fullAddress, houseNumber=$houseNumber, interpolated=$interpolated, name=$name, osmId=$osmId, osmType=$osmType, postcode=$postcode, score=$score, source=$source, state=$state, street=$street, subcategory=$subcategory, tags=$tags, wikipedia=$wikipedia, additionalProperties=$additionalProperties}"
    }

    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val FEATURE = of("Feature")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            FEATURE
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            FEATURE,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                FEATURE -> Value.FEATURE
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
                FEATURE -> Known.FEATURE
                else -> throw PlazaInvalidDataException("Unknown Type: $value")
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

        fun validate(): Type = apply {
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

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is GeocodingFeature &&
            geometry == other.geometry &&
            properties == other.properties &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(geometry, properties, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "GeocodingFeature{geometry=$geometry, properties=$properties, type=$type, additionalProperties=$additionalProperties}"
}
