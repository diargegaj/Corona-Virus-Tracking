package com.diargegaj.coronavirustracking.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.diargegaj.coronavirustracking.CountriesAdapter
import com.diargegaj.coronavirustracking.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        countriesRecyclerView.layoutManager = LinearLayoutManager(this)
        countriesRecyclerView.adapter = CountriesAdapter()
    }
}