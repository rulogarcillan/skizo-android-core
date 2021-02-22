package com.tuppersoft.skizo.android.core.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseFragment<E : ViewBinding>(private val bindingClass: Class<E>) : Fragment() {

    private var _binding: E? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val method =
            bindingClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        _binding = method.invoke(null, layoutInflater, container, false) as E
        initObserversFlow()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected fun <T : Any, L : MutableStateFlow<T>> Fragment.observe(liveData: L, body: (T) -> Unit) =
        lifecycleScope.launch {
            liveData.collect {
                body(it)
            }
        }

    protected abstract fun initObserversFlow()
}


