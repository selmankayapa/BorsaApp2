package com.example.borsaapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.borsaapp.model.KriptoList
import com.example.borsaapp.R
import com.example.borsaapp.adapter.kriptoListAdapter
import com.example.borsaapp.databinding.ActivityKayitBinding
import com.example.borsaapp.databinding.ActivityKriptoBinding
import com.example.borsaapp.model.kriptoModel

class KriptoActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityKriptoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKriptoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController =Navigation.findNavController(this,R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(binding.altMenu,navController)

    }
}