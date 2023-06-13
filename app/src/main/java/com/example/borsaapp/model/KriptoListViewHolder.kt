package com.example.borsaapp.model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.borsaapp.R

class kriptoListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){


    fun binItems(kriptoModel: kriptoModel){

        val kriptoName = itemView.findViewById<TextView>(R.id.kriptoName)
        val kriptoPrice = itemView.findViewById<TextView>(R.id.kriptoPrice)
        val kriptoImage = itemView.findViewById<ImageView>(R.id.kripto_image)

        kriptoName.text = kriptoModel.kriptoName
        kriptoPrice.text = kriptoModel.kriptoPrice
        kriptoImage.setImageResource(kriptoModel.kripto_image)

    }
}