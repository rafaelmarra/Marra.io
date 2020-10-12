package com.marraps.home_presentation.koin

import com.marraps.home_io.koin.homeIoModule
import com.marraps.home_presentation.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homePresentationModule = module {
    viewModel { HomeViewModel(get()) }
}

val homeModules = listOf(homePresentationModule, homeIoModule)