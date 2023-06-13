package com.example.borsaapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.borsaapp.R
import com.google.firebase.auth.FirebaseAuth

class GirisActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giris)
        //kayıt ol tuşu
        val signUp = findViewById<TextView>(R.id.textViewSignUp)
        signUp.setOnClickListener {
            val intent= Intent(this,kayitActivity::class.java)
            startActivity(intent)
            finish()
        }

        //firebase
        auth = FirebaseAuth.getInstance()

        //Şifree  Yenileme
        val btnResetPassword = findViewById<TextView>(R.id.textViewReseTPass)


        btnResetPassword.setOnClickListener {
            val intent = Intent(this,ResetPasswordActivity::class.java)
            startActivity(intent)
        }
    }
    fun girisYap(view: View){
        val email = findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()
        val password = findViewById<EditText>(R.id.editTextTextPassword).text.toString()


        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener{task ->
            val guncelKullanici = auth.currentUser?.email.toString()
            if(task.isSuccessful){
                Toast.makeText(this,"${guncelKullanici} EMAİL ADRESİ İLE GİRİŞ BAŞARILI.",Toast.LENGTH_LONG).show()
                val intent = Intent(this,KriptoActivity::class.java)
                startActivity(intent)
                finish()
            }

        }.addOnFailureListener{exceptions ->
            Toast.makeText(this,exceptions.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }

}