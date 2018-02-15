package exercises.timetesting;

import java.util.Calendar;

public class HelpDesk {

    private TimeProvider timeProvider;

    public final static int EOB_HOUR = 17;

    public HelpDesk(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

//    public boolean willHandleIssue(Issue issue) {
//        Calendar cal = Calendar.getInstance();
//        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
//        if (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek) {
//            return false;
//        }
//        if (Calendar.FRIDAY == dayOfWeek) {
//            int hour = cal.get(Calendar.HOUR_OF_DAY);
//            if (hour > EOB_HOUR) {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean willHandleIssue(Issue issue) {
        Calendar cal = timeProvider.getTime();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek) {
            return false;
        }
        if (Calendar.FRIDAY == dayOfWeek) {
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            if (hour > EOB_HOUR) {
                return false;
            }
        }
        return true;
    }
}
