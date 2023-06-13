package com.example.borsaapp.MenuFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.borsaapp.R
import com.example.borsaapp.adapter.kriptoListAdapter
import com.example.borsaapp.model.KriptoList
import com.example.borsaapp.model.kriptoModel

class homeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home,container,false)
        recyclerView = view.findViewById(R.id.recyclerView)

        //recyclerView
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        val adapter = kriptoListAdapter(KriptoList.getKriptoItemList() as ArrayList<kriptoModel>)
        recyclerView.adapter = adapter


        return view
    }

}
