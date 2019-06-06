package eoinahern.ie.movietrailerapp.ui.view.detail

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.util.MOVIE_ID_KEY
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4::class)
class DetailActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(DetailActivity::class.java, false, false)

    @Before
    fun setUp() {
        var intent = Intent()
        intent.putExtra(MOVIE_ID_KEY, "avatar")
        activityRule.launchActivity(intent)
    }

    @Test
    fun test() {
        onView(withId(R.id.appbar)).check(matches(isDisplayed()))
        onView(withId(R.id.image_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.toolbar_layout)).check(matches(isDisplayed()))
    }
}