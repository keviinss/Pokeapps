package com.example.pokeapps.Adapter

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Color.blue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapps.Common.Common
import com.example.pokeapps.Common.Common.getColorByType
import com.example.pokeapps.Interface.IItemClickListener
import com.example.pokeapps.R
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.chip_item.view.*
import kotlinx.android.synthetic.main.fragment_pokemon_detail.view.*

class PokemonTypeAdapter (internal var context: Context,internal var typeList: List<String>):
RecyclerView.Adapter<PokemonTypeAdapter.MyViewHolder>()
{
    inner class MyViewHolder (itemView:View):RecyclerView.ViewHolder(itemView) {
        internal var chip:Chip

        init {
            chip = itemView.findViewById(R.id.chip) as Chip
            chip.setOnClickListener  { Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show() }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.chip_item,parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.chip.chipText = typeList[position]
        //holder.chip.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.black))
        //holder.chip.setChipBackgroundColor(getColorByType(typeList[position]))
    }

    override fun getItemCount(): Int {
        return typeList.size
    }

}



