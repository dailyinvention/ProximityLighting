package com.dailyinvention.proximitylighting.lib

import android.provider.BaseColumns
import com.dailyinvention.proximitylighting.model.TimeRange
import com.dailyinvention.proximitylighting.model.TimeRangeDAO
import java.lang.Exception

class TimeRangeImpl(
    val local: TimeRangeDAO
) {

    private suspend fun getTimeRanges(): Result<Exception, List<TimeRange>> = Result.build {
        local.getTimeRanges()
    }

    private suspend fun getLocalNote(id: String): Result<Exception, TimeRange> = Result.build {
        local.getTimeRangeById(id)
    }

    private suspend fun deleteLocalNote(timeRange: TimeRange): Result<Exception, Unit> =
        Result.build {
            local.deleteTimeRange(timeRange)
            Unit
        }

    private suspend fun updateTimeRange(timeRange: TimeRange): Result<Exception, Unit> =
        Result.build {
            local.insertOrUpdateTimeRange(timeRange)
            Unit
        }
}