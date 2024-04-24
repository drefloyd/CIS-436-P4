package com.example.cis_436_p4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cis_436_p4.databinding.FragmentCardioBinding


class CardioFragment : Fragment() {

    private lateinit var binding: FragmentCardioBinding
    private lateinit var viewModel: CardioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardioBinding.inflate(inflater, container, false)
        val view = binding.root

        setupViews()
        setupListeners()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize and observe ViewModel
        viewModel = ViewModelProvider(requireActivity())[CardioViewModel::class.java]
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.loggedActivities.observe(viewLifecycleOwner) { activities ->
            displayLoggedActivities(activities)
        }
    }

    private fun displayLoggedActivities(activities: List<String>) {
        binding.llLoggedActivities.removeAllViews()
        activities.forEach { activity ->
            val loggedActivityTextView = TextView(context)
            loggedActivityTextView.text = activity
            binding.llLoggedActivities.addView(loggedActivityTextView)
        }
    }

    private fun setupViews() {
        val exercises = arrayOf("Jogging", "Jumping Jacks", "Burpees")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, exercises)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.exerciseSpinner.adapter = adapter
    }

    private fun setupListeners() {
        binding.btnLogActivity.setOnClickListener {
            logActivity()
        }

        binding.btnLowerHome.setOnClickListener {
            findNavController().navigate(R.id.action_cardioFragment_to_homeFragment)
        }
    }

    private fun logActivity() {
        val date = binding.etDate.text.toString()
        val exercise = binding.exerciseSpinner.selectedItem?.toString() ?: ""
        val weight = binding.etWeight.text.toString()
        val reps = binding.etReps.text.toString()
        val rating = "%.1f".format(binding.rbWorkoutRating.rating)

        if (date.isEmpty() || weight.isEmpty() || reps.isEmpty()) {
            binding.tvErrorMessage.text = "Please complete all fields before logging an activity"
        }else{
            // Add logged activity to ViewModel
            val loggedActivity = "• Date: $date,   Exercise: $exercise,   Weight: $weight,   Time: $reps,   Rating: $rating"
            viewModel.addLoggedActivity(loggedActivity)

            // Clear input fields and error field after logging
            binding.etDate.text.clear()
            binding.etWeight.text.clear()
            binding.etReps.text.clear()
            binding.tvErrorMessage.text = ""
        }
    }
}