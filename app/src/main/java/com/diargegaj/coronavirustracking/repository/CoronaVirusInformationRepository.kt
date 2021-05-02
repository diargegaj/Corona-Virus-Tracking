package com.diargegaj.coronavirustracking.repository

import androidx.lifecycle.MutableLiveData
import com.diargegaj.coronavirustracking.instance.RetrofitInstance
import com.diargegaj.coronavirustracking.models.InformationPerCountry
import io.reactivex.schedulers.Schedulers

class CoronaVirusInformationRepository {
    private var data: MutableLiveData<List<InformationPerCountry>>? = null
    private val TAG = "CoronaVirusInformationRepository"

    fun getConoronaVirusInformation(): MutableLiveData<List<InformationPerCountry>> {
        if (data == null){
            data = MutableLiveData()
            loadDataFromAPI()
        }

        return data as MutableLiveData<List<InformationPerCountry>>
    }

    private fun loadDataFromAPI() {
        val dis = RetrofitInstance.service.getInformationForAllCountries()
            .subscribeOn(Schedulers.io())
            .subscribe {response ->
                data?.value = response
            }
    }


}
