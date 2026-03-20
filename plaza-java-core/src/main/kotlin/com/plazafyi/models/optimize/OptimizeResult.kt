// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.models.optimize

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.plazafyi.core.BaseDeserializer
import com.plazafyi.core.BaseSerializer
import com.plazafyi.core.JsonValue
import com.plazafyi.core.allMaxBy
import com.plazafyi.core.getOrThrow
import com.plazafyi.errors.PlazaInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * Optimization response — either a completed FeatureCollection with the optimized route, or an
 * async job reference to poll.
 */
@JsonDeserialize(using = OptimizeResult.Deserializer::class)
@JsonSerialize(using = OptimizeResult.Serializer::class)
class OptimizeResult
private constructor(
    private val completed: OptimizeCompletedResult? = null,
    private val processing: OptimizeProcessingResult? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * Completed optimization result as a GeoJSON FeatureCollection. Each Feature is a waypoint in
     * optimized visit order. Top-level fields provide summary statistics.
     */
    fun completed(): Optional<OptimizeCompletedResult> = Optional.ofNullable(completed)

    /**
     * Async optimization in progress. Poll `GET /api/v1/optimize/{job_id}` until the status changes
     * to `completed` or `failed`.
     */
    fun processing(): Optional<OptimizeProcessingResult> = Optional.ofNullable(processing)

    fun isCompleted(): Boolean = completed != null

    fun isProcessing(): Boolean = processing != null

    /**
     * Completed optimization result as a GeoJSON FeatureCollection. Each Feature is a waypoint in
     * optimized visit order. Top-level fields provide summary statistics.
     */
    fun asCompleted(): OptimizeCompletedResult = completed.getOrThrow("completed")

    /**
     * Async optimization in progress. Poll `GET /api/v1/optimize/{job_id}` until the status changes
     * to `completed` or `failed`.
     */
    fun asProcessing(): OptimizeProcessingResult = processing.getOrThrow("processing")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            completed != null -> visitor.visitCompleted(completed)
            processing != null -> visitor.visitProcessing(processing)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): OptimizeResult = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitCompleted(completed: OptimizeCompletedResult) {
                    completed.validate()
                }

                override fun visitProcessing(processing: OptimizeProcessingResult) {
                    processing.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitCompleted(completed: OptimizeCompletedResult) =
                    completed.validity()

                override fun visitProcessing(processing: OptimizeProcessingResult) =
                    processing.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OptimizeResult &&
            completed == other.completed &&
            processing == other.processing
    }

    override fun hashCode(): Int = Objects.hash(completed, processing)

    override fun toString(): String =
        when {
            completed != null -> "OptimizeResult{completed=$completed}"
            processing != null -> "OptimizeResult{processing=$processing}"
            _json != null -> "OptimizeResult{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid OptimizeResult")
        }

    companion object {

        /**
         * Completed optimization result as a GeoJSON FeatureCollection. Each Feature is a waypoint
         * in optimized visit order. Top-level fields provide summary statistics.
         */
        @JvmStatic
        fun ofCompleted(completed: OptimizeCompletedResult) = OptimizeResult(completed = completed)

        /**
         * Async optimization in progress. Poll `GET /api/v1/optimize/{job_id}` until the status
         * changes to `completed` or `failed`.
         */
        @JvmStatic
        fun ofProcessing(processing: OptimizeProcessingResult) =
            OptimizeResult(processing = processing)
    }

    /**
     * An interface that defines how to map each variant of [OptimizeResult] to a value of type [T].
     */
    interface Visitor<out T> {

        /**
         * Completed optimization result as a GeoJSON FeatureCollection. Each Feature is a waypoint
         * in optimized visit order. Top-level fields provide summary statistics.
         */
        fun visitCompleted(completed: OptimizeCompletedResult): T

        /**
         * Async optimization in progress. Poll `GET /api/v1/optimize/{job_id}` until the status
         * changes to `completed` or `failed`.
         */
        fun visitProcessing(processing: OptimizeProcessingResult): T

        /**
         * Maps an unknown variant of [OptimizeResult] to a value of type [T].
         *
         * An instance of [OptimizeResult] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws PlazaInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw PlazaInvalidDataException("Unknown OptimizeResult: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<OptimizeResult>(OptimizeResult::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): OptimizeResult {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<OptimizeCompletedResult>())?.let {
                            OptimizeResult(completed = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<OptimizeProcessingResult>())?.let {
                            OptimizeResult(processing = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> OptimizeResult(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<OptimizeResult>(OptimizeResult::class) {

        override fun serialize(
            value: OptimizeResult,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.completed != null -> generator.writeObject(value.completed)
                value.processing != null -> generator.writeObject(value.processing)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid OptimizeResult")
            }
        }
    }
}
