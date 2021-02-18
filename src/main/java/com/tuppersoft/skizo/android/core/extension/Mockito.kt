package com.tuppersoft.skizo.android.core.extension

import org.mockito.Mockito

inline fun <reified T : Any> mock() = Mockito.mock(T::class.java)
