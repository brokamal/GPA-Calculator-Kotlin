package com.example.gpacalculator.View

import com.example.gpacalculator.Model.Course

interface MainView {
    fun showCourse(course: List<Course>)
    fun showGpa(gpa: Double)

}


