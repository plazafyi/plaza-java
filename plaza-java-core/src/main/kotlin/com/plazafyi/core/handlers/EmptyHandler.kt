@file:JvmName("EmptyHandler")

package com.plazafyi.core.handlers

import com.plazafyi.core.http.HttpResponse
import com.plazafyi.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
