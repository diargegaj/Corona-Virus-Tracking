package com.diargegaj.coronavirustracking

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diargegaj.coronavirustracking.models.InformationPerCountry
import kotlinx.android.extensions.LayoutContainer

/**
 * Created by Diar Gegaj on 21-05-02.
 */
class CountriesAdapter: RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {

    private var models: List<InformationPerCountry> = mutableListOf()

    fun setCountriesInformation(countriesInformation: List<InformationPerCountry>) {
        models = countriesInformation
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class CountryViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer{

    }
}