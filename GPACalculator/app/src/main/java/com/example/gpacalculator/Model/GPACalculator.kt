package com.example.gpacalculator.Model


class GPACalculator {
    private val subjects = mutableListOf<Subject>()

    fun addSubject(subject: Subject) {
        subjects.add(subject)
    }

    fun removeSubject(){
        if (subjects.isNotEmpty()) {
            subjects.removeAt(subjects.size - 1)

        }
    }

    fun calculateGPA(): Double {
        var totalCredits = 0
        var totalGradePoints = 0.0
        for (subject in subjects) {
            totalCredits += subject.credits
            totalGradePoints += subject.credits * subject.grade
        }
        return if (totalCredits == 0) 0.0 else totalGradePoints / totalCredits
    }

    fun getSubjects(): List<Subject> = subjects


}
