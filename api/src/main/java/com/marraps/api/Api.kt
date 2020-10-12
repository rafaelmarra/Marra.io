package com.marraps.api

import com.marraps.models.affixes.Affixes
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("mythic-plus/affixes/{region}")
    suspend fun getAffixes(@Path("region") region: String): Affixes
}