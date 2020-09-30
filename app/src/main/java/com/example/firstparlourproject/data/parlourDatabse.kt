package com.example.firstparlourproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.firstparlourproject.model.*


@Database(
    entities = [user::class, customer_reviews::class, detailed_service::class, gallary_image::class, offers::class, services::class],
    version = 1,
    exportSchema = false
)
abstract class parlourDatabse : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: parlourDatabse? = null

        fun getDatabase(context: Context): parlourDatabse {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    parlourDatabse::class.java,
                    "parlour_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }

}