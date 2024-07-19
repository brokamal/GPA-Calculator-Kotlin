package com.example.gpacalculator.Model

class GPACalculator {
    fun calculateGpa(courses: List<Course>): Double {
        var totalGradePoints = 0.0
        var totalCreditHours = 0.0

        for (course in courses) {
            totalGradePoints += course.grade * course.creditHours
            totalCreditHours += course.creditHours
        }

        return if (totalCreditHours == 0.0) 0.0 else totalGradePoints / totalCreditHours
    }
}