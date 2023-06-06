package com.example.imhungry

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.imhungry.databinding.ActivityHomePageBinding
import com.example.imhungry.databinding.ActivityMainPageBinding
import com.example.imhungry.databinding.ActivityProfilePageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ProfilePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfilePageBinding

    private val db = Firebase.database
    private val dbRef = db.getReference("Users")
    private val auth = FirebaseAuth.getInstance().uid

    private lateinit var editNameX: EditText
    private lateinit var editLastNameX: EditText
    private lateinit var editAddressX: EditText
    private lateinit var editCityX: EditText
    private lateinit var editCodeX: EditText
    private lateinit var editPhoneX: EditText

    private lateinit var editName:String
    private lateinit var editLastName:String
    private lateinit var editAddress:String
    private lateinit var editCity:String
    private lateinit var editCode:String
    private lateinit var editPhone:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> changeSite(HomePageActivity())
                R.id.search -> changeSite(SearchPageActivity())
                R.id.profile -> changeSite(ProfilePageActivity())

            }

            true
        }

        editNameX = findViewById(R.id.EditName)
        editLastNameX = findViewById(R.id.EditLastName)
        editAddressX = findViewById(R.id.EditAdress)
        editCityX = findViewById(R.id.EditCity)
        editCodeX = findViewById(R.id.EditCode)
        editPhoneX = findViewById(R.id.EditPhone)
        var btnSave = findViewById<Button>(R.id.btnSaveProfile)

        btnSave.setOnClickListener(View.OnClickListener {
            editName = editNameX.getText().toString()
            editLastName = editLastNameX.getText().toString()
            editAddress = editAddressX.getText().toString()
            editCity = editCityX.getText().toString()
            editCode= editCodeX.getText().toString()
            editPhone = editPhoneX.getText().toString()
            addUser(auth.toString(), editName, editLastName, editAddress,editCity,editCode,editPhone)
        })

    }


    private fun addUser(uid:String, name:String, lastname:String, address:String,
                        city:String, code:String, phone:String){
        val user = User(uid, name, lastname, address, city, code, phone)

        dbRef.child(editName).setValue(user)
    }

    private fun changeSite(activity: Activity){
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}

data class User(val uid:String, val name:String, val lastname:String, val address:String,
                val city:String, val code:String, val phone:String)

