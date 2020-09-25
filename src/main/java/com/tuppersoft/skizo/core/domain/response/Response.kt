package com.tuppersoft.skizo.core.domain.response

import com.tuppersoft.skizo.core.domain.exception.Failure

sealed class Response<out T> {
    data class onSuccess<out T>(val value: T) : Response<T>()
    data class onFailure(val typeError: Failure) : Response<Nothing>()
}
