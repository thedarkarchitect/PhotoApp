package com.example.marsphotos.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPhoto(
    val id: String,
    @SerialName(value = "img_src")//is how the image source is named in the json
    val imgSrc : String//this is how we shall access the image source in the kotlin object
)