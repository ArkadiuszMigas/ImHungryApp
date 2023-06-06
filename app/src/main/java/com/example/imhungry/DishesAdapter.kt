package com.example.imhungry

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class DishesAdapter (private val context: Activity, private val arrayList: ArrayList<Dishes>) : ArrayAdapter<Dishes>(context,
    R.layout.fragment_dishes_box,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.fragment_dishes_box,null)

        val imageView : ImageView = view.findViewById(R.id.Dish_Image)
        val name : TextView = view.findViewById(R.id.DishName)
        val ingredients : TextView = view.findViewById(R.id.Ingredients)
        val price : TextView = view.findViewById(R.id.Price)

        imageView.setImageResource(arrayList[position].imageID)
        name.text = arrayList[position].name
        ingredients.text =arrayList[position].ingredience
        price.text = arrayList[position].price


        return view
    }

}