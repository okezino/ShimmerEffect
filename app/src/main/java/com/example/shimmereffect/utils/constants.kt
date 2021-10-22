package com.example.shimmereffect.utils

const val BASE_URL = "https://pokeapi.co/api/v2/"
fun getId(url : String) : String{
    return url.substring(34 until url.lastIndex)
}