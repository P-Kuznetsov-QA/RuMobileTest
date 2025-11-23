package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.OnboardingTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OnboardingTests.class
})
public class TestSuite {
}
