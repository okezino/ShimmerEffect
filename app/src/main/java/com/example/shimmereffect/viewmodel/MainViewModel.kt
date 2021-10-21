package com.example.shimmereffect.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shimmereffect.model.PokeResult
import com.example.shimmereffect.utils.App
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _pokemonList : MutableLiveData<PokeResult> = MutableLiveData()
    val pokeResult : LiveData<PokeResult>
        get() {
          return   _pokemonList
        }

    fun getPokemon(){

        viewModelScope.launch {
           var result = App.NetworkRepository.getAllPokemon()

        }

    }





}