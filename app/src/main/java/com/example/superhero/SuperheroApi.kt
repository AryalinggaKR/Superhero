/**
 *  Nama    : Aryalingga Karamasatya Radhiendra
 *  NIM     : 10118368
 *  Kelas   : AKBUL1
 */
package com.example.superhero

import Superhero
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroApi {
    @GET("{access-token}/{id}")
    fun getSuperhero(@Path("access-token") accessToken: String, @Path("id") id: String): Call<Superhero>
}