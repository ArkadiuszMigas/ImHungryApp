package com.example.imhungry

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context:Activity, private val arrayList: ArrayList<Restaurants>) : ArrayAdapter<Restaurants>(context,
                R.layout.fragment_restaurant_box,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view:View = inflater.inflate(R.layout.fragment_restaurant_box,null)

        val imageView :ImageView = view.findViewById(R.id.Restaurant_Image)
        val name : TextView = view.findViewById(R.id.RestaurantName)
        val rate : TextView = view.findViewById(R.id.Rate)
        val time : TextView = view.findViewById(R.id.Time)

        imageView.setImageResource(arrayList[position].imageID)
        name.text = arrayList[position].name
        rate.text =arrayList[position].rate
        time.text = arrayList[position].time


        return view
    }

}