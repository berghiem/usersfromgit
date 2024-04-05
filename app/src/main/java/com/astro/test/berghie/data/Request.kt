package com.astro.test.berghie.data

import com.google.gson.Gson
import java.net.URL

class Request {
    companion object{
        private const val URL = "https://api.github.com/search/users?q=Q"

    }

    fun run(): Result{
        val userListJsonStr = URL(URL).readText()
        return Gson().fromJson(userListJsonStr,Result::class.java)
    }
}