package com.diargegaj.coronavirustracking.adapter

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.diargegaj.coronavirustracking.R
import com.diargegaj.coronavirustracking.models.InformationPerCountry
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_country.view.*


/**
 * Created by Diar Gegaj on 21-05-02.
 */
class CountriesAdapter : RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {

    private var models: List<InformationPerCountry> = mutableListOf()

    fun setCountriesInformation(countriesInformation: List<InformationPerCountry>) {
        models = countriesInformation
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.fillView(models[position])
    }

    override fun getItemCount(): Int {
        return models.size
    }

    inner class CountryViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun fillView(informationPerCountry: InformationPerCountry){
            containerView.txtViewCountryName.text = informationPerCountry.countryText
            containerView.totalCasesNumber.text = informationPerCountry.totalCases
            containerView.newCasesNumber.text = informationPerCountry.newCases
            containerView.totalDeathsNumber.text = informationPerCountry.totalDeaths
            containerView.newDeathsNumber.text = informationPerCountry.newDeaths
            containerView.totalRecoveredNumber.text = informationPerCountry.totalRecovered
            containerView.totalActiveCasesNumber.text = informationPerCountry.activeCases
            containerView.lastUpdate.text = String.format(
                containerView.context.getString(R.string.last_update),
                informationPerCountry.lastUpdate
            )

            containerView.txtViewCountryName.setOnClickListener {
                if (containerView.countryInfo.isVisible) {
                    hideCountryInfo()
                }else {
                    showCountryInfo()
                }
            }
        }

        private fun showCountryInfo() {
            containerView.countryInfo.visibility = View.VISIBLE

            containerView.countryInfo.animate()
                .translationY(0f)
                .alpha(2.0f)
                .setListener(null)
        }

        private fun hideCountryInfo() {

            containerView.countryInfo.animate()
                .translationY(-containerView.countryInfo.height.toFloat())
                .alpha(2.0f)
                .setListener(object : AnimatorListenerAdapter() {

                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        containerView.countryInfo.visibility = View.GONE
                    }
                })
        }
    }
}