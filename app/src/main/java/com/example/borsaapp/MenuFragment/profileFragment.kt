package com.example.borsaapp.MenuFragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.borsaapp.Activity.GirisActivity
import com.example.borsaapp.Activity.KriptoActivity
import com.example.borsaapp.Activity.PassUpdateActivity
import com.example.borsaapp.R
import com.example.borsaapp.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class profileFragment : Fragment() {
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        // Şifre Güncelleme
        val passUpdate = view.findViewById<Button>(R.id.passChange)
        passUpdate.setOnClickListener {
            passUpdate(view)
        }
        //Kalıcı Hesap Silme
        val btndeleteAccount = view.findViewById<Button>(R.id.deleteAccount)
        btndeleteAccount.setOnClickListener {
            deleteAccount(view)
        }
        //Hisse Al Sat
        val BuySell = view.findViewById<Button>(R.id.hisseAlSat)
        BuySell.setOnClickListener {
            lot(view)
        }


        return view
    }

    private fun passUpdate(view: View) {
        val passUpdate = view.findViewById<Button>(R.id.passChange)

        passUpdate.setOnClickListener {
            val intent = Intent(requireContext(), PassUpdateActivity::class.java)
            startActivity(intent)
        }

    }

    private fun deleteAccount(view: View) {
        val delete = view.findViewById<Button>(R.id.deleteAccount)

        delete.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())

            builder.setTitle("HESAP SİLME ")
                .setMessage("HESABINIZI KALICI OLARAK SİLMEK İSTEDİĞİNİZE EMİN MİSİNİZ !!! ")
                .setIcon(R.drawable.baseline_delete_24)
                .setPositiveButton("EVET") { dialog, which ->
                    val user = auth.currentUser
                    if (user != null) {
                        user.delete().addOnCompleteListener { task ->

                            if (task.isSuccessful) {
                                Toast.makeText(
                                    requireContext(),
                                    "Hesap silindi!!!",
                                    Toast.LENGTH_LONG
                                ).show()
                            } else {
                                Toast.makeText(
                                    requireContext(), "Hesap silme başarısız oldu. ",
                                    Toast.LENGTH_LONG
                                ).show()

                            }
                        }
                    }


                    var intent = Intent(context, GirisActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("HAYIR ") { dialog, which ->
                    Toast.makeText(
                        requireContext(), "Bizi tercih etmeye devam ettiğiniz için TEŞEKKÜRLER.",
                        Toast.LENGTH_LONG
                    ).show()

                    var intent = Intent(context, KriptoActivity::class.java)
                    startActivity(intent)
                }

            val alertDialog = builder.create()
            alertDialog.show()
        }


    }

    private fun lot(view:View){

        val intent = Intent(requireContext(),KriptoActivity::class.java)
        startActivity(intent)
    }

}
