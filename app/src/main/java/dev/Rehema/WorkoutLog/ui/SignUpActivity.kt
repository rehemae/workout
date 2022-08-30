package dev.Rehema.WorkoutLog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import dev.Rehema.WorkoutLog.ApiClient
import dev.Rehema.WorkoutLog.ApiInterface
import dev.Rehema.WorkoutLog.databinding.ActivitySignUpBinding
import dev.Rehema.WorkoutLog.models.RegisterRequest
import dev.Rehema.WorkoutLog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvLogin.setOnClickListener {
             intent = Intent(this, HomeActivity::class.java)
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
        var phonenumber = binding.etPhoneNumber.text.toString()
        var error=false
        if (firstname.isBlank()) {
            error=true
            binding.tilFirstName.error = "First name is required"
        }
        if (secondname.isBlank()) {
            error=true
            binding.tilSecondName.error = "Second name is required"
        }
        if (password.isBlank()) {
            error=true
            binding.tilPassword.error = "Password is required"
        }
        if (confirm.isBlank()) {
            error=true
            binding.tilConfirm.error = "confirm"
        }
        if (email.isBlank()) {
            error=true
            binding.tilEmail.error = "Email is required"
        }
        if (phonenumber.isBlank()) {
            error=true
            binding.etPhoneNumber.error = "Phone number is required"
        }
        if (!password.equals(confirm)) {
            error=true
            binding.tilEmail.error = "email is invalid"
        }
        if (!error) {
            binding.pbregister.visibility= View.VISIBLE
            var registerRequest = RegisterRequest(firstname, secondname, email,phonenumber, password)
            makeRegistrationRequest(registerRequest)
        }
    }
    fun makeRegistrationRequest(registerRequest: RegisterRequest){
        var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=apiClient.registerUser(registerRequest)
        request.enqueue(object:Callback<RegisterResponse> {

            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>) {
                binding.pbregister.visibility=View.GONE

                if (response.isSuccessful){
                var massage = response.body()?.message
                Toast.makeText(baseContext, massage, Toast.LENGTH_LONG).show()
                startActivity(Intent(baseContext, LoginActivity::class.java))
            }
            else{
                var error=response.errorBody()?.string()
                    Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()

        }

            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

            }
        })



    }
}





















