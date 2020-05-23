package com.dailyinvention.proximitylighting.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATABASE = "proximitylighting_time_range"

@Database(
    entities = [TimeRange::class],
    version = 1,
    exportSchema = false
)

abstract class TimeRangeDatabase : RoomDatabase() {
    abstract fun timeRangeModel(): TimeRangeDAO

    companion object {

        @Volatile
        private var instance: TimeRangeDatabase? = null

        fun getInstance(context: Context): TimeRangeDatabase {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): TimeRangeDatabase {
            return Room.databaseBuilder(context, TimeRangeDatabase::class.java, DATABASE)
                .build()
        }
    }
}