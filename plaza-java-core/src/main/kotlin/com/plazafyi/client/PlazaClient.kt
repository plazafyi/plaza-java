// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.client

import com.plazafyi.core.ClientOptions
import com.plazafyi.services.blocking.DatasetService
import com.plazafyi.services.blocking.ElevationService
import com.plazafyi.services.blocking.FeatureService
import com.plazafyi.services.blocking.GeocodeService
import com.plazafyi.services.blocking.MapMatchService
import com.plazafyi.services.blocking.OptimizeService
import com.plazafyi.services.blocking.QueryService
import com.plazafyi.services.blocking.RoutingService
import com.plazafyi.services.blocking.SearchService
import com.plazafyi.services.blocking.TileService
import java.util.function.Consumer

/**
 * A client for interacting with the Plaza REST API synchronously. You can also switch to
 * asynchronous execution via the [async] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface PlazaClient {

    /**
     * Returns a version of this client that uses asynchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun async(): PlazaClientAsync

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): PlazaClient

    fun features(): FeatureService

    fun datasets(): DatasetService

    fun geocode(): GeocodeService

    fun search(): SearchService

    fun routing(): RoutingService

    fun elevation(): ElevationService

    fun mapMatch(): MapMatchService

    fun optimize(): OptimizeService

    fun query(): QueryService

    fun tiles(): TileService

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /** A view of [PlazaClient] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): PlazaClient.WithRawResponse

        fun features(): FeatureService.WithRawResponse

        fun datasets(): DatasetService.WithRawResponse

        fun geocode(): GeocodeService.WithRawResponse

        fun search(): SearchService.WithRawResponse

        fun routing(): RoutingService.WithRawResponse

        fun elevation(): ElevationService.WithRawResponse

        fun mapMatch(): MapMatchService.WithRawResponse

        fun optimize(): OptimizeService.WithRawResponse

        fun query(): QueryService.WithRawResponse

        fun tiles(): TileService.WithRawResponse
    }
}
