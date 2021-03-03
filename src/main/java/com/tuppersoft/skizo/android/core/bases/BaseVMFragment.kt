package com.tuppersoft.skizo.android.core.bases

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseVMFragment<E : ViewBinding, VM : BaseViewModel<T, S>, T : BaseData<S>, S : BaseState>(
    bindingClass: Class<E>
) : BaseFragment<E>(bindingClass) {

    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserversFlow()
        initObserveNavigate()
    }

    private fun initObserveNavigate() {
        navigate(viewModel.data.state, ::handleState)
    }

    protected fun <T : Any, L : MutableStateFlow<T>> Fragment.observe(stateflow: L, body: (T) -> Unit) =
        lifecycleScope.launch {
            stateflow.collect {
                body(it)
            }
        }

    protected fun <T : BaseState, L : MutableStateFlow<T>> Fragment.navigate(stateflow: L, body: (T) -> Unit) =
        lifecycleScope.launch {
            stateflow.collect {
                body(it)
            }
        }

    protected abstract fun initObserversFlow()
    protected abstract fun handleState(value: S)
}
