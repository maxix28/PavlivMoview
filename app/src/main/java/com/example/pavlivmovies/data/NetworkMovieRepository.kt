package com.example.pavlivmovies.data

import com.example.pavlivmovies.network.Movie
import com.example.pavlivmovies.network.MovieServiceApiInterface
import com.example.pavlivmovies.network.Movies
import javax.inject.Inject

//private val key =BuildConfig.API_KEY
private val key ="ed8a7f6930a3121c20d22bbc89dba5c2"
class NetworkMovieRepository @Inject constructor(private val movieServiceApiInterface: MovieServiceApiInterface):MovieRepository {
    override suspend fun getMoviePopular(page:String): Movies = movieServiceApiInterface.getMoviePopular(apiKey = key, page)


    override suspend fun getMovieTrend(page:String): Movies = movieServiceApiInterface.getMovieTrend(apiKey = key,page)
    override suspend fun getMovieByID(id: String): Movie = movieServiceApiInterface.getMovieByID(id,apiKey = key)
}
