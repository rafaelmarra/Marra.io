package com.marraps.base

import androidx.lifecycle.ViewModel
import com.marraps.base.coroutines.AppContextProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext by lazy { job + AppContextProvider.io }

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }
}