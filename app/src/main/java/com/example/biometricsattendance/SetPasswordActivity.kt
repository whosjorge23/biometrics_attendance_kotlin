package com.example.biometricsattendance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class SetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_password_screen)

        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val tvPasswordError = findViewById<TextView>(R.id.tvPasswordError)
        val btnSignup = findViewById<Button>(R.id.btnSignup)

        btnSignup.setOnClickListener {
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (password != confirmPassword || password.isEmpty()) {
                tvPasswordError.text = "Passwords do not match or are empty"
                tvPasswordError.visibility = TextView.VISIBLE
            } else {
                tvPasswordError.visibility = TextView.GONE
                // Save to database (dummy action)
                Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
            }
        }
    }
}