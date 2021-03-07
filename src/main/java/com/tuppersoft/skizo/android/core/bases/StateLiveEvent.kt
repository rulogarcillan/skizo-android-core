package com.tuppersoft.skizo.android.core.bases

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class StateLiveEvent<T> : MutableLiveData<T?>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<in T?>) {
        super.observe(owner, { t ->
            if (t != null) {
                observer.onChanged(t)
                postValue(null)
            }
        })
    }
}
