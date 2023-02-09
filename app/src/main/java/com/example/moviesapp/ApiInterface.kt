package com.example.moviesapp


import com.example.moviesapp.apiType.ShowsList
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("shows")
    suspend fun getShows():Response<ShowsList>
}