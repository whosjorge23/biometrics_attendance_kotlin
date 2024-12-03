package com.example.biometricsattendance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in_page_screen)

        val etLoginEmail = findViewById<EditText>(R.id.etLoginEmail)
        val etLoginPassword = findViewById<EditText>(R.id.etLoginPassword)
        val tvLoginError = findViewById<TextView>(R.id.tvLoginError)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val email = etLoginEmail.text.toString()
            val password = etLoginPassword.text.toString()

            // Dummy authentication check
            if (email == "test@example.com" && password == "password") {
                tvLoginError.visibility = TextView.GONE
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                tvLoginError.text = "Invalid credentials"
                tvLoginError.visibility = TextView.VISIBLE
            }
        }
    }
}