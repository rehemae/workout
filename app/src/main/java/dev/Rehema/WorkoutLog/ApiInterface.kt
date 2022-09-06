package dev.Rehema.WorkoutLog

import dev.Rehema.WorkoutLog.models.LoginRequest
import dev.Rehema.WorkoutLog.models.LoginResponse
import dev.Rehema.WorkoutLog.models.RegisterRequest
import dev.Rehema.WorkoutLog.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest):Call<RegisterResponse>
    @POST("/login")
    fun loginUser(@Body loginRequest: LoginRequest):Call<LoginResponse>



}