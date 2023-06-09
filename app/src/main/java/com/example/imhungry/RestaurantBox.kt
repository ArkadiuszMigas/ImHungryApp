package com.example.imhungry

import android.app.Activity
import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels

class RestaurantBox : Fragment() {

    private lateinit var btn:Button
    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_restaurant_box, container, false)

        btn = view.findViewById(R.id.btnOrder)

        btn.setOnClickListener(View.OnClickListener {
            fun onClick(v:View){

            }
        })

        return view
    }

    fun onItemClicked(item: ClipData.Item) {

        viewModel.selectItem(item)
    }



    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RestaurantBox().apply {
            }
    }
}