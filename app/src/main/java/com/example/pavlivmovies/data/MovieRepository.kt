package com.example.pavlivmovies.data

import com.example.pavlivmovies.network.Movie
import com.example.pavlivmovies.network.Movies

interface MovieRepository {
    suspend fun getMoviePopular(page:String): Movies
    suspend fun getMovieTrend(page:String): Movies
    suspend fun getMovieByID(id:String): Movie
}