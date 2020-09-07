package com.marraps.api.koin

import com.marraps.api.RetrofitService
import org.koin.dsl.module

val apiModules = module {
    single { RetrofitService.getService() }
}