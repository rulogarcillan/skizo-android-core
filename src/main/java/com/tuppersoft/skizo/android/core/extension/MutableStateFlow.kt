package com.tuppersoft.skizo.android.core.extension

import kotlinx.coroutines.flow.MutableStateFlow

infix fun <T> MutableStateFlow<T>.update(value: T) {
    this.value = value
}
