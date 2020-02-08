package com.example.venten.model


import com.google.gson.annotations.SerializedName

data class ventenModel(
    val colors: List<Any>,
    val countries: List<String>,
    @SerializedName("end_year")
    val endYear: Int,
    val gender: String,
    val id: Int,
    @SerializedName("start_year")
    val startYear: Int
)