package com.diargegaj.coronavirustracking.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.diargegaj.coronavirustracking.R
import com.diargegaj.coronavirustracking.adapter.CountriesAdapter
import com.diargegaj.coronavirustracking.ui.viewModels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CountriesAdapter
    private lateinit var coronaVirusInformationViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()

        coronaVirusInformationViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        coronaVirusInformationViewModel.getInformationForAllCountries().observe(this, {
            adapter.setCountriesInformation(it)
        })
    }

    private fun setUpRecyclerView() {
        adapter = CountriesAdapter()

        countriesRecyclerView.layoutManager = LinearLayoutManager(this)
        countriesRecyclerView.adapter = adapter
    }
}