package com.marraps.models.affixes

import com.google.gson.annotations.SerializedName

data class Affixes(

    @SerializedName("region")
    val region: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("affix_details")
    val affixDetailsList: List<AffixDetails>
)