package com.djdj.espressotest.util

import androidx.test.espresso.IdlingRegistry
import org.junit.rules.TestRule
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * Option 1
 * This option is much more difficult to read and is more verbose.
 */
//class EspressoIdlingResource : TestRule {
//    override fun apply(base: Statement?, description: Description?): Statement {
//        return IdlingResourceStatement(base)
//    }
//
//    class IdlingResourceStatement(private val base: Statement?) : Statement() {
//        private val idlingResource = EspressoIdlingResource.countingIdlingResource
//        override fun evaluate() {
//            idlingResource.getInstance().register(idlingResource)
//            try {
//                base?.evaluate()
//                    ?: throw Exception("Error evaluating test. Base statement is null.")
//            } finally {
//                IdlingRegistry.getInstance().unregister(idlingResource)
//            }
//        }
//    }
//}

/**
 * Option 2
 * Simplified version of option#1. (TestWatcher class implements TestRule)
 */
class EspressoIdlingResource : TestWatcher() {
    private val idlingResource = EspressoIdlingResource.countingIdlingResource
    override fun starting(description: Description?) {
        IdlingRegistry.getInstance().register(idlingResource)
        super.starting(description)
    }
    //After
    override fun finished(description: Description?) {
        IdlingRegistry.getInstance().unregister(idlingResource)
        super.finished(description)
    }


}