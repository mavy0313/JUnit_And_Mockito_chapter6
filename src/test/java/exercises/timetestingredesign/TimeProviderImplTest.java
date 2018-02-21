package exercises.timetestingredesign;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class TimeProviderImplTest {

    @Test
    public void shouldReturnTrueForMorning() {
        TimeProviderImpl timeProvider = new TimeProviderImpl();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        timeProvider.setTime(calendar);

        assertEquals(true, timeProvider.isItMorning());
    }

    @Test
    public void shouldReturnFalseForMorning() {
        TimeProviderImpl timeProvider = new TimeProviderImpl();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        timeProvider.setTime(calendar);

        assertEquals(false, timeProvider.isItMorning());
    }
}
