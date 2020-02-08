package com.example.venten.Api

import com.example.venten.model.ventenModel
import retrofit2.Call
import retrofit2.http.GET

interface venApi {
    @GET("/assessment/filter.json")
    fun getDetails() : Call<List<ventenModel>>

}