import java.util.*;

public class AtmManagementSystem {

    static int balance = 100000;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("*****Automated Teller Machine*****\n           Main Menu");
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 for Check Balance");
            System.out.println("Choose 4 for EXIT");
            System.out.print("Choose the operation you want to perform:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter money to be withdrawn:");
                    int withdraw = sc.nextInt();
                    performWithdrawal(withdraw);
                    break;

                case 2:
                    System.out.print("Enter money to be deposited:");
                    int deposit = sc.nextInt();
                    performDeposit(deposit);
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    static void performWithdrawal(int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Please collect your money");
        } else {
            System.out.println("Insufficient Balance");
        }
        System.out.println("");
    }

    static void performDeposit(int amount) {
        balance = balance + amount;
        System.out.println("Your Money has been successfully deposited");
        System.out.println("");
    }

    static void checkBalance() {
        System.out.println("Balance : " + balance);
        System.out.println("");
    }
}
