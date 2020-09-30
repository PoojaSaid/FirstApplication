package com.example.firstparlourproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class gallary_image (
    @PrimaryKey(autoGenerate = true)
    val gi_id:Int,
    val gi_name:String
)