package com.tuppersoft.skizo.android.core.extension

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> ViewGroup.inflateDataBinding(
    crossinline block: (inflater: LayoutInflater, container: ViewGroup, attach: Boolean) -> T,
    attachToRoot: Boolean = false
) = block(LayoutInflater.from(this.context), this, attachToRoot)

