package exercises.timetestingredesign;

import java.util.Calendar;

public class TimeProviderImpl implements TimeProvider {

    private Calendar calendar = Calendar.getInstance();

    @Override
    public Calendar getTime() {
        return calendar;
    }

    @Override
    public boolean isItMorning() {
        return calendar.get(Calendar.HOUR_OF_DAY) < 12;
    }

    public void setTime(Calendar time) {
        this.calendar = time;
    }
}
