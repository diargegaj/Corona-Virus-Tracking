package com.diargegaj.coronavirustracking.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.diargegaj.coronavirustracking.R
import com.diargegaj.coronavirustracking.instance.RetrofitInstance
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dis = RetrofitInstance.service.getInformationPerCountry("world")
            .subscribeOn(Schedulers.io())
            .subscribe ({
                Log.d("diari1", "active cases: ${it.activeCases}")
            }, {
                Log.d("diari1", "failed ${it.message}", it)
            })
    }
}