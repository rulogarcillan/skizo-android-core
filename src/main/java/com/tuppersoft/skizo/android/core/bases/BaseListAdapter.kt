package com.tuppersoft.skizo.android.core.bases

import androidx.recyclerview.widget.ListAdapter
import com.tuppersoft.skizo.android.core.`typealias`.OnClickItem

abstract class BaseListAdapter : ListAdapter<BaseItemData, BaseViewHolder<*>>(BaseDiffUtils()) {

    private var clickListener: OnClickItem<*> = {}

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        holder.bindView(getItem(position), clickListener)
    }

    @JvmName("setOnClickListenerAbstract")
    fun <T : BaseItemData> setOnClickListener(onClickListener: OnClickItem<T>) {
        this.clickListener = onClickListener
    }

    fun setOnClickListener(onClickListener: OnClickItem<BaseItemData>) {
        this.clickListener = onClickListener
    }
}
