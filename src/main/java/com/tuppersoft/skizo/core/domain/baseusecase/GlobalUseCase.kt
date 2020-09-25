package com.tuppersoft.skizo.core.domain.baseusecase

import com.tuppersoft.skizo.core.customtypealias.OnFailure

/**
 * Created by Raúl Rodríguez Concepción on 17/08/2020.
 * Talento Mobile
 * raulrcs@gmail.com
 */
abstract class GlobalUseCase<out Type, in Params> where Type : Any? {

    protected abstract suspend fun run(params: Params, onFailure: OnFailure?): Type

    suspend fun invoke(params: Params, onFailure: OnFailure? = null): Type {
        return run(params, onFailure)
    }
}
