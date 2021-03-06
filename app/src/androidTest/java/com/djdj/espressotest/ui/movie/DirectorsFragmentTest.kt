package com.djdj.espressotest.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.djdj.espressotest.R
import com.djdj.espressotest.factory.MovieFragmentFactory
import kotlinx.android.synthetic.main.fragment_directors.view.*
import org.junit.Assert.*
import org.junit.Test

class DirectorsFragmentTest{
    @Test
    fun test_isDirectorsListVisible() {
        //GIVEN
        val directors =  arrayListOf("R.J. Stewart", "James Vanderbilt")
        val fragmentFactory = MovieFragmentFactory(null, null)

        val bundle = Bundle()
        bundle.putStringArrayList("args_directors", directors)

        val scenario = launchFragmentInContainer<DirectorsFragment>(
            fragmentArgs = bundle,
         factory =    fragmentFactory
        )

        //VERIFY
        onView(withId(R.id.directors_text)).check(matches(withText(DirectorsFragment.stringBuilderForDirectors(directors))))

    }
}