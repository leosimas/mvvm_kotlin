package com.leosimas.mvvm.extentions

import android.content.Context
import java.util.*
import android.text.format.DateUtils

fun Date.format(context : Context) : String {
    return DateUtils.formatDateTime(context, this.time, DateUtils.FORMAT_SHOW_DATE
                or DateUtils.FORMAT_NUMERIC_DATE
                or DateUtils.FORMAT_SHOW_YEAR
                or DateUtils.FORMAT_SHOW_WEEKDAY)
}