import java.util.HashMap;

/**
 * Created by PiratePowWow on 2/3/16.
 */
public class Methods {
    HashMap<String, Double> accounts = new HashMap<>();
    String selection;
    int withdrawal;
    public void enterName() throws Exception {
        System.out.println("Hey, I'm ATM. What is your name?");
        String name = ATM.scanner.nextLine();
        if (accounts.containsKey(name)) {
            enterSelection(name);
        }

        else {
            System.out.println("I see you are new here. Would you like to create an account? [y/n]");
            String response = ATM.scanner.nextLine();
            if (response.equalsIgnoreCase("y")) {
                accounts.put(name, 0.0);
                System.out.println("An account has been created for you. Would you like to make a deposit? [y/n]");
                response = ATM.scanner.nextLine();
                if (response.equalsIgnoreCase("y")) {
                    System.out.println("How much would you like to deposit?");
                    double deposit = Double.valueOf(ATM.scanner.nextLine());
                    accounts.put(name, deposit);
                    System.out.println("$" + deposit + " has been deposited in your account. Your new balance is $" + accounts.get(name) + ".");
                    enterSelection(name);
                }
                else {
                    System.out.println("Since you do not have and do not wish to make a deposit, this session is terminated. Please come again.");
                    System.exit(0);
                }
            }
            else {
                System.out.println("Since you do not have and do not wish to create an account, this session is terminated. Please come again.");
                System.exit(0);
            }
        }
    }

    public void enterSelection(String name) throws Exception {
        System.out.println("Hello " + name + ". What would you like to do?");
        System.out.println("1: Check Balance");
        System.out.println("2: Withdraw Funds");
        System.out.println("3: Delete Bank Account");
        System.out.println("4: Cancel");

        String selection = ATM.scanner.nextLine();
        if (selection.equals("1")) {
            checkBalance(name);
        }
        else if (selection.equals("2")){
            withdraw(name);
        }
        else if (selection.equals("4")){
            cancel();
        }
        else if (selection.equals("3")){
            deleteAccount(name);
        }
        else {
            throw new Exception("You have entered an invalid selection.");
        }
    }

    public void deleteAccount(String name) throws Exception {
        accounts.remove(name);
        System.out.println("Your account has been removed as requested.");
        enterName();
    }

    public void checkBalance(String name) throws Exception {
        System.out.println("You have chosen to check your balance. Your balance is $" + accounts.get(name) + ".");
        System.out.println("Would you like to make another transaction?");
        String response = ATM.scanner.nextLine();
        if (response.equals("y")){
            enterSelection(name);
        }
        else {
            cancel();
        }
    }

    public void withdraw(String name) throws Exception {
        System.out.println("You have chosen to withdraw funds. How much would you like to withdraw?");
        double withdrawal = ATM.scanner.nextDouble();
        if (withdrawal <= accounts.get(name)) {
            System.out.println("Please collect your $" + withdrawal + " below.");
            accounts.put(name, accounts.get(name) - withdrawal);
            System.out.println("Your new balance is $" + accounts.get(name) + ".");
            enterSelection(name);
        } else {
            throw new Exception("You do not have that much in your account. Have a nice day and please come again.");
        }
    }

    public void cancel(){
        System.out.println("You have chosen to cancel this session. Have a nice day and please come again.");
    }

}
