package com.example.shimmereffect.repository

import com.example.shimmereffect.model.PokeResult
import com.example.shimmereffect.model.Resources
import retrofit2.Response

interface MainRepository {
    suspend fun  getAllPokemon() : Resources<PokeResult>
}