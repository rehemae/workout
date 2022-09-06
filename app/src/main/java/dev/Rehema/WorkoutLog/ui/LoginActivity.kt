package dev.Rehema.WorkoutLog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.Rehema.WorkoutLog.ApiClient
import dev.Rehema.WorkoutLog.ApiInterface
import dev.Rehema.WorkoutLog.databinding.ActivityLoginBinding
import dev.Rehema.WorkoutLog.models.LoginRequest
import dev.Rehema.WorkoutLog.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
        binding.tvsignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            validateLogin()
        }
    }

    fun validateLogin() {
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        var error = false
        if (email.isBlank()) {
            error = true
            binding.tilEmail.error = "Email is required"
        }

        if (password.isBlank()) {
            error = true
            binding.tilPassword.error = "Password is required"
        }
        if (!error) {
            var loginRequest = LoginRequest(email, password)
            makeLoginRequest(loginRequest)
        }
    }

    fun makeLoginRequest(loginRequest: LoginRequest) {
        val apiclient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiclient.loginUser(loginRequest)

        request.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    Toast.makeText(baseContext, loginResponse?.message, Toast.LENGTH_LONG).show()
                    persistLoginDetails(loginResponse!!)
                    startActivity(Intent(baseContext, HomeActivity::class.java))
                } else {
                    val error = response.errorBody()?.string()
                    Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
                }
            }


            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

            }
        })
    }
    fun persistLoginDetails(loginResponse: LoginResponse){
        val editor=sharedPreferences.edit()
        editor.putString("USER_ID",loginResponse.userId)
        editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
        editor.putString("PROFILE_ID",loginResponse.profileId)
        editor.apply()

    }
}

