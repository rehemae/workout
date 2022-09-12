package dev.Rehema.WorkoutLog.repository

import dev.Rehema.WorkoutLog.api.ApiClient
import dev.Rehema.WorkoutLog.api.ApiInterface
import dev.Rehema.WorkoutLog.models.LoginRequest
import dev.Rehema.WorkoutLog.models.LoginResponse
import dev.Rehema.WorkoutLog.models.RegisterRequest
import dev.Rehema.WorkoutLog.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest:LoginRequest):
            Response<LoginResponse> = withContext(Dispatchers.IO) {
            var response = apiClient.loginUser(loginRequest)
            return@withContext response
        }
    suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse> =
        withContext(Dispatchers.IO) {
        var response = apiClient.registerUser(registerRequest)
        return@withContext response
    }


}



