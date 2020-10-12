package com.marraps.utils

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

fun View.makeVisible(isVisible: Boolean = true) {
    visibility = if (isVisible) VISIBLE else GONE
}

fun View.toggleVisibility() {
    visibility = if (visibility == VISIBLE) GONE else VISIBLE
}

fun View.isVisible() = visibility == VISIBLE