package time;

import java.util.Calendar;

/**
 * Allows for taking control over time in unit tests.
 */
public interface TimeProvider {
    Calendar getTime();
}
