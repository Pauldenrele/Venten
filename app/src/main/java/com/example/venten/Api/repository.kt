package com.example.venten.Api

import com.example.venten.model.ventenModel
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class repository @Inject constructor(private val venApi: venApi):
    venRepository {
    override fun fetchDetails(): Call<List<ventenModel>> {
        return venApi.getDetails()
    }


}