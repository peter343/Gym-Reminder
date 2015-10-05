import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * UserInput takes user inputted time, and system time to create an amount of time the program will use to sleep
 * in order to wake up at the correct time: when the user goes to the gym
 * @author Andrew Peterson          peter343@purdue.edu
 * @version 10.3.15
 */
public class UserInput {

    public String time;
    public double inputTime;
    private float added;
    public long diffMill;
    public String[] split = new String[2];


    /**
     * CONSTRUCTOR
     * @param  time specified by the user when they are asked what time they will go to the gym
     */
    public UserInput(String time){
        this.time = time;
    }


    /**
     *
     * Converts the time difference in hour form (HH.mm/60) to milliseconds
     * @param diff is the difference in times, or any time in hours form
     * @return
     */
    public void convertDiff(double diff){

        added = (float)diff*3600000;

    }

    /**
     * compareDates takes the time(specified by the user) and the time(given by the System), converts them to
     * hour-point-minute format (HH.(mm/60)) and calculates the difference between the two.
     * Calls to convertDiff() to get the time difference in milliseconds, and stores the result in a long variable
     */
    public void compareDates() { //TODO AM/PM
        int a = 0;
        for (String in : time.split(":")){          //For every ":" in the user's inputted time, split and store the
            split[a] = in;                          //numbers before and after into an array
            a++;
        }
        double inHour = Integer.valueOf(split[0]);  //Convert the String @ the first index of array into an Int (hours)
        double inMin = Double.valueOf(split[1]);    //Convert the String @ the secnd index of the array to Double (min)

        inMin = inMin/60;                       //gets minutes in the form of fraction of 60    e.g. 30/60 --> .5
        inHour = inHour + inMin;                //appends the minutes in decimal form to the hours to form HH.mm

        inputTime = inHour + 12;




        DateFormat dt = new SimpleDateFormat("HH:mm");//Represents the desired format for the String date --> hours:mins
        Date date = new Date();                     //Create Date Object that represents the current system time
        String str = dt.format(date) + ":";
        int i = 0;
        for (String res : str.split(":")){         //For every ":" in the Date time, split the number before (hours)
            split[i] = res;                        // and after (minutes) the ":"  5:30 ----->> 5   30
            i++;                                   //Stores each side in an array
    }
        double hour = Integer.valueOf(split[0]);        //Converts the string in the first index of the array to an Int
        double min = Double.valueOf(split[1]);          //Converts the string in the secnd index of the array to Double

        min = min/60;                  //gets minutes in the form of fraction of 60    e.g. 30/60 --> .5
        hour = hour + min;             //appends the minutes in decimal form to the hours to form HH.mm





        double difference = inputTime - hour;   //Calculates the time difference in hours (HH.mm) between what the user
                                                //said and the system's static current time

        convertDiff(difference);    //Converts the time difference into Milliseconds....Calls convertDiff method above

        diffMill = (long)added;     //Stores the Milliseconds in variable diffMill
    }

    /**
     * Getter, returns the variable storing the difference in time(milliseconds)
     * @return diffMill
     */
    public long getDiffMill(){  //Getter for the Variable diffMill
        return diffMill;
    }

    /**
     * FOR TEST USE ONLY
     * @param args
     */
    public static void main(String[] args){
        UserInput ui = new UserInput("8:11");
        ui.compareDates();
        System.out.println("" + ui.getDiffMill());

    }


}
