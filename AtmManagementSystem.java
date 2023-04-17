import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AtmManagementSystem {

    public static void main(String args[]) {
        int balance = 100000, withdraw, deposit;
        Scanner sc = new Scanner(System.in);

        // Transaction history
        StringBuilder transactionHistory = new StringBuilder();

        while (true) {
            System.out.println("***** Automated Teller Machine *****\n           Main Menu");
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 for Check Balance");
            System.out.println("Choose 4 for EXIT");
            System.out.print("Choose the operation you want to perform:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter money to be withdrawn:");
                    withdraw = sc.nextInt();
                    if (balance >= withdraw) {
                        balance = balance - withdraw;
                        System.out.println("Please collect your money");
                        // Update transaction history
                        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                        transactionHistory.append("Withdraw: ").append(withdraw).append(" - ").append(timestamp).append("\n");
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                    System.out.println("");
                    break;

                case 2:
                    System.out.print("Enter money to be deposited:");
                    deposit = sc.nextInt();
                    balance = balance + deposit;
                    System.out.println("Your Money has been successfully deposited");
                    // Update transaction history
                    String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    transactionHistory.append("Deposit: ").append(deposit).append(" - ").append(timestamp).append("\n");
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("Balance : " + balance);
                    System.out.println("");
                    break;

                case 4:
                    // Write transaction history to a file
                    try {
                        FileWriter writer = new FileWriter("atm_report.txt");
                        writer.write("ATM Management System Transaction History\n");
                        writer.write("----------------------------------------\n");
                        writer.write(transactionHistory.toString());
                        writer.close();
                        System.out.println("Transaction history written successfully to atm_report.txt");
                    } catch (IOException e) {
                        System.out.println("Error writing transaction history to file: " + e.getMessage());
                    }
                    System.exit(0);

            }
        }
    }
}
