package com.djdj.espressotest.data.source

import com.djdj.espressotest.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?

    fun getMovies(): List<Movie>
}