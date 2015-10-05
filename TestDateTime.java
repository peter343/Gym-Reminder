import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Gets the day of the week, and also formats the day, time, month and year
 * @author Andrew Peterson          peter343@purdue.edu
 * @version 10.2.15
 */
public class TestDateTime {
    Calendar cal = Calendar.getInstance();          //Gets a calendar instance, stores it as cal
    int day = cal.get(Calendar.DAY_OF_WEEK);        //retrieves the day of the week from the System

    /**
     * Gets the day and stores a string of the Day , date , time , and year according to the Day
     * @return A string message displaying the Day, date, time, and year
     */
    public String showDayDateTime() {

        DateFormat dateFormat = new SimpleDateFormat("MMM. d, yyyy h:mma");
        Date date = new Date();
        System.out.println();
        String result;
        if (day == cal.MONDAY)
            result = "Today is Monday " + dateFormat.format(date);
        else if (day == cal.TUESDAY)
            result = "Today is Tuesday " + dateFormat.format(date);
        else if (day == cal.WEDNESDAY)
            result = "Today is Wednesday " + dateFormat.format(date);
        else if (day == cal.THURSDAY)
            result = "Today is Thursday " + dateFormat.format(date);
        else if (day == cal.FRIDAY)
            result = "Today is Friday " + dateFormat.format(date);
        else if (day == cal.SATURDAY)
            result = "Today is Saturday " + dateFormat.format(date);
        else if (day == cal.SUNDAY)
            result = "Today is Sunday " + dateFormat.format(date);
        else result = null;

        return result;
    }

    /**
     * THIS IS FOR TESTING ONLY
     * @param args
     */
    public static void main(String[] args) {

        TestDateTime test = new TestDateTime();
        System.out.println(test.showDayDateTime());

    }


}

