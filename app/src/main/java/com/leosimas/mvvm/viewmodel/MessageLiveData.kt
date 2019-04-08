package com.leosimas.mvvm.viewmodel

import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer


class MessageLiveData : SingleLiveEvent<Int>() {

    fun observe(owner: LifecycleOwner, observer: MessageObserver) {
        super.observe(owner, Observer { t ->
            if (t == null) {
                return@Observer
            }
            observer.onNewMessage(t)
        })
    }

    interface MessageObserver {
        /**
         * Called when there is a new message to be shown.
         * @param resString The new message, non-null.
         */
        fun onNewMessage(@StringRes resString: Int)
    }

}