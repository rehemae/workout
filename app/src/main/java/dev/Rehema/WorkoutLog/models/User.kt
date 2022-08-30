package dev.Rehema.WorkoutLog.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("first_name") var firstName:String,
    @SerializedName("last_name")var lastName:String,
    @SerializedName("phone_number") var password:String,
    var email:String,
    @SerializedName("user_id")var userId:String

    )
