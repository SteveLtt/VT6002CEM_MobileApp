package com.example.mobileapp_;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest4 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION",
                    "android.permission.CAMERA");

    @Test
    public void mainActivityTest4() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recent_recycler),
                        childAtPosition(
                                withId(R.id.back),
                                3)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recent_recycler),
                        childAtPosition(
                                withId(R.id.back),
                                3)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        pressBack();

        pressBack();

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.recent_recycler),
                        childAtPosition(
                                withId(R.id.back),
                                3)));
        recyclerView3.perform(actionOnItemAtPosition(1, click()));

        pressBack();

        ViewInteraction recyclerView4 = onView(
                allOf(withId(R.id.recent_recycler),
                        childAtPosition(
                                withId(R.id.back),
                                3)));
        recyclerView4.perform(actionOnItemAtPosition(2, click()));

        pressBack();

        pressBack();

        ViewInteraction appCompatImageView = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.back),
                                4),
                        2),
                        isDisplayed()));
        appCompatImageView.perform(click());

        pressBack();

        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.scann),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.back),
                                        4),
                                1),
                        isDisplayed()));
        appCompatImageView2.perform(click());

        pressBack();

        ViewInteraction appCompatImageView3 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.back),
                                4),
                        3),
                        isDisplayed()));
        appCompatImageView3.perform(click());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.signin), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        materialButton.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
