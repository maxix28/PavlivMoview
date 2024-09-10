package com.example.pavlivmovies.di



import com.example.pavlivmovies.data.MovieRepository
import com.example.pavlivmovies.data.NetworkMovieRepository
import com.example.pavlivmovies.network.MovieServiceApiInterface
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {
    private val baseUrl="https://api.themoviedb.org/"

    @Provides
    fun providesRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(kotlinx.serialization.json.Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    fun provideCatApi(retrofit: Retrofit): MovieServiceApiInterface {
        return  retrofit.create(MovieServiceApiInterface::class.java)
    }
    @Provides
    fun provideMovieRepo(movieServiceApiInterface: MovieServiceApiInterface): MovieRepository {
        return NetworkMovieRepository(movieServiceApiInterface)
    }

}
