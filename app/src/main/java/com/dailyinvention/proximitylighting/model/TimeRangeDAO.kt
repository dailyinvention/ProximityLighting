package com.dailyinvention.proximitylighting.model

import androidx.room.*

@Dao
interface TimeRangeDAO {
    @Query("SELECT * FROM proximitylighting_time_range")
    suspend fun getTimeRanges(): List<TimeRange>

    @Query("SELECT * FROM proximitylighting_time_range WHERE id = :id")
    suspend fun getTimeRangeById(id: String): TimeRange

    @Delete
    suspend fun deleteTimeRange(timeRange: TimeRange)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateTimeRange(timeRange: TimeRange): String
}