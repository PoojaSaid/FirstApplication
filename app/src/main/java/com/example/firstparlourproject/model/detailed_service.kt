package com.example.firstparlourproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class detailed_service(
    @PrimaryKey
    val ds_id: String,
    val ds_srv_id: String,
    val ds_desc: String,
    val ds_price: Double,
    val ds_img: String
)
