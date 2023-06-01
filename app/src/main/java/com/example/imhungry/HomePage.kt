package com.example.imhungry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomePage.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomePage : Fragment() {

    private lateinit var adapter: MyAdapter
    private lateinit var restaurants: ArrayList<Restaurants>
    private lateinit var listview:ListView

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
        listview.adapter = adapter

        return view

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}