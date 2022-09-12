package com.example.nextapp.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "vehical_table")
data class ResponseDetail(
    val BSNNumber: String,
    val Color: String,
    val DistanceInMeter: Int,
    val DriverName: String,
    val DriverSessionStatus: String,
    val DriverWorkStatus: String,
    val LatestFiscalLabel: String,
    val LatestMessageTime: String,
    val LatestQimEventId: Int,
    val LatestQimStatusId: Int,
    val LicensePlate: String,
    val MaxPassenger: String,
    val ProductId: Int,
    val SerialNumber: String,
    val SessionStateSince: String,
    val SoftwareVersion: Double,
    val VehicleDirectionStatus: Int,
    val VehicleId: Int,
    val VehicleLatitude: Double,
    val VehicleLongitude: Double,
    val VehicleModel: String,
    val VehicleModelType: String,
    val VehicleNumber: String,
    val VehicleOdometer: Int,
    val VehicleSpeed: Int,
    @NonNull
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)