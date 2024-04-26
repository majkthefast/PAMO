package com.example.bmicalculator;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class BmiCalculatorTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testBmiCalculation() {
        // Wpisz wagę
        onView(withId(R.id.weightInput))
                .perform(typeText("70"), closeSoftKeyboard());

        // Wpisz wzrost
        onView(withId(R.id.heightInput))
                .perform(typeText("175"), closeSoftKeyboard());

        // Kliknij przycisk obliczania BMI
        onView(withId(R.id.calculateButton)).perform(click());

        // Sprawdź wynik
        onView(withId(R.id.bmiResult))
                .check(matches(withText("Twoje BMI: 22.86")));
    }
}