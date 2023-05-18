package hrs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    public static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        return dateFormat.format(date);
    }
    
    public static String formatTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(date);
    }
    
    public static String format(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm");
        return dateFormat.format(date);
    }
    
    public static long getNumberOfMillisecondBetweenTwoDates(Date start, Date end) {
        return end.getTime() - start.getTime();
    }
    
    public static long getRoundedDaysBetweenDates(Date startDate, Date endDate) {
        long diffInMillis = getNumberOfMillisecondBetweenTwoDates(startDate, endDate);
        long days = TimeUnit.MILLISECONDS.toDays(diffInMillis);
        long remainder = diffInMillis % TimeUnit.DAYS.toMillis(1);
        if (remainder > 0) {
            days++;
        }
        return days;
    }
}
