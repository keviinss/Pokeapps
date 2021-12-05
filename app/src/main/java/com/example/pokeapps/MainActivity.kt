package com.example.pokeapps

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.pokeapps.Common.Common
import kotlinx.android.synthetic.main.activity_main.*

//context: Context?, intent: Intent?

class MainActivity : AppCompatActivity() {

    //Create Broadcast handle
    private val showDetail = object:BroadcastReceiver() {
        override fun onReceive(p0: Context?, intent: Intent?) {
                if(intent!!.action!!.toString() == Common.KEY_ENABLE_HOME)
                {
                    supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                    supportActionBar!!.setDisplayShowHomeEnabled(true)

                    //Recplace Fragment
                    val detailFragment:PokemonDetail = PokemonDetail.getInstance()
                    val position:Int = intent.getIntExtra("position", -1)
                    val bundle = Bundle()
                    bundle.putInt("position", position)
                    detailFragment.arguments = bundle

                    //val fragmentTransaction:FragmentTransaction = supportFragmentManager.beginTransaction()
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.list_pokemon_fragment,detailFragment)
                    fragmentTransaction.addToBackStack("detail")

                    //Set Pokemon for Toolbar
                    val pokemon = Common.pokemonList[position]
                    toolbar.title = pokemon.name
                }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.setTitle("POKEMON LIST")
        setSupportActionBar(toolbar)

        //Register Broadcast
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(showDetail, IntentFilter(Common.KEY_ENABLE_HOME))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId)
        {
            android.R.id.home -> {
                toolbar.title = "POKEMON LIST"

                //Clear semua fragment dengan name 'detail'
                supportFragmentManager.popBackStack("detail",FragmentManager.POP_BACK_STACK_INCLUSIVE)

                supportActionBar!!.setDisplayShowHomeEnabled(false)
                supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            }
        }
        return true
    }
}