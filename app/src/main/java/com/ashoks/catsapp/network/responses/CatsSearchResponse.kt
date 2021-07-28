package com.ashoks.catsapp.network.responses

import com.ashoks.catsapp.network.model.CatsDto
import com.google.gson.annotations.SerializedName

data class CatsSearchResponse(

/*    @SerializedName("count")
    var count: Int,*/

    @SerializedName("")
    var cats: List<CatsDto>,
)