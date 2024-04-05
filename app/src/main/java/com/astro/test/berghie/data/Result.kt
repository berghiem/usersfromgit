package com.astro.test.berghie.data

data class Result(val items : List<Item>)

data class Item(
    val id : Int,
    val login:String,
    val url:String,
    val avatar_url: String
)