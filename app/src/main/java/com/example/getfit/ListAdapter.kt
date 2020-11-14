package com.example.getfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.single_card.view.*

class ListAdapter(val list: MutableList<String>): RecyclerView.Adapter<ListAdapter.ViewModel>() {

    class ViewModel(val card:View): RecyclerView.ViewHolder(card) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewModel {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.single_card,parent,false)
        return ViewModel(view)
    }

    override fun onBindViewHolder(holder: ViewModel, position: Int) {
        holder.card.textViewlapNo.text="Lap ${(position+1)}"
        holder.card.textViewlapTime.text=list[position].toString()

    }

    override fun getItemCount(): Int {
        return list.size
    }



}
