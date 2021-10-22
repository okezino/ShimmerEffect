package com.example.shimmereffect.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shimmereffect.R
import com.example.shimmereffect.model.Result


class MainAdapter(private var list : List<Result>) : RecyclerView.Adapter<MainViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolderClass {
        return MainViewHolderClass.createView(parent)
    }

    override fun onBindViewHolder(holder: MainViewHolderClass, position: Int) {
        holder.onBind(result = list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }
}