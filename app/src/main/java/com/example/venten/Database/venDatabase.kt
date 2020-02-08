package com.example.venten.Database

import com.example.venten.Api.venApi
import com.example.venten.BuildConfig
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class venDatabase {

    fun provideDatabase(): venApi {
        val gson = GsonBuilder().setLenient().create()
        val builder = Retrofit.Builder()
            .baseUrl("https://ven10.co/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addConverterFactory(ScalarsConverterFactory.create())


        //setup logging interceptor

         val loggingInterceptor = HttpLoggingInterceptor();
         loggingInterceptor.level = if(BuildConfig.DEBUG){
               HttpLoggingInterceptor.Level.BODY
         }else{
             HttpLoggingInterceptor.Level.NONE
         }

        // setup httpclient
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            //.addInterceptor(connectionInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()

        val retrofit = builder
            .client(httpClient)
            .build()
        return retrofit.create(venApi::class.java)


    }
}