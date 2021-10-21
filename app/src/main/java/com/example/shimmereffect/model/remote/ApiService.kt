package com.example.shimmereffect.model.remote

import com.example.shimmereffect.model.PokeResult
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

@GET("pokemon")
suspend fun getPokemon() : Response<PokeResult>
}