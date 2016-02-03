import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Scanner;

/**
 * Created by PiratePowWow on 2/3/16.
 */
public class ATM {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int balance = 100;
        System.out.println("Hey, I'm ATM. What is your name?");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + ". What would you like to do?");
        System.out.println("1: Check Balance");
        System.out.println("2: Withdraw Funds");
        System.out.println("3: Cancel");
        String selection = scanner.nextLine();
        if (selection.equals("1")) {
            System.out.println("You have chosen to check your balance. Your balance is $" + balance + ".");
        }
        else if (selection.equals("2")) {
            System.out.println("You have chosen to withdraw funds. How much would you like to withdraw?");
            int withdrawal = scanner.nextInt();
            if (withdrawal <= balance) {
                System.out.println("Please collect your $" + withdrawal + " below.");
            } else {
                throw new Exception("You do not have that much in your account. Have a nice day and please come again.");
            }
        }
        else if (selection.equals("3")) {
            System.out.println("You have chosen to cancel this session. Have a nice day and please come again.");
        }
        else {
            throw new Exception("You have entered an invalid selection.");
        }

    }
}
