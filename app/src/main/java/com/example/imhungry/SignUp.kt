package com.example.imhungry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var confpass:TextInputEditText
    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        email = findViewById(R.id.login);
        password = findViewById(R.id.pasword);
        confpass = findViewById(R.id.repasword)
        btnSignUp = findViewById(R.id.btnSignUp)
        //Firebase
        firebaseAuth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener(View.OnClickListener {
            val mail = email.text.toString()
            val pass = password.text.toString()
            val confpassword = confpass.text.toString()

            if(mail.isNotEmpty() && pass.isNotEmpty() && confpassword.isNotEmpty()){
                if(pass.equals(confpassword)){

                    firebaseAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this, HomePage::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else{
                    Toast.makeText(this,"Password not matching", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this,"Wrong Input", Toast.LENGTH_SHORT).show()
            }
        })
    }
}