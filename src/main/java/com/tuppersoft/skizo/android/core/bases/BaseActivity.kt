package com.tuppersoft.skizo.android.core.bases

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<E : ViewBinding>(private val bindingClass: Class<E>) : AppCompatActivity() {

    protected lateinit var binding: E

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val method = bindingClass.getMethod("inflate", LayoutInflater::class.java)
        binding = method.invoke(null, layoutInflater) as E
        setContentView(binding.root)
    }
}

