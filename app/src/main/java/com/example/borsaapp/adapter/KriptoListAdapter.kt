package com.example.borsaapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.borsaapp.R
import com.example.borsaapp.model.kriptoListViewHolder
import com.example.borsaapp.model.kriptoModel

class kriptoListAdapter (val kriptoList: ArrayList<kriptoModel>):
    RecyclerView.Adapter<kriptoListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): kriptoListViewHolder {
        return kriptoListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.kripto_row_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return kriptoList.size
    }

    override fun onBindViewHolder(holder: kriptoListViewHolder, position: Int) {
        holder.binItems(kriptoList[position])
    }



}