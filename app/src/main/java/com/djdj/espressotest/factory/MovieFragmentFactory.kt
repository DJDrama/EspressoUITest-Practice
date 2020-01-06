package com.djdj.espressotest.factory

import androidx.fragment.app.FragmentFactory
import com.djdj.espressotest.ui.movie.DirectorsFragment
import com.djdj.espressotest.ui.movie.MovieDetailFragment
import com.djdj.espressotest.ui.movie.StarActorsFragment

class MovieFragmentFactory : FragmentFactory(){

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
            }

            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }


}
