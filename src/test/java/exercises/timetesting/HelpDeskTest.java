package exercises.timetesting;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnitParamsRunner.class)
public class HelpDeskTest {

    //stub
    private TimeProvider timeProvider = mock(TimeProvider.class);
    private Issue issue = new Issue();

    private static final Object[] workingDays() {
        return $(2, 3, 4, 5, 6);
    }

    private static final Object[] weekendDays() {
        return $(0, 7);
    }

    @Test
    @Parameters(method = "workingDays")
    public void shouldHandleIssueInWorkingDays(int workingDay) {
        when(timeProvider.getTime()).thenReturn(getCalendar(workingDay, 8));

        HelpDesk helpDesk = new HelpDesk(timeProvider);

        assertTrue(helpDesk.willHandleIssue(issue));
    }

    @Test
    @Parameters(method = "weekendDays")
    public void shouldNotHandleIssueOnSaturday(int weekendDays) {
        when(timeProvider.getTime()).thenReturn(getCalendar(weekendDays, 8));

        HelpDesk helpDesk = new HelpDesk(timeProvider);

        assertFalse(helpDesk.willHandleIssue(issue));
    }

    @Test
    public void shouldNotHandleIssueOnFridayAfterFive() {
        when(timeProvider.getTime()).thenReturn(getCalendar(Calendar.FRIDAY, 18));

        HelpDesk helpDesk = new HelpDesk(timeProvider);

        assertFalse(helpDesk.willHandleIssue(issue));
    }

    private Calendar getCalendar(int day, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        return cal;
    }
}
