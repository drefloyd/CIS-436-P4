package com.example.cis_436_p4

import androidx.lifecycle.ViewModel
class MainViewModel : ViewModel(){
    private var date = ""
    private var weight = ""
    private var exercise = ""
    private var reps = ""



    fun setWeight(weightInput: String){
        weight= weightInput
    }

    fun setDate(dateInput: String){
        date= dateInput
    }

    fun setExercise(exerciseInput: String){
        exercise = exerciseInput
    }

    fun setReps(repsInput: String){
        reps = repsInput
    }


    fun getDate(): String{
        return date
    }

    fun getWeight(): String{
        return weight
    }

    fun getExercise(): String{
        return exercise
    }

    fun getReps(): String{
        return reps
    }
}