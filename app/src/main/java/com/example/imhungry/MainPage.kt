package com.example.imhungry

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.imhungry.databinding.ActivityMainPageBinding

class MainPage : AppCompatActivity() {

    private lateinit var binding :ActivityMainPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeSite(HomePageActivity())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> changeSite(HomePageActivity())
                R.id.search -> changeSite(SearchPageActivity())
                R.id.profile -> changeSite(ProfilePageActivity())

                else ->{

                }
            }

            true
        }

    }

    private fun changeSite(activity: Activity){
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}