package com.example.nextapp.Room

import androidx.room.Dao
import androidx.room.Insert
import com.example.nextapp.model.ResponseDetail


@Dao
interface vehicalDao {

    @Insert
    fun insertVehicalDetail(vehicallist: ArrayList<ResponseDetail>)
}