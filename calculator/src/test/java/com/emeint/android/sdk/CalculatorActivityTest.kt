package com.emeint.android.sdk


import com.emeint.android.sdk.views.activities.CalculatorActivity

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

@RunWith(AndroidJUnit4::class)
class CalculatorActivityTest {

    @Rule
    var activityRule: ActivityScenarioRule<CalculatorActivity> =
        ActivityScenarioRule(CalculatorActivity::class.java)

    @Test
    fun numbersWithDecimals() {
        onView(withId(R.id.btnEight)).perform(click());
        onView(withId(R.id.btnNine)).perform(click());
        onView(withId(R.id.btnSeven)).perform(click());
        onView(withId(R.id.btnFour)).perform(click());
        onView(withId(R.id.btnDecimal)).perform(click());
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnSix)).perform(click());
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnZero)).perform(click());
        onView(withId(R.id.txtInput)).check(matches(withText("AED 8,974.561320")));
    }

    @Test
    fun decimals() {
        onView(withId(R.id.btnDecimal)).perform(click());
        onView(withId(R.id.btnEight)).perform(click());
        onView(withId(R.id.btnNine)).perform(click());
        onView(withId(R.id.btnSeven)).perform(click());
        onView(withId(R.id.btnFour)).perform(click());
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnSix)).perform(click());
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnZero)).perform(click());
        onView(withId(R.id.txtInput)).check(matches(withText("AED 0.8974561320")));
    }


}