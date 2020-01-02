package com.djdj.espressotest

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    //    /** Test Alphabetical order **/
//    @Test
//    fun test_isActivityInView() {
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//        onView(withId(R.id.main)).check(matches(isDisplayed()))
//    }
//
//    @Test
//    fun test_visibility_title_nextButton() {
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))
//        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))
//
//        //different way of checking visible or not
//        onView(withId(R.id.button_next_activity)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
//    }
//
//    @Test
//    fun test_isTitleTextDisplayed() {
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))
//    }
    @Test
    fun test_navSecondaryActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun test_backPress_toMainActivity(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))

       // onView(withId(R.id.button_back)).perform(click()) //method 1

        pressBack() //method2
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
}
