package com.example.borsaapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.borsaapp.R
import com.google.firebase.auth.FirebaseAuth

class PassUpdateActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_update)

        auth = FirebaseAuth.getInstance()

        val pass = findViewById<Button>(R.id.sifreYenile)

        pass.setOnClickListener {
            val newPass = findViewById<EditText>(R.id.editTextUpdatePass)
            val user = auth.currentUser
            val newPassword = newPass.text.toString()


            user?.updatePassword(newPassword)
                ?.addOnCompleteListener { task->
                    if (task.isSuccessful){
                        Toast.makeText(this,"Şifre değiştirme başarılı...",Toast.LENGTH_LONG).show()

                        val intent = Intent(this,KriptoActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"Şifre değiştirme başarsız...",Toast.LENGTH_LONG).show()
                    }

                }
        }
    }



}