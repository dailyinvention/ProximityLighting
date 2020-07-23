package com.dailyinvention.proximitylighting.model

import com.dailyinvention.proximitylighting.model.entity.TimeRange
import com.dailyinvention.proximitylighting.model.entity.Beacon

interface DatabaseHelper {
    suspend fun getTimeRanges(): List<TimeRange>
    suspend fun insertOrUpdateTimeRange(timeRange: TimeRange)
    suspend fun getBeacons(): List<Beacon>
    suspend fun insertOrUpdateBeacon(beaconObject: Beacon)
}