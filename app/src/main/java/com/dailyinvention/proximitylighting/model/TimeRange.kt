package com.dailyinvention.proximitylighting.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "proximitylighting_time_range",
    indices = [Index("id")]
)

data class TimeRange(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val label: Int,

    @ColumnInfo(name = "start_time")
    val startTime: String,

    @ColumnInfo(name = "end_time")
    val endTime: String,

    @ColumnInfo(name = "beacon_id")
    val beaconID: Int
)