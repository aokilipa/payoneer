package io.github.payoneer.ui.payment;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.github.payoneer.R;

@RunWith(AndroidJUnit4.class)
public class PaymentMethodTest {

    @Test
    public void shouldLaunchPaymentFragment() {
        FragmentScenario<PaymentMethod> scenario = FragmentScenario.launchInContainer(PaymentMethod.class, null, R.style.Theme_MaterialComponents_DayNight_NoActionBar);
        scenario.recreate();
        onView(withId(R.id.recycler_payment)).check(ViewAssertions.matches(isDisplayed()));
    }
}
