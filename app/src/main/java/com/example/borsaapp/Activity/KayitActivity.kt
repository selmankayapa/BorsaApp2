package com.example.borsaapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.borsaapp.R
import com.google.firebase.auth.FirebaseAuth

class kayitActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kayit)
        
        auth = FirebaseAuth.getInstance()
    }

    fun kayıtOl(view: View){
        val email = findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()
        val password = findViewById<EditText>(R.id.editTextTextPassword).text.toString()

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{

            val intent = Intent(this,KriptoActivity::class.java)
            startActivity(intent)
            finish()
        }.addOnFailureListener{
            Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
        }


    }
}

