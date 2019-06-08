package eoinahern.ie.movietrailerapp.ui.view.all

import android.content.Intent
import android.os.Parcelable
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule

import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry

import eoinahern.ie.movietrailerapp.util.MOVIE_LIST_KEY
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AllSectionActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(AllSectionActivity::class.java, false, false)

    @Before
    fun setUp() {

        val intent = Intent()
        intent.putParcelableArrayListExtra(
            MOVIE_LIST_KEY,
            mutableListOf<MovieListEntry>() as java.util.ArrayList<out Parcelable>
        )
        activityRule.launchActivity(intent)
    }

    @Test
    fun othertest() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler)).check(matches(isDisplayed()))
    }
}