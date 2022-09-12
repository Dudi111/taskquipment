package com.example.nextapp.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nextapp.model.ResponseDetail


@Database(entities = arrayOf(ResponseDetail::class), version = 1)
abstract class VehicalDatabase : RoomDatabase(){

    companion object{
        const val DB_NAME = "vehicalList"
        const val TABLE_NAME = "vehical_table"
    }
    abstract fun resProductsDaoAccess(): vehicalDao?
}