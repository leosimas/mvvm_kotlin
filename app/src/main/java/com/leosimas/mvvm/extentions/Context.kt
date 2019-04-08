package com.leosimas.mvvm.extentions

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showKeyboard(editText: EditText) {
    editText.requestFocus()
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
}

fun Context.hideKeyboard(editText: EditText) {
    editText.clearFocus()
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(editText.windowToken, 0)
}

private var Context.toast : Toast?
    get() = null
    set(value) { toast = value }

fun Context.showToastShort(@StringRes stringId: Int) {
    this.cancelToast()
    toast = Toast.makeText(this, stringId, Toast.LENGTH_SHORT)
    toast!!.show()
}

private fun Context.cancelToast() {
    if (toast != null) {
        toast!!.cancel()
        toast = null
    }
}