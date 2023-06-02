package com.example.imhungry

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
        changeSite(HomePage())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> changeSite(HomePage())
                R.id.search -> changeSite(SearchPage())
                R.id.profile -> changeSite(ProfilePage())

                else ->{

                }
            }

            true
        }

    }

    private fun changeSite(fragment:Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}