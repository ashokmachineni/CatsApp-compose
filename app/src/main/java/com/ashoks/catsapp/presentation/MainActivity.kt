package com.ashoks.catsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ashoks.catsapp.R
import com.ashoks.catsapp.network.responses.CatsService
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /*  val service = Retrofit.Builder().baseUrl("https://api.thecatapi.com/v1/breeds/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(CatsService::class.java)

        CoroutineScope(IO).launch {

            val cats = service.get("9ddfcf19-1e0a-40c7-9b19-5c60ef4b8582",
            "ben")

            Log.d("MainActivity","onCreate : ${cats}")
        }*/
    }
}