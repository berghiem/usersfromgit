package com.astro.test.berghie

import com.astro.test.berghie.data.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// val url = "https://api.github.com/search/users?q=Q"
//
interface GithubService {
    @GET("/users")
    fun getUsers(): Call<Result>

    @GET("/search/users")
    fun findUser(@Query("q") q:String,@Query("per_page") p:Int) : Call<Result>
}