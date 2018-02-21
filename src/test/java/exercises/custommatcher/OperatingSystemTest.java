package exercises.custommatcher;

import org.junit.Test;

import static exercises.custommatcher.OsAssert.assertThat;

public class OperatingSystemTest {

    private OperatingSystem os;

    @Test
    public void testUsingMatcher() {
        OperatingSystem min9 = new Mindows9();
        min9.setNbOfBits(128);
        min9.setReleaseYear(2013);
        min9.setVersion("9");

        assertThat(min9).is128bit().wasReleasedIn(2013).hasVersion("9");
    }
}
