package com.example.imhungry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class LogIn : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var email:TextInputEditText
    private lateinit var password:TextInputEditText
    private lateinit var btnLogIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        email = findViewById<TextInputEditText>(R.id.login);
        password = findViewById<TextInputEditText>(R.id.pasword);
        btnLogIn = findViewById<Button>(R.id.btnLogIn)
        //Firebase
        firebaseAuth = FirebaseAuth.getInstance()

        btnLogIn.setOnClickListener(View.OnClickListener {
            val mail = email.text.toString()
            val pass = password.text.toString()

            if(mail.isNotEmpty() && pass.isNotEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this, MainPage::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else {
                Toast.makeText(this, "Password not matching", Toast.LENGTH_SHORT).show()
            }
        })
    }
}