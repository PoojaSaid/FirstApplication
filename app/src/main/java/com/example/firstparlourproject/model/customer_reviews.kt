package com.example.firstparlourproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class customer_reviews (

    val cr_u_id:String,
    @PrimaryKey
    val cr_id:String,
    val cr_review:String

)