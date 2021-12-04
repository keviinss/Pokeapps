package com.example.pokeapps.Retrofit

import com.example.pokeapps.Model.Pokedex
import io.reactivex.Observable
import retrofit2.http.GET

interface IPokemonList {
    @get:GET("pokedex.json")
    val listPokemon:Observable<Pokedex>
}