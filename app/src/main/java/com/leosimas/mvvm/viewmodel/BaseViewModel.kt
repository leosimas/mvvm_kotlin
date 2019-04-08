package com.leosimas.mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.leosimas.mvvm.viewmodel.bean.ViewState


open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val viewState = MutableLiveData<ViewState>()
    protected val toastMessage = MessageLiveData()

    fun getViewState(): LiveData<ViewState> {
        return viewState
    }

    fun getToastMessage() : LiveData<Int> {
        return toastMessage
    }

    protected fun setLoadingState() {
        setViewState(false, true)
    }

    protected fun setErrorState() {
        setViewState(true, false)
    }

    protected fun setNormalState() {
        setViewState(false, false)
    }

    private fun setViewState(isError: Boolean, isLoading: Boolean) {
        var value = viewState.value
        if (value == null) {
            value = ViewState()
        }

        value.isError = isError
        value.isLoading = isLoading
        viewState.value = value
    }

    protected fun isLoading(): Boolean {
        val value = viewState.value ?: return false

        return value.isLoading
    }

}