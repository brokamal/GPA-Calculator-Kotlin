package com.example.gpacalculator.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gpacalculator.Model.Course
import com.example.gpacalculator.R

class CourseAdapter: RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    private var courses = listOf<Course>()

    fun setCourses(courses: List<Course>) {
        this.courses = courses

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(courses[position])
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.courseNameTextView)
        private val gradeTextView: TextView = itemView.findViewById(R.id.courseGradeTextView)
        private val creditHoursTextView: TextView = itemView.findViewById(R.id.courseCreditHoursTextView)

        fun bind(course: Course) {
            nameTextView.text = course.name
            gradeTextView.text = "Grade: ${course.grade}"
            creditHoursTextView.text = "Credit Hours: ${course.creditHours}"
        }
    }
}