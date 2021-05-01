package com.diargegaj.coronavirustracking.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Diar Gegaj on 21-05-01.
 */
data class InformationPerCountry(
    @SerializedName("Active Cases_text")
    val activeCases: String,

    @SerializedName("Country_text")
    val countryText: String,

    @SerializedName("Last Update")
    val lastUpdate: String,

    @SerializedName("New Cases_text")
    val newCases: String,

    @SerializedName("New Deaths_text")
    val newDeaths: String,

    @SerializedName("Total Cases_text")
    val totalCases: String,

    @SerializedName("Total Deaths_text")
    val totalDeaths: String,

    @SerializedName("Total Recovered_text")
    val totalRecovered: String
)
