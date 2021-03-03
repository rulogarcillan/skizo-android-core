package com.tuppersoft.skizo.android.core.bases

import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseData<S : BaseState>(
    val showLoading: MutableStateFlow<Boolean> = MutableStateFlow(false),
    val showError: MutableStateFlow<Boolean> = MutableStateFlow(false)
) {

    val state: MutableStateFlow<S> = MutableStateFlow(this.getInitialState()).also { state = it }

    abstract fun getInitialState(): S

    fun showError() {
        showLoading.value = false
        showError.value = true
    }

    fun showLoading() {
        showLoading.value = true
        showError.value = false
    }
}
