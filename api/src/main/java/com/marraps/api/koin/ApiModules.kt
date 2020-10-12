package com.marraps.api.koin

import com.marraps.api.RetrofitService
import org.koin.dsl.module

val apiModule = module {
    single { RetrofitService.getService() }
}

val apiModules = listOf(apiModule)