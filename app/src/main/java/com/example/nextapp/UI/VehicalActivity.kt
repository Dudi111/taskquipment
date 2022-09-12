package com.example.nextapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.nextapp.R
import com.example.nextapp.Room.VehicalDatabase
import com.example.nextapp.mainViewModel.vehicalviewModel
import kotlinx.android.synthetic.main.activity_vehical.*

class VehicalActivity : AppCompatActivity() {


    private lateinit var vehicaldb: VehicalDatabase
    private lateinit var vehicalVM: vehicalviewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehical)


        vehicalVM= ViewModelProvider(this).get(vehicalviewModel::class.java)


        Thread {
            vehicaldb = Room.databaseBuilder(
                applicationContext,
                VehicalDatabase::class.java, VehicalDatabase.DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }.start()


        tv_radius.setOnClickListener {
            maincard.visibility= View.VISIBLE
        }

        tv_1km.setOnClickListener {
            tv_radius.text="1KM"
            maincard.visibility= View.GONE
        }

        tv_2km.setOnClickListener {
            tv_radius.text="2KM"
            maincard.visibility= View.GONE
        }
        tv_5km.setOnClickListener {
            tv_radius.text="5KM"
            maincard.visibility= View.GONE
        }
        tv_10km.setOnClickListener {
            tv_radius.text="10KM"
            maincard.visibility= View.GONE
        }

        btn_search.setOnClickListener {

            vehicalVM.getvehicaldata("52.164849", "20210702020202", "5.385008", "1")


        }

        vehicalVM.liveData.observe(this){
            val vehicaldetailslist= it

            vehicaldb.resProductsDaoAccess()!!.insertVehicalDetail(it)
        }

    }
}