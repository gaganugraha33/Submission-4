package nugraha.angga.com.footballmatch.main

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.runner.AndroidJUnit4
import nugraha.angga.com.footballmatch.view.MainActivity
import org.junit.Rule
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.matches_layout.*
import nugraha.angga.com.footballmatch.R
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.*
import kotlinx.android.synthetic.main.match_layout.*
import kotlinx.android.synthetic.main.player_layout.*
import kotlinx.android.synthetic.main.team_detail_activity_layout.*
import nugraha.angga.com.footballmatch.view.LastMatchFragment
import org.hamcrest.core.AllOf


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testLastMatchBehaviour() {
        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.prev_match)).perform(ViewActions.click())
        val matcher = AllOf.allOf(withText("Last Match"),
                isDescendantOfA(withId(R.id.tabs_main)))
        onView(matcher).perform(ViewActions.click())


        Thread.sleep(2500)


        Espresso.onView(ViewMatchers.withId(R.id.rvMatchLast))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchLast)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchLast)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, ViewActions.click()))
    }

    @Test
    fun testLastMatchSpinnerBehaviour() {
        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.prev_match)).perform(ViewActions.click())
        val matcher = AllOf.allOf(withText("Last Match"),
                isDescendantOfA(withId(R.id.tabs_main)))
        onView(matcher).perform(ViewActions.click())


        Thread.sleep(2500)

        onView(withId(R.id.spinner_teams_last))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.spinner_teams_last)).perform(ViewActions.click())
        onView(withText("English Premier League")).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.rvMatchLast))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchLast)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchLast)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, ViewActions.click()))
    }

    @Test
    fun testLastMatchSearchBehaviour() {
        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.prev_match)).perform(ViewActions.click())
        val matcher = AllOf.allOf(withText("Last Match"),
                isDescendantOfA(withId(R.id.tabs_main)))
        onView(matcher).perform(ViewActions.click())


        Thread.sleep(2500)

        onView(withId(R.id.action_search))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.action_search)).perform(ViewActions.click())
        onView(withId(R.id.action_search)).perform(ViewActions.typeText(   "Burnley"))

        Thread.sleep(2500)

        Espresso.onView(ViewMatchers.withId(R.id.rvMatchLast))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchLast)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchLast)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
    }

    @Test
    fun testNextMatchBehaviour() {
        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.prev_match)).perform(ViewActions.click())
        val matcher = AllOf.allOf(withText("Next Match"),
                isDescendantOfA(withId(R.id.tabs_main)))
        onView(matcher).perform(ViewActions.click())


        Thread.sleep(2500)


        Espresso.onView(ViewMatchers.withId(R.id.rvMatchNext))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchNext)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchNext)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, ViewActions.click()))
    }

    @Test
    fun testNextMatchSpinnerBehaviour() {
        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.prev_match)).perform(ViewActions.click())
        val matcher = AllOf.allOf(withText("Next Match"),
                isDescendantOfA(withId(R.id.tabs_main)))
        onView(matcher).perform(ViewActions.click())


        Thread.sleep(2500)

        onView(withId(R.id.spinner_teams_next))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.spinner_teams_next)).perform(ViewActions.click())
        onView(withText("English Premier League")).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.rvMatchNext))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchNext)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchNext)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, ViewActions.click()))
    }


    @Test
    fun testNextMatchSearchBehaviour() {
        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.prev_match)).perform(ViewActions.click())
        val matcher = AllOf.allOf(withText("Next Match"),
                isDescendantOfA(withId(R.id.tabs_main)))
        onView(matcher).perform(ViewActions.click())


        Thread.sleep(2500)

        onView(withId(R.id.action_search))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.action_search)).perform(ViewActions.click())
        onView(withId(R.id.action_search)).perform(ViewActions.typeText(   "Burnley"))

        Thread.sleep(2500)

        Espresso.onView(ViewMatchers.withId(R.id.rvMatchNext))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchNext)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchNext)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
    }

    @Test
    fun testTeamBehaviour() {
        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.next_match)).perform(ViewActions.click())


        Thread.sleep(2500)


        Espresso.onView(ViewMatchers.withId(R.id.rvMatch))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatch)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(15))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatch)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(15, ViewActions.click()))

        Thread.sleep(2000)

        val matcher = AllOf.allOf(withText("Player"),
                isDescendantOfA(withId(R.id.htab_tabs)))
        onView(matcher).perform(ViewActions.click())

        Thread.sleep(2500)

        Espresso.onView(ViewMatchers.withId(R.id.rvPlayer))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvPlayer)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
        Espresso.onView(ViewMatchers.withId(R.id.rvPlayer)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, ViewActions.click()))


    }


    @Test
    fun testTeamSpinnerBehaviour() {
        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.next_match)).perform(ViewActions.click())

        Thread.sleep(2500)

        onView(withId(R.id.spinner_teams))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.spinner_teams)).perform(ViewActions.click())
        onView(withText("English Premier League")).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.rvMatch))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatch)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatch)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, ViewActions.click()))

        Thread.sleep(2000)

        val matcher = AllOf.allOf(withText("Player"),
                isDescendantOfA(withId(R.id.htab_tabs)))
        onView(matcher).perform(ViewActions.click())

        Thread.sleep(2500)

        Espresso.onView(ViewMatchers.withId(R.id.rvPlayer))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvPlayer)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
        Espresso.onView(ViewMatchers.withId(R.id.rvPlayer)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, ViewActions.click()))
    }

    @Test
    fun testTeamSearchBehaviour() {
        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.next_match)).perform(ViewActions.click())

        Thread.sleep(2500)

        onView(withId(R.id.action_search))
                .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.action_search)).perform(ViewActions.click())
        onView(withId(R.id.action_search)).perform(ViewActions.typeText(   "Burnley"))

        Thread.sleep(2500)

        Espresso.onView(ViewMatchers.withId(R.id.rvMatch))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatch)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatch)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))

        Thread.sleep(2000)

        val matcher = AllOf.allOf(withText("Player"),
                isDescendantOfA(withId(R.id.htab_tabs)))
        onView(matcher).perform(ViewActions.click())

        Thread.sleep(2500)

        Espresso.onView(ViewMatchers.withId(R.id.rvPlayer))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvPlayer)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
        Espresso.onView(ViewMatchers.withId(R.id.rvPlayer)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, ViewActions.click()))
    }



    @Test
    fun testFavoriteBehaviour() {

        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.prev_match)).perform(ViewActions.click())

        val matcher = AllOf.allOf(withText("Last Match"),
                isDescendantOfA(withId(R.id.tabs_main)))
        onView(matcher).perform(ViewActions.click())

        Thread.sleep(2500)

        Espresso.onView(ViewMatchers.withId(R.id.rvMatchLast))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchLast)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchLast)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, ViewActions.click()))

        Espresso.onView(ViewMatchers.withId(R.id.add_to_favorite))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.add_to_favorite)).perform(ViewActions.click())

        Espresso.pressBack()

        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.favorites)).perform(ViewActions.click())

        Thread.sleep(2500)

        val matchersss = AllOf.allOf(withText("Matches"),
                isDescendantOfA(withId(R.id.tabs_main)))
        onView(matchersss).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.rvMatchFavorite))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatchFavorite)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))

        Espresso.onView(ViewMatchers.withId(R.id.rvMatchFavorite)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
    }


    @Test
    fun testTeamFavoriteBehaviour() {

        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.next_match)).perform(ViewActions.click())


        Thread.sleep(2500)

        Espresso.onView(ViewMatchers.withId(R.id.rvMatch))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatch)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatch)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, ViewActions.click()))

        Espresso.onView(ViewMatchers.withId(R.id.add_to_favorite))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.add_to_favorite)).perform(ViewActions.click())

        Espresso.pressBack()

        Espresso.onView(ViewMatchers.withId(R.id.bottom_navigation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.favorites)).perform(ViewActions.click())

        Thread.sleep(2500)

        val matchersss = AllOf.allOf(withText("Team"),
                isDescendantOfA(withId(R.id.tabs_main)))
        onView(matchersss).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.rvMatch))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvMatch)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))

        Espresso.onView(ViewMatchers.withId(R.id.rvMatch)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))

        val matcher = AllOf.allOf(withText("Player"),
                isDescendantOfA(withId(R.id.htab_tabs)))
        onView(matcher).perform(ViewActions.click())

        Thread.sleep(2500)

        Espresso.onView(ViewMatchers.withId(R.id.rvPlayer))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvPlayer)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))
        Espresso.onView(ViewMatchers.withId(R.id.rvPlayer)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, ViewActions.click()))
    }



}