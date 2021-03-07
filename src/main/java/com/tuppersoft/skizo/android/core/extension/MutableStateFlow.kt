package com.tuppersoft.skizo.android.core.extension

import com.tuppersoft.skizo.android.core.bases.BaseState
import com.tuppersoft.skizo.android.core.bases.StateLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow

infix fun <T> MutableStateFlow<T>.update(value: T) {
    this.value = value
}

infix fun <T : BaseState> StateLiveEvent<T>.update(value: T) {
    this.postValue(value)
}
