package com.guilherme.arsampleapplication.models

import java.io.Serializable

data class ObjAR(
    val cod: String,
    val name: String,
    val description: String,
    val images: List<String>
) : Serializable {
    constructor() : this(
    "",
    "",
    "",
    emptyList()
    )
}