package com.tuppersoft.skizo.core.customtypealias

import com.tuppersoft.skizo.core.domain.exception.Failure

typealias OnFailure = ((Failure) -> Unit)
typealias OnProgress = (suspend (Int) -> Unit)
typealias OnClickItem <T> = (T) -> Unit
