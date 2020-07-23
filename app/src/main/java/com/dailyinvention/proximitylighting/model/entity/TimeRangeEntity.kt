package com.dailyinvention.proximitylighting.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "time_range")
data class TimeRange(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "time_range_label") val time_range_label: String?,
    @ColumnInfo(name = "start_time") val start_time: String?,
    @ColumnInfo(name = "end_time") val end_time: String?,
    @ColumnInfo(name = "beacon_id") val beacon_id: Int?
)