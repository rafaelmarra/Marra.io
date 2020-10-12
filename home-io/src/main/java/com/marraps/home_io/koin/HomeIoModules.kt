package com.marraps.home_io.koin

import com.marraps.home_io.HomeRepository
import org.koin.dsl.module

val homeIoModule = module {
    factory { HomeRepository(get()) }
}