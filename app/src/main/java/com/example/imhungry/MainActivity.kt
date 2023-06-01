package com.example.imhungry

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var btnSignUp: Button
    private lateinit var btnLogIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSignUp = findViewById(R.id.btnSignUp)
        btnLogIn = findViewById(R.id.btnLogIn)

        btnLogIn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LogIn::class.java);
            startActivity(intent)
        })

        btnSignUp.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SignUp::class.java);
            startActivity(intent)
        })

    }
}