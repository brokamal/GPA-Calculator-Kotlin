package com.example.gpacalculator.Presenter

import com.example.gpacalculator.Model.Course
import com.example.gpacalculator.Model.GPACalculator
import com.example.gpacalculator.View.MainView

class Mainpresenter(private val view: MainView, private val gpaCalculator: GPACalculator) {

    fun loadCourses(courses: List<Course>) {
        view.showCourse(courses)
        val gpa = gpaCalculator.calculateGpa(courses)
        view.showGpa(gpa)
    }

}