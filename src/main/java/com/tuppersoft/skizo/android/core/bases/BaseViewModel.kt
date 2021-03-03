package com.tuppersoft.skizo.android.core.bases

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T : BaseData<S>, S : BaseState> : ViewModel() {

    abstract val data: T
}

