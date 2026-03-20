// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.plazafyi.core.ClientOptions
import com.plazafyi.core.RequestOptions
import com.plazafyi.core.http.HttpResponseFor
import com.plazafyi.models.geocode.AutocompleteResult
import com.plazafyi.models.geocode.GeocodeAutocompleteParams
import com.plazafyi.models.geocode.GeocodeAutocompletePostParams
import com.plazafyi.models.geocode.GeocodeBatchParams
import com.plazafyi.models.geocode.GeocodeBatchResponse
import com.plazafyi.models.geocode.GeocodeForwardParams
import com.plazafyi.models.geocode.GeocodeForwardPostParams
import com.plazafyi.models.geocode.GeocodeResult
import com.plazafyi.models.geocode.GeocodeReverseParams
import com.plazafyi.models.geocode.GeocodeReversePostParams
import com.plazafyi.models.geocode.ReverseGeocodeResult
import java.util.function.Consumer

interface GeocodeService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GeocodeService

    /** Autocomplete a partial address */
    fun autocomplete(params: GeocodeAutocompleteParams): AutocompleteResult =
        autocomplete(params, RequestOptions.none())

    /** @see autocomplete */
    fun autocomplete(
        params: GeocodeAutocompleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AutocompleteResult

    /** Autocomplete a partial address */
    fun autocompletePost(params: GeocodeAutocompletePostParams): AutocompleteResult =
        autocompletePost(params, RequestOptions.none())

    /** @see autocompletePost */
    fun autocompletePost(
        params: GeocodeAutocompletePostParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AutocompleteResult

    /** Batch geocode multiple addresses */
    fun batch(params: GeocodeBatchParams): GeocodeBatchResponse =
        batch(params, RequestOptions.none())

    /** @see batch */
    fun batch(
        params: GeocodeBatchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeocodeBatchResponse

    /** Forward geocode an address */
    fun forward(params: GeocodeForwardParams): GeocodeResult =
        forward(params, RequestOptions.none())

    /** @see forward */
    fun forward(
        params: GeocodeForwardParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeocodeResult

    /** Forward geocode an address */
    fun forwardPost(params: GeocodeForwardPostParams): GeocodeResult =
        forwardPost(params, RequestOptions.none())

    /** @see forwardPost */
    fun forwardPost(
        params: GeocodeForwardPostParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GeocodeResult

    /** Reverse geocode a coordinate */
    fun reverse(): ReverseGeocodeResult = reverse(GeocodeReverseParams.none())

    /** @see reverse */
    fun reverse(
        params: GeocodeReverseParams = GeocodeReverseParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ReverseGeocodeResult

    /** @see reverse */
    fun reverse(params: GeocodeReverseParams = GeocodeReverseParams.none()): ReverseGeocodeResult =
        reverse(params, RequestOptions.none())

    /** @see reverse */
    fun reverse(requestOptions: RequestOptions): ReverseGeocodeResult =
        reverse(GeocodeReverseParams.none(), requestOptions)

    /** Reverse geocode a coordinate */
    fun reversePost(): ReverseGeocodeResult = reversePost(GeocodeReversePostParams.none())

    /** @see reversePost */
    fun reversePost(
        params: GeocodeReversePostParams = GeocodeReversePostParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ReverseGeocodeResult

    /** @see reversePost */
    fun reversePost(
        params: GeocodeReversePostParams = GeocodeReversePostParams.none()
    ): ReverseGeocodeResult = reversePost(params, RequestOptions.none())

    /** @see reversePost */
    fun reversePost(requestOptions: RequestOptions): ReverseGeocodeResult =
        reversePost(GeocodeReversePostParams.none(), requestOptions)

    /** A view of [GeocodeService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): GeocodeService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/geocode/autocomplete`, but is otherwise the
         * same as [GeocodeService.autocomplete].
         */
        @MustBeClosed
        fun autocomplete(params: GeocodeAutocompleteParams): HttpResponseFor<AutocompleteResult> =
            autocomplete(params, RequestOptions.none())

        /** @see autocomplete */
        @MustBeClosed
        fun autocomplete(
            params: GeocodeAutocompleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AutocompleteResult>

        /**
         * Returns a raw HTTP response for `post /api/v1/geocode/autocomplete`, but is otherwise the
         * same as [GeocodeService.autocompletePost].
         */
        @MustBeClosed
        fun autocompletePost(
            params: GeocodeAutocompletePostParams
        ): HttpResponseFor<AutocompleteResult> = autocompletePost(params, RequestOptions.none())

        /** @see autocompletePost */
        @MustBeClosed
        fun autocompletePost(
            params: GeocodeAutocompletePostParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AutocompleteResult>

        /**
         * Returns a raw HTTP response for `post /api/v1/geocode/batch`, but is otherwise the same
         * as [GeocodeService.batch].
         */
        @MustBeClosed
        fun batch(params: GeocodeBatchParams): HttpResponseFor<GeocodeBatchResponse> =
            batch(params, RequestOptions.none())

        /** @see batch */
        @MustBeClosed
        fun batch(
            params: GeocodeBatchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeocodeBatchResponse>

        /**
         * Returns a raw HTTP response for `get /api/v1/geocode`, but is otherwise the same as
         * [GeocodeService.forward].
         */
        @MustBeClosed
        fun forward(params: GeocodeForwardParams): HttpResponseFor<GeocodeResult> =
            forward(params, RequestOptions.none())

        /** @see forward */
        @MustBeClosed
        fun forward(
            params: GeocodeForwardParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeocodeResult>

        /**
         * Returns a raw HTTP response for `post /api/v1/geocode`, but is otherwise the same as
         * [GeocodeService.forwardPost].
         */
        @MustBeClosed
        fun forwardPost(params: GeocodeForwardPostParams): HttpResponseFor<GeocodeResult> =
            forwardPost(params, RequestOptions.none())

        /** @see forwardPost */
        @MustBeClosed
        fun forwardPost(
            params: GeocodeForwardPostParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GeocodeResult>

        /**
         * Returns a raw HTTP response for `get /api/v1/geocode/reverse`, but is otherwise the same
         * as [GeocodeService.reverse].
         */
        @MustBeClosed
        fun reverse(): HttpResponseFor<ReverseGeocodeResult> = reverse(GeocodeReverseParams.none())

        /** @see reverse */
        @MustBeClosed
        fun reverse(
            params: GeocodeReverseParams = GeocodeReverseParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ReverseGeocodeResult>

        /** @see reverse */
        @MustBeClosed
        fun reverse(
            params: GeocodeReverseParams = GeocodeReverseParams.none()
        ): HttpResponseFor<ReverseGeocodeResult> = reverse(params, RequestOptions.none())

        /** @see reverse */
        @MustBeClosed
        fun reverse(requestOptions: RequestOptions): HttpResponseFor<ReverseGeocodeResult> =
            reverse(GeocodeReverseParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v1/geocode/reverse`, but is otherwise the same
         * as [GeocodeService.reversePost].
         */
        @MustBeClosed
        fun reversePost(): HttpResponseFor<ReverseGeocodeResult> =
            reversePost(GeocodeReversePostParams.none())

        /** @see reversePost */
        @MustBeClosed
        fun reversePost(
            params: GeocodeReversePostParams = GeocodeReversePostParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ReverseGeocodeResult>

        /** @see reversePost */
        @MustBeClosed
        fun reversePost(
            params: GeocodeReversePostParams = GeocodeReversePostParams.none()
        ): HttpResponseFor<ReverseGeocodeResult> = reversePost(params, RequestOptions.none())

        /** @see reversePost */
        @MustBeClosed
        fun reversePost(requestOptions: RequestOptions): HttpResponseFor<ReverseGeocodeResult> =
            reversePost(GeocodeReversePostParams.none(), requestOptions)
    }
}
