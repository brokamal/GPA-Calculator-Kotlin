package com.example.gpacalculator.Presenter

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
        }
        catch(e: Exception)
        {
            view.showError("Invalid Input")
        }
    }

    fun removeSubject() {
        model.removeSubject()
        view.showSubjects(model.getSubjects())
    }

    fun calculateGPA(){
        val gpa = model.calculateGPA()
        view.showGPA(gpa)
    }



}