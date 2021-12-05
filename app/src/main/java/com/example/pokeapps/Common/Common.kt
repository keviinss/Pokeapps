package com.example.pokeapps.Common

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Color.parseColor
import com.example.pokeapps.Model.Pokemon

object Common {
    fun findPokemonByNum(num: String?): Pokemon? {
        //pokemon:Pokemon in Common.pokemonList
        for(pokemon in Common.pokemonList)
            if(pokemon.num.equals(num))
                return  pokemon
         return null
    }

    fun getColorByType(type: String): Int {
        when (type) {

            "Normal" -> return parseColor("#A4A27A")


            "Dragon" -> return parseColor("#743BFB")


            "Psychic" -> return parseColor("#F15B85")


            "Electric" -> return parseColor("#E9CA3C")


            "Ground" -> return parseColor("#D9BF6C")


            "Grass" -> return parseColor("#81C85B")

            "Poison" -> return parseColor("#A441A3")

            "Steel" -> return parseColor("#BAB7D2")


            "Fairy" -> return parseColor("#DDA2DF")


            "Fire" -> return parseColor("#F48130")


            "Fight" -> return parseColor("#BE3027")


            "Bug" -> return parseColor("#A8B822")


            "Ghost" -> return parseColor("#705693")


            "Dark" -> return parseColor("#745945")


            "Ice" -> return parseColor("#9BD8D8")


            "Water" -> return parseColor("#658FF1")
            else -> return parseColor("#658FA0")
        }
    }

    var pokemonList:List<Pokemon> = ArrayList()
    val KEY_ENABLE_HOME = "position"
}