import java.util.Scanner;

public class DevTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // Part A test
        String name = SafeInput.getNonZeroLenString(in, "Enter your name");
        System.out.println("You entered: " + name);

//         Part B test
         int anyInt = SafeInput.getInt(in, "Enter any integer");
         System.out.println("You entered: " + anyInt);

//         Part C test
         double anyDouble = SafeInput.getDouble(in, "Enter any double");
         System.out.println("You entered: " + anyDouble);
//
//         Part D test
         int rangedInt = SafeInput.getRangedInt(in, "Enter an integer", 1, 10);
         System.out.println("You entered: " + rangedInt);

//         Part E test
         double rangedDouble = SafeInput.getRangedDouble(in, "Enter a double", 0.5, 10.0);
         System.out.println("You entered: " + rangedDouble);

//         Part F test
         boolean yesNo = SafeInput.getYNConfirm(in, "Do you like pizza?");
         System.out.println("Method returned: " + yesNo);

//         Part G test
         String ssn = SafeInput.getRegExString(in, "Enter your SSN (###-##-####)", "^\\d{3}-\\d{2}-\\d{4}$");
         System.out.println("You entered: " + ssn);

//         Part H test
         SafeInput.prettyHeader("Message Centered Here");
    }
}
