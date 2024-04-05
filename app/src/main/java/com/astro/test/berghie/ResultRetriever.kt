package com.astro.test.berghie

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.Callback
import com.astro.test.berghie.data.Result

class ResultRetriever {
    private val service : GithubService

    companion object{
        const val BASE_URL="https://api.github.com/"

    }
    init {
       val retrofit =Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
        service = retrofit.create(GithubService::class.java)
    }

    fun getResult(callback: Callback<Result>, keyword : String){
        val call = service.findUser(keyword)
        call.enqueue(callback)
    }

}