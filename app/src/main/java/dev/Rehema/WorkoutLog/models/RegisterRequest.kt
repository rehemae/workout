package dev.Rehema.WorkoutLog.models

import com.google.gson.annotations.SerializedName


data class RegisterRequest(
    @SerializedName("first_name") var firstName: String,
    @SerializedName("last_name") var secondName: String,
    var email: String,
    @SerializedName("phone_number") var phoneNumber: String,
    var password: String,


    )
