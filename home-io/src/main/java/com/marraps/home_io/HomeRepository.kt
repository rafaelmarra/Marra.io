package com.marraps.home_io

import com.marraps.api.Api
import com.marraps.base.coroutines.AppContextProvider
import com.marraps.models.affixes.Affixes
import kotlinx.coroutines.withContext

class HomeRepository(private val api: Api) {

    suspend fun getAffixes(region: String): Affixes = withContext(AppContextProvider.io) {
        return@withContext api.getAffixes(region)
    }
}