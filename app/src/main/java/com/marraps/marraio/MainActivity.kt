package com.marraps.marraio

import android.os.Bundle
import com.marraps.base.BaseActivity
import com.marraps.home_presentation.HomeFragment
import com.marraps.marraio.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    override val activityBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startHomeFragment()
    }

    private fun startHomeFragment() {
        replaceFragmentNoStack(activityBinding.mainRootContainer, HomeFragment())

    }

}