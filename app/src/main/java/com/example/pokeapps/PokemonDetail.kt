package com.example.pokeapps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PokemonDetail : Fragment() {

    companion object {
        internal var instances:PokemonDetail?=null

        fun getInstance():PokemonDetail{
            if(instances == null)
                instances = PokemonDetail()
            return instances!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val itemView = inflater.inflate(R.layout.fragment_pokemon_detail, container, false)

        return itemView
    }

}