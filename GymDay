/**
 * GymDay extends TestDateTime to give a nice looking String of the message to be displayed
 * Centers the strings horizontally
 *
 * @author Andrew Peterson          peter343@purdue.edu
 * @version 10.3.15
 */
public class GymDay extends TestDateTime {


    public String gDay =   "IT'S GYM DAY!";
    public String dayOff = "It's your day off! Still, try to get some cardio in!";
    public String ques =   "What time will you be going to the gym today?";
    public String date = showDayDateTime();

    public void getGDay() { //Figures out the amount of spaces each line needs in order to look centered
        int qlen = ques.length();   //qlen -> questionLength
        int qSpaces = (qlen - date.length())/2;
        String qSp = "";        //question "" space string

        while(qSpaces > 0){
            qSp += " ";
            qSpaces--;
        }
        date = qSp + date;
        int gLen = gDay.length();
        int numSpaces = (date.length() - gLen) / 2; //the number of spaces IN TOTAL that will go before and after gDay
        String gDaySpaces = "";

        while(numSpaces> 0){
            gDaySpaces += " ";
            numSpaces--;
        }
        gDay = gDaySpaces + gDay;



    }
    public void getDayOff(){ //does same as getGDay except for on days off
        int oLen = dayOff.length();
        int spaces = (oLen - date.length()) / 2;
        String dayOffSpaces = "";

        while(spaces > 0){
            dayOffSpaces += " ";
            spaces--;
        }
        date = dayOffSpaces + date;
    }
    public boolean isGymDay(){


        if(day == cal.MONDAY || day == cal.WEDNESDAY || day == cal.FRIDAY) {
            return true;
        }
        else {

            return false;
        }
    }
   /* public static void main(String[] args){
        GymDay gym = new GymDay();
        System.out.println("" + gym.sayExc());
    }*/

}
