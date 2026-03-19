// File generated from our OpenAPI spec by Stainless.

package com.plazafyi.errors

import com.plazafyi.core.JsonValue
import com.plazafyi.core.http.Headers

abstract class PlazaServiceException
protected constructor(message: String, cause: Throwable? = null) : PlazaException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
