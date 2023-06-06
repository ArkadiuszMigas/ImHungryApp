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
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.imhungry.databinding.ActivityHomePageBinding
import com.example.imhungry.databinding.ActivityMainPageBinding

class HomePageActivity : AppCompatActivity() {

    private lateinit var binding:ActivityHomePageBinding
    private lateinit var adapter: MyAdapter
    private lateinit var restaurants: ArrayList<Restaurants>
    private lateinit var listview: ListView
    private val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> changeSite(HomePageActivity())
                R.id.search -> changeSite(SearchPageActivity())
                R.id.profile -> changeSite(ProfilePageActivity())

            }

            true
        }

        val imageId = intArrayOf(
            R.drawable.pizza,
            R.drawable.pizza2,
            R.drawable.burger1,
            R.drawable.burger2,
            R.drawable.kebab,
        )
        val name = arrayOf(
            "Pizzeria 1",
            "Pizzeria 2",
            "Burger 1",
            "Burger 2",
            "Kebab"
        )
        val rate = arrayOf(
            "Rate: 4/5",
            "Rate: 4,5/5",
            "Rate: 4,8/5",
            "Rate: 3,9/5",
            "Rate: 4,3/5",
        )
        val time = arrayOf(
            "30-50min",
            "20-40min",
            "50-70min",
            "40-60min",
            "20-40min",
        )

        restaurants = arrayListOf()
        for(i in name.indices){
            val restaurant = Restaurants(name[i],rate[i],time[i],imageId[i])
            restaurants.add(restaurant)
        }

        adapter = MyAdapter(this,restaurants)
        listview = findViewById(R.id.listview)
        listview.isClickable= true
        listview.adapter = adapter

        val btnCart = findViewById<ImageButton>(R.id.btnCart)
        val btnOrder = findViewById<Button>(R.id.btnOrder)

        btnCart.setOnClickListener(View.OnClickListener {
            changeSite(CartPageActivity())
        })


        viewModel.selectedItem.observe(this, Observer { item->
            btnOrder.setOnClickListener(View.OnClickListener {
                onClick(binding.root)
            })
        })
    }

    fun onClick(v:View){
        changeSite(DishesPageActivity())
    }

    private fun changeSite(activity: Activity){
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }

}

class ItemViewModel : ViewModel() {
    private val mutableSelectedItem = MutableLiveData<ClipData.Item>()
    val selectedItem: LiveData<ClipData.Item> get() = mutableSelectedItem

    fun selectItem(item: ClipData.Item) {
        mutableSelectedItem.value = item
    }
}