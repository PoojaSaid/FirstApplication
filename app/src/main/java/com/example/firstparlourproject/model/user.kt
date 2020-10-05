package com.example.firstparlourproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class user (
    @PrimaryKey(autoGenerate = true)
    val u_id: Int = -1,
    val u_name: String = "",
    val u_email:String = "",
    val u_phone:String = "",
    val u_password:String = "",
    val u_skin_type:String = "",
    val u_body_structure:String = "",
)