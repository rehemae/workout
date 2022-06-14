package dev.Rehema.WorkoutLog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var tilFirstName: TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var tilSecondName: TextInputLayout
    lateinit var etSecondName: TextInputEditText
    lateinit var tilConfirm: TextInputLayout
    lateinit var etConfirm: TextInputEditText
    lateinit var tilEmail: TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var tilPassword: TextInputLayout
    lateinit var etPassword: TextInputEditText
    lateinit var btnSignup: Button
    lateinit var tvLogin: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btnSignup = findViewById(R.id.btnSignup)
        tilEmail = findViewById(R.id.tilEmail)
        etEmail = findViewById(R.id.etEmail)
        tvLogin = findViewById(R.id.tvLogin)
        etFirstName = findViewById(R.id.etFirstName)
        tilFirstName = findViewById(R.id.tilFirstName)
        tilSecondName = findViewById(R.id.tilSecondName)
        etSecondName = findViewById(R.id.etSecondName)
        tilConfirm = findViewById(R.id.tilConfirm)
        etConfirm = findViewById(R.id.etConfirm)
        tilPassword = findViewById(R.id.tilPassword)
        etPassword = findViewById(R.id.etPassword)
//         intent=Intent(this,SignUpActivity::class.java)
//        startActivity(intent)
        tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btnSignup.setOnClickListener {
            validateSignUp()

        }


    }

    fun validateSignUp() {
        var firstname = etFirstName.text.toString()
        var secondname = etSecondName.text.toString()
        var password = etPassword.text.toString()
        var email = etEmail.text.toString()
        var confirm = etConfirm.text.toString()
        if (firstname.isBlank()) {
            tilFirstName.error = "Firstname is required"


        }
        if (secondname.isBlank()) {
            tilSecondName.error = "Secondname is required"
        }
        if (password.isBlank()) {
            tilPassword.error = "Password is required"
        }
        if (confirm.isBlank())
            tilConfirm.error = "confirm"


        if (email.isBlank()) {
            tilEmail.error = "Email is required"
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches())
            tilEmail.error = "email is invalid"

    }

}




















