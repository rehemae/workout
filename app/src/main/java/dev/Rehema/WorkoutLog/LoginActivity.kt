package dev.Rehema.WorkoutLog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var tvsignup: TextView
    lateinit var etEmail: TextInputEditText
    lateinit var etPassword: TextInputEditText
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        tilPassword = findViewById(R.id.tilPassword)
        tilEmail = findViewById(R.id.tilEmail)
        btnLogin = findViewById(R.id.btnLogin)
        tvsignup = findViewById(R.id.tvsignup)
        tvsignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            validateLogin()


        }
    }

    fun validateLogin() {
        var email = etEmail.text.toString()
        var password = etPassword.text.toString()
        if (email.isBlank()) {
            tilEmail.error = "Email is required"
        }
        if (password.isBlank()) {
            tilPassword.error = "Password is required"
        }
    }
}

