package com.tuppersoft.skizo.android.core.bases

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.tuppersoft.skizo.android.core.`typealias`.OnClickItem

abstract class BaseViewHolder<T : BaseItemData>(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(data: T, onClickListener: OnClickItem<T> = {})

    fun bindView(data: BaseItemData, onClickListener: OnClickItem<*> = {}) {
        this.bind(data as T, onClickListener as OnClickItem<T>)
    }
}




