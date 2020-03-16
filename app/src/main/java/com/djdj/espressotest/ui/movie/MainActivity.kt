package com.djdj.espressotest.ui.movie

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.request.RequestOptions
import com.djdj.espressotest.R
import com.djdj.espressotest.data.source.MoviesDataSource
import com.djdj.espressotest.data.source.MoviesRemoteDataSource
import com.djdj.espressotest.factory.MovieFragmentFactory
import com.djdj.espressotest.ui.UICommunicationListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), UICommunicationListener {

    // dependencies (typically would be injected with dagger)
    lateinit var requestOptions: RequestOptions
    lateinit var moviesDataSource: MoviesDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        supportFragmentManager.fragmentFactory = MovieFragmentFactory(
            requestOptions,
            moviesDataSource
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        if(supportFragmentManager.fragments.size == 0){
            val movieId = 1
            val bundle = Bundle()
            bundle.putInt("movie_id", movieId)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieListFragment::class.java, bundle)
                .commit()
        }
    }

    private fun initDependencies(){

        // glide
        requestOptions = RequestOptions
            .placeholderOf(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        // Data Source
        moviesDataSource = MoviesRemoteDataSource()
    }

    override fun loading(isLoading: Boolean) {
        if (isLoading)
            progress_bar.visibility = View.VISIBLE
        else
            progress_bar.visibility = View.INVISIBLE
    }

}
