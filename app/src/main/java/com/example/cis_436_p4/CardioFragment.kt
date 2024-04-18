package com.example.cis_436_p4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class CardioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // to go from cardio to home
        val view = inflater.inflate(R.layout.fragment_cardio, container, false)
        val goHomeButton = view.findViewById<Button>(R.id.btnCardioHome)
        goHomeButton.setOnClickListener{
            findNavController().navigate(R.id.action_cardioFragment_to_homeFragment)
        }
        return view
    }
}