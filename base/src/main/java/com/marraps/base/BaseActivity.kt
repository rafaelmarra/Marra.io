package com.marraps.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity : AppCompatActivity() {

    abstract val activityBinding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityBinding.root)
    }

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