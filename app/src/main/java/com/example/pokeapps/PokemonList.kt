package com.example.pokeapps

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapps.Common.Common
import com.example.pokeapps.Common.ItemOffsetDecoration
import com.example.pokeapps.Retrofit.IPokemonList
import com.example.pokeapps.Retrofit.RetrofitClient
import com.example.pokeapps.Adapter.PokemonListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PokemonList : Fragment() {

    internal var compositeDisposable = CompositeDisposable()
    internal var iPokemonList:IPokemonList

    internal lateinit var recycler_View:RecyclerView

    init {
        val retrofit = RetrofitClient.instances
        iPokemonList = retrofit.create(IPokemonList::class.java)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val itemView = inflater.inflate(R.layout.fragment_pokemon_list, container, false)


        recycler_View = itemView.findViewById(R.id.pokemon_recyclerview) as RecyclerView
        recycler_View.setHasFixedSize(true)
        recycler_View.layoutManager = GridLayoutManager(activity,2)
        val itemDecoration = ItemOffsetDecoration(activity!!,R.dimen.spacing)
        recycler_View.addItemDecoration(itemDecoration)

        fetchData();

        return itemView
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun fetchData() {
        compositeDisposable.add(iPokemonList.listPokemon
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { pokemonDex ->
                Common.pokemonList = pokemonDex.pokemon!!
                val adapter = PokemonListAdapter(activity!!,Common.pokemonList)

                recycler_View.adapter = adapter
            }
        );

    }
}