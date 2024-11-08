package com.bignerdranch.andriod.criminalintent

import androidx.fragment.app.Fragment
import com.bignerdranch.andriod.criminalintent.databinding.FragmentCrimeDetailBinding
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue


private lateinit var binding:FragmentCrimeDetailBinding


class CrimeDetailFragmentTest : Fragment() {

    lateinit var crime: Crime


    fun testCrimeDetailFragmentUI() {

        val scenario = FragmentScenario.launchInContainer(CrimeDetailFragment::class.java)

        onView(withId(R.id.crime_title))
            .check(matches(isDisplayed()))
            .perform(typeText("Test Crime Title"), closeSoftKeyboard())

        onView(withId(R.id.crime_solved))
            .check(matches(isDisplayed()))
            .perform(click())

        scenario.onFragment { fragment ->
            assertEquals("Test Crime Title", fragment.crime.title)

            assertTrue(fragment.crime.isSolved)
        }

    }
}