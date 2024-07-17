/**
 *  Nama    : Aryalingga Karamasatya Radhiendra
 *  NIM     : 10118368
 *  Kelas   : AKBUL1
 */
package com.example.superhero

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://superheroapi.com/api/"

    val api: SuperheroApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SuperheroApi::class.java)
    }
}
