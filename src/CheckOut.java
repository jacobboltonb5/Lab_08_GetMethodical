import java.util.Scanner;

public class CheckOut
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        double total = 0;
        boolean moreItems = true;

        System.out.println("Welcome to the 10$ Store checkout!");

        while (moreItems)
        {
            double price = SafeInput.getRangedDouble(in, "Enter the price of your item", 0.50, 10.00);
            total = total + price;
            moreItems = SafeInput.getYNConfirm(in, "Do you have more items?");
        }

        System.out.printf("%nYour total cost is: $%.2f%n", total);
    }
}