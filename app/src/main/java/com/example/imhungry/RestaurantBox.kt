package com.example.imhungry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class RestaurantBox : Fragment() {

    private lateinit var btn:Button

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
            btnClick(view)
        })

        return view
    }

    fun btnClick(view: View?){
        changeSite(DishesPage())
    }

    private fun changeSite(fragment:Fragment){
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home_layout,fragment)
        fragmentTransaction.commit()
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RestaurantBox().apply {
            }
    }
}