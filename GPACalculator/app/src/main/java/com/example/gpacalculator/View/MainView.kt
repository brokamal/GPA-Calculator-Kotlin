package com.example.gpacalculator.View

import com.example.gpacalculator.Model.Subject

interface MainView {

    fun showSubjects(subjects: List<Subject>)
    fun showGPA(gpa: Double)

    fun showError(message: String)

}


