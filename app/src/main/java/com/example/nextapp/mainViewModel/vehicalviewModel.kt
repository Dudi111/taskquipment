package com.example.nextapp.mainViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nextapp.model.ResponseDetail
import com.example.nextapp.model.loginModel
import com.example.nextapp.model.vehicalModel
import com.example.nextapp.networkApi.loginDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class vehicalviewModel(): ViewModel() {

    private var mutableLiveData= MutableLiveData<ArrayList<ResponseDetail>>()
    val liveData: LiveData<ArrayList<ResponseDetail>> = mutableLiveData

    private var failmutableLiveData= MutableLiveData<String>()
    val failliveData: LiveData<String> = failmutableLiveData


    fun getvehicaldata(latitude:String?, reqtime:String?, longitude:String?, radius:String?){

        loginDetails.getapiservice().getvehicalData(latitude, reqtime,longitude, radius)
            .enqueue(object :Callback<vehicalModel>{
                override fun onResponse(
                    call: Call<vehicalModel>,
                    response: Response<vehicalModel>
                ) {
                    mutableLiveData.postValue(response.body()?.ResponseDetail as ArrayList<ResponseDetail> /* = java.util.ArrayList<com.example.nextapp.model.ResponseDetail> */)
                }

                override fun onFailure(call: Call<vehicalModel>, t: Throwable) {
                    failmutableLiveData.value="wrong"
                }

            })

    }
}