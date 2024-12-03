package com.example.biometricsattendance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val tvEmailError = findViewById<TextView>(R.id.tvEmailError)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvEmailError.text = "Invalid email address"
                tvEmailError.visibility = TextView.VISIBLE
            } else {
                tvEmailError.visibility = TextView.GONE
                val intent = Intent(this, SetPasswordActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                startActivity(intent)
            }
        }
    }
}