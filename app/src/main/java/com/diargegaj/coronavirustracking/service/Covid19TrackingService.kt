package com.diargegaj.coronavirustracking.service

import com.diargegaj.coronavirustracking.models.InformationPerCountry
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Diar Gegaj on 21-05-01.
 */
interface Covid19TrackingService {

    @GET("v1/")
    fun getInformationForAllCountries(): Observable<List<InformationPerCountry>>


    companion object {
        const val API_URL = "https://covid-19-tracking.p.rapidapi.com/"
    }
}