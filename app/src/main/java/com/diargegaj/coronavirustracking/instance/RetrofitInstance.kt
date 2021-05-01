package com.diargegaj.coronavirustracking.instance

import com.diargegaj.coronavirustracking.service.Covid19TrackingService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Diar Gegaj on 21-05-01.
 */
object RetrofitInstance {

    val retrofit by lazy {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request()

            val request = original.newBuilder()
                .header("X-RapidAPI-Key", "fcfd0e9f8bmshd27427e3da163a0p12c997jsn6a9ffcbb45f1")
                .header("X-RapidAPI-Host", "covid-19-tracking.p.rapidapi.com")
                .method(original.method(), original.body())
                .build()

            chain.proceed(request)
        }

        val client = httpClient.build()

        Retrofit.Builder()
            .baseUrl(Covid19TrackingService.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    val service = retrofit.create(Covid19TrackingService::class.java)

}