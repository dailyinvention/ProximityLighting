package com.dailyinvention.proximitylighting.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beacon")
data class Beacon(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "beacon_label") val beacon_label: String?,
    @ColumnInfo(name = "beacon_identifier") val beacon_identifier: String?
)