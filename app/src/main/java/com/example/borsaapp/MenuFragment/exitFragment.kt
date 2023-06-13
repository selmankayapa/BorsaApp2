package com.example.borsaapp.MenuFragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.borsaapp.Activity.KriptoActivity
import com.example.borsaapp.Activity.GirisActivity
import com.example.borsaapp.R
import com.google.firebase.auth.FirebaseAuth


class exitFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Çıkış ")
            .setMessage("Çıkış yapmak istediğinize emin misiniz ? ")
            .setIcon(R.drawable.exit)
            .setPositiveButton("EVET"){ dialog,which ->

                FirebaseAuth.getInstance().signOut()

                var intent = Intent(context, GirisActivity::class.java)
                startActivity(intent)

            }
            .setNegativeButton("HAYIR "){dialog,which ->
                var intent = Intent(context,KriptoActivity::class.java)
                startActivity(intent)

            }
        val alertDialog = builder.create()
        alertDialog.show()

        return inflater.inflate(R.layout.fragment_exit, container, false)
    }

}