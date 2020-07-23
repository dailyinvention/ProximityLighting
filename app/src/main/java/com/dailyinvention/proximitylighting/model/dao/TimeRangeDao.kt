package com.dailyinvention.proximitylighting.model.dao

import androidx.room.*
import com.dailyinvention.proximitylighting.model.entity.TimeRange

@Dao
interface TimeRangeDAO {
    @Query("SELECT * FROM time_range")
    suspend fun getTimeRanges(): List<TimeRange>

    @Query("SELECT * FROM time_range WHERE id = :id")
    suspend fun getTimeRangeById(id: String): TimeRange

    @Delete
    suspend fun deleteTimeRange(timeRange: TimeRange)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateTimeRange(timeRange: TimeRange)
}