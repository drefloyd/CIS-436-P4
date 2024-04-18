package com.example.cis_436_p4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class LowerBodyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // to go from lower body to home
        val view = inflater.inflate(R.layout.fragment_lower_body, container, false)
        val goHomeButton = view.findViewById<Button>(R.id.btnLowerHome)
        goHomeButton.setOnClickListener{
            findNavController().navigate(R.id.action_lowerBodyFragment_to_homeFragment)
        }
        return view
    }
}