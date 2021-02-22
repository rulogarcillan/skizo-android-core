package com.tuppersoft.skizo.android.core.bases

import androidx.recyclerview.widget.DiffUtil

abstract class BaseItemData {
    abstract val id: String
    fun areItemsTheSame(oldItem: BaseItemData) = this.id == oldItem.id
    fun areContentsTheSame(oldItem: BaseItemData) = this == oldItem
}

class BaseDiffUtils<T : BaseItemData> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = newItem.areItemsTheSame(oldItem)

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = newItem.areContentsTheSame(oldItem)
}
