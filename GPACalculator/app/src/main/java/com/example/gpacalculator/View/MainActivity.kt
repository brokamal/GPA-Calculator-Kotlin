package com.example.gpacalculator.View

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gpacalculator.Model.Course
import com.example.gpacalculator.Model.GPACalculator
import com.example.gpacalculator.Presenter.Mainpresenter
import com.example.gpacalculator.R

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presenter: Mainpresenter
    private lateinit var recyclerView: RecyclerView
    private lateinit var gpaTextView: TextView
    private lateinit var adapter: CourseAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        gpaTextView = findViewById(R.id.gpaTextView)


        adapter = CourseAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        presenter = Mainpresenter(this, GPACalculator())

        // Example data
        val courses = listOf(
            Course("Math", 4.0, 3.0),
            Course("Science", 3.7, 4.0),
            Course("History", 3.3, 3.0)
        )

        presenter.loadCourses(courses)
    }

    override fun showCourse(course: List<Course>) {
        adapter.setCourses(course)


    }

    override fun showGpa(gpa: Double) {
        gpaTextView.text = "GPA: %.2f".format(gpa)
    }
}