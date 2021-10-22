package com.example.shimmereffect.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shimmereffect.model.PokeResult
import com.example.shimmereffect.model.Resources
import com.example.shimmereffect.model.Status
import com.example.shimmereffect.utils.App
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val TAG = "mainViewModel"

    private val _pokemonList : MutableLiveData<Resources<PokeResult>> = MutableLiveData()
    val pokeResult : LiveData<Resources<PokeResult>>
        get() {
          return   _pokemonList
        }

    fun getPokemon(){
        _pokemonList.postValue(Resources.loading("loading"))

        viewModelScope.launch {
           val result = App.NetworkRepository.getAllPokemon()
            _pokemonList.postValue(result)
            Log.d(TAG,result.data.toString())
        }

    }





}