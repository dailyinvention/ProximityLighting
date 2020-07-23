package com.dailyinvention.proximitylighting.model

import androidx.room.*
import com.dailyinvention.proximitylighting.model.dao.BeaconDAO
import com.dailyinvention.proximitylighting.model.dao.TimeRangeDAO
import com.dailyinvention.proximitylighting.model.entity.Beacon
import com.dailyinvention.proximitylighting.model.entity.TimeRange

@Database(entities = [TimeRange::class, Beacon::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun timeRangeDao(): TimeRangeDAO
    abstract fun beaconDao(): BeaconDAO
}