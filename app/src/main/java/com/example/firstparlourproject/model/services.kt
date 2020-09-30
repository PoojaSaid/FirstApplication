package com.example.firstparlourproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class services (
    @PrimaryKey
    val srv_id:String,
    val srv_img:String
)