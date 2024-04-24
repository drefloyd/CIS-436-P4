package com.example.cis_436_p4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CardioViewModel : ViewModel() {
    val loggedActivities = MutableLiveData<List<String>>()

    fun addLoggedActivity(activity: String) {
        val currentList = loggedActivities.value ?: emptyList()
        loggedActivities.value = currentList + activity
    }
}
