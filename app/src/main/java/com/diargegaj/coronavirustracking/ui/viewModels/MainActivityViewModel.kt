package com.diargegaj.coronavirustracking.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.diargegaj.coronavirustracking.models.InformationPerCountry
import com.diargegaj.coronavirustracking.repository.CoronaVirusInformationRepository

/**
 * Created by Diar Gegaj on 21-05-02.
 */
class MainActivityViewModel: ViewModel() {
    private val repository = CoronaVirusInformationRepository()

    fun getInformationForAllCountries(): LiveData<List<InformationPerCountry>> {
        return repository.getConoronaVirusInformation()
    }
}