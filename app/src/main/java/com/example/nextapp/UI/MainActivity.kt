package com.example.nextapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.nextapp.R
import com.example.nextapp.mainViewModel.responseViewmodel
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.math.log

class MainActivity : AppCompatActivity() {



    companion object{
        var token:String=""
    }
   private lateinit var viewmodel:responseViewmodel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel= ViewModelProvider(this).get(responseViewmodel::class.java)

        btn_proceed.setOnClickListener {

            val passwordd= et_password.text.toString()
            val md5password= md5(passwordd).toLowerCase()

            viewmodel.getloginResp(et_email.text.toString(), md5password, "password")

        }

        viewmodel.liveData.observe(this){
            if (!it.access_token.isNullOrEmpty()){
                token= it.access_token
                Log.d("tokencheck", token)

                val intent= Intent(this, VehicalActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Invalid login", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}