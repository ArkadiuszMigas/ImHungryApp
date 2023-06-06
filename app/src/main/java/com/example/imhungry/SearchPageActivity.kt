package com.example.imhungry

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.imhungry.databinding.ActivityDishesPageBinding
import com.example.imhungry.databinding.ActivitySearchPageBinding

class SearchPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> changeSite(HomePageActivity())
                R.id.search -> changeSite(SearchPageActivity())
                R.id.profile -> changeSite(ProfilePageActivity())

            }

            true
        }

        val btnCart = findViewById<ImageButton>(R.id.btnCart)

        btnCart.setOnClickListener(View.OnClickListener {
            changeSite(CartPageActivity())
        })

    }

    private fun changeSite(activity: Activity){
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}