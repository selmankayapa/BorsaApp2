package com.example.borsaapp.model

import com.example.borsaapp.R

object KriptoList {


    fun getKriptoItemList() : List<kriptoModel>{

        val kriptoModel1 = kriptoModel(R.drawable.bitcoin,"BTC", "324687.21$")
        val kriptoModel2 = kriptoModel(R.drawable.eth,"ETH", "2400.84$")
        val kriptoModel3 = kriptoModel(R.drawable.bnb,"BNB", "1200.89$")
        val kriptoModel4 = kriptoModel(R.drawable.avax,"AVAX","152.52$")
        val kriptoModel5 = kriptoModel(R.drawable.solana,"SOL", "79.78$")
        val kriptoModel6 = kriptoModel(R.drawable.xrp,"XRP", "3.92$")
        val kriptoModel7 = kriptoModel(R.drawable.doge,"DOGE","1.23$")

        val kriptoList :ArrayList<kriptoModel> = ArrayList()

        kriptoList.add(kriptoModel1)
        kriptoList.add(kriptoModel2)
        kriptoList.add(kriptoModel3)
        kriptoList.add(kriptoModel4)
        kriptoList.add(kriptoModel5)
        kriptoList.add(kriptoModel6)
        kriptoList.add(kriptoModel7)

        return kriptoList
    }
}