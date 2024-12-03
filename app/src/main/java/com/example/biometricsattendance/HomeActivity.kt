package com.example.biometricsattendance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page_screen)

        val btnCheckIn = findViewById<Button>(R.id.btnCheckIn)
        val btnCheckOut = findViewById<Button>(R.id.btnCheckOut)
        val btnViewAttendance = findViewById<Button>(R.id.btnViewAttendance)

        btnCheckIn.setOnClickListener {
            val currentTime =
                java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault())
                    .format(java.util.Date())
            if (AttendanceListActivity.attendanceData.any { it.contains("Check-In: $currentTime") }) {
                Toast.makeText(this, "You have already checked in today", Toast.LENGTH_SHORT).show()
            } else {
                val currentDateTime =
                    java.text.SimpleDateFormat("yyyy-MM-dd HH:mm a", java.util.Locale.getDefault())
                        .format(java.util.Date())
                AttendanceListActivity.attendanceData.add("Check-In: $currentDateTime")
                Toast.makeText(this, "Check-In successful", Toast.LENGTH_SHORT).show()
            }
        }

        btnCheckOut.setOnClickListener {
            val currentTime =
                java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault())
                    .format(java.util.Date())
            if (AttendanceListActivity.attendanceData.any { it.contains("Check-Out: $currentTime") }) {
                Toast.makeText(this, "You have already checked out today", Toast.LENGTH_SHORT)
                    .show()
            } else if (!AttendanceListActivity.attendanceData.any { it.contains("Check-In: $currentTime") }) {
                Toast.makeText(this, "You must check in before checking out", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val currentDateTime =
                    java.text.SimpleDateFormat("yyyy-MM-dd HH:mm a", java.util.Locale.getDefault())
                        .format(java.util.Date())
                AttendanceListActivity.attendanceData.add("Check-Out: $currentDateTime")
                Toast.makeText(this, "Check-Out successful", Toast.LENGTH_SHORT).show()
            }
        }

        btnViewAttendance.setOnClickListener {
            val intent = Intent(this, AttendanceListActivity::class.java)
            startActivity(intent)
        }
    }
}