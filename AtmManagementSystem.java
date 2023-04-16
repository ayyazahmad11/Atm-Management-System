import java.util.*;

public class AtmManagementSystem {

    static int balance = 100000;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("*****Automated Teller Machine*****\n           Main Menu");
            System.out.println("Choose 1 for Withdraw \n");
            System.out.println("Choose 2 for Deposit\n");
            System.out.println("Choose 3 for Check Balance\n");
            System.out.println("Choose 4 for EXIT\n");
            System.out.print("Choose the operation you want to perform:\n");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter money to be withdrawn:\n");
                    int withdraw = sc.nextInt();
                    performWithdrawal(withdraw);
                    break;

                case 2:
                    System.out.print("Enter money to be deposited:\n");
                    int deposit = sc.nextInt();
                    performDeposit(deposit);
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.exit(0);

            }
        }
    }

    static void performWithdrawal(int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Please collect your money\n Transiction Recorded");
        } else {
            System.out.println("Insufficient Balance\nTransiction Recorded");
        }
        System.out.println("");
    }

    static void performDeposit(int amount) {
        balance = balance + amount;
        System.out.println("Your Money has been successfully deposited\nTransiction Recorded");
        System.out.println("");
    }

    static void checkBalance() {
        System.out.println("Balance : " + balance);
        System.out.println("");
    }
}
