package com.example.nextapp.mainViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nextapp.model.loginModel
import com.example.nextapp.networkApi.loginDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class responseViewmodel: ViewModel() {


    private var mutableLiveData= MutableLiveData<loginModel>()
    val liveData: LiveData<loginModel> = mutableLiveData

    private var failmutableLiveData= MutableLiveData<String>()
    val failliveData: LiveData<String> = failmutableLiveData

    fun getloginResp(username:String?, password: String?,grant:String?){

        loginDetails.getapiservice().getLogindetail(username, password, grant).enqueue(object : Callback<loginModel>{
            override fun onResponse(call: Call<loginModel>, response: Response<loginModel>) {
                mutableLiveData.postValue(response.body())            }

            override fun onFailure(call: Call<loginModel>, t: Throwable) {
                failmutableLiveData.value= "wrong"
            }


        })

    }

}