package com.marraps.marraio

import android.os.Bundle
import com.marraps.base.BaseActivity
import com.marraps.home_presentation.HomeFragment
import com.marraps.marraio.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startHomeFragment()
    }

    private fun startHomeFragment() {
        replaceFragmentNoStack(binding.mainRootContainer, HomeFragment())
    }
}