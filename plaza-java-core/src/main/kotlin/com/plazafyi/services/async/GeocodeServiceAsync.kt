// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.async

import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.geocode.AutocompleteResult
import com.plazafyi.models.geocode.GeocodeAutocompleteParams
import com.plazafyi.models.geocode.GeocodeBatchParams
import com.plazafyi.models.geocode.GeocodeBatchResponse
import com.plazafyi.models.geocode.GeocodeForwardParams
import com.plazafyi.models.geocode.GeocodeResult
import com.plazafyi.models.geocode.GeocodeReverseParams
import com.plazafyi.models.geocode.ReverseGeocodeResult
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface GeocodeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GeocodeServiceAsync

    /** Autocomplete a partial address */
    fun autocomplete(params: GeocodeAutocompleteParams): CompletableFuture<AutocompleteResult> =
        autocomplete(params, RequestOptions.none())

    /** @see autocomplete */
    fun autocomplete(
        params: GeocodeAutocompleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AutocompleteResult>

    /** Batch geocode multiple addresses */
    fun batch(params: GeocodeBatchParams): CompletableFuture<GeocodeBatchResponse> =
        batch(params, RequestOptions.none())

    /** @see batch */
    fun batch(
        params: GeocodeBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GeocodeBatchResponse>

    /** Forward geocode an address */
    fun forward(params: GeocodeForwardParams): CompletableFuture<GeocodeResult> =
        forward(params, RequestOptions.none())

    /** @see forward */
    fun forward(
        params: GeocodeForwardParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GeocodeResult>

    /** Reverse geocode a coordinate */
    fun reverse(params: GeocodeReverseParams): CompletableFuture<ReverseGeocodeResult> =
        reverse(params, RequestOptions.none())

    /** @see reverse */
    fun reverse(
        params: GeocodeReverseParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ReverseGeocodeResult>

    /**
     * A view of [GeocodeServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GeocodeServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/geocode/autocomplete`, but is otherwise the
         * same as [GeocodeServiceAsync.autocomplete].
         */
        fun autocomplete(
            params: GeocodeAutocompleteParams
        ): CompletableFuture<HttpResponseFor<AutocompleteResult>> =
            autocomplete(params, RequestOptions.none())

        /** @see autocomplete */
        fun autocomplete(
            params: GeocodeAutocompleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AutocompleteResult>>

        /**
         * Returns a raw HTTP response for `post /api/v1/geocode/batch`, but is otherwise the same
         * as [GeocodeServiceAsync.batch].
         */
        fun batch(
            params: GeocodeBatchParams
        ): CompletableFuture<HttpResponseFor<GeocodeBatchResponse>> =
            batch(params, RequestOptions.none())

        /** @see batch */
        fun batch(
            params: GeocodeBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GeocodeBatchResponse>>

        /**
         * Returns a raw HTTP response for `get /api/v1/geocode`, but is otherwise the same as
         * [GeocodeServiceAsync.forward].
         */
        fun forward(
            params: GeocodeForwardParams
        ): CompletableFuture<HttpResponseFor<GeocodeResult>> =
            forward(params, RequestOptions.none())

        /** @see forward */
        fun forward(
            params: GeocodeForwardParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GeocodeResult>>

        /**
         * Returns a raw HTTP response for `get /api/v1/geocode/reverse`, but is otherwise the same
         * as [GeocodeServiceAsync.reverse].
         */
        fun reverse(
            params: GeocodeReverseParams
        ): CompletableFuture<HttpResponseFor<ReverseGeocodeResult>> =
            reverse(params, RequestOptions.none())

        /** @see reverse */
        fun reverse(
            params: GeocodeReverseParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ReverseGeocodeResult>>
    }
}
