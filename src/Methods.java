/**
 * Created by PiratePowWow on 2/3/16.
 */
public class Methods {
    String name;
    int balance = 100;
    String selection;
    int withdrawal;
    public void enterName(){
        System.out.println("Hey, I'm ATM. What is your name?");
        name = ATM.scanner.nextLine();
    }

    public void enterSelection() throws Exception {
        System.out.println("Hello " + name + ". What would you like to do?");
        System.out.println("1: Check Balance");
        System.out.println("2: Withdraw Funds");
        System.out.println("3: Cancel");
        selection = ATM.scanner.nextLine();
        if (selection.equals("1")) {
            checkBalance();
        }
        else if (selection.equals("2")){
            withdraw();
        }
        else if (selection.equals("3")){
            cancel();
        }
        else {
            throw new Exception("You have entered an invalid selection.");
        }
    }

    public void checkBalance(){
        System.out.println("You have chosen to check your balance. Your balance is $" + balance + ".");
    }

    public void withdraw() throws Exception {
        System.out.println("You have chosen to withdraw funds. How much would you like to withdraw?");
        int withdrawal = ATM.scanner.nextInt();
        if (withdrawal <= balance) {
            System.out.println("Please collect your $" + withdrawal + " below.");
            this.balance = balance - withdrawal;
            System.out.println("Your new balance is $" + balance + ".");
        } else {
            throw new Exception("You do not have that much in your account. Have a nice day and please come again.");
        }
    }

    public void cancel(){
        System.out.println("You have chosen to cancel this session. Have a nice day and please come again.");
    }

}
