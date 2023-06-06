package com.example.imhungry

import android.content.ClipData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels


class DishesBox : Fragment() {

    private val viewModel: ItemViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dishes_box, container, false)

        val btnAdd = view.findViewById<Button>(R.id.btnAddToCart)

        btnAdd.setOnClickListener(View.OnClickListener {
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
            DishesBox().apply {

            }
    }
}