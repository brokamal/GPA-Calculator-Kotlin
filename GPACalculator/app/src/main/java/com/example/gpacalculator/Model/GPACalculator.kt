package com.example.gpacalculator.Model

import android.util.Log


class GPACalculator {
    private val subjects = mutableListOf<Subject>()

    fun addSubject(subject: Subject) {
        subjects.add(subject)
    }

    fun removeSubject() {
        if (subjects.isNotEmpty()) {
            subjects.removeAt(subjects.size - 1)
        }
    }

    fun getSubjects(): List<Subject> {
        return subjects
    }

    fun calculateGPA(): Double {
        var totalCredits = 0
        var totalGradePoints = 0.0

        for (subject in subjects) {
            Log.d("GPA", "Calculating GPA for subject: ${subject.name}, Credits: ${subject.credits}, Grade: ${subject.grade}")
            totalCredits += subject.credits
            totalGradePoints += subject.credits * subject.grade
        }

        Log.d("GPA", "Total Credits: $totalCredits, Total Grade Points: $totalGradePoints")

        return if (totalCredits == 0) 0.0 else totalGradePoints / totalCredits
    }
}