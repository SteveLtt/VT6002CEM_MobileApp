package com.example.mobileapp_;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
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
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION",
                    "android.permission.CAMERA");

    @Test
    public void mainActivityTest() {
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

        ViewInteraction recyclerView5 = onView(
                allOf(withId(R.id.recent_recycler),
                        childAtPosition(
                                withId(R.id.back),
                                3)));
        recyclerView5.perform(actionOnItemAtPosition(3, click()));

        pressBack();

        ViewInteraction recyclerView6 = onView(
                allOf(withId(R.id.recent_recycler),
                        childAtPosition(
                                withId(R.id.back),
                                3)));
        recyclerView6.perform(actionOnItemAtPosition(4, click()));

        pressBack();

        ViewInteraction recyclerView7 = onView(
                allOf(withId(R.id.recent_recycler),
                        childAtPosition(
                                withId(R.id.back),
                                3)));
        recyclerView7.perform(actionOnItemAtPosition(5, click()));

        pressBack();

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.scann),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.back),
                                        4),
                                1),
                        isDisplayed()));
        appCompatImageView.perform(click());

        pressBack();

        ViewInteraction appCompatImageView2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.back),
                                4),
                        2),
                        isDisplayed()));
        appCompatImageView2.perform(click());

        pressBack();

        ViewInteraction appCompatImageView3 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.back),
                                4),
                        2),
                        isDisplayed()));
        appCompatImageView3.perform(click());

        pressBack();

        ViewInteraction appCompatImageView4 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.back),
                                4),
                        2),
                        isDisplayed()));
        appCompatImageView4.perform(click());

        pressBack();

        ViewInteraction appCompatImageView5 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.back),
                                4),
                        3),
                        isDisplayed()));
        appCompatImageView5.perform(click());

        ViewInteraction materialTextView = onView(
                allOf(withId(R.id.reg), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        materialTextView.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.name),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("stevetest"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.age),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("23"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.email),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("steve3@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.pwd),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("123456852"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.register), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        materialButton.perform(click());

        pressBack();

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.email),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText5.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.email),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("steve3@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.pwd),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("123456"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.signin), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.email), withText("steve3@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("steve2@gmail.com"));

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.email), withText("steve2@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText9.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.pwd), withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText10.perform(replaceText("123456"));

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.pwd), withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText11.perform(closeSoftKeyboard());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.signin), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction materialButton4 = onView(
                allOf(withText("Back"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton4.perform(click());
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
