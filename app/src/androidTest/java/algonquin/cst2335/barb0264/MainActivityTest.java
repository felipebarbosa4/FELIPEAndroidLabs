package algonquin.cst2335.barb0264;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    /**
     * Rule for the activity scenario.
     */
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Test case for the main activity.
     */
    @Test
    public void mainActivityTest() {
        // Perform action on the EditText view
        ViewInteraction appCompatEditText = onView( withId(R.id.editTextText) );
        appCompatEditText.perform(replaceText("12345"), closeSoftKeyboard());

        // Perform action on the Button view
        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        // Check if the TextView displays the expected text
        ViewInteraction textView = onView(withId(R.id.theText));
        textView.check(matches(withText("You shall not pass!")));
    }

    /**
     * Test case to find a missing uppercase letter in the password.
     */
    @Test
    public void testFindMissingUpperCase() {
        // Perform action on the EditText view
        ViewInteraction appCompatEditText = onView( withId(R.id.editTextText) );
        appCompatEditText.perform(replaceText("password123#*$"));

        // Perform action on the Button view
        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        // Check if the TextView displays the expected text
        ViewInteraction textView = onView(withId(R.id.theText));
        textView.check(matches(withText("You shall not pass!")));
    }

    /**
     * Test case to find a missing lowercase letter in the password.
     */
    @Test
    public void testFindMissingLowerCase() {
        // Perform action on the EditText view
        ViewInteraction appCompatEditText = onView( withId(R.id.editTextText) );
        appCompatEditText.perform(replaceText("PASSWORD123#*$"));

        // Perform action on the Button view
        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        // Check if the TextView displays the expected text
        ViewInteraction textView = onView(withId(R.id.theText));
        textView.check(matches(withText("You shall not pass!")));
    }

    /**
     * Test case to find a missing special character in the password.
     */
    @Test
    public void testFindMissingSpecialChar() {
        // Perform action on the EditText view
        ViewInteraction appCompatEditText = onView( withId(R.id.editTextText) );
        appCompatEditText.perform(replaceText("PASSWOrd123"));

        // Perform action on the Button view
        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        // Check if the TextView displays the expected text
        ViewInteraction textView = onView(withId(R.id.theText));
        textView.check(matches(withText("You shall not pass!")));
    }

    /**
     * Test case to find a missing number in the password.
     */
    @Test
    public void testFindMissingNumber() {
        // Perform action on the EditText vieww
        ViewInteraction appCompatEditText = onView( withId(R.id.editTextText) );
        appCompatEditText.perform(replaceText("PASSword#*$"));

        // Perform action on the Button view
        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        // Check if the TextView displays the expected text
        ViewInteraction textView = onView(withId(R.id.theText));
        textView.check(matches(withText("You shall not pass!")));
    }

    /**
     * Test case for a complex enough password.
     */
    @Test
    public void testComplexEnough() {
        // Perform action on the EditText view
        ViewInteraction appCompatEditText = onView( withId(R.id.editTextText) );
        appCompatEditText.perform(replaceText("PASSword#*$123"));

        // Perform action on the Button view
        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.theText));
        textView.check(matches(withText("Your password meets the requirements")));
    }

}