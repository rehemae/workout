package dev.Rehema.WorkoutLog.api

import dev.Rehema.WorkoutLog.models.LoginRequest
import dev.Rehema.WorkoutLog.models.LoginResponse
import dev.Rehema.WorkoutLog.models.RegisterRequest
import dev.Rehema.WorkoutLog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>
    @POST("/login")
   suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>



}