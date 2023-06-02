package com.example.imhungry

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView

class HomePage : Fragment(R.layout.fragment_home_page) {

    private lateinit var adapter: MyAdapter
    private lateinit var restaurants: ArrayList<Restaurants>
    private lateinit var listview:ListView
    private lateinit var btnFav:ImageButton
    private lateinit var btnCart:ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home_page,container,false)
        adapter = MyAdapter(requireActivity(),restaurants)
        listview = view.findViewById(R.id.listview)
        listview.isClickable= true
        listview.adapter = adapter

        btnFav = view.findViewById(R.id.btnFavs)
        btnCart = view.findViewById(R.id.btnCart)


        btnCart.setOnClickListener(View.OnClickListener {
            changeSite((CartPage()))
            Log.d("TAG","Cart")
        })

        return view

    }
    private fun changeSite(fragment:Fragment){
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home_layout,fragment)
        fragmentTransaction.commit()
    }

    private fun order(view: View) {
        // Your code for handling the button click goes here
        changeSite(DishesPage())
        Log.d("TAG", "Order")
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePage().apply {

            }
    }
}