package com.mycode.mealplanapp.ui
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.rule.ActivityTestRule
import com.mycode.mealplanapp.persistence.RestaurantDatabaseTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import org.hamcrest.Matcher
import android.os.SystemClock
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.mycode.mealplanapp.R
import java.util.concurrent.TimeUnit

class MainActivityTest  : RestaurantDatabaseTest()  {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)
    private var activity : MainActivity? = null

    @Before
    fun setUp() {
        activity = activityRule.activity
    }

    @After
    fun tearDown() {
        activity = null
    }
    inner class ClickOnButtonView : ViewAction {
        internal var click = ViewActions.click()

        override fun getConstraints(): Matcher<View> {
            return click.constraints
        }

        override fun getDescription(): String {
            return " click on custom button view"
        }

        override fun perform(uiController: UiController, view: View) {
            //btnClickMe -> Custom row item view button
            click.perform(uiController, view.findViewById(R.id.order))
        }
    }

    @Test
    fun ReserveButtonClickedDialogSuccessShowsButton1(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withId(R.id.floating)).perform(click())
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, ClickOnButtonView()
            )
        )
        onView(withText("Success")).check(matches(isDisplayed()))
    }

    @Test
    fun ReserveButtonClickedDialogSuccessShowsButton2(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withId(R.id.floating)).perform(click())
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1, ClickOnButtonView()
            )
        )
        onView(withText("Success")).check(matches(isDisplayed()))
    }
    @Test
    fun ReserveButtonClickedDialogSuccessShowsButton3(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withId(R.id.floating)).perform(click())
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2, ClickOnButtonView()
            )
        )
        onView(withText("Success")).check(matches(isDisplayed()))
    }

    @Test
    fun ReserveButtonClickedDialogSuccessShowsButton4(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withId(R.id.floating)).perform(click())
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3, ClickOnButtonView()
            )
        )
        onView(withText("Success")).check(matches(isDisplayed()))
    }

    @Test
    fun ReserveButtonClickedDialogSuccessShowsButton5(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withId(R.id.floating)).perform(click())
        onView(withId(R.id.recycleView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(4))
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                4, ClickOnButtonView()
            )
        )
        onView(withText("Success")).check(matches(isDisplayed()))
    }

    @Test
    fun ReserveButtonClickedDialogSuccessShowsButton6(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withId(R.id.floating)).perform(click())
        onView(withId(R.id.recycleView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5, ClickOnButtonView()
            )
        )
        onView(withText("Success")).check(matches(isDisplayed()))
    }

    @Test
    fun ReserveButtonClickedDialogSuccessShowsButton7(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withId(R.id.floating)).perform(click())
        onView(withId(R.id.recycleView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(6))
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                6, ClickOnButtonView()
            )
        )
        onView(withText("Success")).check(matches(isDisplayed()))
    }

    @Test
    fun ReserveButtonClickedDialogErrorShowsButton1(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withId(R.id.floating)).perform(click())
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, ClickOnButtonView()
            )
        )
        onView(withText("Success")).check(matches(isDisplayed())).perform(pressBack())
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1, ClickOnButtonView()
            )
        )
        onView(withText("Error")).check(matches(isDisplayed()))
    }

    @Test
    fun ReserveButtonClickedDialogErrorShowsButton2(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withId(R.id.floating)).perform(click())
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, ClickOnButtonView()
            )
        )
        onView(withText("Success")).check(matches(isDisplayed())).perform(pressBack())
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2, ClickOnButtonView()
            )
        )
        onView(withText("Error")).check(matches(isDisplayed()))
    }

    @Test
    fun ReserveButtonClickedDialogErrorShowsButton3(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withId(R.id.floating)).perform(click())
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, ClickOnButtonView()
            )
        )
        onView(withText("Success")).check(matches(isDisplayed())).perform(pressBack())
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3, ClickOnButtonView()
            )
        )
        onView(withText("Error")).check(matches(isDisplayed()))
    }

    @Test
    fun ReserveButtonClickedDialogErrorShowsButton4(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withId(R.id.floating)).perform(click())
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, ClickOnButtonView()
            )
        )
        onView(withText("Success")).check(matches(isDisplayed())).perform(pressBack())
        onView(withId(R.id.recycleView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(4))
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                4, ClickOnButtonView()
            )
        )
        onView(withText("Error")).check(matches(isDisplayed()))
    }

    @Test
    fun ReserveButtonClickedDialogErrorShowsButton5(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withId(R.id.floating)).perform(click())
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, ClickOnButtonView()
            )
        )
        onView(withText("Success")).check(matches(isDisplayed())).perform(pressBack())
        onView(withId(R.id.recycleView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5, ClickOnButtonView()
            )
        )
        onView(withText("Error")).check(matches(isDisplayed()))
    }

    @Test
    fun ReserveButtonClickedDialogErrorShowsButton6(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withId(R.id.floating)).perform(click())
        onView(withId(R.id.recycleView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(6))
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0, ClickOnButtonView()
            )
        )
        onView(withText("Success")).check(matches(isDisplayed())).perform(pressBack())
        onView(withId(R.id.recycleView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                6, ClickOnButtonView()
            )
        )
        onView(withText("Error")).check(matches(isDisplayed()))
    }

    @Test
    fun allTextFromAPIIsInApp(){
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3))
        onView(withText("Meal: Donate a Meal")).check(matches(isDisplayed()))
        onView(withText("Restaurant: Be a Pal This Holiday Season")).check(matches(isDisplayed()))
        onView(withText("Meal: Jambon Berre")).check(matches(isDisplayed()))
        onView(withText("Restaurant: Lena")).check(matches(isDisplayed()))
        onView(withText("Meal: Salmon Kale Quinoa Bowl")).check(matches(isDisplayed()))
        onView(withText("Restaurant: Eddy's Eats")).check(matches(isDisplayed()))
        onView(withText("Meal: 5 Buffalo Wings & Onion Rings")).check(matches(isDisplayed()))
        onView(withText("Restaurant: Down the Hatch")).check(matches(isDisplayed()))
        onView(withId(R.id.recycleView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(6))
        onView(withText("Meal: BLT Sandwich")).check(matches(isDisplayed()))
        onView(withText("Restaurant: Croissanteria")).check(matches(isDisplayed()))
        onView(withText("Meal: Meatball Sandwich")).check(matches(isDisplayed()))
        onView(withText("Restaurant: La Contrada")).check(matches(isDisplayed()))
        onView(withText("Meal: Egg Salad")).check(matches(isDisplayed()))
        onView(withText("Restaurant: Pick A Bagel - Lexington Ave.")).check(matches(isDisplayed()))
    }

}