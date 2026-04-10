// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.client

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.getPackageVersion
import com.plazafyi.services.blocking.DatasetService
import com.plazafyi.services.blocking.DatasetServiceImpl
import com.plazafyi.services.blocking.ElevationService
import com.plazafyi.services.blocking.ElevationServiceImpl
import com.plazafyi.services.blocking.FeatureService
import com.plazafyi.services.blocking.FeatureServiceImpl
import com.plazafyi.services.blocking.GeocodeService
import com.plazafyi.services.blocking.GeocodeServiceImpl
import com.plazafyi.services.blocking.MapMatchService
import com.plazafyi.services.blocking.MapMatchServiceImpl
import com.plazafyi.services.blocking.OptimizeService
import com.plazafyi.services.blocking.OptimizeServiceImpl
import com.plazafyi.services.blocking.QueryService
import com.plazafyi.services.blocking.QueryServiceImpl
import com.plazafyi.services.blocking.RoutingService
import com.plazafyi.services.blocking.RoutingServiceImpl
import com.plazafyi.services.blocking.SearchService
import com.plazafyi.services.blocking.SearchServiceImpl
import com.plazafyi.services.blocking.TileService
import com.plazafyi.services.blocking.TileServiceImpl
import java.util.function.Consumer

class PlazaClientImpl(private val clientOptions: ClientOptions) : PlazaClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: PlazaClientAsync by lazy { PlazaClientAsyncImpl(clientOptions) }

    private val withRawResponse: PlazaClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val features: FeatureService by lazy { FeatureServiceImpl(clientOptionsWithUserAgent) }

    private val datasets: DatasetService by lazy { DatasetServiceImpl(clientOptionsWithUserAgent) }

    private val geocode: GeocodeService by lazy { GeocodeServiceImpl(clientOptionsWithUserAgent) }

    private val search: SearchService by lazy { SearchServiceImpl(clientOptionsWithUserAgent) }

    private val routing: RoutingService by lazy { RoutingServiceImpl(clientOptionsWithUserAgent) }

    private val elevation: ElevationService by lazy {
        ElevationServiceImpl(clientOptionsWithUserAgent)
    }

    private val mapMatch: MapMatchService by lazy {
        MapMatchServiceImpl(clientOptionsWithUserAgent)
    }

    private val optimize: OptimizeService by lazy {
        OptimizeServiceImpl(clientOptionsWithUserAgent)
    }

    private val query: QueryService by lazy { QueryServiceImpl(clientOptionsWithUserAgent) }

    private val tiles: TileService by lazy { TileServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): PlazaClientAsync = async

    override fun withRawResponse(): PlazaClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): PlazaClient =
        PlazaClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun features(): FeatureService = features

    override fun datasets(): DatasetService = datasets

    override fun geocode(): GeocodeService = geocode

    override fun search(): SearchService = search

    override fun routing(): RoutingService = routing

    override fun elevation(): ElevationService = elevation

    override fun mapMatch(): MapMatchService = mapMatch

    override fun optimize(): OptimizeService = optimize

    override fun query(): QueryService = query

    override fun tiles(): TileService = tiles

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PlazaClient.WithRawResponse {

        private val features: FeatureService.WithRawResponse by lazy {
            FeatureServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val datasets: DatasetService.WithRawResponse by lazy {
            DatasetServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val geocode: GeocodeService.WithRawResponse by lazy {
            GeocodeServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val search: SearchService.WithRawResponse by lazy {
            SearchServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val routing: RoutingService.WithRawResponse by lazy {
            RoutingServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val elevation: ElevationService.WithRawResponse by lazy {
            ElevationServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val mapMatch: MapMatchService.WithRawResponse by lazy {
            MapMatchServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val optimize: OptimizeService.WithRawResponse by lazy {
            OptimizeServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val query: QueryService.WithRawResponse by lazy {
            QueryServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val tiles: TileService.WithRawResponse by lazy {
            TileServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PlazaClient.WithRawResponse =
            PlazaClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun features(): FeatureService.WithRawResponse = features

        override fun datasets(): DatasetService.WithRawResponse = datasets

        override fun geocode(): GeocodeService.WithRawResponse = geocode

        override fun search(): SearchService.WithRawResponse = search

        override fun routing(): RoutingService.WithRawResponse = routing

        override fun elevation(): ElevationService.WithRawResponse = elevation

        override fun mapMatch(): MapMatchService.WithRawResponse = mapMatch

        override fun optimize(): OptimizeService.WithRawResponse = optimize

        override fun query(): QueryService.WithRawResponse = query

        override fun tiles(): TileService.WithRawResponse = tiles
    }
}
