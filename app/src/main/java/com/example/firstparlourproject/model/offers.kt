package com.example.firstparlourproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class offers (
    @PrimaryKey
    val o_id:String,
    val o_img:String,
    val o_heading:String,
    val o_validationDate:String,
    val o_desc:String,
    val o_price:Double,
    val o_status:Char
)