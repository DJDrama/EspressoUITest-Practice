package com.djdj.espressotest

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.app.Instrumentation
import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.provider.MediaStore
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.djdj.espressotest.ui.MainActivity
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
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
//    @Test
//    fun test_navSecondaryActivity() {
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//        onView(withId(R.id.button_next_activity)).perform(click())
//        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
//    }
//
//    @Test
//    fun test_backPress_toMainActivity(){
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//        onView(withId(R.id.button_next_activity)).perform(click())
//        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
//
//       // onView(withId(R.id.button_back)).perform(click()) //method 1
//
//        pressBack() //method2
//        onView(withId(R.id.main)).check(matches(isDisplayed()))
//    }

    @get: Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun test_validateIntentSentToPickPackage() {
        //GIVEN
        val expectedIntent: Matcher<Intent> = allOf(
            hasAction(Intent.ACTION_PICK), //action
            hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI) //datatype
        )
        val activityResult = createGalleryPickActivityResultStub()
        intending(expectedIntent).respondWith(activityResult)

        // Execute and Verify
        onView(withId(R.id.button_open_gallery)).perform(click())
        intended(expectedIntent)

    }

    private fun createGalleryPickActivityResultStub(): Instrumentation.ActivityResult {
        val resource: Resources = InstrumentationRegistry.getInstrumentation()
            .context.resources
        val imageUri = Uri.parse(
            ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                    resource.getResourcePackageName(R.drawable.ic_launcher_background) + "/" +
                    resource.getResourceTypeName(R.drawable.ic_launcher_background) + "/" +
                    resource.getResourceEntryName(R.drawable.ic_launcher_background)
        )
        val resultIntent = Intent()
        resultIntent.data = imageUri
        return Instrumentation.ActivityResult(RESULT_OK, resultIntent)
    }
}
