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
import dev.Rehema.WorkoutLog.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener {
            validateSignUp()
        }
    }
    fun validateSignUp() {
        var firstname = binding.etFirstName.text.toString()
        var secondname = binding.etSecondName.text.toString()
        var password = binding.etPassword.text.toString()
        var email = binding.etEmail.text.toString()
        var confirm = binding.etConfirm.text.toString()
        if (firstname.isBlank()) {
            binding.tilFirstName.error = "Firstname is required"
        }
        if (secondname.isBlank()) {
            binding.tilSecondName.error = "Secondname is required"
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
        }
        if (confirm.isBlank())
            binding.tilConfirm.error = "confirm"
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches())
            binding.tilEmail.error = "email is invalid"
    }
}




















