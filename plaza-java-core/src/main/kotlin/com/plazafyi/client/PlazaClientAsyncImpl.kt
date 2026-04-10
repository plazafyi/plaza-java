// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.client

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.getPackageVersion
import com.plazafyi.services.async.DatasetServiceAsync
import com.plazafyi.services.async.DatasetServiceAsyncImpl
import com.plazafyi.services.async.ElevationServiceAsync
import com.plazafyi.services.async.ElevationServiceAsyncImpl
import com.plazafyi.services.async.FeatureServiceAsync
import com.plazafyi.services.async.FeatureServiceAsyncImpl
import com.plazafyi.services.async.GeocodeServiceAsync
import com.plazafyi.services.async.GeocodeServiceAsyncImpl
import com.plazafyi.services.async.MapMatchServiceAsync
import com.plazafyi.services.async.MapMatchServiceAsyncImpl
import com.plazafyi.services.async.OptimizeServiceAsync
import com.plazafyi.services.async.OptimizeServiceAsyncImpl
import com.plazafyi.services.async.QueryServiceAsync
import com.plazafyi.services.async.QueryServiceAsyncImpl
import com.plazafyi.services.async.RoutingServiceAsync
import com.plazafyi.services.async.RoutingServiceAsyncImpl
import com.plazafyi.services.async.SearchServiceAsync
import com.plazafyi.services.async.SearchServiceAsyncImpl
import com.plazafyi.services.async.TileServiceAsync
import com.plazafyi.services.async.TileServiceAsyncImpl
import java.util.function.Consumer

class PlazaClientAsyncImpl(private val clientOptions: ClientOptions) : PlazaClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: PlazaClient by lazy { PlazaClientImpl(clientOptions) }

    private val withRawResponse: PlazaClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val features: FeatureServiceAsync by lazy {
        FeatureServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val datasets: DatasetServiceAsync by lazy {
        DatasetServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val geocode: GeocodeServiceAsync by lazy {
        GeocodeServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val search: SearchServiceAsync by lazy {
        SearchServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val routing: RoutingServiceAsync by lazy {
        RoutingServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val elevation: ElevationServiceAsync by lazy {
        ElevationServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val mapMatch: MapMatchServiceAsync by lazy {
        MapMatchServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val optimize: OptimizeServiceAsync by lazy {
        OptimizeServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val query: QueryServiceAsync by lazy {
        QueryServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val tiles: TileServiceAsync by lazy { TileServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): PlazaClient = sync

    override fun withRawResponse(): PlazaClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): PlazaClientAsync =
        PlazaClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun features(): FeatureServiceAsync = features

    override fun datasets(): DatasetServiceAsync = datasets

    override fun geocode(): GeocodeServiceAsync = geocode

    override fun search(): SearchServiceAsync = search

    override fun routing(): RoutingServiceAsync = routing

    override fun elevation(): ElevationServiceAsync = elevation

    override fun mapMatch(): MapMatchServiceAsync = mapMatch

    override fun optimize(): OptimizeServiceAsync = optimize

    override fun query(): QueryServiceAsync = query

    override fun tiles(): TileServiceAsync = tiles

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PlazaClientAsync.WithRawResponse {

        private val features: FeatureServiceAsync.WithRawResponse by lazy {
            FeatureServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val datasets: DatasetServiceAsync.WithRawResponse by lazy {
            DatasetServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val geocode: GeocodeServiceAsync.WithRawResponse by lazy {
            GeocodeServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val search: SearchServiceAsync.WithRawResponse by lazy {
            SearchServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val routing: RoutingServiceAsync.WithRawResponse by lazy {
            RoutingServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val elevation: ElevationServiceAsync.WithRawResponse by lazy {
            ElevationServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val mapMatch: MapMatchServiceAsync.WithRawResponse by lazy {
            MapMatchServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val optimize: OptimizeServiceAsync.WithRawResponse by lazy {
            OptimizeServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val query: QueryServiceAsync.WithRawResponse by lazy {
            QueryServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val tiles: TileServiceAsync.WithRawResponse by lazy {
            TileServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PlazaClientAsync.WithRawResponse =
            PlazaClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun features(): FeatureServiceAsync.WithRawResponse = features

        override fun datasets(): DatasetServiceAsync.WithRawResponse = datasets

        override fun geocode(): GeocodeServiceAsync.WithRawResponse = geocode

        override fun search(): SearchServiceAsync.WithRawResponse = search

        override fun routing(): RoutingServiceAsync.WithRawResponse = routing

        override fun elevation(): ElevationServiceAsync.WithRawResponse = elevation

        override fun mapMatch(): MapMatchServiceAsync.WithRawResponse = mapMatch

        override fun optimize(): OptimizeServiceAsync.WithRawResponse = optimize

        override fun query(): QueryServiceAsync.WithRawResponse = query

        override fun tiles(): TileServiceAsync.WithRawResponse = tiles
    }
}
