package com.example.borsaapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.borsaapp.R
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        auth =FirebaseAuth.getInstance()
        auth.setLanguageCode("tr")

        val sifreYenile = findViewById<Button>(R.id.sifreYenile)
        val email = findViewById<EditText>(R.id.editTextUpdatePass)

        sifreYenile.setOnClickListener {
            val emailAdress = email.text.toString()

            auth.sendPasswordResetEmail(emailAdress)
                .addOnCompleteListener {
                    Toast.makeText(this,"\"ŞİFRE EMAİL ADRESİNE GÖNDERİLDİ...",Toast.LENGTH_LONG).show()
            }.addOnFailureListener{
                    Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
                }
        }
    }
}