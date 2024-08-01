package com.example.gpacalculator.View

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gpacalculator.Model.Subject
import com.example.gpacalculator.Model.GPACalculator
import com.example.gpacalculator.Presenter.Mainpresenter
import com.example.gpacalculator.R
import android.widget.*

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presenter: Mainpresenter
    private lateinit var subjectsContainer: LinearLayout
    private lateinit var gpaResult: TextView
    private lateinit var addSubjectButton: Button
    private lateinit var calculateGPAButton: Button
    private lateinit var removeSubjectButton: Button
    private lateinit var gradeAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subjectsContainer = findViewById(R.id.subjects_container)
        gpaResult = findViewById(R.id.gpa_result)
        addSubjectButton = findViewById(R.id.add_subject_button)
        calculateGPAButton = findViewById(R.id.calculate_gpa_button)
        removeSubjectButton = findViewById(R.id.remove_subject_button)

        presenter = Mainpresenter(this)

        // Initialize spinner values
        val grades = arrayOf("Grade", "4.0", "3.5", "3.0", "2.5", "2.0", "1.0", "0.0")
        gradeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, grades)
        gradeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        findViewById<Spinner>(R.id.new_grade_spinner).adapter = gradeAdapter

        addSubjectButton.setOnClickListener {
            addSubject()
        }

        calculateGPAButton.setOnClickListener {
            presenter.calculateGPA()
        }

        removeSubjectButton.setOnClickListener {
            presenter.removeSubject()
        }
    }

    override fun showSubjects(subjects: List<Subject>) {
        subjectsContainer.removeAllViews()
        for (subject in subjects) {
            val view = layoutInflater.inflate(R.layout.item_course, subjectsContainer, false)
            view.findViewById<EditText>(R.id.subject_name).setText(subject.name)
            view.findViewById<EditText>(R.id.credits).setText(subject.credits.toString())
            view.findViewById<Spinner>(R.id.grade_spinner).adapter = gradeAdapter
            view.findViewById<Spinner>(R.id.grade_spinner).setSelection(getGradeIndex(subject.grade))
            subjectsContainer.addView(view)
        }
    }

    override fun showGPA(gpa: Double) {
        Log.d("MainActivity", "GPA updated: $gpa")
        gpaResult.text = "GPA: ${gpa.toFixed(2)}"
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun addSubject() {
        val name = findViewById<EditText>(R.id.new_subject_name).text.toString()
        val credits = findViewById<EditText>(R.id.new_credits).text.toString()
        val grade = findViewById<Spinner>(R.id.new_grade_spinner).selectedItem.toString()
        Log.d("MainActivity", "Adding subject: $name, $credits, $grade")
        presenter.addSubject(name, credits, grade)
    }

    private fun getGradeIndex(grade: Double): Int {
        return when (grade) {
            4.0 -> 1
            3.5 -> 2
            3.0 -> 3
            2.5 -> 4
            2.0 -> 5
            1.0 -> 6
            else -> 7
        }
    }
}

fun Double.toFixed(digits: Int) = "%.${digits}f".format(this)