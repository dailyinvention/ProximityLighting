package com.dailyinvention.proximitylighting.model.dao

import androidx.room.*
import com.dailyinvention.proximitylighting.model.entity.Beacon

@Dao
interface BeaconDAO {
    @Query("SELECT * FROM beacon")
    suspend fun getBeacons(): List<Beacon>

    @Query("SELECT * FROM beacon WHERE id = :id")
    suspend fun getBeaconById(id: String): Beacon

    @Delete
    suspend fun deleteBeacon(beaconObject: Beacon)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateBeacon(beaconObject: Beacon)
}