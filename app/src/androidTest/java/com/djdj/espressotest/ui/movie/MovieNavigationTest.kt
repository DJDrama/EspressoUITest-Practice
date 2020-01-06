package com.djdj.espressotest.ui.movie

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.djdj.espressotest.R
import com.djdj.espressotest.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieNavigationTest{
    @Test
    fun testMovieFragmentsNavigation(){
        //SETUP
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        //Nav DirectorsFragment
        onView(withId(R.id.movie_directiors)).perform(click())

        //Verify
        onView(withId(R.id.fragment_movie_directors_parent)).check(matches(isDisplayed()))
        pressBack()

        //Verify
        onView(withId(R.id.fragment_movie_detail_parent)).check(matches(isDisplayed()))


        //Nav StarActorsFragment
        onView(withId(R.id.movie_star_actors)).perform(click())

        //Verify
        onView(withId(R.id.fragment_movie_star_actors_parent)).check(matches(isDisplayed()))

    }
}