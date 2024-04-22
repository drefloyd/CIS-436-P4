package com.example.cis_436_p4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.cis_436_p4.databinding.FragmentLowerBodyBinding

class LowerBodyFragment : Fragment() {

    private lateinit var binding: FragmentLowerBodyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLowerBodyBinding.inflate(inflater, container, false)
        val view = binding.root

        setupViews()
        setupListeners()

        return view
    }

    private fun setupViews() {
        val exercises = arrayOf("Squats into Jumps", "Calf Raises", "Lunges")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, exercises)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.exerciseSpinner.adapter = adapter
    }

    private fun setupListeners() {
        binding.btnLogActivity.setOnClickListener {
            logActivity()
        }

        binding.btnLowerHome.setOnClickListener {
            findNavController().navigate(R.id.action_lowerBodyFragment_to_homeFragment)
        }
    }
    private fun logActivity() {
        val date = binding.etDate.text.toString()
        val exercise = binding.exerciseSpinner.selectedItem?.toString() ?: ""
        val weight = binding.etWeight.text.toString()
        val reps = binding.etReps.text.toString()

        // Create a new TextView to display the logged activity
        val loggedActivityTextView = TextView(context)
        loggedActivityTextView.text = "Date: $date, Exercise: $exercise, Weight: $weight, Reps: $reps"

        // Add the TextView to the LinearLayout inside ScrollView
        binding.llLoggedActivities.addView(loggedActivityTextView)

        // Clear input fields after logging
        binding.etDate.text.clear()
        binding.etWeight.text.clear()
        binding.etReps.text.clear()
    }
}