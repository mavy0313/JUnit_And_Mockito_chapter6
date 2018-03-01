package exercises.enhancedretrytestrule;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnhancedRetryTest {

    @Rule
    public RetryTestEnhancedRule retryTestRule = new RetryTestEnhancedRule();

    static int firstTestCounter = 0;
    static int secondTestCounter = 0;
    static int thirdTestCounter = 0;

    @Test
    @RetryTest(retryNb = 2)
    public void shouldFailOnSecondAttempt() {
        firstTestCounter++;
        fail("failing " + firstTestCounter);
    }

    @Test
    @RetryTest(retryNb = 3)
    public void shouldFailOnThirdAttempt() {
        secondTestCounter++;
        fail("failing " + secondTestCounter);
    }

    @Test
    public void shouldNotBeRerun() {
        thirdTestCounter++;
        fail("failing " + thirdTestCounter);
    }
}
