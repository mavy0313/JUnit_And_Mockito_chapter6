package exercises.timetesting;

import org.junit.Test;

public class HelpDeskTest {

    @Test
    public void shouldHandleIssue() {
        HelpDesk helpDesk = new HelpDesk();
        helpDesk.willHandleIssue(new Issue());
    }
}
