package com.example.shimmereffect.repository

import com.example.shimmereffect.model.PokeResult
import com.example.shimmereffect.model.Resources
import com.example.shimmereffect.utils.App
import com.example.shimmereffect.model.remote.ApiService

class MainRepositoryImpl(private val apiHelper : ApiService) : MainRepository{
    override suspend fun getAllPokemon(): Resources<PokeResult> {
      try {
          val response = apiHelper.getPokemon()
          if(response.isSuccessful){
              response.body()?.let {
                  return Resources.success(it)
              }?: return Resources.failure("server error",null)

          }else {
              return Resources.failure("server error",null)
          }

      }catch (e : Exception){
          return Resources.failure("server error",null)
      }
    }
}