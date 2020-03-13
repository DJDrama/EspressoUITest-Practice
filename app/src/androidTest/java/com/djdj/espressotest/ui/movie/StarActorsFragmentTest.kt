package com.djdj.espressotest.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.djdj.espressotest.R
import com.djdj.espressotest.factory.MovieFragmentFactory
import org.junit.Test

class StarActorsFragmentTest {

    @Test
    fun test_isActorsListVisible() {
        //GIVEN
        val actors =  arrayListOf("Dwayne Johnson", "Seann William Scott", "Rosario Dawson", "Christopher Walken")
        val fragmentFactory = MovieFragmentFactory(null, null)

        val bundle = Bundle()
        bundle.putStringArrayList("args_actors", actors)

        val scenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory =  fragmentFactory
        )

        //VERIFY
        onView(withId(R.id.star_actors_text)).check(matches(withText(StarActorsFragment.stringBuilderForStarActors(actors))))

    }
}