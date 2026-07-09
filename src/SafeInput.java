import java.util.Scanner;

public class SafeInput
{
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    /**
     * Gets an int value from the user with no range constraint
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return an int value entered by the user
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine(); // clear the newline out of the pipe
                done = true;
            }
            else
            {
                trash = pipe.nextLine(); // read the trash and show the error
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a double value from the user with no range constraint
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a double value entered by the user
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear the newline out of the pipe
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets an int value from the user within a specified inclusive range
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param low low value of the inclusive range
     * @param high high value of the inclusive range
     * @return an int value within the range [low - high]
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value in range [" + low + " - " + high + "]: " + retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a double value from the user within a specified inclusive range
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param low low value of the inclusive range
     * @param high high value of the inclusive range
     * @return a double value within the range [low - high]
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value in range [" + low + " - " + high + "]: " + retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a Y or N from the user and returns the equivalent true or false
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return true for yes (Y/y) and false for no (N/n)
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retVal = false;
        boolean done = false;
        String response = "";

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y"))
            {
                retVal = true;
                done = true;
            }
            else if (response.equalsIgnoreCase("N"))
            {
                retVal = false;
                done = true;
            }
            else
            {
                System.out.println("You must enter Y or N: " + response);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a String from the user that matches a supplied RegEx pattern
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param regEx the RegEx pattern in Java String format to match against
     * @return a String that matches the RegEx pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String response = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("Input must match the pattern " + regEx + ": " + response);
            }
        } while (!done);

        return response;
    }

    /**
     * Prints a pretty header 60 characters wide with the message centered
     * on the middle line with 3 stars on each end
     *
     * @param msg the message to center in the header
     */
    public static void prettyHeader(String msg)
    {
        final int WIDTH = 60;

        // top row of stars
        for (int i = 0; i < WIDTH; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        // middle row: 3 stars, centered msg, 3 stars
        int spaces = WIDTH - 6 - msg.length(); // total spaces left over
        int leftSpaces = spaces / 2;
        int rightSpaces = spaces - leftSpaces; // handles odd leftovers

        System.out.print("***");
        for (int i = 0; i < leftSpaces; i++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < rightSpaces; i++)
        {
            System.out.print(" ");
        }
        System.out.println("***");

        // bottom row of stars
        for (int i = 0; i < WIDTH; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}