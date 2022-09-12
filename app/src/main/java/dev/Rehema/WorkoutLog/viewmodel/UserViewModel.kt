package dev.Rehema.WorkoutLog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.Rehema.WorkoutLog.models.LoginRequest
import dev.Rehema.WorkoutLog.models.LoginResponse
import dev.Rehema.WorkoutLog.models.RegisterRequest
import dev.Rehema.WorkoutLog.models.RegisterResponse
import dev.Rehema.WorkoutLog.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    val userRepository = UserRepository()
    val loginLiveData = MutableLiveData<LoginResponse>()
    val loginError = MutableLiveData<String>()
    val registerLiveData=MutableLiveData<RegisterResponse>()
    val registerError=MutableLiveData<String>()

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if (response.isSuccessful) {
                loginLiveData.postValue(response.body())
            } else {
                loginError.postValue(response.errorBody()?.string())
            }
        }
    }

    fun register(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response=userRepository.registerUser(registerRequest)
            if (response.isSuccessful){
                registerLiveData.postValue(response.body())
            }else{
                registerError.postValue(response.errorBody()?.string())

            }
        }
    }
}



