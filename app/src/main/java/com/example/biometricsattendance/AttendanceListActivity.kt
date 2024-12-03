package com.example.biometricsattendance

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class AttendanceListActivity : AppCompatActivity() {
    companion object {
        val attendanceData = mutableListOf(
            "Check-In: 2024-12-01 09:00 AM",
            "Check-Out: 2024-12-01 05:00 PM",
            "Check-In: 2024-12-02 09:15 AM",
            "Check-Out: 2024-12-02 05:10 PM",
            "Check-In: 2024-12-03 08:45 AM"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.attendance_list_screen)

        val attendanceListView = findViewById<ListView>(R.id.lvAttendanceList)

        // Set adapter for ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, attendanceData)
        attendanceListView.adapter = adapter
    }
}