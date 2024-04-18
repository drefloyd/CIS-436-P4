package com.example.cis_436_p4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        val upperButton = view.findViewById<Button>(R.id.btnUpperBody)
        upperButton.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_upperBodyFragment)
        }

        val lowerButton = view.findViewById<Button>(R.id.btnLowerBody)
        lowerButton.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_lowerBodyFragment)
        }

        val cardioButton = view.findViewById<Button>(R.id.btnCardio)
        cardioButton.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_cardioFragment)
        }

        return view
    }
}