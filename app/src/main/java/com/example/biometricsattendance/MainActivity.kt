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
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val registeredEmails = mutableSetOf("admin@email.com", "user@example.com")

        btnNext.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(this, "Name is required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvEmailError.text = "Invalid email address"
                tvEmailError.visibility = TextView.VISIBLE
                return@setOnClickListener
            } else if (registeredEmails.contains(email)) {
                tvEmailError.text = "Email is already registered"
                tvEmailError.visibility = TextView.VISIBLE
                return@setOnClickListener
            } else {
                tvEmailError.visibility = TextView.GONE
                registeredEmails.add(email) // Register new email
                val intent = Intent(this, SetPasswordActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                startActivity(intent)
            }
        }
        btnLogin.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}