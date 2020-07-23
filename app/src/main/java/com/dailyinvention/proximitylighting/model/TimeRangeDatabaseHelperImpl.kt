package com.dailyinvention.proximitylighting.model

import com.dailyinvention.proximitylighting.model.entity.Beacon
import com.dailyinvention.proximitylighting.model.entity.TimeRange

class TimeRangeDatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getTimeRanges(): List<TimeRange> =
        appDatabase.timeRangeDao().getTimeRanges()

    override suspend fun insertOrUpdateTimeRange(timeRange: TimeRange) =
        appDatabase.timeRangeDao().insertOrUpdateTimeRange(timeRange = timeRange)

    override suspend fun getBeacons(): List<Beacon> = appDatabase.beaconDao().getBeacons()
    override suspend fun insertOrUpdateBeacon(beaconObject: Beacon) =
        appDatabase.beaconDao().insertOrUpdateBeacon(beaconObject = beaconObject)

}