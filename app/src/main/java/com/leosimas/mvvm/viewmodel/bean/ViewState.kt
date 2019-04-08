package com.leosimas.mvvm.viewmodel.bean

class ViewState {

    var isLoading: Boolean = false
    var isError: Boolean = false

    override fun toString(): String {
        return "ViewState{" +
                "loading=" + isLoading +
                ", error=" + isError +
                '}'.toString()
    }
}