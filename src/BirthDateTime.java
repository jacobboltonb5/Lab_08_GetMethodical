import java.util.Scanner;

public class BirthDateTime
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int year = SafeInput.getRangedInt(in, "Enter the year of your birth", 1950, 2015);
        int month = SafeInput.getRangedInt(in, "Enter the month of your birth", 1, 12);

        int maxDays = 0;

        // only 3 groups: Feb, the 30 day months, and the 31 day months
        switch (month)
        {
            case 2:
                maxDays = 29;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxDays = 30;
                break;
            default:
                maxDays = 31;
                break;
        }

        int day = SafeInput.getRangedInt(in, "Enter the day of your birth", 1, maxDays);
        int hour = SafeInput.getRangedInt(in, "Enter the hour of your birth", 1, 24);
        int minute = SafeInput.getRangedInt(in, "Enter the minute of your birth", 1, 59);

        System.out.println("\nYou were born on " + month + "/" + day + "/" + year + " at " + hour + ":" + minute);
    }
}