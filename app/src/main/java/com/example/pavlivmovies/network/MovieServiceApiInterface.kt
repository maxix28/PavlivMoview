package com.example.pavlivmovies.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieServiceApiInterface {
    @GET("3/movie/popular")
    suspend fun getMoviePopular(
        @Query("api_key") apiKey: String,
        @Query("page") page: String
    ): Movies

    @GET("3/trending/all/day")
    suspend fun getMovieTrend(
        @Query("api_key") apiKey: String,
        @Query("page") page: String): Movies

    @GET("3/movie/{id}")
    suspend fun getMovieByID(
        @Path("id") id: String?,
        @Query("api_key") apiKey: String
    ): Movie
}