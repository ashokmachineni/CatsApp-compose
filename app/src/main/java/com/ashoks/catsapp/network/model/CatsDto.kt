package com.ashoks.catsapp.network.model

import com.google.gson.annotations.SerializedName

data class CatsDto(

    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("temperament")
    val temperament: String?,

    @SerializedName("energy_level")
    val energy_level: Int,

    @SerializedName("wikipedia_url")
    val wikipedia_url: String?,

    @SerializedName("reference_image_id")
    val reference_image_id: String?
)