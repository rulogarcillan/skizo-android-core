package com.tuppersoft.skizo.android.core.bases

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<E : ViewDataBinding>(private val layoutId: Int) : AppCompatActivity() {

    protected lateinit var binding: E

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
    }
}
