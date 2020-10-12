package com.marraps.base

import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    fun replaceFragmentNoStack(container: View, fragment: BaseFragment) =
        supportFragmentManager
            .beginTransaction()
            .replace(container.id, fragment)
            .commit()

    fun replaceFragmentAddStack(container: View, fragment: BaseFragment) =
        supportFragmentManager
            .beginTransaction()
            .replace(container.id, fragment)
            .addToBackStack(null)
            .commit()
}