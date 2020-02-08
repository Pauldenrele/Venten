package com.example.venten.Api

import com.example.venten.model.ventenModel
import retrofit2.Call

interface venRepository {
    fun fetchDetails(): Call<List<ventenModel>>

}