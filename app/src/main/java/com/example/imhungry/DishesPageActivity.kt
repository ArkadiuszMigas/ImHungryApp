package com.example.imhungry

import android.app.Activity
import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.get
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.imhungry.databinding.ActivityDishesPageBinding
import com.example.imhungry.databinding.ActivityHomePageBinding

class DishesPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDishesPageBinding
    private lateinit var adapter: DishesAdapter
    private lateinit var dishes: ArrayList<Dishes>
    private lateinit var listview: ListView
    private val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDishesPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        val imageId = intArrayOf(
            R.drawable.margo,
            R.drawable.salami,
            R.drawable.capri,
            R.drawable.diavola,
            R.drawable.parma,
        )
        val name = arrayOf(
            "Margherita",
            "Salami",
            "Capri",
            "Diavola",
            "Parma"
        )
        val ingredient = arrayOf(
            "tomato sauce, cheese",
            "tomato sauce, cheese, salami",
            "tomato sauce, cheese, ham, mushrooms",
            "tomato sauce, cheese. salami picante, jalapeno",
            "tomato sauce, cheese, prosciutto crudo, rucola",
        )
        val price = arrayOf(
            "28zł",
            "30zł",
            "32zł",
            "35zł",
            "38zł",
        )

        dishes = arrayListOf()
        for(i in name.indices){
            val dish = Dishes(name[i], ingredient[i],price[i],imageId[i])
            dishes.add(dish)
        }

        adapter = DishesAdapter(this,dishes)
        listview = findViewById(R.id.listview)
        listview.isClickable= true
        listview.adapter = adapter

        val btnCart = findViewById<ImageButton>(R.id.btnCart)
        val btnAdd = findViewById<Button>(R.id.btnAddToCart)

        btnCart.setOnClickListener(View.OnClickListener {
            changeSite(CartPageActivity())
        })

        viewModel.selectedItem.observe(this, Observer { item->
            btnAdd.setOnClickListener(View.OnClickListener {
                onClick(binding.root)
            })
        })
    }

    fun onClick(v:View){
        changeSite(CartPageActivity())
    }

    private fun changeSite(activity: Activity){
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}
