package com.marraps.models.affixes

import com.google.gson.annotations.SerializedName

class AffixDetails(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String
)