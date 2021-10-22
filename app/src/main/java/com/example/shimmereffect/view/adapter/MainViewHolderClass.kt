package com.example.shimmereffect.view.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shimmereffect.R
import com.example.shimmereffect.model.Result
import com.example.shimmereffect.utils.getId
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView


class MainViewHolderClass(itemView : View) : RecyclerView.ViewHolder(itemView) {


    fun onBind(result : Result){
        val pokemonName : TextView = itemView.findViewById(R.id.pokemon_name)
        pokemonName.text = result.name



        val pokemonNum : TextView = itemView.findViewById(R.id.pokemon_num)
        pokemonNum.text = getId(result.url)

        val pokemonImage : CircleImageView = itemView.findViewById(R.id.circleImageView)
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${getId(result.url)}.png").into(pokemonImage)
    }

    companion object{
        fun createView(parent: ViewGroup) : MainViewHolderClass{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)

            return MainViewHolderClass(view)
        }
    }


}