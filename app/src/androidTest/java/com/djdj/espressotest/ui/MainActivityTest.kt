package com.djdj.espressotest.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.djdj.espressotest.R
import kotlinx.android.synthetic.main.activity_main.view.*
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.*
import org.junit.Test

class MainActivityTest {

    @Test
    fun test_showDialog_captureNameInput() {
        //GIVEN
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val EXPECTED_NAME = "DONGSTER"

        //Execute and Verify
        onView(withId(R.id.button_launch_dialog)).perform(click())
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))
        onView(withText(R.string.text_ok)).perform(click())
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))

        //enter same input
        onView(withId(R.id.md_input_message)).perform(typeText(EXPECTED_NAME))
        onView(withText(R.string.text_ok)).perform(click())

        //make sure dialog is gone
        onView(withText(R.string.text_enter_name)).check(doesNotExist())

        //confirm name is set to TextView in activity
        onView(withId(R.id.text_name)).check(matches(withText(EXPECTED_NAME)))

    }
}