package com.example.gpacalculator.Presenter

import android.util.Log
import com.example.gpacalculator.Model.Subject
import com.example.gpacalculator.Model.GPACalculator
import com.example.gpacalculator.View.MainView

class Mainpresenter(private val view: MainView) {
    private val model = GPACalculator()

    fun addSubject(name: String, credits: String, grade: String) {
        try {
            val creditInt = credits.toInt()
            val gradeDouble = grade.toDouble()
            val subject = Subject(name, creditInt, gradeDouble)
            model.addSubject(subject)
            view.showSubjects(model.getSubjects())
            calculateGPA()  // Recalculate GPA after adding a subject
            Log.d("GPAPresenter", "Added subject: $name, $credits, $grade")
        } catch (e: Exception) {
            view.showError("Invalid input")
        }
    }

    fun removeSubject() {
        model.removeSubject()
        view.showSubjects(model.getSubjects())
        calculateGPA()  // Recalculate GPA after removing a subject
        Log.d("GPAPresenter", "Removed subject")
    }

    fun calculateGPA() {
        val gpa = model.calculateGPA()
        view.showGPA(gpa)
        Log.d("GPAPresenter", "Calculated GPA: $gpa")
    }
}



